/**
 * Created by Nelson M. Odhiambo on 01/04/2018.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.eunicson.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HumanVsHuman5x5 extends AppCompatActivity implements View.OnClickListener {

    private Button[] buttons = new Button[25];

    private boolean player1Turn = true;

    private int player1Points = 0;

    //Number of draws
    private int drawTimes = 0;

    private int player2Points = 0;

    //TextView holding the first player's points
    private TextView textViewPlayer1;

    //TextView holding the number of draws
    private TextView textViewDraw;

    //TextView holding the first player's points
    private TextView textViewPlayer2;
    Comon comon = new Comon();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human5x5);

        //Text views for holding the points
        textViewPlayer1 = findViewById(R.id.hh5x5_p1);

        textViewDraw = findViewById(R.id.hh5x5_draw);

        textViewPlayer2 = findViewById(R.id.hh5x5_p2);

        //Get the Buttons from the Layout(findViewById)
        for (int i = 0; i < 25; i++) {

            String buttonID = "button_" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resID);
            buttons[i].setOnClickListener(this);

        }

        /**
         * resetBoard
         */
        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBoard();
            }
        });
    }

    /**
     * Handles the players' turns
     * @param v The clicked Button
     */
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (player1Turn) {
            ((Button) v).setText("X");
            if (comon.checkForWin5x5(buttons)) {
                comon.humanWins(this,"Player !",player1Points,textViewPlayer1);
                player1Points++;
            }
        } else {
            ((Button) v).setText("O");
            if (comon.checkForWin5x5(buttons)) {
                comon.oponentWins(this,"Player 2",player2Points,textViewPlayer2);
                player2Points++;
            }
        }

        if(comon.boardIsFull5x5(buttons)) {
            if (!comon.checkForWin5x5(buttons)) {
                comon.draw(this,textViewDraw,drawTimes);
                drawTimes++;
            }
        }
        player1Turn =!player1Turn;
    }

    /**
     * Resets the board by clearing the markings
     * Change turns
     * */

    private void resetBoard() {
        for (int i = 0; i < 25; i++) {
            buttons[i].setText("");
        }
        player1Turn = true;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("drawTimes", drawTimes);
        outState.putInt("player1Points", player1Points);
        outState.putInt("player2Points", player2Points);
        outState.putBoolean("player1Turn", player1Turn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        drawTimes = savedInstanceState.getInt("drawTimes");
        player1Points = savedInstanceState.getInt("player1Points");
        player2Points = savedInstanceState.getInt("player2Points");
        player1Turn = savedInstanceState.getBoolean("player1Turn");

    }
}
