/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesapp;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSales implements iProductSales {
    private int[][] salesData;
    private static final int SALES_LIMIT = 500;
    
    public ProductSales(int[][] salesData) {
        this.salesData = salesData;
    }
    
    @Override
    public int[][] getProductSales() {
        return salesData;
    }
    
    @Override
    public int getTotalSales() {
        int total = 0;
        for (int[] yearSales : salesData) {
            for (int sale : yearSales) {
                total += sale;
            }
        }
        return total;
    }
    
    @Override
    public int getSalesOverLimit() {
        int count = 0;
        for (int[] yearSales : salesData) {
            for (int sale : yearSales) {
                if (sale > SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }
    
    @Override
    public int getSalesUnderLimit() {
        int count = 0;
        for (int[] yearSales : salesData) {
            for (int sale : yearSales) {
                if (sale <= SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }
    
    @Override
    public int getProductsProcessed() {
        return salesData.length; // Number of years processed
    }
    
    @Override
    public double getAverageSales() {
        int totalSales = getTotalSales();
        int totalProducts = salesData.length * salesData[0].length;
        return (double) totalSales / totalProducts;
    }
}
