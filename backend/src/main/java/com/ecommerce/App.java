package com.ecommerce;

public class App {
    public static void main(String[] args) {
        System.out.println("App started successfully!");

        while (true) {
            try {
                Thread.sleep(10000);
            } catch (Exception e) {}
        }
    }
}
