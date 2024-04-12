package com.example.demograbfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demograbfood.Model.Restaurant;
import com.example.demograbfood.adapter.RestaurantHomeAdapter;

import java.util.ArrayList;

public class RestaurantListActivity extends AppCompatActivity {
    ImageButton btn_back_restaurantlist;
    TextView txt_RestaurantList;
    ImageView imgbanner_RestaurantList;
    RecyclerView rcv_RestaurantList;
    ArrayList<Restaurant> restaurantArrayList;
    RestaurantHomeAdapter restaurantHomeAdapter;
    Intent intent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        addControl();
        loadData();
        AddEvents();
    }

    private void AddEvents() {
        btn_back_restaurantlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void loadData() {
        intent = getIntent();
        String foodname = intent.getStringExtra("foodname");
        if(foodname.equals("Gà rán")) {
            txt_RestaurantList.setText("Gà rán");
            byte[] imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.kfc);
            restaurantArrayList.add(new Restaurant(imageBytes, "KFC", "4.2"));
            imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.lotteria);
            restaurantArrayList.add(new Restaurant(imageBytes, "Lotteria", "4.2"));
            imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.texas);
            restaurantArrayList.add(new Restaurant(imageBytes, "Texas", "4.2"));
            imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.jollibee);
            restaurantArrayList.add(new Restaurant(imageBytes, "Jollibee", "4.2"));
        }
        if(foodname.equals("Cơm sườn")){
            txt_RestaurantList.setText("Cơm sườn");
            byte[] imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.kfc);
            restaurantArrayList.add(new Restaurant(imageBytes, "Cơm sườn KFC", "4.2"));
            imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.lotteria);
            restaurantArrayList.add(new Restaurant(imageBytes, "Cơm sườn Lotteria", "4.2"));
            imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.texas);
            restaurantArrayList.add(new Restaurant(imageBytes, "Cơm sườn Texas", "4.2"));
            imageBytes = ImageUtils.convertDrawableToByteArray(this, R.drawable.jollibee);
            restaurantArrayList.add(new Restaurant(imageBytes, "Cơm sườn Jollibee", "4.2"));
        }
    }

    private void addControl() {
        btn_back_restaurantlist = findViewById(R.id.btn_back_restaurantlist);
        txt_RestaurantList = findViewById(R.id.txt_RestaurantList);
        imgbanner_RestaurantList = findViewById(R.id.imgbanner_RestaurantList);
        rcv_RestaurantList = findViewById(R.id.rcv_RestaurantList);
        restaurantArrayList = new ArrayList<>();
        restaurantHomeAdapter = new RestaurantHomeAdapter(this, restaurantArrayList);
        rcv_RestaurantList.setAdapter(restaurantHomeAdapter);
        rcv_RestaurantList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        restaurantHomeAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(String data) {
                Intent intent1 = new Intent(RestaurantListActivity.this,MenuRestaurantActivity.class);
                for(Restaurant item : restaurantArrayList)
                {
                    if(item.getTensp().equals(data))
                    {
                        intent1.putExtra("hinh",item.getHinh());
                        intent1.putExtra("ten",item.getTensp());
                        intent1.putExtra("danhgia",item.getLuotdanhgia());
                        break;
                    }
                }
                startActivity(intent1);
            }
        });
    }
}