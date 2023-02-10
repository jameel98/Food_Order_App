//package com.example.foodorderapp.adapter;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.foodorderapp.Interface.ChangeNumberItemsListener;
//import com.example.foodorderapp.R;
//import com.example.foodorderapp.activity.ShowDetailsActivity;
//import com.example.foodorderapp.arrays.ArrayListFood;
//import com.example.foodorderapp.common.Project;
//import com.example.foodorderapp.db.ManagementCart;
//import com.example.foodorderapp.entities.Food;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//
//public class CartListAdapterOld extends RecyclerView.Adapter {
//
//    private ManagementCart managementCart;
//    private ChangeNumberItemsListener changeNumberItemsListener;
//
//    private final Context mContext;
//    private final ArrayListFood mArrayListFood;
//    protected ItemListener mListener;
//
//    public CartListAdapterOld(Context context, ArrayListFood values, ItemListener itemListener) {
//        mArrayListFood = values;
//        mContext = context;
//        mListener = itemListener;
//        this.managementCart = new ManagementCart(context);
//        this.changeNumberItemsListener = changeNumberItemsListener;
//    }
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        Food item;
//        View resultView;
//        LayoutInflater layoutInflater;
//        TextView title, feeEachItem;
//        ImageView pic, plusItem, minusItem;
//        TextView totalEachItem, num;
//
//        @SuppressLint("InflateParams")
//        public ViewHolder(View v) {
//            super(v);
//
//            layoutInflater = (LayoutInflater) Project.APP_INSTANCE.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            resultView = layoutInflater.inflate(R.layout.viewholder_cart, null);
//
//            title = itemView.findViewById(R.id.textTitle);
//            feeEachItem = itemView.findViewById(R.id.feeEachItem);
//            pic = itemView.findViewById(R.id.picCart);
//            totalEachItem = itemView.findViewById(R.id.totalEachItem);
//            num = itemView.findViewById(R.id.numberItemTxt);
//            plusItem = itemView.findViewById(R.id.plusCartBtn);
//            minusItem = itemView.findViewById(R.id.minusCartBtn);
//
//            v.setTag(R.id.textTitle, title);
//            v.setTag(R.id.feeEachItem, feeEachItem);
//            v.setTag(R.id.picCart, pic);
//            v.setTag(R.id.totalEachItem, totalEachItem);
//            v.setTag(R.id.numberItemTxt, num);
//            v.setTag(R.id.plusCartBtn, plusItem);
//            v.setTag(R.id.minusCartBtn, minusItem);
//
//        }
//        public void setData(Food item) {
//            this.item = item;
//            title.setText(item.getName());
//            feeEachItem.setText(String.valueOf(item.getPrice()));
//            totalEachItem.setText(String.valueOf(Math.round((item.getNumberInCart() * item.getPrice()) * 100) / 100));
//            num.setText(String.valueOf(item.getNumberInCart()));
//
//            Picasso.get().load(item.getImage()).into(pic);
//
//            plusItem.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    managementCart.plusNumberFood(mArrayListFood, item.getDbid(), new ChangeNumberItemsListener() {
//                        @Override
//                        public void changed() {
//                            notifyDataSetChanged();
//                            changeNumberItemsListener.changed();
//                        }
//                    });
//                }
//            });
//            minusItem.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    managementCart.minusNumberFood(mArrayListFood, item.getDbid(), new ChangeNumberItemsListener() {
//
//                        @Override
//                        public void changed() {
//                            notifyDataSetChanged();
//                            changeNumberItemsListener.changed();
//                        }
//                    });
//                }
//            });
//        }
//
//        @Override
//        public void onClick(View view) {
//            if (mListener != null) {
//                mListener.onItemClick(item);
//            }
//        }
//    }
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.viewholder_cart, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        ((ViewHolder) holder).setData(mArrayListFood.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mArrayListFood.size();
//
//    }
//
//    public interface ItemListener {
//        void onItemClick(Food item);
//    }
//}
