package com.game.pxc.mario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button game;
    Button date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        game = ( Button ) findViewById(R.id.bg);
        date = ( Button ) findViewById(R.id.bd);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }

        });
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }

        });
    }

}
