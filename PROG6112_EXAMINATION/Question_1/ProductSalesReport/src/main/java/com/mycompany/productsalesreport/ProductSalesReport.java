/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsalesreport;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSalesReport {

    public static void main(String[] args) {
          // Initialize the product sales data
        int[][] productSales = {
            {300, 150, 700}, // Year 1: Quarter 1, Quarter 2, Quarter 3
            {250, 200, 600}  // Year 2: Quarter 1, Quarter 2, Quarter 3
        };
        
        // Create ProductSales instance
        ProductSales salesCalculator = new ProductSales();
        
        // Calculate statistics
        int totalSales = salesCalculator.TotalSales(productSales);
        double averageSales = salesCalculator.AverageSales(productSales);
        int maxSale = salesCalculator.MaxSale(productSales);
        int minSale = salesCalculator.MinSale(productSales);
        
        // Display the report
        System.out.println("PRODUCT SALES REPORT – 2025");
        System.out.println("Total sales: " + totalSales);
        System.out.println("Average sales: " + Math.round(averageSales));
        System.out.println("Maximum sale: " + maxSale);
        System.out.println("Minimum sale: " + minSale);
        
        // Display the data table
        System.out.println("\nSales Data Table:");
        System.out.println("|         | QUARTER 1 | QUARTER 2 | QUARTER 3 |");
        System.out.println("|---------|-----------|-----------|-----------|");
        System.out.println("| YEAR 1  | " + productSales[0][0] + "     | " + 
                         productSales[0][1] + "     | " + productSales[0][2] + "     |");
        System.out.println("| YEAR 2  | " + productSales[1][0] + "     | " + 
                         productSales[1][1] + "     | " + productSales[1][2] + "     |");
    }
}
