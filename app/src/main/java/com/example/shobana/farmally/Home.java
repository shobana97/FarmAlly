package com.example.shobana.farmally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        ImageButton imageButton = (ImageButton)findViewById(R.id.log_in);
        /*ImageButton imageButton1 = (ImageButton)findViewById(R.id.sell);
        ImageButton imageButton2 = (ImageButton)findViewById(R.id.log_in);*/

        /*View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buy:
                        Intent intent = new Intent(Home.this, ProductsList1.class);
                        startActivity(intent);
                        break;
                    case R.id.sell:
                        Intent intent1 = new Intent(Home.this, AddProduct.class);
                        startActivity(intent1);
                        break;
                    case R.id.log_in:
                        Intent intent2 = new Intent(Home.this, Login.class);
                        startActivity(intent2);
                        break;

                }
            }
        };*/
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
