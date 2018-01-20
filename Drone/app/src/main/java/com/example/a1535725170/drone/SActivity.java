package com.example.a1535725170.drone;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by 1535725170 on 2018/1/15.
 */

//10.实现listview点击和滚动 OnItemClickListener,OnScrollListener 并且点击小红灯import method来实现相关接口中的方法
public class SActivity extends Activity implements View.OnClickListener,AdapterView.OnItemClickListener,AbsListView.OnScrollListener {
    private Button to_code_screen;
    private Button return_to_majot_screen;
    private TextView test;

    //1.声明listview和simple_adapter
    private ListView listView;
    private SimpleAdapter simp_adapter;

    //5.声明dataList（作为适配器的第二个参数）,导入包
    private List<Map<String,Object>>dataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity);
        to_code_screen=(Button)findViewById(R.id.to_code_screen);
        return_to_majot_screen=(Button)findViewById(R.id.return_to_majot_screen);
        test = (TextView)findViewById(R.id.test);

        //2.初始化listview
        listView=(ListView)findViewById(R.id.listView);

        //6.初始化dataList
        dataList=new ArrayList<Map<String,Object>>();

        //3.新建数据适配器
        //SimpleAdapter（）
        /**
         * context：上下文
         * data：数据源（List<？ extends Map<String,?>> data)一个Map所组成的List集合
         *          每一个Map都会对应ListView列表中的一行
         *         每一个Map（键-值对）中的键必须包含所有在from中所指定的键
         * resource：列表中布局文件的id
         * from:Map中的键名
         * to:绑定数据视图中的ID，与from成对应关系
         */
        simp_adapter = new SimpleAdapter(this,getData(),R.layout.item,new String[]{"pic","text"},new int[]{R.id.pic,R.id.code});

        //4.新建item布局文件

        //9.视图（listview）加载适配器
        listView.setAdapter(simp_adapter);
        //11。加载监听器*2
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);

        to_code_screen.setOnClickListener(this);
        return_to_majot_screen.setOnClickListener(this);



    }

    //7.写得到数据源的函数
    private List<Map<String,Object>> getData(){
        //8.写一个测试代码
        for(int i=0;i<20;i++){
            Map<String,Object>map = new HashMap<String,Object>();
            map.put("pic",R.mipmap.ic_launcher_round);
            map.put("text","huhu"+i);
            dataList.add(map);
        }



        return dataList;
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //12.测试点击事件
        String textt = listView.getItemIdAtPosition(position)+" ";

        test.setText(textt);
    }

    //14.笔记：刷新适配器: 对dataList进行一波操作之后，刷新适配器 simp_adapter.notifyDataSetChanged()

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //13.这里可以改变下拉时的一些功能，如下拉刷新
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
