package com.example.a3634_doublediceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceOneResult = (TextView) findViewById(R.id.mDiceResult1);
        diceTwoResult = (TextView) findViewById(R.id.mDiceResult2);
        sumResult = (TextView) findViewById(R.id.mTotal);

        diceOneImg = (ImageView) findViewById(R.id.mDiceImg1);
        diceTwoImg = (ImageView) findViewById(R.id.mDiceImg2);

        body = (LinearLayout) findViewById(R.id.mBody);
        body.setVisibility(View.GONE);

        totalTitle = (TextView) findViewById(R.id.mTotalTitle);
        total = (TextView) findViewById(R.id.mTotal);
        totalTitle.setVisibility(View.GONE);
        total.setVisibility(View.GONE);

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

    private void roll() {
        int diceOne = (int) (Math.random()*6) + 1;
        int diceTwo = (int) (Math.random()*6) + 1;
        int rollSum = diceOne + diceTwo;

        changeDiceImage(diceOneImg, diceOne);
        changeDiceImage(diceTwoImg, diceTwo);

        diceOneResult.setText(Integer.toString(diceOne));
        diceTwoResult.setText(Integer.toString(diceTwo));
        sumResult.setText(Integer.toString(rollSum));

        layoutChange();
    }

    private void layoutChange(){
        body.setVisibility(View.VISIBLE);
        totalTitle.setVisibility(View.VISIBLE);
        total.setVisibility(View.VISIBLE);
        button.setText("Re-roll");
    }

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
