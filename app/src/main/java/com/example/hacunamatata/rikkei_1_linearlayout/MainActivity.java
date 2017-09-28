package com.example.hacunamatata.rikkei_1_linearlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup mRadioGroup;
    RadioButton mRedButton, mGreenButton, mBlueButton;
    TextView mTextView;
    Button mSet, mClear;
    int c = Color.RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize variables
        mRadioGroup = (RadioGroup) findViewById(R.id.ColorGroup);
        mRedButton = (RadioButton) findViewById(R.id.Red);
        mGreenButton = (RadioButton) findViewById(R.id.Green);
        mBlueButton = (RadioButton) findViewById(R.id.Blue);
        mTextView = (TextView) findViewById(R.id.textView);
        mSet = (Button) findViewById(R.id.setColor);
        mClear = (Button) findViewById(R.id.clear);

        //Buttons' actionPerformed
        actionPerformed();
    }

    //Change color when ColorGroup change.
    private void changeColor(RadioGroup group) {
        int checkedId = group.getCheckedRadioButtonId();

        switch (checkedId) {
             case R.id.Red:
                c = Color.RED;
                break;
            case R.id.Green:
                c = Color.GREEN;
                break;
            case R.id.Blue:
                c = Color.BLUE;
                break;
        }
    }

    private void actionPerformed() {

        //ColorGroup Changed Listener
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                changeColor(radioGroup);
            }
        });

        //Set Color button
        mSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setBackgroundColor(c);
            }
        });

        //Clear Button
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setBackgroundColor(Color.BLACK);
            }
        });
    }
}
