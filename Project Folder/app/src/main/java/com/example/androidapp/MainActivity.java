package com.example.androidapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.hole1score);
        ArrayList<String> arrayList = new ArrayList<String>();
        int listString = array[0];
        list.setText(String.valueOf(listString));
    }
}