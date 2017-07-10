package com.route.test.mvclistview;

import android.content.res.Resources;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //界面中的ListView是View，View在layout目录下通过xml文件格式生成，用findViewById()获取
        ListView listView = (ListView) findViewById(R.id.listview);
        // 控制数据怎样在ListView中显示是Controller
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData());
        //View和Model是通过桥梁Adapter来连接起来。
        listView.setAdapter(adapter);
        // 点击事件，Controller负责
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // position是从0开始的,获取点击item的内容
                Toast.makeText(MainActivity.this, getData().get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    // 要显示的数据Model，Model在values目录下通过xml文件格式生成
    private List<String> getData() {
        List<String> data = new ArrayList<String>();
        Resources res =getResources();
        // 取xml文件格式的字符数组
        String[] good=res.getStringArray(R.array.good);
        for(int i=0;i<good.length;i++){
            data.add(good[i]);
        }
        return data;
    }
}
