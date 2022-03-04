package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class JapaneseSweetsDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "JapaneseSweetsMenudb.sqlite";
    static final private int VERSION = 1;

    JapaneseSweetsDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE JapaneseSweetsTable ("+" number Integer PRIMARY KEY,menu TEXT)");
        int[] number={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27,};

        String[] menu={"おはぎ", "芋もち", "くず餅", "わらびもち", "ごま団子", "たい焼き", "みつ豆",
                "牛乳かん", "ぜんざい", "大学芋", "くず桜", "いきなり団子", "かけ餅", "磯辺餅",
                "きんとん", "茶巾絞り", "果汁かん", "サイダーかん", "抹茶かん", "白玉だんごのシロップかけ",
                "椿餅", "芋餅", "小倉水玉", "豆板", "梅花かん", "野菜菓かん", "里芋のしるこ風"
        };
        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO JapaneseSweetsTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS JapaneseSweetsTable");
        onCreate(db);
    }



}
