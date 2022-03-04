package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class EggDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "EggMenudb.sqlite";
    static final private int VERSION = 1;

    EggDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE EggTable("+" number Integer PRIMARY KEY,menu TEXT)");
        int[] number ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
        };

        String[] menu ={"卵焼き", "う巻き卵", "貝入り卵焼き", "目玉焼き", "ハムエッグ", "ココット", "オムレツ", "スクランブルエッグ",
                "かにたま", "スコッチエッグ", "だし巻き卵", "炒り卵", "中華風炒め卵", "茶碗蒸し", "小田巻き蒸し", "豆腐と卵の炒め物",
                "にらたま", "野菜の卵とじ", "炒め卵のあんかけ", "いわしの川柳風味", "卵豆腐", "温泉卵", "洋風茶碗蒸し"
        };

        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO EggTable(number,menu) VALUES(?,?)");
            for (int i = 0; i < number.length; i++) {
                sql.bindString(1, String.valueOf(i));
                sql.bindString(2, menu[i]);
                sql.executeInsert();
            }
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS EggTable");
        onCreate(db);
    }



}
