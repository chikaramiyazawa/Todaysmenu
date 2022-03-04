package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class NoodlesDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "NoodlesMenudb.sqlite";
    static final private int VERSION = 1;

    NoodlesDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE NoodlesTable("+" number Integer PRIMARY KEY,menu TEXT)");
    int[] number={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58,
            59, 60, 61, 62,};
    String[] menu={"釜揚げうどん", "ざるうどん", "かけうどん", "きつねうどん", "たぬきうどん", "わかめうどん",
            "月見うどん", "天ぷらうどん", "かき揚げうどん","肉うどん","カレーうどん", "煮込みうどん",
            "焼きうどん", "とろろうどん", "山菜うどん", "力うどん", "おろしうどん", "かき揚げそば",
            "肉そば", "かけそば", "きつねそば", "ざるそば", "たぬきそば", "とろろそば",
            "月見そば", "鳥南蛮そば", "天ぷらそば", "ひやしそうめん", "にゅうめん", "そうめんチャンプルー",
            "にしんそば", "山菜そば", "おろしそば","ラーメン", "チャーシューラーメン", "タンメン", "チャンポンメン",
            "タンタンメン", "焼きそば", "揚げそば", "冷やし中華", "焼きビーフン", "塩ラーメン", "みそラーメン",
            "醤油ラーメン", "にしんそば", "ワンタン麺", "とんこつラーメン", "スパゲッティナポリタン", "スパゲッティミートソース",
            "スパゲッティボンゴレ", "スパゲッティカルボナーラ", "スパゲッティペペロンチーノ", "スパゲッティシーフード",
            "きのこスパゲッティ", "たらこスパゲッティ", "カレー風味", "クリームスパゲッティ", "コンソメスパゲッティ",
            "マカロニグラタン", "ラザーニア", "バジリコスパゲッティ"
    };

        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO NoodlesTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS NoodlesTable");
        onCreate(db);
    }



}
