package com.example.recipesapp;

public class Recipe {
    private int id;
    private String name;

    public void setTime(String time) {
        this.time = time;
    }

    private String time;
    private String description;
    private int calories;

    // Constructor
    public Recipe() {}

    // Getter and Setter methods
    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
