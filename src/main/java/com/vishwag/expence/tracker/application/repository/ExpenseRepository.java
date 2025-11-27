package com.vishwag.expence.tracker.application.repository;

import com.vishwag.expence.tracker.application.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
List<Expense> findAllByOrderByDateDesc();
}
