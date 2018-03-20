package com.game.pxc.mario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.game.pxc.mario.view.GameLayout;

public class MainActivity extends AppCompatActivity {
    private GameLayout mGameLayout;
//    private View left;
//    private View right;
//    private View mus;
//    private boolean isMus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //隐藏标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mGameLayout = (GameLayout) findViewById(R.id.game);
//        left = findViewById(R.id.left);
//        right = findViewById(R.id.right);
//        mus = findViewById(R.id.music);
//        Music.play(MainActivity.this, R.raw.bgm4);
//        left.setOnTouchListener(new OnContinueClickListener() {
//            @Override
//            public void handleClickEvent(View view) {
//                mGameLayout.moveLeft();
//            }
//        });
//        right.setOnTouchListener(new OnContinueClickListener() {
//            @Override
//            public void handleClickEvent(View view) {
//                mGameLayout.moveRight();
//            }
//        });
        //音乐控制
//        mus.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // isMus =!isMus;
//                if (isMus == true) {
//                    Music.play(MainActivity.this, R.raw.bgm4);
//                    mus.setBackgroundResource(R.drawable.stopm);
//                    isMus = false;
//                } else if (isMus == false) {
//                    Music.stop(MainActivity.this);
//                    mus.setBackgroundResource(R.drawable.startm);
//                    isMus = true;
//                }
//            }
//        });


    }
}