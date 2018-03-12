package com.example.shobana.farmally;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsList1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list1);


        final String[] products = {"Rice", "Wheat", "Tomatoes", "Onions", "Potatoes", "Brinjals", "Beans", "Carrots"};
        ListView listView = (ListView) findViewById(R.id.products_listview);
        // Creating a List from String Array elements
        final List<String> products_list = new ArrayList<String>(Arrays.asList(products));

        //Creating ArrayAdapter from the list
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, products_list);
        //Note: simple_list_item_1 :  Android internal layout view
        //      android.R.id.text1 :  In Android internal layout view already defined text fields to show data

        //binding ListView with ArrayAdapter
        listView.setAdapter(arrayAdapter);

        // ListView on item selected listener.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ProductsList1.this, products[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}


