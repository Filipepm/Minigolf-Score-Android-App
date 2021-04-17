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

    EditText hole1score, hole2score;
    TextView hole1total, hole2total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hole1score = (EditText) findViewById(R.id.hole1score);
        hole1total = (TextView) findViewById(R.id.total1score);
        hole2score = (EditText) findViewById(R.id.hole2score);
        hole2total = (TextView) findViewById(R.id.total2score);


        hole1score.addTextChangedListener(scoretext);
        hole2score.addTextChangedListener(scoretext);

        ImageButton btnAddPlayer = findViewById(R.id.add_player_btn);
        btnAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddPlayer.class));
            }
        });

        Button btnNext = findViewById(R.id.next_hole);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Hole2.class));
            }
        });

        //TODO: implement prev hole button
        Button btnPrev = findViewById(R.id.prev_hole);
    }

    private TextWatcher scoretext = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            hole1score = (EditText) findViewById(R.id.hole1score);
            String holescore = hole1score.getText().toString().trim();
            hole1total = (TextView) findViewById(R.id.total1score);
            hole1total.setText(holescore);

            hole2score = (EditText) findViewById(R.id.hole2score);
            String holescore2 = hole2score.getText().toString().trim();
            hole2total = (TextView) findViewById(R.id.total2score);
            hole2total.setText(holescore2);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}