package com.example.foodorderapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodorderapp.R;
import com.example.foodorderapp.db.ManagementCart;
import com.example.foodorderapp.entities.Food;
import com.squareup.picasso.Picasso;

public class ShowDetailsActivity extends AppCompatActivity {

    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private Food object;
    int numberOrder = 1;
    private ManagementCart managementCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        managementCart = new ManagementCart(this);
        initComponents();

        getBundle();
    }

    private void getBundle(){

        object = (Food) getIntent().getSerializableExtra("object");

        String txtImage = object.getImage();

        Picasso.get().load(txtImage).into(picFood);
//        int drawableResourceId= this.getResources().getIdentifier(object.getImage(), "drawable", this.getPackageName());
//        Glide.with(this)
//                .load(drawableResourceId)
//                .into(picFood);
        titleTxt.setText(object.getName());
        feeTxt.setText("$" + object.getPrice());
      //  descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));

            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder - 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));

            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
                startActivity(new Intent(ShowDetailsActivity.this, MainActivity.class));

            }
        });
    }

    private void initComponents(){
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.textTitle);
        feeTxt = findViewById(R.id.priceText);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        picFood = findViewById(R.id.detailsFoodPic);
    }

}