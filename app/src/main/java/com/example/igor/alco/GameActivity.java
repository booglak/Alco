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
    List<Integer> sounds;
    Handler handler;
    Random random;


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

        sounds = new ArrayList<>();
        sounds.add(sp.load(this, R.raw.one_sound, 1));
        sounds.add(sp.load(this, R.raw.two_sound, 1));
        sounds.add(sp.load(this, R.raw.three_sound, 1));
        sounds.add(sp.load(this, R.raw.four_sound, 1));
        sounds.add(sp.load(this, R.raw.five_sound, 1));
        sounds.add(sp.load(this, R.raw.six_sound, 1));
        sounds.add(sp.load(this, R.raw.seven_sound, 1));
        sounds.add(sp.load(this, R.raw.eight_sound, 1));
        sounds.add(sp.load(this, R.raw.nine_sound, 1));
        sounds.add(sp.load(this, R.raw.ten_sound, 1));
        sounds.add(sp.load(this, R.raw.eleven_sound, 1));
        sounds.add(sp.load(this, R.raw.twelve_sound, 1));


        iwShsh = (ImageView)findViewById(R.id.imShsh);
        btnGoBuhich = (Button)findViewById(R.id.btnGoBuhich);
        btnAutoBuhich = (Button)findViewById(R.id.btnAutoBuhich);

        handler = new Handler();

        btnGoBuhich.setOnClickListener(this);
        btnAutoBuhich.setOnClickListener(this);

    }


    public void Buhich (){

        random = new Random();
        System.out.println(sounds.get(random.nextInt(sounds.size())));

        iwShsh.setImageResource(R.drawable.second_image);
        sp.play(sounds.get(random.nextInt(sounds.size())), 1, 1, 0, 0, 1);
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
