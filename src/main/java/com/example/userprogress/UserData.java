package com.example.userprogress;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;


@Entity
@Table(name = "userProgress")
public class UserData {
    @Id
    private long id;
    private BigDecimal lastMonthExpenses;

    private BigDecimal lastMonthSavings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getLastMonthExpenses() {
        return lastMonthExpenses;
    }

    public void setLastMonthExpenses(BigDecimal lastMonthExpenses) {
        this.lastMonthExpenses = lastMonthExpenses;
    }

    public BigDecimal getLastMonthSavings() {
        return lastMonthSavings;
    }

    public void setLastMonthSavings(BigDecimal lastMonthSavings) {
        this.lastMonthSavings = lastMonthSavings;
    }
}
