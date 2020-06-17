package com.ebookfrenzy.myapplication.ui.dishes;

public class Dish {
    private int DishID;
    private String DishName;
    private String DishDescription;
    private boolean isFavorite;

    // No arg constructor
    public Dish() {
    }

    // Constructor
    public Dish(int dishID, String dishName, String dishDescription, Boolean isMyFavorite) {
        DishID = dishID;
        DishName = dishName;
        DishDescription = dishDescription;
        isFavorite = isMyFavorite;
    }

    // Getters
    public int getDishID() {
        return DishID;
    }

    public String getDishName() {
        return DishName;
    }

    public String getDishDescription() {
        return DishDescription;
    }

    // Setters

    public void setDishID(int dishID) {
        DishID = dishID;
    }

    public void setDishName(String dishName) {
        DishName = dishName;
    }

    public void setDishDescription(String dishDescription) {
        DishDescription = dishDescription;
    }

    // To String Method
    @Override
    public String toString() {
        return "Dish{" +
                "DishID=" + DishID +
                ", DishName='" + DishName + '\'' +
                ", DishDescription='" + DishDescription + '\'' +
                '}';
    }
}
