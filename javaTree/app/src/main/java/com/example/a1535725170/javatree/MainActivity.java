package com.example.a1535725170.javatree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt;//定义按钮
    TextView tx;//定义显示结果的text

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button)findViewById(R.id.bt);//实例化按钮
        tx = (TextView)findViewById(R.id.text);//实例化text
        bt.setOnClickListener(this);//给按钮设置点击事件
    }

    @Override
    public void onClick(View v) {

        String output=tx.getText().toString();
        switch (v.getId()){
            case R.id.bt:
                output +="a";
                break;
            default:
                break;
        }
        tx.setText(output);
    }
}
