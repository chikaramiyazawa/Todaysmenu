package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.EditText;

public class RiceDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "MenuRicedb.sqlite";
    static final private int VERSION = 1;

    RiceDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE RiceTable("+" number integer PRIMARY KEY,menu TEXT)");
        int[] number ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42,43, 44, 45, 46, 47, 48,};
        String[] menu={"お茶漬け","雑炊","きなご飯","鮭飯","赤飯","中華ちまき","イカめし","クッパ","リゾット",
                "ゆかりご飯","五穀米","おにぎり(鮭)","おにぎり(おかか)","おにぎり(高菜)","おにぎり(うめ)","おにぎり(ツナマヨネーズ)",
                "おにぎり(ツナオニオン)","おにぎり(鶏五目)","おにぎり(明太子)","おにぎり(たらこ)","おにぎり(塩)","おにぎり(昆布)","焼きおにぎり",
                "あんかけ焼きおにぎり","三色おにぎり","釜めし","豆ご飯","栗ご飯","きのこご飯","たけのこご飯","山菜おこわ","あさりご飯","ゆば茶漬け",
                "カレーライス","カツカレー","野菜カレー","ハヤシカレー","ドライカレー","バターライス","チャーハン","コーンピラフ","チキンピラフ",
                "エビピラフ","オムライス","チキンライス","チキンドリア","パエリア","ビビンバ"};

      db.beginTransaction();
      try {
          SQLiteStatement sql = db.compileStatement(
                  "INSERT INTO RiceTable(number,menu) VALUES(?,?)");
          for (int i = 0; i < number.length; i++) {
              sql.bindString(1, String.valueOf(i));
              sql.bindString(2, menu[i]);
              sql.executeInsert();
          }
          db.setTransactionSuccessful();
      }catch(SQLException e){
          e.printStackTrace();
      }finally {
          db.endTransaction();
      }






    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS RiceTable");
        onCreate(db);
    }


}
