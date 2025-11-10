/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.productsalesreport;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSalesTest {
    
    private ProductSales productSales;
    private int[][] testSalesData;
    
    @Before
    public void setUp() {
        productSales = new ProductSales();
        testSalesData = new int[][] {
            {300, 150, 700}, // Year 1
            {250, 200, 600}  // Year 2
        };
    }
    
    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        // Arrange
        int expectedTotal = 300 + 150 + 700 + 250 + 200 + 600; // 2200
        
        // Act
        int actualTotal = productSales.TotalSales(testSalesData);
        
        // Assert
        assertEquals("Total sales should be 2200", expectedTotal, actualTotal);
    }
    
    @Test
    public void AverageSales_ReturnsAverageProductSales() {
        // Arrange
        double expectedAverage = 2200.0 / 6.0; // 366.666...
        
        // Act
        double actualAverage = productSales.AverageSales(testSalesData);
        
        // Assert
        assertEquals("Average sales should be approximately 366.67", 
                    expectedAverage, actualAverage, 0.01);
    }
    
    @Test
    public void MaxSale_ReturnsMaximumSale() {
        // Arrange
        int expectedMax = 700;
        
        // Act
        int actualMax = productSales.MaxSale(testSalesData);
        
        // Assert
        assertEquals("Maximum sale should be 700", expectedMax, actualMax);
    }
    
    @Test
    public void MinSale_ReturnsMinimumSale() {
        // Arrange
        int expectedMin = 150;
        
        // Act
        int actualMin = productSales.MinSale(testSalesData);
        
        // Assert
        assertEquals("Minimum sale should be 150", expectedMin, actualMin);
    }
    
    @Test
    public void AverageSales_WithEmptyData_ReturnsZero() {
        // Arrange
        int[][] emptyData = new int[0][0];
        
        // Act
        double actualAverage = productSales.AverageSales(emptyData);
        
        // Assert
        assertEquals("Average with empty data should be 0", 0.0, actualAverage, 0.01);
    }
}
    

