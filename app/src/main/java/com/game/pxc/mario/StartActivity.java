package com.game.pxc.mario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;
import scut.carson_ho.kawaii_loadingview.Kawaii_LoadingView;
public class StartActivity extends AppCompatActivity {
    private Kawaii_LoadingView Kawaii_LoadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.start);
        //开场动画控件
        Kawaii_LoadingView = (Kawaii_LoadingView) findViewById(R.id.Kawaii_LoadingView);
        //  启动动画
        Kawaii_LoadingView.startMoving();

        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout1);    //获取线性布局管理器
        Toast.makeText(this, "触摸屏幕跳过...", Toast.LENGTH_SHORT).show();    //显示一个消息提示框
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Kawaii_LoadingView.stopMoving();
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);

            }

        });


    }
}