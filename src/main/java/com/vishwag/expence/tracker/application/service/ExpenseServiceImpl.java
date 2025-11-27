package com.vishwag.expence.tracker.application.service;

import com.vishwag.expence.tracker.application.dto.ExpenseDTO;
import com.vishwag.expence.tracker.application.entity.Expense;
import com.vishwag.expence.tracker.application.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseRepository repo;


    //add expenses
    @Override
    public Expense addExpense(ExpenseDTO dto) {
        Expense expense = new Expense();
        expense.setCategory(dto.getCategory());
        expense.setAmount(dto.getAmount());
        expense.setDate(LocalDate.parse((dto.getDate())));
        expense.setDescription(dto.getDescription());

        return repo.save(expense);
    }

    //to get all expenses
    @Override
    public List<Expense> getAllExpenses() {
        return repo.findAll();
    }

    //get expense by id
    @Override
    public Expense getExpenseById(Long id) {
        return repo.findById(id).orElse(null);
    }

    //to update the expense
    @Override
    public Expense updateExpense(Long id, ExpenseDTO dto) {
        Expense expense = repo.findById(id).orElse(null);
        if (expense == null) {
            return null;
        }
        expense.setCategory(dto.getCategory());
        expense.setAmount(dto.getAmount());
        expense.setDate(LocalDate.parse(dto.getDate()));
        expense.setDescription(dto.getDescription());

        return repo.save(expense);
    }

    //to delete the expense
    @Override
    public void deleteExpense(Long id) {
        repo.deleteById(id);
    }

    //to get expenses total for specific month
    @Override
    public Double getMonthlytotal(int month, int year) {
        List<Expense> expenses = repo.findAll();
        double total = 0.0;
        for (Expense e : expenses) {
            if (e.getDate() == null || e.getAmount() == null) {
                continue;
            }
            if (e.getDate().getYear() == year && e.getDate().getMonthValue() == month) {
                total = total + e.getAmount();
            }
        }
        return total;
    }

    //to get expense total by category
    @Override
    public Double getCategoryTotal(String category) {
        List<Expense> expenses = repo.findAll();
        double total = 0.0;
        for (Expense e : expenses) {
            if (e.getCategory() != null && e.getCategory().equalsIgnoreCase(category)) {

                total = total + e.getAmount();
            }
            System.out.println("category filter" + category + " total " + total);

        }

        return total;
    }

    // to get expense total for today
    @Override
    public Double getTodayTotal() {
        List<Expense> expenses = repo.findAll();
        double total = 0.0;
        LocalDate today = LocalDate.now();
        for (Expense e : expenses){
            if (e.getDate()!= null && e.getDate().isEqual(today)){
                total = total+e.getAmount();

            }

        }
        return total;
    }

    // to get expense total for week
    @Override
    public Double getWeeklyTotal() {
        List<Expense> expenses = repo.findAll();
        double total = 0.0;
        LocalDate today = LocalDate.now();
        LocalDate week = today.minusDays(7);

        for (Expense e : expenses){

            if (e.getDate() != null && !e.getDate().isBefore(week) && !e.getDate().isAfter(today)){
                total = total + e.getAmount();
            }

        }
        return  total;
    }

    // to get all expenses by latest date
    @Override
    public List<Expense> getAllExpensesSorted() {
        return repo.findAllByOrderByDateDesc();
    }

    // return this total to dashboard
    @Override
    public Double getTotalAmount() {
        double total = 0.0;
        for (Expense e : repo.findAll()){
            total = total + e.getAmount();
        }
        return total;
    }


}
