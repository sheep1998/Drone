package com.example.a1535725170.javatree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        ManyNodeTree manyNodeTree = new ManyNodeTree();
        manyNodeTree.addChild(new ManyTreeNode(new TreeNode("1")));
        manyNodeTree.addChild(new ManyTreeNode(new TreeNode("2")));
        manyNodeTree.addChild(new ManyTreeNode(new TreeNode("3")));
        manyNodeTree.beChild(1);
        manyNodeTree.addChild(new ManyTreeNode(new TreeNode("4")));
        manyNodeTree.addChild(new ManyTreeNode(new TreeNode("5")));
        manyNodeTree.addChild(new ManyTreeNode(new TreeNode("6")));
        manyNodeTree.beParent();
        manyNodeTree.addChild(new ManyTreeNode(new TreeNode("d")));
        manyNodeTree.beChild(2);
        manyNodeTree.addChild(new ManyTreeNode(new TreeNode("7")));
        manyNodeTree.addChild(new ManyTreeNode(new TreeNode("8")));
        manyNodeTree.addChild(new ManyTreeNode(new TreeNode("9")));


        String output=tx.getText().toString();
        switch (v.getId()){
            case R.id.bt:
                output = manyNodeTree.iteratorTree(manyNodeTree.getRoot());
                break;
            default:
                break;
        }
        tx.setText(output);
    }
}
