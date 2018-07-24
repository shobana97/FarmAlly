package com.example.shobana.farmally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class BuyOrSell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_or_sell);
        ImageButton imageButton1 = (ImageButton)findViewById(R.id.about);
        ImageButton imageButton2 = (ImageButton)findViewById(R.id.sell);
        ImageButton imageButton3 = (ImageButton)findViewById(R.id.buy);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.about:
                        Intent intent = new Intent(BuyOrSell.this, SellerModule.class);
                        startActivity(intent);
                        break;
                    case R.id.buy:
                        Intent intent1 = new Intent(BuyOrSell.this, ProductsList1.class);
                        startActivity(intent1);
                        break;
                    case R.id.sell:
                        Intent intent2 = new Intent(BuyOrSell.this, AddProduct.class);
                        startActivity(intent2);
                }
            }
        };
        imageButton1.setOnClickListener(listener);
        imageButton2.setOnClickListener(listener);
        imageButton3.setOnClickListener(listener);
    }
}
