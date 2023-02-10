package com.example.foodorderapp.db;

import android.content.Context;
import android.widget.Toast;

import com.example.foodorderapp.Interface.ChangeNumberItemsListener;
import com.example.foodorderapp.entities.Food;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context){
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertFood(Food item){
        ArrayList<Food> listFood = getListCart();
        boolean existAlready = false;
        int n =0;
        for (int i = 0; i< listFood.size(); i++){
            if (listFood.get(i).getName().equals(item.getName())){
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready){
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        }else {
            listFood.add(item);
        }
        tinyDB.putListObject("CardList", listFood);
        Toast.makeText(context, "Added to Your Cart",Toast.LENGTH_SHORT).show();
    }
    public ArrayList<Food> getListCart(){
        return tinyDB.getListObject("CardList");
    }

    public void plusNumberFood(ArrayList<Food> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CardList", listFood);
        changeNumberItemsListener.changed();
    }

    public void minusNumberFood(ArrayList<Food> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        if(listFood.get(position).getNumberInCart() == 1){
            listFood.remove(position);
        }else{
            listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CardList", listFood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee(){
        ArrayList<Food> listFood = getListCart();
        double fee = 0;
        for (int i = 0; i < listFood.size(); i++){
            fee = fee + (listFood.get(i).getPrice() * listFood.get(i).getNumberInCart());
        }
        return fee;
    }

}
