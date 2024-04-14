package com.example.simplecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button add, subtract, multiply, divide;
    TextView answer,number1, number2;
    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        add = findViewById(R.id.btn_add);
        subtract = findViewById(R.id.btn_sub);
        multiply = findViewById(R.id.btn_mul);
        divide = findViewById(R.id.btn_div);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        answer = findViewById(R.id.answer);

        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
    }


    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View v) {
        num1=Integer.parseInt(number1.getText().toString());
        num2=Integer.parseInt(number2.getText().toString());

        if(v.getId()==R.id.btn_add)
            answer.setText("Answer = "+(num1+num2));
        else if (v.getId()==R.id.btn_sub)
            answer.setText("Answer = "+(num1-num2));
        else if (v.getId()==R.id.btn_mul)
            answer.setText("Answer = "+(num1*num2));
        else if (v.getId()==R.id.btn_div)
            answer.setText("Answer = "+((float)num1/(float)num2));
    }
}