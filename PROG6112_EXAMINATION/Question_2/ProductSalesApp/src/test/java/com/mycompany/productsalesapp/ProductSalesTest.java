/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.productsalesapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSalesTest {
    
    public ProductSalesTest() {
    }
    
     @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        // Arrange test
        int[][] testData = {
            {300, 150, 700}, // 700 > 500
            {250, 200, 600}  // 600 > 500
        };
        ProductSales productSales = new ProductSales(testData);
        
        // Act
        int overLimit = productSales.getSalesOverLimit();
        
        // Assert
        assertEquals(2, overLimit, "Should return 2 sales over limit (700 and 600)");
    }
    
    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        // Arrange test
        int[][] testData = {
            {300, 150, 700}, // 300, 150 <= 500
            {250, 200, 600}  // 250, 200 <= 500
        };
        ProductSales productSales = new ProductSales(testData);
        
        // Act
        int underLimit = productSales.getSalesUnderLimit();
        
        // Assert 
        assertEquals(4, underLimit, "Should return 4 sales under limit (300, 150, 250, 200)");
    }
    
    @Test
    public void GetTotalSales_ReturnsCorrectTotal() {
        // Arrange
        int[][] testData = {
            {300, 150, 700},
            {250, 200, 600}
        };
        ProductSales productSales = new ProductSales(testData);
        
        // Act
        int total = productSales.getTotalSales();
        
        // Assert
        assertEquals(2200, total, "Total should be 300+150+700+250+200+600 = 2200");
    }
    
    @Test
    public void GetAverageSales_ReturnsCorrectAverage() {
        // Arrange
        int[][] testData = {
            {300, 150, 700},
            {250, 200, 600}
        };
        ProductSales productSales = new ProductSales(testData);
        
        // Act
        double average = productSales.getAverageSales();
        
        // Assert
        assertEquals(366.66, average, 0.1, "Average should be 2200/6 ≈ 366.66");
    }
    
    @Test
    public void GetProductsProcessed_ReturnsNumberOfYears() {
        // Arrange
        int[][] testData = {
            {300, 150, 700},
            {250, 200, 600}
        };
        ProductSales productSales = new ProductSales(testData);
        
        // Act
        int yearsProcessed = productSales.getProductsProcessed();
        
        // Assert
        assertEquals(2, yearsProcessed, "Should return 2 years processed");
    }
}
    

