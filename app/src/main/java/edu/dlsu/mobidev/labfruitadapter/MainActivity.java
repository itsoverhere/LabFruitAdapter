package edu.dlsu.mobidev.labfruitadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvFruits;

    ArrayList<String> listFruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFruits = (RecyclerView) findViewById(R.id.rv_fruits);

        listFruits = new ArrayList<String>();
        listFruits.add("Apple");
        listFruits.add("Banana");
        listFruits.add("Cherry");
        listFruits.add("Durian");
        listFruits.add("Elderberry");
        listFruits.add("Fig");
        listFruits.add("Grape");
        listFruits.add("Honeydew");
        listFruits.add("Indian Mango");
        listFruits.add("Jackfruit");
        listFruits.add("Kiwi");
        listFruits.add("Lemon");

        FruitAdapter fruitAdapter = new FruitAdapter(listFruits);

        rvFruits.setAdapter(fruitAdapter);

        // setting the LayoutManager to a RecyclerView is important. It dictates how the data will be presented
        rvFruits.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // other layout managers include GridLayoutManager and StaggeredGridLayoutManager
    }


}
