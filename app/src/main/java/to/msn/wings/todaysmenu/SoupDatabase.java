package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SoupDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "SoupMenudb.sqlite";
    static final private int VERSION = 1;

    SoupDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SoupTable("+" number Integer PRIMARY KEY,menu TEXT)");
        int[] number={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53,};

        String[] menu={"落とし卵のみそ汁", "じゃが芋のみそ汁", "大根のみそ汁", "貝のみそ汁", "みそ汁", "きのこのみそ汁",
                "そうみんのみそ汁", "かぼちゃのみそ汁", "魚のみそ汁", "豚汁", "みそ雑煮", "豆乳仕立てのみそ汁", "牛乳仕立てのみそ汁",
                "赤だし汁", "すいとん", "粕汁", "呉汁", "卯の花汁", "さつま汁", "そばがき汁", "ふな汁", "肉を主にしたみそ汁",
                "磯汁", "冷やしみそ汁", "とうもろこしのみそ汁", "のっぺい汁", "白うり汁", "そばのすまし汁", "豆腐のすまし汁",
                "かきたま汁", "きのこのすまし汁", "若竹汁", "貝の塩汁", "魚のすまし汁", "吉野鶏のすまし汁", "とろろ昆布汁",
                "そば米汁", "けんちん汁", "すまし雑煮", "あん餅雑煮", "肝吸い", "沢煮椀", "薄くず汁", "三平汁", "あら汁",
                "野菜のすり流し汁", "もろこしと豆腐のすり流し汁", "すっぽん仕立てのすまし汁", "卵雑煮", "船場汁", "みぞれ汁",
                "醤油味とろろ汁", "魚のすり流し汁"
        };
        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO SoupTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS SoupTable");
        onCreate(db);
    }



}