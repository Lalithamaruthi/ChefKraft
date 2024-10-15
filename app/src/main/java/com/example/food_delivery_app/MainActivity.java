package com.example.fooddelivery;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Pizza Palace", "Italian"));
        restaurants.add(new Restaurant("Burger World", "American"));

        RestaurantAdapter adapter = new RestaurantAdapter(restaurants, new RestaurantAdapter.OnRestaurantClickListener() {
            @Override
            public void onRestaurantClick(Restaurant restaurant) {
                Intent intent = new Intent(MainActivity.this, FoodItemsActivity.class);
                intent.putExtra("restaurant", restaurant.getName());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
