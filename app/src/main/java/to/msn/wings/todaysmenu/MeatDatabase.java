package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class MeatDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "MeatMenudb.sqlite";
    static final private int VERSION = 1;

    MeatDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MeatTable("+" number Integer PRIMARY KEY,menu TEXT)");
       int[] number={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
               21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
               40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58,
               59, 60, 61, 62, 63, 64, 65, 66, 67, 68,

       };

       String[] menu={"ビーフステーキ", "ローストビーフ", "牛肉のたたき", "ハンバーグ", "ミートローフ", "ピーマン肉詰め焼き",
               "焼肉", "肉の味噌漬け焼き", "肉の塩焼き", "ハンバーグの和風ソース添え", "焼き餃子", "ポークソテー", "豚肉の生姜焼き",
               "ハムステーキ", "アスパラベーコン", "ローストベーコン", "チキンソテー", "鶏の照り焼き", "焼き鳥", "チキングラタン",
               "鶏肉のピカタ", "焼き豚とキャベツ千切り", "フランクフルト", "ビーフカツ", "トンカツ", "野菜ロールカツ", "串カツ",
               "鶏肉のから揚げ", "鶏肉チーズフライ", "チキンカツ","チキンマリネ", "ささみフライ", "れんこんのはさみ揚げ",
               "メンチカツ", "ミートボール", "ポテトコロッケ", "ミートボール", "春巻き", "竜田揚げ", "レバーケチャップ炒め",
               "ウインナーソテー", "酢豚", "豚キムチ", "ウスターソース", "甘辛炒め", "牛肉とピーマンの千切り炒め", "肉と野菜の炒め物",
               "ひき肉となすの炒め物", "レバーと野菜の炒め物", "肉の野菜巻き","ロールキャベツ", "ビーフシチュー", "クリームシチュー",
               "豚の角煮", "蒸しシューマイ", "すき焼き", "しゃぶしゃぶ", "鶏肉の水吹き", "キムチ鍋", "鶏肉のトマト",
               "肉だんご鍋", "はりはり鍋", "肉と野菜の煮物", "バンバンジー", "鶏レバーの生姜焼き", "鶏肉のそぼろ煮", "蒸し鶏",
               "筑前煮"
       };

        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO MeatTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS MeatTable");
        onCreate(db);
    }



}
