package com.golfstonks.androidapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Only3Player extends AppCompatActivity {
    EditText listplayer11, listplayer21, listplayer31;
    TextView totalParView, totalParView2, totalParView3, listplayer12, listplayer22, listplayer32, holeNumber;
    Button nextHole, prevHole;
    int holeNum = 0;
    int totalPar1 = 0;
    int totalPar2 = 0;
    int totalPar3 = 0;
    int[] arrayplayer1 = new int[9];
    int[] arrayplayer2 = new int[9];
    int[] arrayplayer3 = new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.only_3_player);
        nextHole = findViewById(R.id.next_hole);
        prevHole = findViewById(R.id.prev_hole);
        holeNumber = findViewById(R.id.holenumber2);

        listplayer11 = findViewById(R.id.hole1score);
        listplayer12 = findViewById(R.id.total1score);
        totalParView = findViewById(R.id.total1score);

        listplayer21 = findViewById(R.id.hole2score);
        listplayer22 = findViewById(R.id.total2score);
        totalParView2 = findViewById(R.id.total2score);

        listplayer31 = findViewById(R.id.hole3score);
        listplayer32 = findViewById(R.id.total3score);
        totalParView3 = findViewById(R.id.total3score);


        nextHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holeNum < arrayplayer1.length - 1)
                    holeNum = holeNum + 1;
                holeNumber.setText(String.valueOf(holeNum + 1));

                int listString1 = arrayplayer1[holeNum];
                listplayer11.setText(String.valueOf(listString1));

                int listString2 = arrayplayer2[holeNum];
                listplayer21.setText(String.valueOf(listString2));

                int listString3 = arrayplayer3[holeNum];
                listplayer31.setText(String.valueOf(listString3));
            }
        });

        prevHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holeNum > 0)
                    holeNum = holeNum - 1;
                holeNumber.setText(String.valueOf(holeNum + 1));

                int listString1 = arrayplayer1[holeNum];
                listplayer11.setText(String.valueOf(listString1));

                int listString2 = arrayplayer2[holeNum];
                listplayer21.setText(String.valueOf(listString2));

                int listString3 = arrayplayer3[holeNum];
                listplayer31.setText(String.valueOf(listString3));
            }
        });

        listplayer11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int holeValue1 = Integer.valueOf(listplayer11.getText().toString());
                    arrayplayer1[holeNum] = holeValue1;
                } catch (NumberFormatException e) {
                }

                for (int i = 0; i < arrayplayer1.length; i++) {
                    totalPar1 = totalPar1 + arrayplayer1[i];
                }
                totalParView.setText(String.valueOf(totalPar1));
                totalPar1 = 0;
            }
        });

        listplayer21.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int holeValue2 = Integer.valueOf(listplayer21.getText().toString());
                    arrayplayer2[holeNum] = holeValue2;
                } catch (NumberFormatException e) {
                }

                for (int i = 0; i < arrayplayer2.length; i++) {
                    totalPar2 = totalPar2 + arrayplayer2[i];
                }
                totalParView2.setText(String.valueOf(totalPar2));
                totalPar2 = 0;
            }
        });

        listplayer31.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int holeValue3 = Integer.valueOf(listplayer31.getText().toString());
                    arrayplayer3[holeNum] = holeValue3;
                } catch (NumberFormatException e) {
                }

                for (int i = 0; i < arrayplayer3.length; i++) {
                    totalPar3 = totalPar3 + arrayplayer3[i];
                }
                totalParView3.setText(String.valueOf(totalPar3));
                totalPar3 = 0;
            }
        });
    }
}