package com.ebookfrenzy.myapplication.ui.ingredients;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ebookfrenzy.myapplication.MainActivity;
import com.ebookfrenzy.myapplication.R;

public class IngredientsViewModel extends ViewModel {

//    Button btn_addIngredients, btn_viewAllIngredients;
//    EditText et_ingredientName, et_ingredientDescription;
//    Switch sw_inPantry;
//    ListView lv_ingredientList;

    private MutableLiveData<String> mText;

    public IngredientsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ingredients fragment");

//        btn_addIngredients = btn_addIngredients.findViewById(R.id.btn_AddIngredients);
//        btn_viewAllIngredients = btn_viewAllIngredients.findViewById(R.id.btn_viewAllIngredients);
//        et_ingredientName = et_ingredientName.findViewById(R.id.et_ingredientName);
//        et_ingredientDescription = et_ingredientDescription.findViewById(R.id.et_ingredientDescription);
//        sw_inPantry = sw_inPantry.findViewById(R.id.sw_inPantry);
//        lv_ingredientList = lv_ingredientList.findViewById(R.id.lv_ingredientList);
//
//        btn_addIngredients.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(.this, "Add Ing", Toast.LENGTH_SHORT).show();
//            }
//        });

        ///        btn_addIngredients.setOnClickListener(new View.OnClickListener() {
        ////            @Override
        ////            public void onClick(View v) {
        ////                Log.e("tag", "I am an idiot!" );
        ////                //Toast.makeText(MainActivity.this, "Ingredient Added", Toast.LENGTH_SHORT).show();
        ////            }
////        });
    }

    public LiveData<String> getText() {
        return mText;
    }
}