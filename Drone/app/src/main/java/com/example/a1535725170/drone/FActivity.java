package com.example.a1535725170.drone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by 1535725170 on 2018/1/15.
 */

public class FActivity extends Activity{
    private Button bt1;

    private Button bt3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity);
        bt1=(Button)findViewById(R.id.major_screen_to_programming);

        bt3=(Button)findViewById(R.id.qt);
        //给bt1注册一个点击事件
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //初始化intent 第一个参数是上下文对象this  第二个参数是目标文件
                Intent intent = new Intent(FActivity.this,SActivity.class);
                //实现跳转
                startActivity(intent);

            }
        });
        bt3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
}
}

