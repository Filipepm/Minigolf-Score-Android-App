package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewGame extends AppCompatActivity {

    private EditText playerNum;
    private EditText parNum;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);

        playerNum = (EditText) findViewById(R.id.PersonNumInput);
        parNum = (EditText) findViewById(R.id.ParNumInput);
        submit = (Button) findViewById(R.id.NewGameSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game game = new Game();

                String num = playerNum.getText().toString();
                final int maxplayers = Integer.parseInt(num);
                game.setMaxPlayerID(maxplayers);

                Intent i = new Intent(NewGame.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
