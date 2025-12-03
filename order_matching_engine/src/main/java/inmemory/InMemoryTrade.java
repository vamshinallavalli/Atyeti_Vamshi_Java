package inmemory;

import model.Trade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryTrade {
    private final List<Trade> trades = new CopyOnWriteArrayList<>();
    private final AtomicLong tradeIdCounter = new AtomicLong(0);

    public String generateTradeId() {
        return "T" + tradeIdCounter.incrementAndGet();
    }

    public void saveTrade(Trade trade) {
        trades.add(trade);
    }

    public List<Trade> getAllTrades() {
        return Collections.unmodifiableList(new ArrayList<>(trades));
    }
}


//package inmemory;
//
//import model.Trade;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class InMemoryTrade {
//    private final List<Trade> trades=new ArrayList<>();
//
//    public void saveTrade(Trade trade){
//        trades.add(trade);
//    }
//}
