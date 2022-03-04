package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class VegetableDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "VegetableMenudb.sqlite";
    static final private int VERSION = 1;

    VegetableDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE VegeTable("+" number Integer PRIMARY KEY,menu TEXT)");
        int[] number={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53,
        };

        String[] menu={"野菜ソテー", "青菜のソテー", "もやし炒め", "にんにくの茎炒め", "マーボ春雨",
                "マーボなす", "ゴーヤチャンプル", "いんげんのソテー", "きのこ炒め", "きんぴらごぼう",
                "青菜グラタンチーズ", "かぼちゃチーズ焼き", "ひじきの炒め煮", "かぶのクリーム煮",
                "ほうれん草のチーズグラタン", "野菜とじゃこの煮物", "串カツ(シシトウ)", "串カツ(玉ねぎ)",
                "串カツ(椎茸)", "かぼちゃコロッケ", "野菜コロッケ", "天ぷら(かぼちゃ)", "天ぷら(さつまいも)",
                "天ぷら(れんこん)", "天ぷら(青しそ)", "かき揚げ", "野菜の天ぷら", "ジャーマンポテト",
                "じゃが芋バター焼き", "じゃが芋コンビーフ炒め", "じゃが芋と生揚げの煮物", "肉じゃが",
                "きぬかずき", "里芋の煮物", "大根の煮物", "里芋田楽", "粉ふき芋", "さつま芋バター煮",
                "こんにゃく炒め煮", "じゃが芋の牛乳焼き", "おでん", "刺身こんにゃく", "おでん",
                "ふろふき大根", "かぼちゃの煮物", "れんこんの煮物", "切り干し大根の煮物", "山菜の吹き合わせ",
                "白菜の牛乳煮", "切り昆布の煮物", "茎わかめの炒め煮", "若竹煮", "きゃらぶき"
        };
        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO VegeTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS VegetableTable");
        onCreate(db);
    }



}
