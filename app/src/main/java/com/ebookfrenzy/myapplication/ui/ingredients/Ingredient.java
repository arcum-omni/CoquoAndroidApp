package com.ebookfrenzy.myapplication.ui.ingredients;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import java.util.List;

@Entity(tableName = "ingredients")
public class Ingredient {
    private int IngredientID;
    private String IngredientName;
    private String IngredientDescription;
    private boolean inPantry;

    // No arg constructors
    public Ingredient() {
    }

    // Constructor
    public Ingredient(int ingredientID, String ingredientName, String ingredientDescription, boolean inStock) {
        IngredientID = ingredientID;
        IngredientName = ingredientName;
        IngredientDescription = ingredientDescription;
        inPantry = inStock;
    }

    // Getters
    public int getIngredientID() {
        return IngredientID;
    }

    public String getIngredientName() {
        return IngredientName;
    }

    public String getIngredientDescription() {
        return IngredientDescription;
    }

    public boolean isInPantry() {
        return inPantry;
    }

    // Setters
    public void setIngredientID(int ingredientID) {
        IngredientID = ingredientID;
    }

    public void setIngredientName(String ingredientName) {
        IngredientName = ingredientName;
    }

    public void setIngredientDescription(String ingredientDescription) {
        IngredientDescription = ingredientDescription;
    }

    public void setInPantry(boolean inPantry) {
        this.inPantry = inPantry;
    }

    // To String Method
    @Override
    public String toString() {
        String inStock = "";
        if(!inPantry){
            inStock = " (Need to Buy)";
        }
        return IngredientName + ", " + IngredientDescription + inStock;
//        return "Ingredient{" +
//                "IngredientID=" + IngredientID +
//                ", IngredientName='" + IngredientName + '\'' +
//                ", IngredientDescription='" + IngredientDescription + '\'' +
//                ", inPantry=" + inPantry +
//                '}';
    }
}

