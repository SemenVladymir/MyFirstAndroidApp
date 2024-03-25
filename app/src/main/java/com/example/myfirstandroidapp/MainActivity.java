package com.example.myfirstandroidapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout view;
    private Button button;
    private TextView textView;
    private SeekBar min;
    private SeekBar max;
    private TextView minNumb;
    private TextView maxNumb;

    @SuppressLint("MissingInflatedId")
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

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        view = findViewById(R.id.main);
        minNumb = findViewById(R.id.minNumb);
        maxNumb = findViewById(R.id.maxNumb);
        min = findViewById(R.id.minSeekBar);
        max = findViewById(R.id.maxSeekBar);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                AddTextHistory();
                textView.setText(Integer.toString(new Random().nextInt(max.getProgress() - min.getProgress() + 1) + min.getProgress()));
            }
        });

        min.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                minNumb.setText(String.valueOf("Minimal number: " + progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        max.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                maxNumb.setText(String.valueOf("Maximal number: " + progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void AddTextHistory (){
        String num = textView.getText().toString();
        TextView newTxt = new TextView(this);
        newTxt.setText(num);
        newTxt.setTextSize(15);
        newTxt.setGravity(Gravity.CENTER_HORIZONTAL);
        view.addView(newTxt, 7);
    }
}