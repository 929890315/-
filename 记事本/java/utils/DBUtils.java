package com.example.administrator.myapplication.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBUtils {
    public static final String DATABASE_NAME="Notepad";//数据库名
    public static final String DATABASE_TEBLE="Note";//表名
    public static final int DATABASE_VARION=1;
    //数据库表中的列名
    public static final String NOTEPAD_ID="id";
    public static final String NOTEPAD_CONTENT="content";
    public static final String NOTEPAD_TIME="notetime";
    //获取当前日期
    public static final String getTime(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyy年MM月dd日HH:mm:ss");
        Date date =new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
}
