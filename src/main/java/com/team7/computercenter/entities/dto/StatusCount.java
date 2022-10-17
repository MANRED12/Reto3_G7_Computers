package com.team7.computercenter.entities.dto;

public class StatusCount {

    private Integer completed;
    private Integer cancelled;

    public StatusCount(Object completed, Object cancelled) {
        this.completed=Integer.parseInt(completed.toString());
        this.cancelled=Integer.parseInt(cancelled.toString());

    }

    public StatusCount(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }
}
