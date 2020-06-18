package com.ebookfrenzy.myapplication;

/*  References:
    Shad Sluiter
    https://www.youtube.com/watch?v=hDSVInZ2JCs&t=1646s

    Android Developer Doc's
    https://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ebookfrenzy.myapplication.ui.dishes.Dish;
import com.ebookfrenzy.myapplication.ui.ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String INGREDIENT_TABLE = "ingredient_table";
    public static final String column_INGREDIENT_NAME = "ingredient_name";
    public static final String column_INGREDIENT_DESCRIPTION = "ingredient_description";
    public static final String column_IN_PANTRY = "in_pantry";
    public static final String column_INGREDIENT_ID = "ingredient_id";

    public static final String DISH_TABLE = "dish";
    public static final String column_DISH_NAME = "dish_name";
    public static final String column_DISH_DESCRIPTION = "dish_description";
    public static final String column_IS_FAVORITE = "is_favorite";
    public static final String column_DISH_ID = "dish_id";


    public DatabaseHelper(@Nullable Context context) {
        super(context, "pantryInventory.db", null, 1);
    }

    // this is called the first time a database object is accessed.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createIngredientsTable = "create table " + INGREDIENT_TABLE + " (" + column_INGREDIENT_ID + " integer primary key autoincrement, " + column_INGREDIENT_NAME + " text,  " + column_INGREDIENT_DESCRIPTION + " text, " + column_IN_PANTRY + " bool)";
        db.execSQL(createIngredientsTable);

        String createDishesTable = "create table " + DISH_TABLE + " (" + column_DISH_ID + " integer primary key autoincrement, " + column_DISH_NAME + " text,  " + column_DISH_DESCRIPTION + " text, " + column_IS_FAVORITE + " bool)";
        db.execSQL(createDishesTable);
    }

    // this is called if the database version number changes, update schema.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO: implement method
    }

    public boolean addIngredient(Ingredient ingredient){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(column_INGREDIENT_NAME, ingredient.getIngredientName());
        cv.put(column_INGREDIENT_DESCRIPTION, ingredient.getIngredientDescription());
        cv.put(column_IN_PANTRY, ingredient.isInPantry());

        long insert = db.insert(INGREDIENT_TABLE, null, cv);
        if (insert <= 0) {
            return false;
        } else{
            return true;
        }
    }

    public boolean addDish(Dish dish){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(column_DISH_NAME, dish.getDishName());
        cv.put(column_DISH_DESCRIPTION, dish.getDishDescription());
        cv.put(column_IS_FAVORITE, dish.isFavorite());

        long insert = db.insert(DISH_TABLE, null, cv);
        if (insert <= 0) {
            return false;
        } else{
            return true;
        }
    }

    public List<Ingredient> getAllIngredients(){
        List<Ingredient> returnIngredientsList = new ArrayList<>();

        String queryString = "SELECT * FROM " + INGREDIENT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor ingredientsCursor = db.rawQuery(queryString, null);

        if(ingredientsCursor.moveToFirst()){
            // loop through results
            do{
                int ingredientID = ingredientsCursor.getInt(0);
                String ingredientName = ingredientsCursor.getString(1);
                String ingredientDescription = ingredientsCursor.getString(2);
                boolean isInPantry = ingredientsCursor.getInt(3) == 1 ? true: false;

                Ingredient newIngredient = new Ingredient(ingredientID, ingredientName, ingredientDescription, isInPantry);
                returnIngredientsList.add(newIngredient);

            } while (ingredientsCursor.moveToNext());


        } else{
            // failure, did not add anything to the list.
        }

        // House keeping
        ingredientsCursor.close();
        db.close();
        return returnIngredientsList;
    }

    public List<Dish> getAllDishes(){
        List<Dish> returnDishesList = new ArrayList<>();

        String queryString = "SELECT * FROM " + DISH_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor dishesCursor = db.rawQuery(queryString, null);

        if(dishesCursor.moveToFirst()){
            // loop through results
            do{
                int dishID = dishesCursor.getInt(0);
                String dishName = dishesCursor.getString(1);
                String dishDescription = dishesCursor.getString(2);
                boolean isFavorite = dishesCursor.getInt(3) == 1 ? true: false;

                Dish newDish = new Dish(dishID, dishName, dishDescription, isFavorite);
                returnDishesList.add(newDish);

            } while (dishesCursor.moveToNext());


        } else{
            // failure, did not add anything to the list.
        }

        // House keeping
        dishesCursor.close();
        db.close();
        return returnDishesList;
    }

    /*
    * find ingredient in DB, delete it, and return true
    * if ingredient is not found, return false
    * */
    public boolean deleteIngredient(Ingredient ingredient){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "delete from " + INGREDIENT_TABLE + " where " + column_INGREDIENT_ID + " = " + ingredient.getIngredientID();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            return true;
        } else {
            return false;
        }
    }

    /*
     * find dish in DB, delete it, and return true
     * if dish is not found, return false
     * */
    public boolean deleteDish(Dish dish){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "delete from " + DISH_TABLE + " where " + column_DISH_ID + " = " + dish.getDishID();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            return true;
        } else {
            return false;
        }
    }
}
