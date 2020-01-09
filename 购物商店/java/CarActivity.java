package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.myapplication.adapter.CarAdapter;
import com.example.administrator.myapplication.bean.ShopBean;
import com.example.administrator.myapplication.database.SQLiteHelper;

import java.util.List;


public class CarActivity extends Activity{
    private ListView mListView;
    List<ShopBean> list;
    SQLiteHelper sqLiteHelper;
    CarAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        mListView = (ListView) findViewById(R.id.lv);//初始化ListView控件
        initData();
    }
    protected void initData(){
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id){
                AlertDialog dialog;
                AlertDialog.Builder builder = new AlertDialog.Builder(CarActivity.this)
                        .setMessage("是否删除此记录")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ShopBean notepadBean = list.get(position);
                                if (sqLiteHelper.deleteData(notepadBean.getId())){
                                    list.remove(position);
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(CarActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                dialog = builder.create();
                dialog.show();
                return true;
            }
        });
        sqLiteHelper = new SQLiteHelper(this);
        showQueryData();
    }
    private void showQueryData() {
        if (list != null) {
            list.clear();
        }
        list = sqLiteHelper.query();
        adapter = new CarAdapter(this, list);
        mListView.setAdapter(adapter);
    }
}
