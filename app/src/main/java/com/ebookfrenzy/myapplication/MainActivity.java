package com.ebookfrenzy.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.ebookfrenzy.myapplication.ui.dishes.Dish;
import com.ebookfrenzy.myapplication.ui.ingredients.Ingredient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    // references to buttons and other controls on the layout
    Button btn_addIngredients, btn_viewAllIngredients, btn_addDish, btn_viewAllDishes;
    EditText et_ingredientName, et_ingredientDescription, et_dishName, et_dishDescription;
    Switch sw_inPantry, sw_isFavorite;
    ListView lv_ingredientList, lv_dishList;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_addIngredients = findViewById(R.id.btn_AddIngredients);
        btn_viewAllIngredients = findViewById(R.id.btn_viewAllIngredients);
        et_ingredientName = findViewById(R.id.et_ingredientName);
        et_ingredientDescription = findViewById(R.id.et_ingredientDescription);
        sw_inPantry = findViewById(R.id.sw_inPantry);
        lv_ingredientList = findViewById(R.id.lv_ingredientList);

        btn_addDish = findViewById(R.id.btn_AddDish);
        btn_viewAllDishes = findViewById(R.id.btn_viewAllDishes);
        et_dishName = findViewById(R.id.et_dishName);
        et_dishDescription = findViewById((R.id.et_dishDescription));
        sw_isFavorite = findViewById(R.id.sw_isFavorite);
        lv_dishList = findViewById(R.id.lv_dishList);


//        btn_addIngredients.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Ingredient ingredient = new Ingredient(-1, et_ingredientName.getText().toString(), et_ingredientDescription.getText().toString(), sw_inPantry.isChecked());
//                Toast.makeText(MainActivity.this, "Ingredient Added", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        btn_viewAllIngredients.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "View All Ingredients", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        btn_addDish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Dish dish = new Dish(-1, et_dishName.getText().toString(), et_dishDescription.getText().toString(), sw_isFavorite.isChecked());
//                Toast.makeText(MainActivity.this, "Dish Added", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        btn_viewAllDishes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "View All Dishes", Toast.LENGTH_SHORT).show();
//            }
//        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Coquó Support", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}