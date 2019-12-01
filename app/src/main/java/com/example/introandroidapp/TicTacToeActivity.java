package com.example.introandroidapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class TicTacToeActivity extends AppCompatActivity implements OnClickListener{


    //PRIVATE VARIABLES
    private Button gameGrid[][] = new Button[3][3];
    private Button newGameButton;
    private TextView messageTextView;

    private int turn;
    private String message;
    private boolean gameOver;
    private String gameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        gameGrid[0][0] = findViewById(R.id.square1);
        gameGrid[0][1] = findViewById(R.id.square2);
        gameGrid[0][2] = findViewById(R.id.square3);
        gameGrid[1][0] = findViewById(R.id.square4);
        gameGrid[1][1] = findViewById(R.id.square5);
        gameGrid[1][2] = findViewById(R.id.square6);
        gameGrid[2][0] = findViewById(R.id.square7);
        gameGrid[2][1] = findViewById(R.id.square8);
        gameGrid[2][2] = findViewById(R.id.square9);
        newGameButton = findViewById(R.id.newGameButton);
        messageTextView = findViewById(R.id.messageTextView);


        //event handler
        for(int x = 0; x < gameGrid.length; x++){
            for(int y = 0; y < gameGrid[x].length; y++){
                gameGrid[x][y].setOnClickListener(this);
            }
        }

        newGameButton.setOnClickListener(this);
        //clear the grid
        for(int x = 0; x < gameGrid.length; x++){
            for(int y = 0; y < gameGrid[x].length; y++){
                gameGrid[x][y].setText(" ");
            }
        }

        //setting string values
        turn = 1;
        gameOver = false;
        message= "Player X's turn";
        messageTextView.setText(message);
        gameString = "         "; //9 spaces; One for each square


    }//end of onCreate method

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.newGameButton:
                //clear all the grid
                for(int x = 0; x < gameGrid.length; x++){
                    for(int y=0; y < gameGrid[x].length; y++){
                        gameGrid[x][y].setText(" ");
                    }
                }
                turn = 1;
                gameOver = false;
                message="Player X's turn";
                messageTextView.setText(message);
                gameString = "         "; //9 spaces; One for each square
                break;
            default:
                if(!gameOver){
                    Button b = (Button) v;

                    if(b.getText().equals(" ")){
                        if(turn % 2 !=0){
                            b.setText("X");
                            message = "Player O's turn";

                        }
                        else{
                            b.setText("O");
                            message = "Player X's turn";
                        }

                        turn ++;
                        checkForGameOver();

                    }else{
                        message="That square is taken. Try again.";
                    }
                }
                messageTextView.setText(message);
        }

    }

    private void checkForGameOver() {

        //checks for rows
        for(int x = 0; x < 3; x++){
            if(!gameGrid[x][0].getText().equals(" ") &&
                gameGrid[x][0].getText().equals(gameGrid[x][1].getText()) &&
                gameGrid[x][1].getText().equals(gameGrid[x][2].getText())
            ){
                message=gameGrid[x][0].getText() + " wins!";
                gameOver = true;
                return;
            }
        }

        //checks for columns
        for(int y = 0; y < 3; y++){
            if(!gameGrid[0][y].getText().equals(" ") &&
                    gameGrid[0][y].getText().equals(gameGrid[1][y].getText()) &&
                    gameGrid[1][y].getText().equals(gameGrid[2][y].getText())
            ){
                message=gameGrid[0][y].getText() + " wins!";
                gameOver = true;
                return;
            }
        }

        //checks for diagonal 1
        if(!gameGrid[0][0].getText().equals(" ") &&
                gameGrid[0][0].getText().equals(gameGrid[1][1].getText()) &&
                gameGrid[1][1].getText().equals(gameGrid[2][2].getText())
        ){
            message=gameGrid[0][0].getText() + " wins!";
            gameOver = true;
            return;
        }

        //checks for diagonal 2
        if(!gameGrid[2][0].getText().equals(" ") &&
                gameGrid[2][0].getText().equals(gameGrid[1][1].getText()) &&
                gameGrid[0][2].getText().equals(gameGrid[1][1].getText())
        ){
            message=gameGrid[2][0].getText() + " wins!";
            gameOver = true;
            return;
        }

        if(turn > 9){
            message = "It's a tie!";
            gameOver = true;
            return;
        }

        gameOver = false;


    } //end of checkForGameOver method

}
