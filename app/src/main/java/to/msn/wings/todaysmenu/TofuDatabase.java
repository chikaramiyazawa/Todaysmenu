package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class TofuDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "TofuMenudb.sqlite";
    static final private int VERSION = 1;

    TofuDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TofuTable("+" number Integer PRIMARY KEY,menu TEXT)");
       int[] number= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
       String[] menu={"マーボ豆腐", "豆腐ステーキ", "豆腐ハンバーグ", "豆腐のグラタン", "豆腐のチーズフライ", "豆腐のあんかけ",
               "豆腐の田楽", "ぎせい豆腐", "豆腐のつくね揚げ", "湯豆腐", "高野豆腐肉詰め煮", "ビーンシチュー", "冷や奴",
               "豆乳鍋", "炒り豆腐", "生揚げと大根煮物", "うの花炒り", "福袋", "揚げだし豆腐", "がんもどきの煮物",
               "高野豆腐の煮物", "煮豆", "五目豆", "そら豆の煮物", "納豆", "鶏ひき肉", "生ゆばにチーズ巻き", "チーズの包み揚げ"
       };

        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO TofuTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS TofuTable");
        onCreate(db);

    }



}
