package com.ebookfrenzy.myapplication.ui.ingredients;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ebookfrenzy.myapplication.MainActivity;
import com.ebookfrenzy.myapplication.R;

public class IngredientsFragment extends Fragment {
//    private IngredientFragmentListener listener;
    Button btn_addIngredients, btn_viewAllIngredients;
    EditText et_ingredientName, et_ingredientDescription;
    Switch sw_inPantry;
    ListView lv_ingredientList;

//    public interface IngredientFragmentListener {
//        void onInputIngredientSent(CharSequence input);
//    }

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

        btn_addIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ingredient ingredient = new Ingredient(-1, et_ingredientName.getText().toString(), et_ingredientDescription.getText().toString(), sw_inPantry.isChecked());
                Toast.makeText(getContext(), ingredient.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btn_viewAllIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clicked View All Ingredients", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}