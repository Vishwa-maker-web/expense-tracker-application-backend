package com.vishwag.expence.tracker.application.dto;

public class DasboardDTO {
    private Double today;
    private Double week;
    private Double month;
    private Double total;
    public Double getToday() {
        return today;
    }

    public void setToday(Double today) {
        this.today = today;
    }

    public Double getWeek() {
        return week;
    }

    public void setWeek(Double week) {
        this.week = week;
    }

    public Double getMonth() {
        return month;
    }

    public void setMonth(Double month) {
        this.month = month;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }




    public DasboardDTO(Double today, Double week, Double month, Double total) {
        this.today = today;
        this.week = week;
        this.month = month;
        this.total = total;
    }
}
