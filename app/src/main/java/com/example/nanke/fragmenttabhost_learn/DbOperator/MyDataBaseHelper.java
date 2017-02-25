package com.example.nanke.fragmenttabhost_learn.DbOperator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

/**
 * Created by zt on 2017/2/25.
 */

public class MyDataBaseHelper extends SQLiteOpenHelper {

    private Context mContext;

    private static final String CREATE_DATA = "create table Sdata ("
            + "id integer primary key autoincrement, "
            + "desc text, "//标题
            + "url text, "//文章链接地址
            + "storge_time text,"//收藏时间
            + "createdAt text, " //文章发表时间
            + "type text)";//文章所属类型

    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATA);
        Toasty.success(mContext, "数据库创建成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists Sdata");
        onCreate(db);
    }
}
