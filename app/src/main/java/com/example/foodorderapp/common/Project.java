package com.example.foodorderapp.common;

import android.app.Application;

import com.example.foodorderapp.arrays.ArrayListFood;
import com.example.foodorderapp.db.WMDBAPI;
import com.example.foodorderapp.domain.CategoryDomain;
import com.example.foodorderapp.entities.Food;
import com.example.foodorderapp.entities.FoodTypes;

import java.util.ArrayList;

public class Project extends Application {

    public static Project APP_INSTANCE = null;
    private WMDBAPI mWMDBAPI;

    private ArrayListFood mArrayListFood;

    @Override
    public void onCreate()
    {
        super.onCreate();
        //  super.getApplicationContext().deleteDatabase("project.db");

        mWMDBAPI = new WMDBAPI(this);

        mArrayListFood = new ArrayListFood();

        APP_INSTANCE = this;

        addBasicItems();
    }

    public WMDBAPI getWMDBAPI()
    {
        return mWMDBAPI;
    }

    public ArrayListFood getmArrayListFood()
    {
        return mArrayListFood;
    }

    public void setmArrayListFood(ArrayListFood mArrayListFood)
    {
        this.mArrayListFood = mArrayListFood;
    }


    private void addBasicItems(){
//        ArrayList<Food> foods = new ArrayList<>();
//        foods.add(new Food(0,10, "Big Mac", FoodTypes.Burger,"https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Big-Mac.jpg?$Product_Desktop$" ));
//        mWMDBAPI.saveFood(foods);
        mWMDBAPI.removeFood();
        Food f = new Food();

        // -----------<Pizza>-------------------------
        f.setType(FoodTypes.Pizza);
        f.setName("pizza italiano");
        f.setPrice(50);
        f.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Supreme_pizza.jpg/1280px-Supreme_pizza.jpg");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Pizza);
        f.setName("pizza paperoni");
        f.setPrice(50);
        f.setImage("https://cdn.foodbox.co.il/wp-content/uploads/sites/7/2022/07/18142820/tmunat-mosar-FRESKA-no-gluten.png");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Pizza);
        f.setName("pizza vigiterian");
        f.setPrice(50);
        f.setImage("https://cdn.sanity.io/images/w6ol9cun/production/0fbc5d588c01b4ca1b712061daf2d802154c7ca5-2000x1080.jpg");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Pizza);
        f.setName("big pizza");
        f.setPrice(50);
        f.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Supreme_pizza.jpg/1280px-Supreme_pizza.jpg");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Pizza);
        f.setName("pizza double cheese");
        f.setPrice(50);
        f.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Supreme_pizza.jpg/1280px-Supreme_pizza.jpg");
        mWMDBAPI.saveFood(f);

        // ---------- <Burger> -----------------------------
        f.setType(FoodTypes.Burger);
        f.setName("Big Mac");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Big-Mac.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Burger);
        f.setName("Quarter Pounder with Cheese");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Quarter-Pounder-with-Cheese.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Burger);
        f.setName("Double Quarter Pounder with Cheese");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Double-Quarter-Pounder-with-Cheese.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Burger);
        f.setName("Cheeseburger");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Cheeseburger.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Burger);
        f.setName("McDouble");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-McDouble.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);

        // ---------- <Drinks> -----------------------------

        // <--- HOT DRINKS --->
        f.setType(FoodTypes.Drinks);
        f.setName("Caramel Macchiato");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-caramel-macchiato.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Drinks);
        f.setName("Cappuccino");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-cappuccino.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Drinks);
        f.setName("Mocha");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-McCafe-Mocha-Medium.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Drinks);
        f.setName("Latte");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-McCafe-Latte-Medium.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        f.setType(FoodTypes.Drinks);
        f.setName("Americano");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-americano.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);
        // <--- COLD DRINKS --->
        f.setType(FoodTypes.Drinks);
        f.setName("Coca cola");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Coca-Cola-Classic-Small.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);

        f.setType(FoodTypes.Drinks);
        f.setName("Sprite");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Sprite-Small.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);

        f.setType(FoodTypes.Drinks);
        f.setName("Fanta Orange");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-fanta-orange.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);

        f.setType(FoodTypes.Drinks);
        f.setName("Chocolate shake");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Chocolate-McCafe-Shake-Medium.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);

        f.setType(FoodTypes.Drinks);
        f.setName("iced tea");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.com/is/image/content/dam/usa/nfl/nutrition/items/hero/desktop/t-mcdonalds-Iced-Tea-Large.jpg?$Product_Desktop$");
        mWMDBAPI.saveFood(f);

/////////////Donuts//////////////////////////////////////////////////////////////////////////////////

        f.setType(FoodTypes.Donuts);
        f.setName("chockolate donut");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.co.il/filestock/img/thumb_1642597050420-0.png");
        mWMDBAPI.saveFood(f);

        f.setType(FoodTypes.Donuts);
        f.setName("oreo donut");
        f.setPrice(10);
        f.setImage("https://www.mcdonalds.co.il/filestock/img/img_1657466382352-0.png");
        mWMDBAPI.saveFood(f);

////////Hot Dog ////////////////////////////////////////////////////////////////
        f.setType(FoodTypes.HotDog);
        f.setName("cheese dog");
        f.setPrice(10);
        f.setImage("https://res.cloudinary.com/sonic-drive-in/image/upload/c_fit,w_200,h_200,dpr_2,f_auto,q_auto/v1622138320/oa_menu/products/menuproduct_hotdog_footlong-quarter-pound-cheese-coney.png");
        mWMDBAPI.saveFood(f);

        f.setType(FoodTypes.HotDog);
        f.setName("hot dog");
        f.setPrice(10);
        f.setImage("https://res.cloudinary.com/sonic-drive-in/image/upload/c_fit,w_200,h_200,dpr_2,f_auto,q_auto/v1622138320/oa_menu/products/menuproduct_hotdog_footlong-quarter-pound-cheese-coney.png");
        mWMDBAPI.saveFood(f);

        f.setType(FoodTypes.HotDog);
        f.setName("chilli dog");
        f.setPrice(10);
        f.setImage("https://res.cloudinary.com/sonic-drive-in/image/upload/c_fit,w_200,h_200,dpr_2,f_auto,q_auto/v1622138320/oa_menu/products/menuproduct_hotdog_footlong-quarter-pound-cheese-coney.png");
        mWMDBAPI.saveFood(f);

        f.setType(FoodTypes.HotDog);
        f.setName("grilled dog");
        f.setPrice(10);
        f.setImage("https://res.cloudinary.com/sonic-drive-in/image/upload/c_fit,w_200,h_200,dpr_2,f_auto,q_auto/v1622138320/oa_menu/products/menuproduct_hotdog_footlong-quarter-pound-cheese-coney.png");
        mWMDBAPI.saveFood(f);

    }
}
