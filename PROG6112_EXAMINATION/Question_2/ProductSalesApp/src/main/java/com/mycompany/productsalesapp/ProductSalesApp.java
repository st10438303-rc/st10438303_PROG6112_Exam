/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsalesapp;

/**
 *
 * @author RC_Student_Lab
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ProductSalesApp extends JFrame {
    private JTextArea textArea;
    private JLabel yearsProcessedLabel;
    private ProductSales productSales;
    private JButton loadButton, saveButton;
    
    public ProductSalesApp() {
        initializeGUI();
        setupMenu();
    }
    
    private void initializeGUI() {
        setTitle("Product Sales Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        
        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Text area for displaying data
        textArea = new JTextArea(15, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Control panel with buttons
        JPanel controlPanel = new JPanel();
        loadButton = new JButton("Load Product Data");
        saveButton = new JButton("Save Product Data");
        
        loadButton.addActionListener(new LoadButtonListener());
        saveButton.addActionListener(new SaveButtonListener());
        
        controlPanel.add(loadButton);
        controlPanel.add(saveButton);
        
        // Status panel
        JPanel statusPanel = new JPanel(new FlowLayout());
        yearsProcessedLabel = new JLabel("Years Processed: 0");
        statusPanel.add(yearsProcessedLabel);
        
        // Add components to main panel
        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(statusPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();
        
        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);
        
        // Tools menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadMenuItem = new JMenuItem("Load Product Data");
        JMenuItem saveMenuItem = new JMenuItem("Save Product Data");
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        
        loadMenuItem.addActionListener(new LoadButtonListener());
        saveMenuItem.addActionListener(new SaveButtonListener());
        clearMenuItem.addActionListener(e -> {
            textArea.setText("");
            yearsProcessedLabel.setText("Years Processed: 0");
        });
        
        toolsMenu.add(loadMenuItem);
        toolsMenu.add(saveMenuItem);
        toolsMenu.add(clearMenuItem);
        
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        
        setJMenuBar(menuBar);
    }
    
    private class LoadButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loadProductData();
        }
    }
    
    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveProductData();
        }
    }
    
    private void loadProductData() {
        // Sample data as requirements
        int[][] salesData = {
            {300, 150, 700}, // Year 1: Microphone, Speakers, Mixing Desk
            {250, 200, 600}  // Year 2: Microphone, Speakers, Mixing Desk
        };
        
        productSales = new ProductSales(salesData);
        
        // Display results
        StringBuilder sb = new StringBuilder();
        sb.append("Product Sales Data:\n");
        sb.append("===================\n");
        sb.append(String.format("%-15s %-12s %-12s %-12s\n", 
            "Year", "Microphone", "Speakers", "Mixing Desk"));
        sb.append(String.format("%-15s %-12d %-12d %-12d\n", 
            "Year 1", salesData[0][0], salesData[0][1], salesData[0][2]));
        sb.append(String.format("%-15s %-12d %-12d %-12d\n", 
            "Year 2", salesData[1][0], salesData[1][1], salesData[1][2]));
        sb.append("\n");
        sb.append("Summary:\n");
        sb.append("========\n");
        sb.append("Total Sales: ").append(productSales.getTotalSales()).append("\n");
        sb.append("Average Sales: ").append(String.format("%.0f", productSales.getAverageSales())).append("\n");
        sb.append("Sales over limit: ").append(productSales.getSalesOverLimit()).append("\n");
        sb.append("Sales under limit: ").append(productSales.getSalesUnderLimit()).append("\n");
        
        textArea.setText(sb.toString());
        yearsProcessedLabel.setText("Years Processed: " + productSales.getProductsProcessed());
    }
    
    private void saveProductData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt"))) {
            writer.println("Data Log");
            writer.println("*******************************");
            if (productSales != null) {
                writer.println("Total Sales: " + productSales.getTotalSales());
                writer.println("Average Sales: " + String.format("%.0f", productSales.getAverageSales()));
                writer.println("Sales over limit: " + productSales.getSalesOverLimit());
                writer.println("Sales under limit: " + productSales.getSalesUnderLimit());
            } else {
                writer.println("No data loaded");
            }
            writer.println("*******************************");
            JOptionPane.showMessageDialog(this, "Data saved to data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductSalesApp().setVisible(true);
        });
    }
}
