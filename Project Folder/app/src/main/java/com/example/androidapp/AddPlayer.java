package com.example.androidapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class AddPlayer extends AppCompatActivity {

    private EditText playerName;
    private Button submit;
    private RadioButton red, orange, yellow, green, blue, purple;
    int playerIndex = 0;
    int playerScore = 0;
    Game game = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_player);

        playerName = (EditText) findViewById(R.id.NameInput);
        red = (RadioButton) findViewById(R.id.redButton);
        orange = (RadioButton) findViewById(R.id.orangeButton);
        yellow = (RadioButton) findViewById(R.id.yellowButton);
        green = (RadioButton) findViewById(R.id.greenButton);
        blue = (RadioButton) findViewById(R.id.blueButton);
        purple = (RadioButton) findViewById(R.id.purpleButton);
        submit = (Button) findViewById(R.id.NewPlayerSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                final String Name = playerName.getText().toString();
                final Color playerColor = colorButtons();

                //Player player = new Player (++playerIndex, Name, playerColor);
                Player player = new Player();

                player.setPlayerID(playerIndex);
                player.setPlayerName(Name);
                player.setColor(playerColor);

                Intent i;

                if (playerIndex <= game.maxPlayerID) {
                    i = new Intent(AddPlayer.this, AddPlayer.class);
                } else {
                    i = new Intent(AddPlayer.this, MainActivity.class);
                }

                startActivity(i);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private Color colorButtons() {
       Color color = null;
        if (red.isChecked()) {
            color = Color.valueOf(238, 80, 46);
        } else if (orange.isChecked()) {
            color = Color.valueOf(238, 176, 46);
        } else if (yellow.isChecked()) {
            color = Color.valueOf(229, 220, 42);
        } else if (green.isChecked()) {
            color = Color.valueOf(51, 229, 42);
        } else if (blue.isChecked()) {
            color = Color.valueOf(42, 144, 229);
        } else if (purple.isChecked()) {
            color = Color.valueOf(112, 42, 29);
        } else {
            color = Color.valueOf(255, 255, 255); //WHITE
        }
        
        return color;
    }

}
