package com.ebookfrenzy.myapplication.ui.ingredients;

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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ebookfrenzy.myapplication.R;

public class IngredientsFragment extends Fragment {

    //private IngredientsViewModel ingredientsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_ingredients, container, false);
        final TextView textView = root.findViewById(R.id.et_ingredientName);

        return root;
    }
}

//public class IngredientsFragment extends Fragment {
//
//    private IngredientsViewModel ingredientsViewModel;
//
//    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        ingredientsViewModel = ViewModelProviders.of(this).get(IngredientsViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_ingredients, container, false);
//        final TextView textView = root.findViewById(R.id.et_ingredient);
//        ingredientsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
//    }
//}