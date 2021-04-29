package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText list;
    TextView totalParView, list2, holeNumber;
    Button nextHole, prevHole;
    int holeNum = 0;
    int totalPar = 0;
    int[] array = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.hole1score);
        list2 = findViewById(R.id.total2score);
        nextHole = findViewById(R.id.next_hole);
        prevHole = findViewById(R.id.prev_hole);
        totalParView = findViewById(R.id.total1score);
        holeNumber = findViewById(R.id.holenumber);

        nextHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holeNum < array.length - 1)
                    holeNum = holeNum+1;
                int listString = array[holeNum];
                holeNumber.setText(String.valueOf(holeNum + 1));
                list.setText(String.valueOf(listString));
            }
        });

        prevHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holeNum > 0)
                    holeNum = holeNum-1;
                int listString = array[holeNum];
                holeNumber.setText(String.valueOf(holeNum + 1));
                list.setText(String.valueOf(listString));
            }
        });

        ImageButton btnAddPlayer = findViewById(R.id.add_player_btn);
        btnAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddPlayer.class));
            }
        });

        list.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int holeValue = Integer.valueOf(list.getText().toString());
                    array[holeNum] = holeValue;
                }
                catch(NumberFormatException e){
                }

                for(int i = 0; i < array.length; i++) {
                    totalPar = totalPar + array[i];
                }
                totalParView.setText(String.valueOf(totalPar));
                totalPar = 0;
            }
        });
    }
}