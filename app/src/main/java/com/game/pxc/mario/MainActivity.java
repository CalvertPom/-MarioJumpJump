package com.game.pxc.mario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.game.pxc.mario.util.Music;
import com.game.pxc.mario.util.OnContinueClickListener;
import com.game.pxc.mario.view.GameLayout;

public class MainActivity extends AppCompatActivity {
    private GameLayout mGameLayout;


    private View left;
    private View right;
    private View mus;



    private boolean isMus = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGameLayout = (GameLayout) findViewById(R.id.game);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        mus = findViewById(R.id.music);
        Music.play(MainActivity.this,R.raw.bgm3);
        left.setOnTouchListener(new OnContinueClickListener() {
            @Override
            public void handleClickEvent(View view) {
                mGameLayout.moveLeft();
            }
        });
        right.setOnTouchListener(new OnContinueClickListener() {
            @Override
            public void handleClickEvent(View view) {
                mGameLayout.moveRight();
            }
        });
        mus.setOnTouchListener(new OnContinueClickListener() {
            @Override
            public void handleClickEvent(View view) {
                isMus =!isMus;
                if(isMus ==true){
                    Music.play(MainActivity.this,R.raw.bgm3);
                    mus.setBackgroundResource(R.drawable.stopm);
                }else if(isMus==false){
                    Music.stop(MainActivity.this);
                    mus.setBackgroundResource(R.drawable.startm);
                }
            }
        });
    }


}