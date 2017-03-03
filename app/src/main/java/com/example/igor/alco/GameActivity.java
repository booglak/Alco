package com.example.igor.alco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView iwShsh;
    private Button btnGoBuhich;
    private Button btnAutoBuhich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        iwShsh = (ImageView)findViewById(R.id.imShsh);
        btnGoBuhich = (Button)findViewById(R.id.btnGoBuhich);
        btnAutoBuhich = (Button)findViewById(R.id.btnAutoBuhich);

        btnGoBuhich.setOnClickListener(this);
        btnAutoBuhich.setOnClickListener(this);

    }


    public void Buhich (){

    }

    @Override
    public void onClick(View v) {

    }
}
