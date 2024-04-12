package com.example.demograbfood;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.demograbfood.Model.Food;
import com.example.demograbfood.Model.Restaurant;
import com.example.demograbfood.adapter.FoodAdapter;
import com.example.demograbfood.adapter.ImageSliderAdapter;
import com.example.demograbfood.adapter.RestaurantHomeAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView, recyclerView_restaurant;
    ArrayList<Food> arr;
    ArrayList<Restaurant> restaurantArrayList;
    private ViewPager viewPager;
    private int[] images = {R.drawable.imageslide1, R.drawable.imageslide2, R.drawable.imageslide3}; // Add your image resources here
    private int currentPage = 0;
    private Timer timer;
    FoodAdapter foodAdapter;
    RestaurantHomeAdapter restaurantHomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        loadData();
        startAutoSlide();
    }

    private void startAutoSlide() {
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == images.length) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(update);
            }
        }, 1000, 3000); // Delay 1 sec, repeat every 3 sec
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    private void loadData() {
        // Chuyển drawable sang mảng byte
        byte[] imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.pizza);
        arr.add(new Food(imageBytes, "Gà rán"));
        arr.add(new Food(imageBytes, "Cơm sườn"));
        arr.add(new Food(imageBytes, "Pizza"));
        arr.add(new Food(imageBytes, "Pizza"));
        arr.add(new Food(imageBytes, "Pizza"));
        arr.add(new Food(imageBytes, "Pizza"));
        imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.kfc);
        restaurantArrayList.add(new Restaurant(imageBytes, "KFC", "4.2"));
        imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.lotteria);
        restaurantArrayList.add(new Restaurant(imageBytes,"Lotteria","4.2"));
        imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.texas);
        restaurantArrayList.add(new Restaurant(imageBytes,"Texas","4.2"));
        imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.jollibee);
        restaurantArrayList.add(new Restaurant(imageBytes,"Jollibee","4.2"));
    }

    private void addControl() {

        recyclerView = findViewById(R.id.rcv_home);
        viewPager = findViewById(R.id.viewPager);
        ImageSliderAdapter imageSliderAdapter = new ImageSliderAdapter(this, images);
        viewPager.setAdapter(imageSliderAdapter);
        arr = new ArrayList<>();
        foodAdapter = new FoodAdapter(this, arr);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_restaurant = findViewById(R.id.rcv_restaurant_home);
        restaurantArrayList = new ArrayList<>();
        restaurantHomeAdapter = new RestaurantHomeAdapter(this, restaurantArrayList);
        recyclerView_restaurant.setAdapter(restaurantHomeAdapter);
        recyclerView_restaurant.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        foodAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(String data) {
                Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
                intent.putExtra("foodname",data);
                startActivity(intent);
            }
        });
    }
}