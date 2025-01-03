package com.example.demo;

public class Todo {
    private int id;
    private String item;

    // Constructor
    public Todo(int id, String item) {
        this.id = id;
        this.item = item;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for item
    public String getItem() {
        return item;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Setter for item
    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Todo{id=" + id + ", item='" + item + "'}";
    }

    public static void main(String[] args) {
    }
}
