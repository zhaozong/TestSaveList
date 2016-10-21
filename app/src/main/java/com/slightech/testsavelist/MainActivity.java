package com.slightech.testsavelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<String> list = null;
    private Button add;
    private Button delete;
    private ListView listView;
    private MyAdapter adapter;
    private int count = 0;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.add_item);
        add.setOnClickListener(this);
        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listview);

        util = new Util(this);
        list = util.loadArray(this);
        adapter = new MyAdapter(this, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_item:
                list.add(count + "");
                count++;
                break;
            case R.id.delete:
                if (list.size()>0){
                    list.remove(list.size() - 1);
                }
                break;
        }
        adapter.notifyDataSetChanged();
        util.saveArray(list);
    }
}
