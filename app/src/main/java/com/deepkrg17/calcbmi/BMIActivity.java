package com.deepkrg17.calcbmi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class BMIActivity extends AppCompatActivity {
    public void setThings(int color, String type) {
        LinearLayout layoutBMI = findViewById(R.id.layoutBMI);
        TextView txtType = findViewById(R.id.txtType);

        layoutBMI.setBackgroundColor(ContextCompat.getColor(this, color));
        txtType.setText("You are " + type);
    }

    public void setResults(double bmi) {
        TextView txtBMI = findViewById(R.id.txtBMI);

        txtBMI.setText(String.format("Your BMI is %.2f", bmi));
        if (bmi < 18.5) {
            setThings(R.color.unwght, "underweight.");
        } else if (bmi < 25) {
            setThings(R.color.norm, "normal.");
        } else if (bmi < 30) {
            setThings(R.color.ovwght, "overweight.");
        } else if (bmi < 35) {
            setThings(R.color.obese, "obese.");
        } else {
            setThings(R.color.exobese, "extra obese.");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        Intent intent = getIntent();
        setResults(intent.getDoubleExtra(MainActivity.BMI, 0));
    }
}
