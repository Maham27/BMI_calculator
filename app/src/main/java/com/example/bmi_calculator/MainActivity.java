package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.xml.transform.Result;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    EditText etname,etage,etgender,etheight,etweight;
    Button btncalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkdata()) {
                    String name;
                    String gender;
                    Integer age;
                    Double height;
                    Double weight;
                    Double bmi;
                    DecimalFormat d=new DecimalFormat(".##");
                    name=etname.getText().toString();
                    gender=etgender.getText().toString();
                    age =Integer.parseInt(etage.getText().toString());
                    height=Double.parseDouble(etheight.getText().toString());
                    weight=Double.parseDouble(etweight.getText().toString());
                    bmi=Double.parseDouble(d.format(weight/(height*height)));
                    Intent intent = new Intent(MainActivity.this,com.example.bmi_calculator.MainActivity2.class);
                    intent.putExtra("keybmicalculation",bmi);
                    startActivity(intent);
                    finish();
                    String datafile="Bmi_data.txt";
                    String info=name+","+age+","+gender+","+height+","+ weight+","+bmi;
                    FileOutputStream fileOutputStream=null;
                    try {
                        fileOutputStream = openFileOutput(datafile,MODE_APPEND);
                        fileOutputStream.write(info.getBytes());
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    private boolean checkdata() {
        boolean flag=true;
        if (etname.getText().toString().isEmpty())
        {
            etname.setError("name cannot be empty");
            flag=false;
        }
        if (etgender.getText().toString().isEmpty())
        {
            etgender.setError("gender cannot be empty");
            flag=false;
        }
        if (etheight.getText().toString().isEmpty())
        {
            etheight.setError("height cannot be empty");
            flag=false;
        }
        if (etweight.getText().toString().isEmpty())
        {
            etweight.setError("weight cannot be empty");
            flag=false;
        }
        return flag;
    }
    private void initial() {
        etname=findViewById(R.id.etname);
        etgender=findViewById(R.id.etgender);
        etage=findViewById(R.id.etage);
        etheight=findViewById(R.id.etheight);
        etweight=findViewById(R.id.etweight);
        btncalculate=findViewById(R.id.btncalculate);
    }
}