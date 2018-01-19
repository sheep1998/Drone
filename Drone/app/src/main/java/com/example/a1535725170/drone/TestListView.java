package com.example.a1535725170.drone;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by 1535725170 on 2018/1/19.
 */

public class TestListView extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code_view);
        ListView list = (ListView)findViewById(R.id.lv01);
        ArrayList<HashMap<String,Object>> listItem = new ArrayList<HashMap<String,Object>>();
        for (int i =0;i<10;i++){
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("ItemImage",R.mipmap.ic_launcher);
            map.put("ItemTitle","Level"+i);
            map.put("ItemText","Finished in 1 Min !");
            listItem.add(map);
        }

        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,R.layout.code_block,new String[]{"ItemImage","ItemTitle","ItemText"},new int[]{R.id.ItemImage,R.id.ItemTitle,R.id.ItemText});

        list.setAdapter(listItemAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setTitle("点击第"+position+"个项目");
            }
        });

        list.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("长按菜单-ContextMenu");
                menu.add(0,0,0,"弹出长按菜单0");
                menu.add(0,1,0,"弹出长按菜单1");
            }
        });
    }

    public boolean onContextItemSelected(MenuItem item){
        setTitle("点击了长按菜单里面的第"+item.getItemId()+"个项目");
        return super.onContextItemSelected(item);
    }
}
