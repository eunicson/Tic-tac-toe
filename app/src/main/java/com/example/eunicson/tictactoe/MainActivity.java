package com.example.eunicson.tictactoe;

/**
 * Created by eunicson on 09/04/2018.
 */


import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

private static boolean singlePlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button singlePlayer = (Button)findViewById(R.id.single_player);

        singlePlayer.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
                setSinglePlay(true);
            }
        });


        Button twoPlayers = (Button)findViewById(R.id.two_players);

        twoPlayers.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
                setSinglePlay(false);
            }
        });
    }
    public void setSinglePlay(boolean v){
        singlePlay = v;
    }
    public boolean getSinglePlay(){
        return singlePlay;
    }
}