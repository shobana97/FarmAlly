package com.example.shobana.farmally;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Register extends AppCompatActivity {
    EditText E1,E2,E3,E4,E5,E6;
    Button B1;
    SQLiteDatabase db;
    RadioButton rb;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        E1=(EditText)findViewById(R.id.E1);
        E2=(EditText)findViewById(R.id.E2);
        E3=(EditText)findViewById(R.id.E3);
        E4=(EditText)findViewById(R.id.E4);
        E5=(EditText)findViewById(R.id.E5);
        E6=(EditText)findViewById(R.id.E6);


        B1=(Button)findViewById(R.id.B1);
        rg=(RadioGroup)findViewById(R.id.radioGroup);
        db=openOrCreateDatabase("ACCDB", Context.MODE_PRIVATE,null);
   /* public void RadioButtonClicked(View view){
    }*/



        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = E1.getText().toString();
                String age = E2.getText().toString();
                String usrname = E3.getText().toString();
                String pswd = E4.getText().toString();
                String phone = E6.getText().toString();
                String Addr = E5.getText().toString();
                String type = " ";
           /*boolean checked = ((RadioButton)v).isChecked();
            switch(v.getId()){
                case R.id.radioButton1:
                    if(checked)
                        type = "f";
                    break;
                case R.id.radioButton2:
                    if(checked)
                        type = "c";
                    break;
            }*/
           int selectedId = rg.getCheckedRadioButtonId();
           rb = (RadioButton) findViewById(selectedId);
           type = (String) rb.getText();

           Cursor c = db.rawQuery("SELECT COUNT(*) FROM LOGIN WHERE UNAME='" + usrname + "'", null);
           if (c.moveToFirst()) {
               db.execSQL("INSERT INTO LOGIN VALUES('" + name + "','" + age + "','" + usrname + "','" + pswd + "','" + Addr + "','" + type + "','" + phone + "');");
                    //showMessage("Success","Record Added");
               Intent intent = new Intent(Register.this, Login.class);
               intent.putExtra("UNAME", usrname);
               startActivity(intent);
           }
           else {
               showMessage("Error", "UserName not available");
           }
            }
        });
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}