/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesreport;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSales implements iProductSales {
    
    @Override
    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int[] productSale : productSales) {
            for (int j = 0; j < productSale.length; j++) {
                total += productSale[j];
            }
        }
        return total;
    }
    
    @Override
    public double AverageSales(int[][] productSales) {
        int total = TotalSales(productSales);
        int count = 0;
        
        for (int i = 0; i < productSales.length; i++) {
            count += productSales[i].length;
        }
        
        return (double) total / count;
    }
    
    @Override
    public int MaxSale(int[][] productSales) {
        int max = productSales[0][0];
        for (int[] productSale : productSales) {
            for (int j = 0; j < productSale.length; j++) {
                if (productSale[j] > max) {
                    max = productSale[j];
                }
            }
        }
        return max;
    }
    
    @Override
    public int MinSale(int[][] productSales) {
        int min = productSales[0][0];
        for (int[] productSale : productSales) {
            for (int j = 0; j < productSale.length; j++) {
                if (productSale[j] < min) {
                    min = productSale[j];
                }
            }
        }
        return min;
    }
}
