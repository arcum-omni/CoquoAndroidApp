package com.ebookfrenzy.myapplication.ui.ingredients;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ebookfrenzy.myapplication.DatabaseHelper;
import com.ebookfrenzy.myapplication.R;

public class IngredientsFragment extends Fragment {
    Button btn_addIngredients, btn_viewAllIngredients;
    EditText et_ingredientName, et_ingredientDescription;
    Switch sw_inPantry;
    ListView lv_ingredientList;
    ArrayAdapter ingredientArrayAdapter;
    ArrayAdapter dishArrayAdapter;

    DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ingredients, container, false);
        btn_addIngredients = root.findViewById(R.id.btn_AddIngredients);
        btn_viewAllIngredients = root.findViewById(R.id.btn_viewAllIngredients);
        et_ingredientName = root.findViewById(R.id.et_ingredientName);
        et_ingredientDescription = root.findViewById(R.id.et_ingredientDescription);
        sw_inPantry = root.findViewById(R.id.sw_inPantry);
        lv_ingredientList = root.findViewById(R.id.lv_ingredientList);

        databaseHelper = new DatabaseHelper(getContext());

        PopulateIngredientsListView(databaseHelper);

        btn_addIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Ingredient ingredient;
                try {
                    ingredient = new Ingredient(-1, et_ingredientName.getText().toString(), et_ingredientDescription.getText().toString(), sw_inPantry.isChecked());
                    //Toast.makeText(getContext(), ingredient.toString(), Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(getContext(), "Error creating ingredient", Toast.LENGTH_SHORT).show();
                    ingredient = new Ingredient(-1, "error", "error", false);
                }

                DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
                boolean success = databaseHelper.addIngredient(ingredient);
                if (success){
                    Toast.makeText(getContext(), et_ingredientName.getText().toString() + " Added Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Error Nothing Added to DB", Toast.LENGTH_SHORT).show();
                }

                PopulateIngredientsListView(databaseHelper);
            }
        });

        btn_viewAllIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper = new DatabaseHelper(getContext());

                PopulateIngredientsListView(databaseHelper);

                //Toast.makeText(getContext(), allIngredients.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        lv_ingredientList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ingredient clickedIngredient = (Ingredient)parent.getItemAtPosition(position);
                databaseHelper.deleteIngredient(clickedIngredient);
                PopulateIngredientsListView(databaseHelper);
                Toast.makeText(getContext(), clickedIngredient.getIngredientName() + "Successfully Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    private void PopulateIngredientsListView(DatabaseHelper databaseHelper2) {
        ingredientArrayAdapter = new ArrayAdapter<Ingredient>(getContext(), android.R.layout.simple_list_item_1, databaseHelper2.getAllIngredients());
        lv_ingredientList.setAdapter(ingredientArrayAdapter);
    }
}