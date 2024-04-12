package com.example.demograbfood;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demograbfood.Model.Food;
import com.example.demograbfood.adapter.FoodMenuAdapter;

import java.util.ArrayList;

public class MenuRestaurantActivity extends AppCompatActivity {
    ImageButton btn_back_menu_restaurant;
    ImageView img_menuRestaurant;
    TextView txt_menuRestaurant, txt_danhgia_menuRestaurant;
    RecyclerView rcv_menuRestaurant;
    ArrayList<Food> foodArrayList;

    FoodMenuAdapter foodMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_restaurant);
        addControl();
        loadData();
    }

    private void loadData() {
        Intent intent = getIntent();
        byte[] img = intent.getByteArrayExtra("hinh");
        String ten = intent.getStringExtra("ten");
        String danhgia = intent.getStringExtra("danhgia");
        Bitmap bitmap = ImageUtils.convertByteArrayToBitmap(img);
        //img_menuRestaurant.setImageBitmap(bitmap);
        txt_danhgia_menuRestaurant.setText(danhgia);
        txt_menuRestaurant.setText(ten);
        byte[] imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.pizza);
        foodArrayList.add(new Food(imageBytes,"pizza","20.000"));
        foodArrayList.add(new Food(imageBytes,"pizza","20.000"));
        foodArrayList.add(new Food(imageBytes,"pizza","20.000"));
        foodArrayList.add(new Food(imageBytes,"pizza","20.000"));
        foodArrayList.add(new Food(imageBytes,"pizza","20.000"));
    }

    private void addControl() {
        img_menuRestaurant = findViewById(R.id.img_menuRestaurant);
        btn_back_menu_restaurant = findViewById(R.id.btn_back_menu_restaurant);
        txt_menuRestaurant = findViewById(R.id.txt_menuRestaurant);
        rcv_menuRestaurant = findViewById(R.id.rcv_menuRestaurant);
        txt_danhgia_menuRestaurant = findViewById(R.id.txt_danhgia_menuRestaurant);
        foodArrayList = new ArrayList<>();
        foodMenuAdapter = new FoodMenuAdapter(this, foodArrayList);
        rcv_menuRestaurant.setAdapter(foodMenuAdapter);
        rcv_menuRestaurant.setLayoutManager(new GridLayoutManager(this, 2));
        foodMenuAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(String data) {
                Intent intent = new Intent(MenuRestaurantActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
    }
}