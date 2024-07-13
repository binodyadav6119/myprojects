package com.deals.deals.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//@Data

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Deals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String itemName;
    private double price;
    private int totalItems;
    private int claimedItems;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean active;

    public Deals(Long id, String itemName, double price, int totalItems, int claimedItems, LocalDateTime startTime, LocalDateTime endTime, boolean active) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.totalItems = totalItems;
        this.claimedItems = claimedItems;
        this.startTime = startTime;
        this.endTime = endTime;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getClaimedItems() {
        return claimedItems;
    }

    public void setClaimedItems(int claimedItems) {
        this.claimedItems = claimedItems;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
