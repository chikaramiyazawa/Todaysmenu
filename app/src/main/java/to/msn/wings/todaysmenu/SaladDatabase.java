package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SaladDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "SaladMenudb.sqlite";
    static final private int VERSION = 1;

    SaladDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SaladTable("+" number Integer PRIMARY KEY,menu TEXT)");
     int[] number={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
             21, 22, 23, 24, 25, 26, 27, 28, 29, 30,};

     String[] menu={"ミモザサラダ", "野菜サラダ", "ツナサラダ", "青菜と貝のゴママヨネーズ", "マカロニサラダ",
             "ポテトサラダ", "ヨーグルトサラダ", "豆のサラダ", "春雨サラダ", "ごぼうのサラダ", "海藻サラダ",
             "シーフードサラダ", "キャベツのサラダ", "大根のサラダ", "豆腐のサラダ", "豆腐ドレッシングサラダ",
             "ほうれん草サラダ", "冷しゃぶサラダ", "フルーツサラダ", "和風ドレッシングサラダ", "チーズサラダ",
             "スパゲティサラダ", "生ゆばとれんこんのサラダ", "コールスロー", "かぼちゃのマヨネーズサラダ",
             "シーザーサラダ", "スライスオニオン", "大根おろし", "もろきゅう", "人参グラッセ"};

        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO SaladTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS SaladTable");
        onCreate(db);
    }



}