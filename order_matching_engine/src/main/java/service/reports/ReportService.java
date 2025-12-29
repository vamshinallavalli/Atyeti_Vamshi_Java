package reports;

import inmemory.OrderBook;
import model.Order;
import model.OrderStatus;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Generates CSV reports for orders based on status
 */
public class ReportService {

    private static final String REPORT_DIR =
            "C:\\Users\\VamshiNallavalli\\OneDrive - Atyeti Inc\\Desktop\\My_Learnings\\order_matching_engine\\src\\main\\java\\reports";

    private static final String CSV_HEADER =
            "OrderId,TraderId,TradeType,OrderType,Price,Quantity,RemainingQuantity,Status,Timestamp";

    private final OrderBook orderBook;

    public ReportService(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public void generateAllCsvReports() throws IOException {
        Files.createDirectories(Paths.get(REPORT_DIR));

        generateCsv(OrderStatus.FILLED, "filled_orders.csv");
        generateCsv(OrderStatus.PARTIALLY_FILLED, "partially_filled_orders.csv");
        generateCsv(OrderStatus.PENDING, "pending_orders.csv"); // ✅ changed
    }

    private void generateCsv(OrderStatus status, String fileName) throws IOException {

        List<Order> orders = orderBook.getAllOrders()
                .stream()
                .filter(o -> o.getStatus() == status)
                .collect(Collectors.toList());

        Path path = Paths.get(REPORT_DIR, fileName);

        List<String> lines = orders.stream()
                .map(this::toCsvRow)
                .collect(Collectors.toList());

        lines.add(0, CSV_HEADER);

        Files.write(path, lines,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);

        System.out.println("CSV generated: " + path);
    }

    private String toCsvRow(Order o) {
        return String.join(",",
                o.getOrderId(),
                o.getTraderId(),
                o.getTradeType().name(),
                o.getOrderType().name(),
                String.valueOf(o.getPrice()),
                String.valueOf(o.getQuantity()),
                String.valueOf(o.getRemainingQuantity()),
                o.getStatus().name(),
                o.getTimestamp().toString()
        );
    }
}
