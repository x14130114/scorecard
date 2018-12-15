package com.example.bmc.scorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final int splashTimeOut = 2000;
        super.onCreate(savedInstanceState);

        Thread splashThread = new Thread(){
            int wait = 0;
            @Override
            public void run() {
                try {
                    super.run();
                    while(wait < splashTimeOut){
                        sleep(100);
                        wait += 100;
                    }
                } catch (Exception e) {
                }finally{
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }
            }
        };
        splashThread.start();

    }

}
