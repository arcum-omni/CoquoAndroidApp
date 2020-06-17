package com.ebookfrenzy.myapplication.ui.dishes;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ebookfrenzy.myapplication.R;

public class DishesFragment extends Fragment {

    Button btn_addDish, btn_viewAllDishes;
    EditText et_dishName, et_dishDescription;
    Switch sw_isFavorite;
    ListView lv_dishList;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dishes, container, false);

        btn_addDish = root.findViewById(R.id.btn_AddDish);
        btn_viewAllDishes = root.findViewById(R.id.btn_viewAllDishes);
        et_dishName = root.findViewById(R.id.et_dishName);
        et_dishDescription = root.findViewById((R.id.et_dishDescription));
        sw_isFavorite = root.findViewById(R.id.sw_isFavorite);
        lv_dishList = root.findViewById(R.id.lv_dishList);

        btn_addDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish(-1, et_dishName.getText().toString(), et_dishDescription.getText().toString(), sw_isFavorite.isChecked());
                Toast.makeText(getContext(), dish.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btn_viewAllDishes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "View All Dishes Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}