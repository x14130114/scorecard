package com.example.bmc.scorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createScorecard(View view){
        Intent intent = new Intent(MainActivity.this, scoreCard.class);
        startActivity(intent);
    }

    public void chooseScorecard(View view){
        Intent intent = new Intent(MainActivity.this, ChooseScorecard.class);
        startActivity(intent);
    }
}
