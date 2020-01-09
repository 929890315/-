package com.example.administrator.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrator.myapplication.bean.ShopBean;
import com.example.administrator.myapplication.utils.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;
    public SQLiteHelper(Context context){
        super(context,DBUtils.DATABASE_NAME, null, DBUtils.DATABASE_VERION);
        sqLiteDatabase = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + DBUtils.DATABASE_TABLE  + "(" + DBUtils.SHOP_ID +
                " integer primary key autoincrement, " + DBUtils.SHOP_TITLE +
                " text," + DBUtils.SHOP_PRICE + " text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}

    public boolean insertData(String shopTitle,String shopPrice){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBUtils.SHOP_TITLE,shopTitle);
        contentValues.put(DBUtils.SHOP_PRICE,shopPrice);
        return
                sqLiteDatabase.insert(DBUtils.DATABASE_TABLE, null, contentValues)>0;
    }
    public boolean deleteData(String id) {
        String sql = DBUtils.SHOP_ID+"=?";
        String[] contentValuesArray = new String[]{String.valueOf(id)};
        return
                sqLiteDatabase.delete(DBUtils.DATABASE_TABLE, sql, contentValuesArray)>0;
    }
    public List<ShopBean> query(){
        List<ShopBean> list = new ArrayList<ShopBean>();
        Cursor cursor = sqLiteDatabase.query(DBUtils.DATABASE_TABLE, null, null, null, null, null,
                DBUtils.SHOP_ID + " desc");
        if (cursor != null) {
            while (cursor.moveToNext()){
                ShopBean shopInfo = new ShopBean();
                String id = String.valueOf(cursor.getInt(cursor.getColumnIndex(DBUtils.SHOP_ID)));
                String title = cursor.getString(cursor.getColumnIndex(DBUtils.SHOP_TITLE));
                String price = cursor.getString(cursor.getColumnIndex(DBUtils.SHOP_PRICE));
                shopInfo.setId(id);
                shopInfo.setShopTitle(title);
                shopInfo.setShopPrice(price);
                list.add(shopInfo);
            }
            cursor.close();
        }
        return  list;
    }

}
