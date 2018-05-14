package com.example.a1535725170.drone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by 1535725170 on 2018/1/22.
 */

//1.创建并且extend Activity
    //2.创建tactivity为constraintlayout,如果生成失败，回看之前创建这种layout时的教程
    //3.在tactivity里创建一个按钮进行测试(声明+初始化）
public class TActivity extends Activity implements RadioGroup.OnCheckedChangeListener{
    Button choice1;
    Button choice2;
    RadioGroup rg;
    int radio;
    String kind;
    TextView t_direction;
    TextView t_velocity;
    TextView t_time;
    TextView t_distance;
    TextView t_times;
    EditText direction;
    EditText velocity;
    EditText time;
    EditText distance;
    EditText times;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //*************重要,注册
        setContentView(R.layout.tactivity);
        choice1=(Button)findViewById(R.id.choice1);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        t_direction = (TextView)findViewById(R.id.textView8);
        t_distance = (TextView)findViewById(R.id.t_distance) ;
        t_velocity = (TextView)findViewById(R.id.t_velocity) ;
        t_time = (TextView)findViewById(R.id.t_time) ;
        t_times = (TextView)findViewById(R.id.t_times) ;
        direction = (EditText)findViewById(R.id.editText6);
        distance = (EditText)findViewById(R.id.distance);
        velocity = (EditText)findViewById(R.id.velocity);
        time = (EditText)findViewById(R.id.time);
        times = (EditText)findViewById(R.id.times);
        choice2 = (Button)findViewById(R.id.choice2);


        rg.setOnCheckedChangeListener(this);

        //4.对button设置intent监听事件
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回数据为data
                Intent data = new Intent();
                Bundle bundle = new Bundle();
                if(radio == 1){
                    String tmp = distance.getText().toString();
                    if("".equals(tmp)){
                        tmp = "0";
                    }
                    int t=Integer.parseInt(tmp);
                    bundle.putInt("radio",1);
                    bundle.putInt("kind",0);//"not a condition"
                    bundle.putInt("distance",t);
                }
                else if (radio ==2){
                    bundle.putInt("radio",2);
                    bundle.putInt("kind",0);//"not a condition"
                }
                else if (radio == 3){
                    String tmp1 = direction.getText().toString();
                    if("".equals(tmp1)){
                        tmp1 = "0";
                    }
                    int t1=Integer.parseInt(tmp1);
                    String tmp2 = velocity.getText().toString();
                    if("".equals(tmp2)){
                        tmp2 = "0";
                    }
                    int t2=Integer.parseInt(tmp2);
                    String tmp3 = time.getText().toString();
                    if("".equals(tmp3)){
                        tmp3 = "0";
                    }
                    int t3=Integer.parseInt(tmp3);
                    bundle.putInt("radio",3);
                    bundle.putInt("kind",0);//"not a condition"
                    bundle.putInt("direction",t1);
                    bundle.putInt("velocity",t2);
                    bundle.putInt("time",t3);
                }
                else if (radio == 4){
                    String tmp = time.getText().toString();
                    if("".equals(tmp)){
                        tmp = "0";
                    }
                    int t=Integer.parseInt(tmp);
                    bundle.putInt("radio",4);
                    bundle.putInt("kind",0);//"not a condition"
                    bundle.putInt("time",t);
                }
                else if(radio == 5){
                    String  tmp = times.getText().toString();
                    if("".equals(tmp)){
                        tmp = "0";
                    }
                    int t=Integer.parseInt(tmp);
                    bundle.putInt("radio",5);
                    bundle.putInt("kind",1);//"condition
                    bundle.putInt("times",t);
                }
                data.putExtras(bundle);
                //设置页面返回标识为2
                setResult(2,data);
                finish();
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回数据为data
                Intent data = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("radio",0);
                data.putExtras(bundle);
                //设置页面返回标识为2
                setResult(2,data);
                finish();
            }
        });;

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
            case R.id.TakeOff:
                radio = 1;
                kind = "not_a_condition";
                break;
            case R.id.Land:
                radio = 2;
                kind = "not_a_condition";
                break;
            case R.id.Direction:
                radio = 3;
                kind = "not_a_condition";
                break;
            case R.id.Hover:
                radio = 4;
                kind = "not_a_condition";
                break;
            case R.id.For:
                radio = 5;
                kind = "condition";
                break;
            default:
                break;
        }
    }
}
