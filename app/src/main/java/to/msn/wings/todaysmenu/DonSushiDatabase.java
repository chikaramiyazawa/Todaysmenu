package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import android.database.SQLException;

public class DonSushiDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "DonSushiMenudb.sqlite";
    static final private int VERSION = 1;

    DonSushiDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DonSushiTable(" + " number Integer PRIMARY KEY,menu TEXT)");
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49};

        String[] menu = {"うな丼", "親子丼", "他人丼", "卵丼", "かつ丼", "えび天丼", "かき揚げ丼", "牛丼", "三色丼",
                "マグロ丼", "いくら丼", "うに丼", "中華丼", "かにたま丼", "マーボ丼", "あなご丼", "山かけ丼", "そぼろ丼",
                "にぎり寿司(盛り合わせ)", "にぎり寿司(まぐろ)", "にぎり寿司(はまち)", "にぎり寿司(いか)", "にぎり寿司(たこ)",
                "にぎり寿司(えび)", "にぎり寿司(うなぎ)", "にぎり寿司(あなご)", "にぎり寿司(ホタテ)", "にぎり寿司(赤貝)",
                "にぎり寿司(かずのこ)", "にぎり寿司(さば)", "にぎり寿司(たまご焼き)", "にぎり寿司(うに)", "にぎり寿司(甘えび)",
                "にぎり寿司(マヨコーン)", "にぎり寿司(なす漬物)", "にぎり寿司(サーモン)", "にぎり寿司(ローストビーフ)",
                "にぎり寿司(あじ)", "にぎり寿司(あわび)", "バッテラ", "姿ずし", "手巻きずし", "まき寿司", "鉄火巻き",
                "サラダ巻き", "納豆巻き", "五目ずし", "いなり寿司", "ちらし寿司"};


        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO DonSushiTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS DonSushiTable");
        onCreate(db);
    }



}
