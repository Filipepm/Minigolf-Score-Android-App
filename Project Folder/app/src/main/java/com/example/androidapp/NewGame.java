package com.example.androidapp;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewGame extends AppCompatActivity {

    private EditText playerNum;
    private EditText parNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);
    }
}
