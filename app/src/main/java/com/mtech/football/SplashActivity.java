package com.mtech.football;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // XML লেআউট সেট করতে হবে

        // 3 সেকেন্ড পর হোম পেজে নিয়ে যাওয়া
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // হোম অ্যাক্টিভিটি চালু করা
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // স্প্ল্যাশ অ্যাক্টিভিটি বন্ধ
            }
        }, 2000); // 3000 মিলিসেকেন্ড = 3 সেকেন্ড
    }
}
