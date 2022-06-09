package com.devandros.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout lnMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        lnMain = findViewById(R.id.lnMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int wt = Integer.parseInt(edtWeight.getText().toString());
               int htFt = Integer.parseInt((edtHeightFt.getText().toString()));
               int htIn = Integer.parseInt(edtHeightIn.getText().toString());

               int totalIn = htFt*12 + htIn;
               double totalCm = totalIn * 2.53;
               double totalMm = totalCm / 100;
               double bmi = wt / (totalMm * totalMm);

               if (bmi > 25) {
                   txtResult.setText("You're Overweight");
                   lnMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
               } else if (bmi < 18) {
                   txtResult.setText("You're Underweight");
                   lnMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
               } else {
                   txtResult.setText("You're Healthy");
                   lnMain.setBackgroundColor(getResources().getColor(R.color.colorH));
               }
            }
        });
    }
}