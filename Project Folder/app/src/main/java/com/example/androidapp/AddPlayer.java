package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AddPlayer extends AppCompatActivity {

    private GridView colorGrid;
    private EditText playerName;
    private Button SubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_player);
        colorGrid = findViewById(R.id.ColorGrid);
        playerName = findViewById(R.id.PlayerNameInput);

        SubmitButton.setOnClickListener(new View.OnClickListener() {

            @Ovverride
            public void OnClick(View view) {
                final String playerName = PlayerNameInput.getText().toString();

                Player player = new Player();
            }
        });
        
    }

}
