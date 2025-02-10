package com.jincou.apollo.juejin.juejin8;

/**
 * @author zhouguilong6
 * @date 2025/1/17 14:27
 */
public class Investor {
    private String name;
    public Investor(String name){
        this.name = name;
    }

    public void update(Stock stock,double newPrice){
        //投资者收到股票价格更新的逻辑
        System.out.println("Investor: " + name + "is notified: " + "stock: " + stock.getName() + "price updated to " +newPrice);
    }
}
