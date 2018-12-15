package com.example.bmc.scorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class viewAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        TextView tvList = (TextView) findViewById(R.id.textView3);
        Intent i = getIntent();
        String sList = i.getStringExtra("dbScoresList");
        tvList.setText(sList);
        Button bDel = (Button) findViewById(R.id.delete);

        bDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySQLiteHelper db = new MySQLiteHelper(viewAll.this);
                db.deleteAllScores();
                Intent i = new Intent(viewAll.this,viewAll.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }
}
