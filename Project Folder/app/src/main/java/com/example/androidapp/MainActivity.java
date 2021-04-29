package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    EditText list;
    int[] array = {2, 5, 6, 8, 0, 7, 9, 4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        list = findViewById(R.id.hole1score);
        ArrayList<String> arrayList = new ArrayList<String>();
        int listString = array[0];
        list.setText(String.valueOf(listString));

        ImageButton btnAddPlayer = findViewById(R.id.add_player_btn2);
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
    }
}