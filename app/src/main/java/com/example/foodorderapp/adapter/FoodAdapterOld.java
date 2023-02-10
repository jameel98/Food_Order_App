package com.example.foodorderapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderapp.R;
import com.example.foodorderapp.activity.ShowDetailsActivity;
import com.example.foodorderapp.arrays.ArrayListFood;
import com.example.foodorderapp.common.Project;
import com.example.foodorderapp.entities.Food;
import com.squareup.picasso.Picasso;


public class FoodAdapterOld extends RecyclerView.Adapter {

    private final Context mContext;
    private final ArrayListFood mArrayListFood;
    protected ItemListener mListener;

    public FoodAdapterOld(Context context, ArrayListFood values, ItemListener itemListener) {
        mArrayListFood = values;
        mContext = context;
        mListener = itemListener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Food item;
        TextView txtFoodName;
        TextView txtFoodPrice;
        ImageView image;
        TextView addBtn;
        View resultView;
        LayoutInflater layoutInflater;

        @SuppressLint("InflateParams")
        public ViewHolder(View v) {
            super(v);

            layoutInflater = (LayoutInflater) Project.APP_INSTANCE.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            resultView = layoutInflater.inflate(R.layout.viewholder_food, null);
            txtFoodName = v.findViewById((R.id.foodTitle));
            txtFoodPrice = v.findViewById((R.id.price));
            addBtn = v.findViewById(R.id.addBtn);

            image = v.findViewById((R.id.foodPic));
            v.setTag(R.id.foodTitle, txtFoodName);
            v.setTag(R.id.price, txtFoodPrice);
            v.setTag(R.id.foodPic, image);

            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ShowDetailsActivity.class);
                    intent.putExtra("object", item);
                    mContext.startActivity(intent);
                }
            });

        }
        public void setData(Food item) {
            this.item = item;
            txtFoodName.setText(item.getName());
            txtFoodPrice.setText(String.valueOf(item.getPrice()));

            Picasso.get().load(item.getImage()).into(image);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).setData(mArrayListFood.get(position));
    }

    @Override
    public int getItemCount() {
        return mArrayListFood.size();

    }

    public interface ItemListener {
        void onItemClick(Food item);
    }
}
