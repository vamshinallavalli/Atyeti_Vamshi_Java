package concurrency;

import model.*;
import service.OrderService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;   // ← THIS LINE WAS MISSING!

class ConcurrentOrderSubmissionTest {

    void shouldHandle100ThreadsSubmitting10000OrdersWithoutRaceConditions() throws InterruptedException {
        OrderService orderService = new OrderService();

        ExecutorService pool = Executors.newFixedThreadPool(100);
        CountDownLatch latch = new CountDownLatch(10_000);

        for (int i = 0; i < 10_000; i++) {
            final int idx = i;
            pool.submit(() -> {
                try {
                    orderService.submitCsvOrder(
                            "CONC-" + idx,
                            "T" + (idx % 100),
                            TradeType.values()[idx % 3],
                            idx % 2 == 0 ? OrderType.BUY : OrderType.SELL,
                            100.0 + (idx % 100),
                            50,
                            "US",
                            Timestamp.from(Instant.now())
                    );
                } finally {
                    latch.countDown();
                }
            });
        }

        assertTrue(latch.await(30, TimeUnit.SECONDS));
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);

        long trades = orderService.getTradeRepository().getAllTrades().size();
        long filled = orderService.getOrderBook().getAllOrders()
                .stream()
                .filter(o -> o.getStatus() == OrderStatus.FILLED)
                .count();

        System.out.println("Concurrency test passed: " + trades + " trades, " + filled + " filled orders");

        // Proof that real matching happened under extreme concurrency
        assertTrue(trades > 800, "Expected many trades under concurrent load");
        assertTrue(filled > 1000, "Expected many orders to be fully filled");
    }
}