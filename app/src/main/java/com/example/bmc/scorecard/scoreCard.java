package com.example.bmc.scorecard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class scoreCard extends AppCompatActivity{
    private static final int [] scArray = {R.id.score1, R.id.score2, R.id.score3, R.id.score4, R.id.score5, R.id.score6, R.id.score7, R.id.score8, R.id.score9,R.id.score10, R.id.score11, R.id.score12, R.id.score13, R.id.score14, R.id.score15, R.id.score16, R.id.score17, R.id.score18 };
    private static final int [] sc2Array = {R.id.sc1, R.id.sc2, R.id.sc3, R.id.sc4, R.id.sc5, R.id.sc6, R.id.sc7, R.id.sc8, R.id.sc9,R.id.sc10, R.id.sc11, R.id.sc12, R.id.sc13, R.id.sc14, R.id.sc15, R.id.sc16, R.id.sc17, R.id.sc18 };
    //private static final int [] idArray = {R.id.submit10, R.id.submit1, R.id.submit2, R.id.submit3, R.id.submit4, R.id.submit5, R.id.submit6, R.id.submit7, R.id.submit8, R.id.submit9};
    private Button button,button1;
    private Double b,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,sum1;
    private Double a,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,sum;
    private TextView result, result2;

    MediaPlayer mpl;

    //private Button[] button = new Button[idArray.length];
    private EditText[] edittext = new EditText[scArray.length];
    private EditText[] edittext1 = new EditText[sc2Array.length];
    int j, k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
        Button bAdd = (Button) findViewById(R.id.submitP1);
        Button bViewAll = (Button) findViewById(R.id.submitP2);
        final EditText crse = (EditText) findViewById(R.id.course);
        final EditText p1 = (EditText) findViewById(R.id.p1);
        final EditText p2 = (EditText) findViewById(R.id.p2);
        final TextView p1res = (TextView) findViewById(R.id.result);
        final TextView p2res = (TextView) findViewById(R.id.result2);
        MySQLiteHelper db = new MySQLiteHelper(scoreCard.this);
        List<Overall> overall = db.getAllScores();
        String[] names = new String[overall.size()];
        mpl = MediaPlayer.create(scoreCard.this, R.raw.crowdcheer);

        result = findViewById(R.id.result);
        result2 = findViewById(R.id.result2);

        bViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySQLiteHelper db = new MySQLiteHelper(scoreCard.this);
                List<Overall> overallList = db.getAllScores();
                String sCompleteList = "Scorecard History: \n";
                for (int i=0;i<overallList.size();++i) {
                    sCompleteList = sCompleteList + "\n"+ overallList.get(i).toString();
                }
                Intent i = new Intent(scoreCard.this,viewAll.class);
                i.putExtra("dbScoresList",sCompleteList);
                startActivity(i);
            }
        });
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySQLiteHelper db = new MySQLiteHelper(scoreCard.this);
                String p1ay1 = p1.getText().toString();
                String play2 = p2.getText().toString();
                String res1 = p1res.getText().toString();
                String res2 = p2res.getText().toString();
                String course = crse.getText().toString();
                Overall overall = new Overall(p1ay1,play2,res1,res2, course);
                db.addOverall(overall);
                    Intent i = new Intent(scoreCard.this,scoreCard.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        for (j = 0; j < scArray.length; j++) {
            EditText et = findViewById(scArray[j]);
            TextWatcher tw = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(null != s.toString() && !"".equals(s.toString()) && Integer.parseInt(s.toString()) == 2){
                       // final MediaPlayer mp = MediaPlayer.create(scoreCard.this, R.raw.crowdcheer);
                        if(!mpl.isPlaying()){
                            mpl.start();
                        }
                    }
                }
            };
            et.addTextChangedListener(tw);
            edittext[j] = et;

        }
            button = findViewById(R.id.submit1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer total = 0;

                    for (int i = 0; i < edittext.length; i++) {
                        if(null != edittext[i].getText().toString() && !"".equals(edittext[i].getText().toString())){
                            total += Integer.parseInt(edittext[i].getText().toString());
                        }
                    }

                    final MediaPlayer mp = MediaPlayer.create(scoreCard.this, R.raw.crowdcheer);
                    switch (v.getId()) {
                        case R.id.submit1:
                            //mp.start();
                            result.setText(Integer.toString(total));
                            break;
                    }
                }
            });

        for (k = 0; k < sc2Array.length; k++) {
            EditText et = findViewById(sc2Array[k]);
            TextWatcher tw = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(null != s.toString() && !"".equals(s.toString()) && Integer.parseInt(s.toString()) == 2){
                        // final MediaPlayer mp = MediaPlayer.create(scoreCard.this, R.raw.crowdcheer);
                        if(!mpl.isPlaying()){
                            mpl.start();
                        }
                    }
                }
            };
            et.addTextChangedListener(tw);
            edittext1[k] = et;

        }

        button1 = findViewById(R.id.submit2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                Integer total = 0;

                for (int i = 0; i < edittext1.length; i++) {
                    if(null != edittext1[i].getText().toString() && !"".equals(edittext1[i].getText().toString())){
                        total += Integer.parseInt(edittext1[i].getText().toString());
                    }
                }

                //final MediaPlayer mp = MediaPlayer.create(scoreCard.this, R.raw.crowdcheer);
                switch (vv.getId()) {
                    case R.id.submit2:
                        //mp.start();
                        result2.setText(Integer.toString(total));
                        break;
                }
            }
        });

    }
}