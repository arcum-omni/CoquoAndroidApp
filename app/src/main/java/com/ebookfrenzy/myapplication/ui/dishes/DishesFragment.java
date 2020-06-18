package com.ebookfrenzy.myapplication.ui.dishes;

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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ebookfrenzy.myapplication.DatabaseHelper;
import com.ebookfrenzy.myapplication.R;
import com.ebookfrenzy.myapplication.ui.ingredients.Ingredient;

public class DishesFragment extends Fragment {
    Button btn_addDish, btn_viewAllDishes;
    EditText et_dishName, et_dishDescription;
    Switch sw_isFavorite;
    ListView lv_dishList;
    ArrayAdapter dishArrayAdapter;

    DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dishes, container, false);
        btn_addDish = root.findViewById(R.id.btn_AddDish);
        btn_viewAllDishes = root.findViewById(R.id.btn_viewAllDishes);
        et_dishName = root.findViewById(R.id.et_dishName);
        et_dishDescription = root.findViewById((R.id.et_dishDescription));
        sw_isFavorite = root.findViewById(R.id.sw_isFavorite);
        lv_dishList = root.findViewById(R.id.lv_dishList);

        databaseHelper = new DatabaseHelper(getContext());

        PopulateDishesListView(databaseHelper);

        btn_addDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish;
                try{
                    dish = new Dish(-1, et_dishName.getText().toString(), et_dishDescription.getText().toString(), sw_isFavorite.isChecked());
                    //Toast.makeText(getContext(), dish.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(getContext(), "Error creating dish", Toast.LENGTH_SHORT).show();
                    dish = new Dish(-1, "error", "error", false);
                }

                DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
                boolean success = databaseHelper.addDish(dish);
                if (success){
                    Toast.makeText(getContext(), et_dishName.getText().toString() + " Added Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Error Nothing Added to DB", Toast.LENGTH_SHORT).show();
                }

                PopulateDishesListView(databaseHelper);
            }
        });

        btn_viewAllDishes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper = new DatabaseHelper(getContext());

                PopulateDishesListView(databaseHelper);

                //Toast.makeText(getContext(), "View All Dishes Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        lv_dishList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dish clickedDish = (Dish)parent.getItemAtPosition(position);
                databaseHelper.deleteDish(clickedDish);
                PopulateDishesListView(databaseHelper);
                Toast.makeText(getContext(), clickedDish.getDishName() + "Successfully Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    private void PopulateDishesListView(DatabaseHelper databaseHelper2) {
        dishArrayAdapter = new ArrayAdapter<Dish>(getContext(), android.R.layout.simple_list_item_1, databaseHelper2.getAllDishes());
        lv_dishList.setAdapter(dishArrayAdapter);
    }
}