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

import java.util.Random;


public class HumanVsComputer5x5 extends AppCompatActivity {

    //GUI buttons
    private Button[] buttons = new Button[25];

    //Points for the first player(human)
    private int humanPoints = 0;

    //Number of draws
    private int drawTimes = 0;

    //Points for the oponent(computer)
    private int computerPoints = 0;

    //Determines which player is to make the first move
    private boolean humanTurn = true;

    //TextView holding the first player's points
    private TextView textViewPlayer1;

    //TextView holding the number of draws
    private TextView textViewDraw;

    //TextView holding the first player's points
    private TextView textViewPlayer2;

    //The comon class object
    Comon comon = new Comon();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer5x5);

        ///Text views for holding the points
        textViewPlayer1 = findViewById(R.id.hc5x5_p1);

        textViewDraw = findViewById(R.id.hc5x5_draw);

        textViewPlayer2 = findViewById(R.id.hc5x5_p2);

        //Get the Buttons from the Layout(findViewById)
        for (int i = 0; i < 25; i++) {
            String buttonID = "button_" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resID);
        }
    }

    /**
     * Handles the players' turns
     * @param v The clicked Button
     */
    public void playGame(View v) {

        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (comon.checkForWin5x5(buttons)) {
            return;
        } else {
            if (humanTurn) {
                ((Button) v).setText("X");
            } else {
                ((Button) v).setText("O");
            }
            if (comon.checkForWin5x5(buttons)) {
                comon.humanWins(this,"Human", humanPoints,textViewPlayer1);
                humanPoints++;
                return;
            }

            computerTurn();
            if (comon.checkForWin5x5(buttons)) {
                comon.oponentWins(this,"Computer",computerPoints,textViewPlayer2);
                computerPoints++;
            } else {
                if (comon.boardIsFull5x5(buttons)) {
                    comon.draw(this,textViewDraw,drawTimes);
                    drawTimes++;
                }
            }
        }

    }

    /**
     * Resets the board by clearing the markings
     * Makes the first move for the computer when it is the computer to make the first move
     * @param v The reset Button clicked
     */
    public void resetGame(View v) {
        comon.resetBoard(25, buttons);

        humanTurn = !humanTurn;

        if (!humanTurn) {
            Random rand = new Random();
            int r = rand.nextInt(25);

            String buttonID1 = "button_" + r;

            int resID1 = getResources().getIdentifier(buttonID1, "id", getPackageName());

            buttons[r] = findViewById(resID1);

            buttons[r].setText("X");
        } else {
            return;
        }

    }

    /**
     * Handles the computers turn
     * Uses X When the computer is to make the first move and vise versa
     */
    private void computerTurn() {
        if (comon.boardIsFull5x5(buttons)) {
            if (!comon.checkForWin5x5(buttons)) {
                comon.draw(this,textViewDraw,drawTimes);
                drawTimes++;
            } else {
                return;
            }
        } else {
            Random rand = new Random();
            int r = rand.nextInt(25);
            String buttonID1 = "button_" + r;

            int resID1 = getResources().getIdentifier(buttonID1, "id", getPackageName());

            buttons[r] = findViewById(resID1);

            if (buttons[r].getText().toString().equals("")) {
                if (humanTurn) {
                    buttons[r].setText("O");
                } else {
                    buttons[r].setText("X");
                }
            } else {
                computerTurn();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("drawTimes", drawTimes);
        outState.putInt("humanPoints", humanPoints);
        outState.putInt("computerPoints", computerPoints);
        outState.putBoolean("humanTurn", humanTurn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        drawTimes = savedInstanceState.getInt("drawTimes");
        humanPoints = savedInstanceState.getInt("humanPoints");
        computerPoints = savedInstanceState.getInt("computerPoints");
        humanTurn = savedInstanceState.getBoolean("humanTurn");
    }
}
