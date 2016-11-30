package com.mvp.libin.recylerview_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_main;
    private List<NameBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_main = (RecyclerView) findViewById(R.id.rv_main);

        setData();

        myAdapter= new MyAdapter(list);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onClick(View View, int position) {
                Toast.makeText(getApplicationContext(),list.get(position).getName(),Toast.LENGTH_SHORT).show();

            }
        });
        rv_main.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        rv_main.setAdapter(myAdapter);
    }

    private void setData() {
        for (int i = 0 ; i < 10;i++){
           NameBean nameBean = new NameBean();
            nameBean.setName(i+"");
            list.add(nameBean);
        }
    }
}
