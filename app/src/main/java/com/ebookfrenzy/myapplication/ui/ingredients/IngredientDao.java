package com.ebookfrenzy.myapplication.ui.ingredients;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.ebookfrenzy.myapplication.ui.ingredients.Ingredient;

import java.util.List;

@Dao
public interface IngredientDao{
    @Query("select * from ingredients")
    LiveData<List<Ingredient>> getAllIngredients();
}
