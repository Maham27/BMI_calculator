package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;
public class MainActivity2 extends AppCompatActivity {
    TextView tv3,tvbm,tv4;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initial();
        Intent intent=getIntent();
        Double getbmi;
        getbmi=intent.getDoubleExtra("keybmicalculation",-1);
        tv3.setText(Double.toString(getbmi));
           if(getbmi<18.5)
            {
                tvbm.setText("body mass deificit");
                tv4.setText("range:less than 18.5kg/m^2 class,Risk of devopling associated illnesses:lower(but higher risk of other illnesses");
            }
             else if(getbmi>=18.5 && getbmi<=24.9)
            {
                tvbm.setText("normal body mass");
                tv4.setText("range:18.5kg/m^2-24.9kg/m^2,Risk of devopling associated illnesses:Average");
            }
            else if(getbmi>=25.0  && getbmi<=29.9)
            {
                tvbm.setText("excessive body mass(pre-obesity)");
                tv4.setText("range:25.0kg/m^2-29.9kg/m^2,Risk of devopling associated illnesses:Heightened");
            }
            else if(getbmi>=30.0 && getbmi<=34.9)
            {
                tvbm.setText("obesity 1st degree");
                tv4.setText("range:30.0kg/m^2-34.9kg/m^2,Risk of devopling associated illnesses:High");
            }
           else if(getbmi>=35.0 && getbmi<=39.9)
            {
                tvbm.setText("obesity 2nd degree");
                tv4.setText("range:35.0kg/m^2-39.9kg/m^2,Risk of devopling associated illnesses:Very high");
            }
            else if(getbmi>=40.0)
            {
                tvbm.setText("obesity 3rd degree");
                tv4.setText("range:40.0 and more,Risk of devopling associated illnesses:extremely high");
            }

            else
            {
                tvbm.setText("invalid");
                tv4.setText("invalid");
            }

       btnback.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(MainActivity2.this,com.example.bmi_calculator.MainActivity.class);
               startActivity(intent);
               finish();
           }
       });
    }
    private void initial() {
        tv3=findViewById(R.id.tv3);
        tvbm=findViewById(R.id.tvbm);
        tv4=findViewById(R.id.tv4);
        btnback=findViewById(R.id.btnback);
    }
}