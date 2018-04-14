/**
 * Created by eunicson on 01/04/2018.
 *
 * Copyright 2018 The Android Open Source Project
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


import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Comon class holds methods common to the other classes
 */
public class Comon {

    /**
     * Toasts  a message to indicate that the first player has won.
     *
     * @param x               The current activity
     * @param player          The first player
     * @param humanPoints     Points for the first player
     * @param text TextView for holding the first player's points
     */
    public void humanWins(Activity x, String player, int humanPoints, TextView text) {
        humanPoints += 1;
        Toast.makeText(x, player + " wins!", Toast.LENGTH_SHORT).show();
        text.setText(String.valueOf(humanPoints));
    }

    /**
     * Toasts  a message to indicate that the second player/oponent has won.
     *
     * @param x               The current Activity
     * @param oponentPoints   Points for the second player
     * @param oponent         The second player
     * @param text TextView for holding the second player's points
     */
    public void oponentWins(Activity x, String oponent, int oponentPoints, TextView text) {
        oponentPoints += 1;
        Toast.makeText(x, oponent + " Wins!", Toast.LENGTH_SHORT).show();
        text.setText(String.valueOf(oponentPoints));
    }

    /**
     * Toasts a message to indicate that the game ended in a draw.
     * @param x The current Activity
     */
    public void draw(Activity x, TextView text, int drawTimes) {
        drawTimes += 1;
        Toast.makeText(x, "Draw!", Toast.LENGTH_SHORT).show();
        text.setText(String.valueOf(drawTimes));
    }

    /**
     * Clears the TicTacToe board of all the X and O markings
     *
     * @param numberOfButtons The number of Buttons on the current TicTacToe board
     * @param buttons         array of Buttons on thr current TicTacToe board
     */

    public void resetBoard(int numberOfButtons, Button[] buttons) {
        for (int i = 0; i < numberOfButtons; i++) {
            buttons[i].setText("");
        }
    }

    /**
     * Checks if every Button of the current TicTacToe 3x3 board is marked
     *
     * @param buttons array of Buttons on the current TicTacToe board
     * @return true of false
     */
    public boolean boardIsFull3x3(Button[] buttons) {
        String field[] = new String[9];
        for (int i = 0; i < 9; i++) {
            field[i] = buttons[i].getText().toString();
        }

        if (!field[0].equals("")
                && !field[1].equals("")
                && !field[2].equals("")
                && !field[3].equals("")
                && !field[4].equals("")
                && !field[5].equals("")
                && !field[6].equals("")
                && !field[7].equals("")
                && !field[8].equals("")
                ) {
            return true;
        }
        return false;
    }

    /**
     * Checks if every Button of the current TicTacToe 5x5 board is marked
     *
     * @param buttons array of Buttons on the current TicTacToe board
     * @return true of false
     */
    public boolean boardIsFull5x5(Button[] buttons) {

        String field[] = new String[25];
        for (int i = 0; i < 25; i++) {
            field[i] = buttons[i].getText().toString();
        }

        if (!field[0].equals("")
                && !field[1].equals("")
                && !field[2].equals("")
                && !field[3].equals("")
                && !field[4].equals("")
                && !field[5].equals("")
                && !field[6].equals("")
                && !field[7].equals("")
                && !field[8].equals("")
                && !field[9].equals("")
                && !field[10].equals("")
                && !field[11].equals("")
                && !field[12].equals("")
                && !field[13].equals("")
                && !field[14].equals("")
                && !field[15].equals("")
                && !field[16].equals("")
                && !field[17].equals("")
                && !field[18].equals("")
                && !field[19].equals("")
                && !field[20].equals("")
                && !field[21].equals("")
                && !field[22].equals("")
                && !field[23].equals("")
                && !field[24].equals("")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the player, who has just made a move, has won
     *
     * @param buttons array of Buttons on the current TicTacToe 3x3 board
     * @return true of false
     */
    public boolean checkForWin3x3(Button[] buttons) {
        String[] field = new String[9];

        for (int i = 0; i < 9; i++) {
            field[i] = buttons[i].getText().toString();
        }
        //Check the first row
        if (field[0].equals(field[1])
                && field[0].equals(field[2])
                && !field[0].equals("")) {
            return true;
        }
        //Check the second row
        if (field[3].equals(field[4])
                && field[3].equals(field[5])
                && !field[3].equals("")) {
            return true;
        }
        //Check the third row
        if (field[6].equals(field[7])
                && field[6].equals(field[8])
                && !field[6].equals("")) {
            return true;
        }
        //Check the first column
        if (field[0].equals(field[3])
                && field[0].equals(field[6])
                && !field[0].equals("")) {
            return true;
        }
        //Check the second column
        if (field[1].equals(field[4])
                && field[1].equals(field[7])
                && !field[1].equals("")) {
            return true;
        }
        //Check the third column
        if (field[2].equals(field[5])
                && field[2].equals(field[8])
                && !field[2].equals("")) {
            return true;
        }
        //Check the diagonal
        if (field[0].equals(field[4])
                && field[0].equals(field[8])
                && !field[0].equals("")) {
            return true;
        }
        //Check the anti-diagonal
        if (field[2].equals(field[4])
                && field[2].equals(field[6])
                && !field[2].equals("")) {
            return true;
        }

        return false;
    }

    /**
     * Checks if the player, who has just made a move, has won
     *
     * @param buttons array of Buttons on the current TicTacToe 5x5 board
     * @return true of false
     */
    public boolean checkForWin5x5(Button[] buttons) {
        String[] field = new String[25];

        for (int i = 0; i < 25; i++) {
            field[i] = buttons[i].getText().toString();
        }
        //Check the first row
        if (field[0].equals(field[1])
                && field[0].equals(field[2])
                && field[0].equals(field[3])
                && field[0].equals(field[4])
                && !field[0].equals("")) {
            return true;
        }
        //Check the second row
        if (field[5].equals(field[6])
                && field[5].equals(field[7])
                && field[5].equals(field[8])
                && field[5].equals(field[9])
                && !field[5].equals("")) {
            return true;
        }
        //Check the third row
        if (field[10].equals(field[11])
                && field[10].equals(field[12])
                && field[10].equals(field[13])
                && field[10].equals(field[14])
                && !field[10].equals("")) {
            return true;
        }
        //Check the fourth row
        if (field[15].equals(field[16])
                && field[15].equals(field[17])
                && field[15].equals(field[18])
                && field[15].equals(field[19])
                && !field[15].equals("")) {
            return true;
        }
        //Check the fifth row
        if (field[20].equals(field[21])
                && field[20].equals(field[22])
                && field[20].equals(field[23])
                && field[20].equals(field[24])
                && !field[20].equals("")) {
            return true;
        }
        //Check the first column
        if (field[0].equals(field[5])
                && field[0].equals(field[10])
                && field[0].equals(field[15])
                && field[0].equals(field[20])
                && !field[0].equals("")) {
            return true;
        }
        //Check the second column
        if (field[1].equals(field[6])
                && field[1].equals(field[11])
                && field[1].equals(field[16])
                && field[1].equals(field[21])
                && !field[1].equals("")) {
            return true;
        }
        //Check the third column
        if (field[2].equals(field[7])
                && field[2].equals(field[12])
                && field[2].equals(field[17])
                && field[2].equals(field[22])
                && !field[2].equals("")) {
            return true;
        }
        //Check the fourth column
        if (field[3].equals(field[8])
                && field[3].equals(field[13])
                && field[3].equals(field[18])
                && field[3].equals(field[23])
                && !field[3].equals("")) {
            return true;
        }
        //Check the fifth column
        if (field[4].equals(field[9])
                && field[4].equals(field[14])
                && field[4].equals(field[19])
                && field[4].equals(field[24])
                && !field[4].equals("")) {
            return true;
        }
        //Check the diagonal
        if (field[0].equals(field[6])
                && field[0].equals(field[12])
                && field[0].equals(field[18])
                && field[0].equals(field[24])
                && !field[0].equals("")) {
            return true;
        }
        //Check the anti-diagonal
        if (field[4].equals(field[8])
                && field[4].equals(field[12])
                && field[4].equals(field[16])
                && field[4].equals(field[20])
                && !field[4].equals("")) {
            return true;
        }

        return false;
    }
}
