package com.example.userprogress;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id == userData.id && Objects.equals(lastMonthExpenses, userData.lastMonthExpenses) && Objects.equals(lastMonthSavings, userData.lastMonthSavings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastMonthExpenses, lastMonthSavings);
    }
}
