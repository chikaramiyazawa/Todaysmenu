package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class WesternChineseDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "W.C.Menudb.sqlite";
    static final private int VERSION = 1;

    WesternChineseDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE WesternChineseTable("+" number Integer PRIMARY KEY,menu TEXT)");
       int[] number={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
               21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};

       String[] menu={"コンソメスープ", "ポテトポタージュ", "コーンポタージュ", "かぼちゃポタージュ", "グリンピースのポタージュ",
               "チーズ入り卵スープ", "チャウダー", "カレースープ", "わかめスープ", "ミネストローネ", "オニオンスープ", "牛乳スープ",
               "泡立て卵白スープ", "ガスパッチョ", "クネルスープ", "ビスク", "ブイヤベース", "ポタージュスープ", "ボルシチ",
               "オニオングラタンスープ", "コールドポタージュスープ", "とうもろこしのスープ", "ピューレクリームスープ", "ポタージュピューレスープ",
               "中華風スープ", "ワンタンスープ", "中華風団子スープ", "とうがんの五目スープ", "とろみスープ", "ふかひれスープ",
               "干し貝柱との炒めスープ", "中華風とうもろこしのスープ", "中華風牛乳入りスープ", "中華風即席スープ", "中華風卵スープ",
               "ナイ湯"};
        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO WesternChineseTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS WesternChineseTable");
        onCreate(db);
    }



}
