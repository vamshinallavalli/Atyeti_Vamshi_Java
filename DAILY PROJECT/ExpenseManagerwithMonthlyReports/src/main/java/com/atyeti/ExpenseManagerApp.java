package com.atyeti;

import com.atyeti.model.Expense;
import com.atyeti.service.ExpenseService;
import com.atyeti.service.ReportService;

import java.time.YearMonth;
import java.util.List;

public class ExpenseManagerApp {
    public static void main(String[] args) {
        ExpenseService obj=new ExpenseService();
        ReportService reportService=new ReportService();

        List<Expense> allExpense=obj.readDirectory();
        YearMonth month=YearMonth.of(2025,7);

        reportService.generateMonthlyReport(allExpense,month);


    }
}