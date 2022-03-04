package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class FishDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "FishMenudb.sqlite";
    static final private int VERSION = 1;

    FishDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE FishTable("+" number Integer PRIMARY KEY,menu TEXT)");
    int[] number={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
            61, 62, 63,
    };

    String[] menu={"かつおのたたき", "しめさば", "刺身(まぐろ)", "刺身(白身魚)", "刺身(いか)", "刺身(たこ)",
            "刺身(はまち)", "刺身(甘えび)", "魚のカルパッチョ", "魚の塩焼き", "魚の照り焼き", "魚のみそ漬け焼き",
            "魚のムニエル", "白身魚のホイル焼き", "うなぎのかば焼き", "いかしょうゆ焼き", "サザエのつぼ焼き",
            "ホタテ貝バター焼き", "山椒焼き", "南蛮焼き", "鮭のホイル焼き", "カニグラタン", "タラのチーズ焼き",
            "魚の唐揚げ", "いわしのしそ揚げ", "魚の南蛮漬け", "魚のマリネ", "魚と野菜の天ぷら", "天ぷら(エビ)",
            "天ぷら(白身魚)", "天ぷら(ちくわ)", "白身魚のフライ", "いかリングフライ", "エビフライ",
            "ホタテフライ", "カキフライ", "まぐろカツ", "カニクリームコロッケ", "八宝菜", "えびケチャップ炒め(エビチリ)",
            "えびとカシューナッツの炒めもの", "揚げ魚の甘酢あんかけ", "煮魚", "はもんじょ", "魚のみそ煮",
            "いわしの梅肉煮", "いわしのつみれ煮", "あさりの酒蒸し", "いわしの生姜煮", "いわしの揚げ煮",
            "かきの土手鍋", "野菜と小魚の煮物", "寄せ鍋", "ブリ大根", "魚の角煮", "かにすき", "なすと魚の煮物",
            "いかの煮つけ", "大根と魚の煮つけ", "かまぼこの煮物", "いいだこの煮つけ", "味付かずのこ",
            "小魚の佃煮"
    };
        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO FishTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS FishTable");
        onCreate(db);
    }



}
