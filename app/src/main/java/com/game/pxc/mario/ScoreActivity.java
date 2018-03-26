package com.game.pxc.mario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.game.pxc.mario.dao.ScoreDao;
import com.game.pxc.mario.model.Tb_score;

import java.util.List;
public class ScoreActivity extends AppCompatActivity {
    public static final String FLAG = "id";// 定义一个常量，用来作为请求码
    ListView lvinfo;// 创建ListView对象
    String strType = "";// 创建字符串，记录管理类型
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_score);
        lvinfo = (ListView) findViewById(R.id.lvinscoreinfo);// 获取布局文件中的ListView组件
        ShowInfo();
    }
    private void ShowInfo() {// 用来根据传入的管理类型，显示相应的信息
        String[] strInfos = null;// 定义字符串数组，用来存储分数信息
        ArrayAdapter<String> arrayAdapter = null;// 创建ArrayAdapter对象
        ScoreDao scoreinfo = new ScoreDao(ScoreActivity.this);// 创建InaccountDAO对象
        // 获取所有分数信息，并存储到List泛型集合中
        List<Tb_score> listinfos = scoreinfo.getScrollData(0,
                (int) scoreinfo.getCount());
        strInfos = new String[listinfos.size()];// 设置字符串数组的长度
        int m = 0;// 定义一个开始标识
        for (Tb_score tb_score : listinfos) {// 遍历List泛型集合
            // 将分数相关信息组合成一个字符串，存储到字符串数组的相应位置
            strInfos[m] = tb_score.get_id()  + "                   " + String.valueOf(tb_score.getScore()) + "分";
            m++;// 标识加1
        }
        // 使用字符串数组初始化ArrayAdapter对象
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strInfos);
        lvinfo.setAdapter(arrayAdapter);// 为ListView列表设置数据源
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();// 实现基类中的方法
        ShowInfo();// 显示分数信息
    }
}
