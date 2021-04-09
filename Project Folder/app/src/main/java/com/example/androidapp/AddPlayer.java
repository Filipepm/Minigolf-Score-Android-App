package com.example.androidapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AddPlayer extends AppCompatActivity {

    private GridView gridView;
    private EditText playerName;
    private Button SubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_player);

        gridView = findViewById(R.id.gridview);
        gridView.setAdapter(new ColorAdapter(this));

        playerName = findViewById(R.id.PlayerNameInput); 

        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){ 
                
                Intent i = new Intent();
                i.putExtra("id", position);
                position = i.getExtras().getInt("id");
                ColorAdapter colorAdapter = new ColorAdapter(this);

                
                ImageView imageView = (ImageView) findViewById(R.id.ColorView);
                final Color color = imageView.setImageResource(colorAdapter.colorIds[position]);
            }
        });



        SubmitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void OnClick(View view) {
                final String playerName = PlayerNameInput.getText().toString(); 

                Player player = new Player();
            }
        });
        
    }

}
