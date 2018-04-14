package com.example.eunicson.tictactoe;

/**
 * Created by eunicson on 09/04/2018.
 */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final MainActivity mainActivity = new MainActivity();

        final Button simpleMode = (Button) findViewById(R.id.simple_mode);

        simpleMode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i;
                if (mainActivity.getSinglePlay()) {
                    i = new Intent(MainActivity2.this, HumanVsComputer.class);
                } else {
                    i = new Intent(MainActivity2.this, HumanVsHuman.class);
                }
                startActivity(i);

            }
        });



        Button ultimateMode = (Button) findViewById(R.id.ultimate_mode);

        ultimateMode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i;
                if (mainActivity.getSinglePlay()) {
                    i = new Intent(MainActivity2.this, HumanVsComputer5x5.class);
                } else {
                    i = new Intent(MainActivity2.this, HumanVsHuman5x5.class);
                }

                startActivity(i);

            }
        });
    }

}