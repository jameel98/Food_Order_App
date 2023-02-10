package com.example.foodorderapp.arrays;


import com.example.foodorderapp.entities.Food;

import java.util.ArrayList;
import java.util.Date;

public class ArrayListFood extends ArrayList<Food>
{

    private Date loaded;

    public Date getLoaded() {
        return loaded;
    }

    public void setLoaded(Date loaded) {
        this.loaded = loaded;
    }
}
