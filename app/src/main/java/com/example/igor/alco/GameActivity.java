package com.example.igor.alco;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView iwShsh;
    Button btnGoBuhich;
    Button btnAutoBuhich;
    SoundPool sp;
    List<Integer> sounds;
    Handler handler;
    Random random;
    AlertDialog.Builder buhichTime;


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

        buhichTime = new AlertDialog.Builder(this);

    }



    public void Buhich (){

        random = new Random();
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

    public void AutoBuhichDialog(){

        buhichTime.setTitle("Как часто ты можешь пить, бро?");
        buhichTime.setMessage("Укажи время в минутах:");
        buhichTime.setCancelable(true);

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        buhichTime.setView(input);

        buhichTime.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                try {
                    int val = Integer.parseInt(input.getText().toString());
                    AutoBuhich(val);
                }
                catch (NumberFormatException e){
                    Toast toast = Toast.makeText(getApplicationContext(), "Ты забыл сказать через сколько бухаем снова!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        buhichTime.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });

        buhichTime.show();
    }

    public void AutoBuhich(final int val){

            //System.out.println("AutoBuhich START");
            try {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Your process to do
                        Buhich();
                        AutoBuhich(val);
                    }
                }, val * 1000*60);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGoBuhich:
                Buhich();
                break;
            case R.id.btnAutoBuhich:
                AutoBuhichDialog();
                break;
        }
    }
    @Override
    public void onBackPressed (){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAndRemoveTask ();
        }
        else {
            System.exit(0);
        }


    }


}

