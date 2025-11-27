package com.vishwag.expence.tracker.application.controller;

import com.vishwag.expence.tracker.application.dto.DasboardDTO;
import com.vishwag.expence.tracker.application.dto.ExpenseDTO;
import com.vishwag.expence.tracker.application.entity.Expense;
import com.vishwag.expence.tracker.application.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {
    @Autowired
    private ExpenseService service;

    //add expenses
    @PostMapping("/expenses")
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseDTO dto){
        Expense saved = service.addExpense(dto);
        return ResponseEntity.ok(saved);
    }

    //to get all expenses
     @GetMapping("/expenses")
    public List<Expense> getAllExpenses(){
        return service.getAllExpenses();
    }

    //to get expense by id
    @GetMapping("/expenses/{id}")
    public ResponseEntity<Expense> getExpensesById(@PathVariable Long id ){
        Expense expense = service.getExpenseById(id);
        if (expense == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(expense);
    }

   //to update the expense
   @PutMapping("/expenses/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id ,@RequestBody ExpenseDTO dto){
        Expense updated = service.updateExpense(id,dto);
        if (updated==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }
    //to delete the expense
    @DeleteMapping("/expenses/{id}")
    public ResponseEntity<Expense> deleteBy(@PathVariable Long id){
        service.deleteExpense(id);
        return ResponseEntity.noContent().build();

    }

    //to get expenses total for specific month
    @GetMapping("/expenses/summary/month")
    public ResponseEntity<String> getMonthSummary(@RequestParam int month, @RequestParam int year){
        Double total  = service.getMonthlytotal(month, year);
        String message = " total amount spent on this month :  "+ total;
        return ResponseEntity.ok(message);
    }

    //to get expense total by category
    @GetMapping("/expenses/summary/category/{category}")
    public ResponseEntity<String> getCategorySummary(@PathVariable String category){
        Double total = service.getCategoryTotal(category);
        String message = " Total Amount Spent On "+ category + " is "+ total;
     return ResponseEntity.ok(message);
    }

    // to get expense total for today
    @GetMapping("/expenses/summary/today")
    public ResponseEntity<String>getTodaySummary(){
        Double total = service.getTodayTotal();
        String message = "Total spent on today "+ total;
       return ResponseEntity.ok(message);
    }

    // to get expense total for week
    @GetMapping("/expenses/summary/week")
        public ResponseEntity<String> getWeeklySummary(){
            Double total = service.getWeeklyTotal();
            String message = "total spent this week is "+total;
          return   ResponseEntity.ok(message);
        }

        // to get all expenses by latest date
     @GetMapping("/expenses/latest")
    public ResponseEntity<List<Expense>>getAllExpensesSorted(){
        return ResponseEntity.ok(service.getAllExpensesSorted());
     }

     // dashboard summary of amount
    @GetMapping("/dashboard")
    public ResponseEntity<DasboardDTO> getDashboard(){
        Double today = service.getTodayTotal();
        Double week = service.getWeeklyTotal();
        Double month = service.getMonthlytotal(LocalDate.now().getMonthValue(),LocalDate.now().getYear());
        Double total = service.getTotalAmount();

        DasboardDTO dasboardDTO = new DasboardDTO(today,week,month,total);
       return ResponseEntity.ok(dasboardDTO);
    }
}
