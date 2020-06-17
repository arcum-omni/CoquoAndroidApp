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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ebookfrenzy.myapplication.R;

public class DishesFragment extends Fragment {

    private DishesViewModel dishesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dishesViewModel = ViewModelProviders.of(this).get(DishesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dishes, container, false);
        final TextView textView = root.findViewById(R.id.et_dishName);
        return root;
    }
}

//    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        dishesViewModel = ViewModelProviders.of(this).get(DishesViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_dishes, container, false);
//        final TextView textView = root.findViewById(R.id.text_dishes);
//        dishesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {textView.setText(s);
//            }
//        });
//        return root;
//    }