package com.example.lab_line;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etX1;
    private EditText etY1;
    private EditText etX2;
    private EditText etY2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etX1 = findViewById(R.id.et_main_x1);
        etY1 = findViewById(R.id.et_main_y1);
        etX2 = findViewById(R.id.et_main_x2);
        etY2 = findViewById(R.id.et_main_y2);

        Button btnSolve = findViewById(R.id.btn_main_solve);
        btnSolve.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_main_solve) {
            solve();
        }
    }

    private void solve() {
        TextView tvResult = findViewById(R.id.tv_main_result);
        float x1 = Float.parseFloat(etX1.getText().toString());
        float y1 = Float.parseFloat(etY1.getText().toString());
        float x2 = Float.parseFloat(etX2.getText().toString());
        float y2 = Float.parseFloat(etY2.getText().toString());

        String result;

        if ((x2 - x1) != 0) {
            float a = ((y2 - y1) / (x2 - x1));
            float b = ((x2 * y1) - (x1 * y2)) / (x2 - x1);
            result = "y = " +
                    String.format(Locale.getDefault(), "%.2f", a) +
                    "x " +
                    (b < 0 ? " - " : " + ") +
                    String.format(Locale.getDefault(), "%.2f", Math.abs(b));
        } else if ((x2 - x1) == 0 && (y2 - y1) == 0) {
            result = "Точки совпадают";
        } else {
            float c = ((x1 * y2) - (x2 * y1)) / (y2 - y1);
            result = "x = " + String.format(Locale.getDefault(), "%.2f", c);
        }
        tvResult.setText(result);
    }
}