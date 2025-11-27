package com.vishwag.expence.tracker.application.service;

import com.vishwag.expence.tracker.application.dto.ExpenseDTO;
import com.vishwag.expence.tracker.application.entity.Expense;

import java.util.List;

public interface ExpenseService {
    Expense addExpense(ExpenseDTO dto);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense updateExpense(Long id, ExpenseDTO dto);
    void deleteExpense(Long id);
    Double getMonthlytotal(int month, int year);
    Double getCategoryTotal(String category);
    Double getTodayTotal();
    Double getWeeklyTotal();
    List<Expense> getAllExpensesSorted();
    Double getTotalAmount();
}
