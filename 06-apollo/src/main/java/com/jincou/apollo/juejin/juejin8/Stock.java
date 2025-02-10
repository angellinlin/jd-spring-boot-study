package com.jincou.apollo.juejin.juejin8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouguilong6
 * @date 2025/1/17 14:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    private String name;
    private double price;
    private List<Investor> observers = new ArrayList<>();

    public void setPrice(double newPrice){
        if(newPrice != this.price){
            this.price = newPrice;
            notifyInvestor();
        }
    }

    public void subScribe(Investor investor){
        observers.add(investor);
    }

    public void unScribe(Investor investor){
        observers.remove(investor);
    }

    public void notifyInvestor(){
        for (Investor observer : observers) {
            observer.update(this,price);
        }
    }

}
