package com.example.bmc.scorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseScorecard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_scorecard);
    }

    public void chooseStepaside(View view){
        Intent intent = new Intent(ChooseScorecard.this, stepaside.class);
        startActivity(intent);
    }

    public void chooseGlenMills(View view){
        Intent intent = new Intent(ChooseScorecard.this, glenmills.class);
        startActivity(intent);
    }
}
