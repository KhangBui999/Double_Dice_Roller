package com.example.a3634_doublediceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declare components that will be modified in MainActivity
    private LinearLayout body;
    private TextView totalTitle;
    private TextView total;
    private Button button;
    private TextView diceOneResult;
    private TextView diceTwoResult;
    private TextView sumResult;
    private ImageView diceOneImg;
    private ImageView diceTwoImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Default launch of the Activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets declared components to respective XML component ID using findViewById(R.id.<comp_id>)
        diceOneResult = (TextView) findViewById(R.id.mDiceResult1);
        diceTwoResult = (TextView) findViewById(R.id.mDiceResult2);
        sumResult = (TextView) findViewById(R.id.mTotal);

        diceOneImg = (ImageView) findViewById(R.id.mDiceImg1);
        diceTwoImg = (ImageView) findViewById(R.id.mDiceImg2);

        //Sets initial visibility of certain components to invisible using .setVisibility(View.GONE)
        body = (LinearLayout) findViewById(R.id.mBody);
        body.setVisibility(View.GONE);

        totalTitle = (TextView) findViewById(R.id.mTotalTitle);
        total = (TextView) findViewById(R.id.mTotal);
        totalTitle.setVisibility(View.GONE);
        total.setVisibility(View.GONE);

        //Sets an onClickListener to activate roll() method when button is pressed
        button = findViewById(R.id.mRollBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll();
            }
        });
    }

    //Handles the actions required when the 'ROLL' button is clicked
    private void roll() {
        int diceOne = (int) (Math.random()*6) + 1; //Generates random number b/w 1 and 6
        int diceTwo = (int) (Math.random()*6) + 1;
        int rollSum = diceOne + diceTwo; //Sum of both dices

        changeDiceImage(diceOneImg, diceOne); //Invokes method to change dice image
        changeDiceImage(diceTwoImg, diceTwo);

        diceOneResult.setText(Integer.toString(diceOne)); //Sets text to String value of diceOne
        diceTwoResult.setText(Integer.toString(diceTwo)); //Sets text to String value of diceTwo
        sumResult.setText(Integer.toString(rollSum)); //Sets text to String value of rollSum

        layoutChange(); //Invokes method to change layout
    }

    //Causes certain XML components to become visible again using serVisibility(View.VISIBLE)
    private void layoutChange(){
        body.setVisibility(View.VISIBLE);
        totalTitle.setVisibility(View.VISIBLE);
        total.setVisibility(View.VISIBLE);
        button.setText("Re-roll");
    }

    /**
     * Changes the ImageView to the an image of the respective dice value from the resource file.
     * Resource file path: /app/src/main/res/drawable
     * @param diceImg the ImageView component that will be changed.
     * @param diceRoll refers to the value of the dice.
     */
    private void changeDiceImage(ImageView diceImg, int diceRoll) {
        switch(diceRoll){
            case 1: diceImg.setImageResource(R.drawable.dice1); break;
            case 2: diceImg.setImageResource(R.drawable.dice2); break;
            case 3: diceImg.setImageResource(R.drawable.dice3); break;
            case 4: diceImg.setImageResource(R.drawable.dice4); break;
            case 5: diceImg.setImageResource(R.drawable.dice5); break;
            case 6: diceImg.setImageResource(R.drawable.dice6); break;
        }
    }
}
