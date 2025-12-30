# 🏦 Trading Order Matching Engine

## 📌 Overview
This project implements an **in-memory Trading Order Matching Engine** that processes **BUY** and **SELL** orders across multiple trade types (**EQUITY, FOREX, CRYPTO**).  
It validates orders against business rules, matches compatible orders using **price-time priority (FIFO)**, executes trades, and safely handles **highly concurrent order submissions**.

The system is designed with **clean architecture**, **SOLID principles**, and **extensibility** in mind.

---

## 🎯 Objective
Build a thread-safe order matching engine that:
- Accepts orders from multiple traders
- Validates orders using business rules
- Maintains separate order books per trade type
- Matches orders correctly using price and timestamp
- Supports partial fills
- Handles heavy concurrency without race conditions

---

## ⚙️ How to Run the Application

### 1️⃣ Prerequisites
- Java **8+**
- Maven or Gradle (optional)
- JUnit 5

### 2️⃣ Run Main Application
Run `Main.java`.  
CSV files must be placed under:
```
src/main/resources/
 ├── buy_orders.csv
 └── sell_orders.csv
```

### 3️⃣ Run Concurrency Tests
Run:
```
ConcurrentOrderSubmissionTest
```

---

## 🧱 Architecture
```
CSV → CsvReader → OrderService → MatchingService → OrderBook + TradeBook
                                          ↓
                                   Trades + Reports
```

---

## 📦 Core Components
- **OrderService** – Central orchestrator (Facade)
- **MatchingService** – Price-time priority matching
- **OrderBook** – In-memory priority queues
- **InMemoryTrade** – Thread-safe trade storage
- **CsvReader** – Robust CSV ingestion
- **ReportService** – CSV report generation

---

## ✅ Validation Rules
- Approved countries: US, UK, IN, SG, JP, DE, FR
- Amount limits:
  - EQUITY: 100,000
  - FOREX: 500,000
  - CRYPTO: 50,000
- Positive price & quantity
- Duplicate order ID protection

---

## 🔄 Order Lifecycle
```
PENDING → PARTIALLY_FILLED → FILLED
             ↓
          REJECTED
```

---

## 🧵 Concurrency
- One lock per TradeType
- Parallel processing across trade types
- No global locks
- Thread-safe collections used

---

## 🧪 Testing
- 100 concurrent threads
- 10,000 orders
- Validates:
  - No negative quantities
  - No duplicate trades
  - All orders accounted for

---

## 📊 Reports
Generated under `reports/`:
- filled_orders.csv
- partially_filled_orders.csv
- pending_orders.csv

---

## 🧠 Design Patterns
- Strategy
- Facade
- Validator Chain
- SOLID principles

---

## 🏁 Conclusion
A production-grade, concurrent, extensible order matching engine fully aligned with the assignment requirements.
