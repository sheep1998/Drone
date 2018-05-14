package com.example.a1535725170.drone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.transition.TransitionManager;
import android.util.Log;
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
import java.io.*;

/**
 * Created by 1535725170 on 2018/1/15.
 */



//实现listview点击和滚动 OnItemClickListener,OnScrollListener 并且点击小红灯import method来实现相关接口中的方法
public class SActivity extends Activity implements View.OnClickListener,AdapterView.OnItemClickListener,AbsListView.OnScrollListener {
    private Button to_code_screen;
    private Button return_to_majot_screen;
    private Button condition;
    private Button up_to_parent;
    private TextView test;
    String output = "ccc";
    ManyNodeTree manyNodeTree = new ManyNodeTree();
    private int pos;//the pos of item in datalist to be changed
    private Button py;



    //声明listview和simple_adapter
    private ListView listView;
    private SimpleAdapter simp_adapter;

    //声明dataList（作为适配器的第二个参数）,导入包
    private List<Map<String,Object>>dataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity);
        to_code_screen=(Button)findViewById(R.id.to_code_screen);
        return_to_majot_screen=(Button)findViewById(R.id.return_to_majot_screen);
        condition = (Button)findViewById(R.id.condition);
        up_to_parent = (Button)findViewById(R.id.up_to_parent);
        condition.setText(manyNodeTree.getTmp().getText());
        test = (TextView)findViewById(R.id.test);
        py = (Button)findViewById(R.id.py);

        ManyTreeNode t1 = new ManyTreeNode("请点击输入");
        ManyTreeNode t2 = new ManyTreeNode("请点击输入");
        ManyTreeNode t3 = new ManyTreeNode("请点击输入");
        ManyTreeNode t4 = new ManyTreeNode("请点击输入");
        ManyTreeNode t5 = new ManyTreeNode("请点击输入");
        ManyTreeNode t6 = new ManyTreeNode("请点击输入");
        ManyTreeNode t7 = new ManyTreeNode("请点击输入");
        ManyTreeNode t8 = new ManyTreeNode("请点击输入");
        ManyTreeNode t9 = new ManyTreeNode("请点击输入");
        ManyTreeNode t10 = new ManyTreeNode("添加新操作");
        t10.setPic(R.mipmap.ic_launcher);

        manyNodeTree.addChild(t1);
        manyNodeTree.addChild(t2);
        manyNodeTree.addChild(t3);
        manyNodeTree.addChild(t4);
        manyNodeTree.addChild(t5);
        manyNodeTree.addChild(t6);
        manyNodeTree.addChild(t7);
        manyNodeTree.addChild(t8);
        manyNodeTree.addChild(t9);
        manyNodeTree.addChild(t10);


        //初始化listview
        listView=(ListView)findViewById(R.id.listView);

        //初始化dataList
        dataList=new ArrayList<Map<String,Object>>();
        for(int i=0;i<manyNodeTree.childNumber();i++){
            Map<String,Object>map = new HashMap<String,Object>();
            map.put("pic",manyNodeTree.getTmp().getChildList().get(i).getPic());
            map.put("text",manyNodeTree.getTmp().getChildList().get(i).getText());
            dataList.add(map);
        }

        //新建数据适配器
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

        //新建item布局文件

        //视图（listview）加载适配器
        listView.setAdapter(simp_adapter);
        //加载监听器*2
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);

        to_code_screen.setOnClickListener(this);
        return_to_majot_screen.setOnClickListener(this);
        up_to_parent.setOnClickListener(this);
        py.setOnClickListener(this);

    }

    //写得到数据源的函数
    private List<Map<String,Object>> getData(){
        return dataList;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.to_code_screen:
                output=manyNodeTree.iteratorTree(manyNodeTree.getRoot());
                break;
            case R.id.return_to_majot_screen:
                finish();
                break;
            case R.id.py:
               // File file = new File("/mnt/sdcard/Download","hello.py");
                File file = new File(getExternalFilesDir(null).getPath(),"hello.txt");
                String s = manyNodeTree.iteratorTree(manyNodeTree.getRoot());



                FileOutputStream output = null;
                try {
                    output = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    output.write(s.getBytes());
                    output.close();
                    py.setText(file.getPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;
            case R.id.up_to_parent:
                manyNodeTree.beParent();
                dataList.clear();
                for(int i=0;i<manyNodeTree.childNumber();i++){
                    Map<String,Object>map = new HashMap<String,Object>();
                    map.put("pic",manyNodeTree.getTmp().getChildList().get(i).getPic());
                    map.put("text",manyNodeTree.getTmp().getChildList().get(i).getText());
                    dataList.add(map);
                }
                simp_adapter.notifyDataSetChanged();
                condition.setText(manyNodeTree.getTmp().getText());
                break;
            default:
                break;
        }
        test.setText(output);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //测试点击事件
        //String textt = listView.getItemIdAtPosition(position)+" ";

        //test.setText(textt);
        pos = position;
        if(position== (manyNodeTree.childNumber()-1)){
            Map<String,Object>map = new HashMap<String,Object>();
            map.put("pic",R.mipmap.ic_launcher_round);
            map.put("text","请点击输入");
            dataList.add(position,map);
            simp_adapter.notifyDataSetChanged();
            manyNodeTree.deleteChild(manyNodeTree.getTmp().getChildList().size()-1);
            manyNodeTree.addChild(new ManyTreeNode("请点击输入"));
            ManyTreeNode t_final = new ManyTreeNode("添加新操作");
            t_final.setPic(R.mipmap.ic_launcher);
            manyNodeTree.addChild(t_final);
        }
        else{
            if(manyNodeTree.getTmp().getChildList().get(position).getKind()=="condition"){
                manyNodeTree.beChild(position);
                dataList.clear();
                for(int i=0;i<manyNodeTree.childNumber();i++){
                    Map<String,Object>map = new HashMap<String,Object>();
                    map.put("pic",manyNodeTree.getTmp().getChildList().get(i).getPic());
                    map.put("text",manyNodeTree.getTmp().getChildList().get(i).getText());
                    dataList.add(map);
                }
                for(int i = manyNodeTree.childNumber();i<9;i++){
                    Map<String,Object>map = new HashMap<String,Object>();
                    map.put("pic",R.mipmap.ic_launcher_round);
                    map.put("text","请点击输入");
                    dataList.add(map);
                    ManyTreeNode new_node = new ManyTreeNode("请点击输入");
                    manyNodeTree.addChild(new_node);
                }
                if(manyNodeTree.getTmp().getHasBeenBuild()==false){
                Map<String,Object>map = new HashMap<String,Object>();
                map.put("pic",R.mipmap.ic_launcher);
                map.put("text","添加新操作");
                dataList.add(map);
                ManyTreeNode new_node = new ManyTreeNode("添加新操作");
                manyNodeTree.addChild(new_node);
                manyNodeTree.getTmp().setHasBeenBuild(true);
                }

                simp_adapter.notifyDataSetChanged();
                condition.setText(manyNodeTree.getTmp().getText());
            }
            else{

            Intent intent = new Intent(SActivity.this,TActivity.class);
            //第二个参数是请求的标识——请求码
            startActivityForResult(intent,1);
            }
        }


    }



    //笔记：刷新适配器: 对dataList进行一波操作之后，刷新适配器 simp_adapter.notifyDataSetChanged()

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //这里可以改变下拉时的一些功能，如下拉刷新
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    public void s(){
        manyNodeTree.getTmp().getChildList().get(pos).setText("qqq");

        Map<String,Object>map = new HashMap<String,Object>();
        map.put("pic",manyNodeTree.getTmp().getChildList().get(pos).getPic());
        map.put("text",manyNodeTree.getTmp().getChildList().get(pos).getText());
        simp_adapter.notifyDataSetChanged();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((requestCode==1) && (resultCode==2)){
            Bundle b = data.getExtras();
            int radio = b.getInt("radio");
            if (radio==0){
                manyNodeTree.getTmp().getChildList().get(pos).reset();
                dataList.get(pos).put("pic",manyNodeTree.getTmp().getChildList().get(pos).getPic());
                dataList.get(pos).put("text",manyNodeTree.getTmp().getChildList().get(pos).getText());
            }
            else if(radio == 1){
                int distance = b.getInt("distance");
                String attr = String.valueOf(distance);
                manyNodeTree.getTmp().getChildList().get(pos).setRadio("TakeOff");
                manyNodeTree.getTmp().getChildList().get(pos).setAttribution(attr);
                manyNodeTree.getTmp().getChildList().get(pos).setText("takeoff("+ attr +")");
                dataList.get(pos).put("pic",manyNodeTree.getTmp().getChildList().get(pos).getPic());
                dataList.get(pos).put("text",manyNodeTree.getTmp().getChildList().get(pos).getText());
            }
            else if(radio == 2){
                manyNodeTree.getTmp().getChildList().get(pos).setRadio("Land");
                manyNodeTree.getTmp().getChildList().get(pos).setText("land()");
                dataList.get(pos).put("pic",manyNodeTree.getTmp().getChildList().get(pos).getPic());
                dataList.get(pos).put("text",manyNodeTree.getTmp().getChildList().get(pos).getText());
            }
            else if (radio ==3){
                manyNodeTree.getTmp().getChildList().get(pos).setRadio("Direction");
                manyNodeTree.getTmp().getChildList().get(pos).setAttribution(String.valueOf(b.getInt("direction"))+"_" +String.valueOf(b.getInt("velocity"))+"_"+String.valueOf(b.getInt("time")));
                //manyNodeTree.getTmp().getChildList().get(pos).setText("Direction-"+String.valueOf(b.getInt("direction"))+" " +String.valueOf(b.getInt("velocity"))+"m/s "+String.valueOf(b.getInt("time")) +"s" );
                manyNodeTree.getTmp().getChildList().get(pos).setText("goto("+String.valueOf(b.getInt("direction"))+")");
                dataList.get(pos).put("pic",manyNodeTree.getTmp().getChildList().get(pos).getPic());
                dataList.get(pos).put("text",manyNodeTree.getTmp().getChildList().get(pos).getText());
            }
            else if(radio == 4){
                manyNodeTree.getTmp().getChildList().get(pos).setRadio("Hover");
                manyNodeTree.getTmp().getChildList().get(pos).setAttribution(String.valueOf(b.getInt("time")));
                manyNodeTree.getTmp().getChildList().get(pos).setText("hover("+String.valueOf(b.getInt("time"))+")");
                dataList.get(pos).put("pic",manyNodeTree.getTmp().getChildList().get(pos).getPic());
                dataList.get(pos).put("text",manyNodeTree.getTmp().getChildList().get(pos).getText());
            }
            else if(radio == 5){
                manyNodeTree.getTmp().getChildList().get(pos).setRadio("For");
                manyNodeTree.getTmp().getChildList().get(pos).setKind("condition");
                manyNodeTree.getTmp().getChildList().get(pos).setAttribution(String.valueOf(b.getInt("times")));
                manyNodeTree.getTmp().getChildList().get(pos).setText("for i in range("+String.valueOf(b.getInt("times"))+"):");
                dataList.get(pos).put("pic",manyNodeTree.getTmp().getChildList().get(pos).getPic());
                dataList.get(pos).put("text",manyNodeTree.getTmp().getChildList().get(pos).getText());
            }
            simp_adapter.notifyDataSetChanged();
            condition.setText(manyNodeTree.getTmp().getText());










        }
    }
}