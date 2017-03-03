package com.example.igor.alco;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvStartApp;
    private TextView tvExitApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tvStartApp = (TextView)findViewById(R.id.tvStartApp);
        tvExitApp = (TextView) findViewById(R.id.tvExitApp);

        tvStartApp.setOnClickListener(this);
        tvExitApp.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvStartApp:
                Intent intentStart = new Intent(this, GameActivity.class);
                startActivity(intentStart);
                break;
            case R.id.tvExitApp:
                finish();
                break;
            default:
                break;
        }
    }
}
