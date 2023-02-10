package com.example.foodorderapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.foodorderapp.Interface.ChangeCategoryItemsListener;
import com.example.foodorderapp.R;
import com.example.foodorderapp.adapter.CategoryAdapter;
import com.example.foodorderapp.adapter.FoodAdapterOld;
import com.example.foodorderapp.common.Project;
import com.example.foodorderapp.db.WMDBAPI;
import com.example.foodorderapp.domain.CategoryDomain;
import com.example.foodorderapp.entities.FoodTypes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ChangeCategoryItemsListener {

    private RecyclerView.Adapter adapter;
     RecyclerView recyclerViewCategoryList;
     RecyclerView recyclerViewFoodList;
    private Context mContext;

    WMDBAPI db;
    Project project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        project = Project.APP_INSTANCE;
        mContext = this;
        setContentView(R.layout.activity_main);

        initComponents();
        initList();

        bottomNavigation();
    }
    private void initComponents(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList= findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        recyclerViewFoodList = findViewById(R.id.recycleViewFood);
        recyclerViewFoodList.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerViewFoodList.setItemAnimator(new DefaultItemAnimator());

        db = Project.APP_INSTANCE.getWMDBAPI();
        project.setmArrayListFood(db.loadAllFoodList());
    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.mainFloatingBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }
//
//    private void recyclerViewCategory(){
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewCategoryList= findViewById(R.id.recyclerView);
//        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
//
//        ArrayList<CategoryDomain> category= new ArrayList<>();
//        category.add(new CategoryDomain("pizza", "cat_1"));
//        category.add(new CategoryDomain("burger", "cat_2"));
//        category.add(new CategoryDomain("hotdog", "cat_3"));
//        category.add(new CategoryDomain("drink", "cat_4"));
//        category.add(new CategoryDomain("donut", "cat_5"));
//
//        adapter = new CategoryAdapter(category, );
//        recyclerViewCategoryList.setAdapter(adapter);
//    }
//
//    public void recyclerViewFood(){
//        recyclerViewFoodList = findViewById(R.id.recycleViewFood);
//        recyclerViewFoodList.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerViewFoodList.setItemAnimator(new DefaultItemAnimator());
//
//        db = Project.APP_INSTANCE.getWMDBAPI();
//        project.setmArrayListFood(db.loadAllFoodList());
//
//        FoodAdapterOld recyclerViewAdapter = new FoodAdapterOld(mContext, project.getmArrayListFood(), null);
//        recyclerViewFoodList.setAdapter(recyclerViewAdapter);
//    }

    private  void initList(){
        ArrayList<CategoryDomain> category= new ArrayList<>();
        category.add(new CategoryDomain("pizza", "cat_1"));
        category.add(new CategoryDomain("burger", "cat_2"));
        category.add(new CategoryDomain("hotdog", "cat_3"));
        category.add(new CategoryDomain("drink", "cat_4"));
        category.add(new CategoryDomain("donut", "cat_5"));

        adapter = new CategoryAdapter(category,  new ChangeCategoryItemsListener() {
            @Override
            public void onCategoryClick(int category) {
                updateTab(category);
            }
        });

        recyclerViewCategoryList.setAdapter(adapter);

    }

    public void updateTab(int id){

        switch (id) {
            case 0:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.Pizza));
                break;
            case 1:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.Burger));
                break;
            case 2:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.HotDog));
                break;
            case 3:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.Drinks));
                break;
            case 4:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.Donuts));
                break;
            case 10:
                project.setmArrayListFood(db.loadAllFoodList());
            break;

        }
        FoodAdapterOld recyclerViewAdapter = new FoodAdapterOld(mContext, project.getmArrayListFood(), null);
        recyclerViewFoodList.setAdapter(recyclerViewAdapter);

    }

    @Override
    public void onCategoryClick(int category) {
        switch (category) {
            case 0:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.Burger));
                break;
            case 1:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.Pizza));
                break;
            case 2:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.HotDog));
                break;
            case 3:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.Drinks));
                break;
            case 4:
                project.setmArrayListFood(db.loadFoodList(FoodTypes.Donuts));
                break;
        }
        FoodAdapterOld recyclerViewAdapter = new FoodAdapterOld(mContext, project.getmArrayListFood(), null);
        recyclerViewFoodList.setAdapter(recyclerViewAdapter);
    }
}



















//       old
//    private void recyclerViewFood(){
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewFoodList= findViewById(R.id.recycleViewFood);
//        recyclerViewFoodList.setLayoutManager(linearLayoutManager);
//
//        ArrayList<Food> foods = new ArrayList<>();
//        foods.add(new Food(1,10, "Big Mac", FoodTypes.Burger,"pop_2"));
//        foods.add(new Food(2,15, "Pizza", FoodTypes.Pizza,"pop_1"));
//        foods.add(new Food(3,20, "Pizza vegetables", FoodTypes.Pizza,"pop_3"));
//        adapter2 = new FoodAdapter(foods);
////        db = Project.APP_INSTANCE.getWMDBAPI();
////        project.setmArrayListFood(db.loadFoodList(FoodTypes.Burger));
//
//
//      //  FoodAdapter recyclerViewAdapter = new FoodAdapter(project.getmArrayListFood());
//        recyclerViewFoodList.setAdapter(adapter2);
//    }