package com.example.a1535725170.drone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by 1535725170 on 2018/1/22.
 */

//1.创建并且extend Activity
    //2.创建tactivity为constraintlayout,如果生成失败，回看之前创建这种layout时的教程
    //3.在tactivity里创建一个按钮进行测试(声明+初始化）
public class TActivity extends Activity{
    Button choice1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //*************重要,注册
        setContentView(R.layout.tactivity);
        choice1=(Button)findViewById(R.id.choice1);

        //4.对button设置intent监听事件
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回数据为data
                Intent data = new Intent();
                data.putExtra("choice","choice1");
                //设置页面返回标识为2
                setResult(2,data);
                finish();
            }
        });
    }
}
