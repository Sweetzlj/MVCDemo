package com.route.test.mvcdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //界面中的ListView是View，这里通过硬编码的方式直接Java代码生成
        ListView listView = new ListView(this);
        // 控制数据怎样在ListView中显示是Controller
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData());
        //View和Model是通过桥梁Adapter来连接起来。
        listView.setAdapter(adapter);
        setContentView(listView);
        // 点击事件，Controller负责
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // position是从0开始的,获取点击item的内容
                Toast.makeText(MainActivity.this, getData().get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    // 要显示的数据Model，通过硬编码的方式直接Java代码生成
    private List<String> getData() {
        List<String> data = new ArrayList<String>();
        data.add("a");
        data.add("b");
        data.add("c");
        data.add("d");
        return data;
    }
}
