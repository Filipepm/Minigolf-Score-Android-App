package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Hole2 extends AppCompatActivity {

    EditText hole1score, hole2score;
    TextView hole1total, hole2total, holenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hole2);

        hole1score = (EditText) findViewById(R.id.hole1score);
        hole1total = (TextView) findViewById(R.id.total1score);
        hole2score = (EditText) findViewById(R.id.hole1score);
        hole2total = (TextView) findViewById(R.id.total1score);
        holenumber = (TextView) findViewById(R.id.holenumber);

        hole1total.setText("2");
        hole2total.setText("1");
        holenumber.setText("2");

        hole1score.addTextChangedListener(scoretext);
        hole2score.addTextChangedListener(scoretext1);

        Button btnPrev = findViewById(R.id.prev_hole);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hole2.this, MainActivity.class ));
            }
        });
    }

    private TextWatcher scoretext = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            hole1total.setText("4");

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher scoretext1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            hole2total.setText("3");

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
