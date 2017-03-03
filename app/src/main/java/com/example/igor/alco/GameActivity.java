package com.example.igor.alco;

import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView iwShsh;
    Button btnGoBuhich;
    Button btnAutoBuhich;
    SoundPool sp;
    int soundId;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        SoundPool.OnLoadCompleteListener onLoadCompleteListener = new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {

            }
        };

        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sp.setOnLoadCompleteListener(onLoadCompleteListener);

        soundId = sp.load(this, R.raw.one_sound, 1);

        iwShsh = (ImageView)findViewById(R.id.imShsh);
        btnGoBuhich = (Button)findViewById(R.id.btnGoBuhich);
        btnAutoBuhich = (Button)findViewById(R.id.btnAutoBuhich);

        handler = new Handler();

        btnGoBuhich.setOnClickListener(this);
        btnAutoBuhich.setOnClickListener(this);

    }


    public void Buhich (){

        iwShsh.setImageResource(R.drawable.second_image);
        sp.play(soundId, 1, 1, 0, 0, 1);
        handler.postDelayed(new Runnable() {
            public void run() {
                iwShsh.setImageResource(R.drawable.third_image);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        iwShsh.setImageResource(R.drawable.first_image);
                    }
                }, 2000);
            }
        }, 5000);
    }

    public void AutoBuhich(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGoBuhich:
                Buhich();
                break;
        }
    }
}
