package com.example.demograbfood.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demograbfood.Model.Food;
import com.example.demograbfood.Model.Restaurant;
import com.example.demograbfood.OnItemClickListener;
import com.example.demograbfood.R;

import java.util.ArrayList;

public class RestaurantHomeAdapter extends RecyclerView.Adapter<RestaurantHomeAdapter.ViewHolder> {
    Context context;
    ArrayList<Restaurant> arr;
    private OnItemClickListener onItemClickListener;

    public RestaurantHomeAdapter(Context context, ArrayList<Restaurant> arr) {
        this.context = context;
        this.arr = arr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.items_restaurant_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurant restaurant = arr.get(position);
        byte[] hinhAlbumByteArray = restaurant.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAlbumByteArray, 0, hinhAlbumByteArray.length);
        // Kiểm tra null trước khi sử dụng ImageView
        if (holder.img != null) {
            holder.img.setImageBitmap(bitmap);
        }
        holder.txtTen.setText(restaurant.getTensp());
        holder.txtDanhgia.setText(restaurant.getLuotdanhgia());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(arr.get(position).getTensp());
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return arr.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTen,txtDanhgia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.items_img_resutaurant_home);
            txtTen = itemView.findViewById(R.id.items_txt_restaurant_home);
            txtDanhgia = itemView.findViewById(R.id.items_txt_restaurant_danhgia_home);
        }
    }
}
