package com.example.a1535725170.drone;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by 1535725170 on 2018/1/15.
 */

public class SActivity extends Activity implements View.OnClickListener {
    private Button to_code_screen;
    private Button return_to_majot_screen;
    private TextView test;
    private ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity);
        to_code_screen=(Button)findViewById(R.id.to_code_screen);
        return_to_majot_screen=(Button)findViewById(R.id.return_to_majot_screen);
        test = (TextView)findViewById(R.id.test);


        to_code_screen.setOnClickListener(this);
        return_to_majot_screen.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        String output = "ccc";
        ManyTreeNode t1 = new ManyTreeNode("1");
        ManyTreeNode t2 = new ManyTreeNode("2");
        ManyTreeNode t3 = new ManyTreeNode("3");
        ManyTreeNode t4 = new ManyTreeNode("4");
        ManyTreeNode t5 = new ManyTreeNode("5");
        ManyTreeNode t6 = new ManyTreeNode("6");
        ManyNodeTree m = new ManyNodeTree();
        m.addChild(t1);
        m.addChild(t2);
        m.addChild(t3);
        m.beChild(1);
        m.addChild(t4);
        m.addChild(t5);
        m.addChild(t6);
        m.beParent();
        m.addChild(t6);
        m.addChild(t6);
        m.deleteChild(2);

        switch (v.getId()){
            case R.id.to_code_screen:
                output=m.iteratorTree(m.getRoot());
                break;
            case R.id.return_to_majot_screen:
                output="bbb";


                break;
            default:
                break;
        }
        test.setText(output);
    }
}
