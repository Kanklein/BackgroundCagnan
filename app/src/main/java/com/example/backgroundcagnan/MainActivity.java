package com.example.backgroundcagnan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
        ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.clMain);
        bgElement.setBackgroundColor(Color.WHITE);
        //myButtonListenerMethodTest();
        daynightToggleListenerMethod();
    }

    public void daynightToggleListenerMethod(){
        Switch swday = (Switch) findViewById(R.id.swDay);
        swday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.clMain);
                CheckBox cbCIT = (CheckBox) findViewById(R.id.cbCIT);
                RadioButton rbMale = (RadioButton) findViewById(R.id.rbMale);
                RadioButton rbFemale = (RadioButton) findViewById(R.id.rbFemale);
                RadioButton rbfirst = (RadioButton) findViewById(R.id.rbfirst);
                RadioButton rbsecond = (RadioButton) findViewById(R.id.rbsecond);
                RadioButton rbthird = (RadioButton) findViewById(R.id.rbthird);
                RadioButton rbfourth = (RadioButton) findViewById(R.id.rbfourth);

                TextView[] texts = {swday, cbCIT, rbMale, rbFemale, rbfirst ,rbsecond , rbthird, rbthird, rbfourth};
                boolean day = swday.isChecked();
                if (day) {
                    bgElement.setBackgroundColor(Color.WHITE);
                    for (TextView tv : texts){
                        tv.setTextColor(Color.BLACK);
                    }
                } else {
                    bgElement.setBackgroundColor(Color.BLACK);
                    for (TextView tv : texts){
                        tv.setTextColor(Color.WHITE);
                    }
                }
            }
        });
    }

    public void userTypeChangeListener(){
        Spinner spUserType = (Spinner) findViewById(R.id.spUserType);
        spUserType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tvselected = (TextView) spUserType.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void myButtonListenerMethod(){
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.clMain);
                int color = ((ColorDrawable) bgElement.getBackground()).getColor();
                if(color == Color.RED){
                    bgElement.setBackgroundColor(Color.BLUE);
                } else {
                    bgElement.setBackgroundColor(Color.RED);
                }
            }
        });
    }
    /*public void myButtonListenerMethodTest(){
        Button switch1 = (Button) findViewById(R.id.swDay);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.clMain);
                int color = ((ColorDrawable) bgElement.getBackground()).getColor();
                if(color == Color.WHITE){
                    bgElement.setBackgroundColor(Color.BLACK);
                } else {
                    bgElement.setBackgroundColor(Color.WHITE);
                }
            }
        });
    }*/
}