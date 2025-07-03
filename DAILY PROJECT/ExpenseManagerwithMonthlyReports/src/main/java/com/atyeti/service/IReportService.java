package com.atyeti.service;

import com.atyeti.model.Expense;

import java.time.YearMonth;
import java.util.List;

interface IReportService {
    void generateMonthlyReport(List<Expense> expenses, YearMonth month);
}
