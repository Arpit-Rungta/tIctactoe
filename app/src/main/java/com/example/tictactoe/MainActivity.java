package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
/* player Representation
  0=x
  1=o
*/
    int activePlayer = 0;
    /* state meaning
    * 0-x
    * 1-o
    * 2- null
    */
    int[] gameState={2,2,2,2,2,2,2,2,2};
//    identifying all Winning position
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    @SuppressLint("SetTextI18n")
    public void Player_Tap(View view) {
//     ImageView is used for showing image
        ImageView img = (ImageView) view;

//        tappedImg is int which we assign a imgtag value by calling .getTag() and then converting it in string and then pure ko Integer. parseInt() kiya
        int tappedImg = Integer.parseInt(img.getTag().toString());


        if (!gameActive) {
            GameReset(view);
//            adding return so that it will reset and start with x
            return;
        }
//     Setting image on the tap location
        if (gameState[tappedImg] == 2) {
            gameState[tappedImg] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;// Changing active player
                TextView status = findViewById(R.id.Status_bar);//Creating a status bar that can change value
                status.setText(R.string.o_turn_tap_to_play);
            } else  {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;// Changing active player
                TextView status = findViewById(R.id.Status_bar);//Creating a status bar that can change value
                status.setText(R.string.x_turn_tap_to_play);
            }
            img.animate().translationYBy(1000f).setDuration(300);//Animating image
        }

//Check if any one won
        for (int[] winPosition:
                winPositions) {
           if( gameState[winPosition[0]] == gameState[winPosition[1]] &&  gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] !=2) {
//          someone won
               String winnerSTR;
               gameActive = false;
               if (gameState[winPosition[0]] == 0) {
                   winnerSTR = "x has won";
               } else {
                   winnerSTR = "o has won";
               }
               TextView status=findViewById(R.id.Status_bar);
               status.setText(winnerSTR);
           }
                                                                                                                                                                                                                                                                                                            //           my add
//            if draw
               if ( gameState[0]!=2 && gameState[1]!=2 &&gameState[2]!=2 &&gameState[3]!=2 &&gameState[5]!=2 &&gameState[6]!=2 &&gameState[4]!=2 &&gameState[7]!=2 &&gameState[8]!=2 ){
                   gameActive=false;
               }
        }
    }

    @SuppressLint("SetTextI18n")
    public void GameReset(View view){
        gameActive=true;
        activePlayer=0;
        TextView status = findViewById(R.id.Status_bar);
        status.setText("X to play");
        Arrays.fill(gameState, 2);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}