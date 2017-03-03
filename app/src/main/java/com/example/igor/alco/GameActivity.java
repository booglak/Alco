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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView iwShsh;
    Button btnGoBuhich;
    Button btnAutoBuhich;
    SoundPool sp;
    int soundId;
    List<Integer> sounds;
    Handler handler;
    Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        sounds = new ArrayList<>();
        sounds.add(R.raw.one_sound);
        sounds.add(R.raw.two_sound);
        sounds.add(R.raw.three_sound);
        sounds.add(R.raw.four_sound);
        sounds.add(R.raw.five_sound);
        sounds.add(R.raw.six_sound);
        sounds.add(R.raw.seven_sound);
        sounds.add(R.raw.eight_sound);
        sounds.add(R.raw.nine_sound);
        sounds.add(R.raw.ten_sound);
        sounds.add(R.raw.eleven_sound);
        sounds.add(R.raw.twelve_sound);

        SoundPool.OnLoadCompleteListener onLoadCompleteListener = new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {

            }
        };

        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sp.setOnLoadCompleteListener(onLoadCompleteListener);

        //soundId = sp.load(this, sounds.get(random.nextInt(sounds.size())), 1);
        soundId = sp.load(this, R.raw.one_sound, 1);

        iwShsh = (ImageView)findViewById(R.id.imShsh);
        btnGoBuhich = (Button)findViewById(R.id.btnGoBuhich);
        btnAutoBuhich = (Button)findViewById(R.id.btnAutoBuhich);

        handler = new Handler();

        btnGoBuhich.setOnClickListener(this);
        btnAutoBuhich.setOnClickListener(this);

    }


    public void Buhich (){

        random = new Random();


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
                System.out.println("");
                Buhich();
                break;
        }
    }
}
