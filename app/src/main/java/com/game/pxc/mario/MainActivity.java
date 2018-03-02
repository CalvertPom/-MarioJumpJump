package com.game.pxc.mario;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.game.pxc.mario.util.OnContinueClickListener;
import com.game.pxc.mario.view.GameLayout;

public class MainActivity extends AppCompatActivity {
    private GameLayout mGameLayout;


    private View left;
    private View right;
    private Thread thread;
    private static MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGameLayout = (GameLayout) findViewById(R.id.game);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                playBGSound();
            }
        });
        thread.start();

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
    }

    private void playBGSound() {
        if (mp != null) {
            mp.release();
        }
        mp = MediaPlayer.create(MainActivity.this, R.raw.bgm2);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                try {
                    Thread.sleep(5000);
                    playBGSound();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
        if (thread != null) {
            thread = null;
        }
        mGameLayout.stop();
        super.onDestroy();
    }
}