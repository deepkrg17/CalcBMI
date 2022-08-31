package com.deepkrg17.calcbmi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.deepkrg17.calcbmi.BMIActivity;

public class MainActivity extends AppCompatActivity {
    public static final String BMI = "com.deepkrg17.calcbmi.bmi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getInput(EditText edt) {
        if (TextUtils.isEmpty(edt.getText().toString())) {
            edt.setError("Can't be empty.");
            return "0";
        }
        return edt.getText().toString();
    }

    public void setResultText(double bmi) {
        TextView res = findViewById(R.id.result);

        if (bmi == 0) {
            res.setText("Enter corect details.");
            return;
        }

        res.setText(String.format("Your BMI is %.2f", bmi));
    }

    public void calc(View v) {
        EditText inpWght = findViewById(R.id.inpWght);
        EditText inpHght = findViewById(R.id.inpHght);

        double wght = Double.parseDouble(getInput(inpWght));
        double hght = Double.parseDouble(getInput(inpHght)) / 100;

        if (wght <= 0 || hght <= 0) {
            setResultText(0);
            return;
        }

        double bmi = wght / (hght * hght);
        setResultText(bmi);

        Intent intent = new Intent(this, BMIActivity.class);
        intent.putExtra(BMI, bmi);
        startActivity(intent);
    }
}
