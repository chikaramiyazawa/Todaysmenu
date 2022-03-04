package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class BreadDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "BreadMenudb.sqlite";
    static final private int VERSION = 1;

    BreadDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE BreadTable("+" number Integer PRIMARY KEY,menu TEXT)");
       int[] number={1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
               11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
               21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
               31, 32, 33, 34, 35, 36, 37, 38
       };
       String[] menu={"トースト", "フレンチトースト", "ピザトースト", "ピロシキ", "焼きそばパン","コロッケパン", "ガーリックトースト",
               "ハンバーガー", "チーズバーガー", "ダブルバーガー", "チキンバーガー", "照り焼きチキンバーガー", "カツバーガー",
               "フィッシュバーガー", "卵ベーコンバーガー", "ライスバーガー", "ホットドック", "照り焼きバーガー", "カツサンド",
               "ミックスサンド", "サンドウィッチ", "トーストサンド", "フルーツサンド", "バケットサンド", "ロールパンサンド",
               "ロールサンドウィッチ","エビカツサンド", "ベーグル", "カレーパン","蒸しパン", "ウインナーロール", "ミックスピザ",
               "肉まん", "カレーまん", "ピザまん", "お好み焼き", "もんじゃ焼き", "たこ焼き"};

        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO BreadTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS BreadTable");
        onCreate(db);
    }



}