package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DessertDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "DessertMenudb.sqlite";
    static final private int VERSION = 1;

    DessertDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DessertTable("+" number Integer PRIMARY KEY,menu TEXT)");
        int[] number={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80,};
        String[] menu={"ショートケーキ", "チョコレートケーキ", "チーズケーキ", "レアチーズケーキ", "ミルフィーユ",
                "ティラミス", "タルト", "ホットアップルパイ", "ホットポテトパイ", "ロールケーキ", "バウンドケーキ", "メレンゲパイ",
                "マーブルケーキ", "ベジタブルケーキ", "オムレツケーキ", "即席チーズケーキ", "スイートポテト", "クレープ",
                "フリッター", "揚げパスタ", "フルーツパスタ", "フルーツゼリー", "コーヒーゼリー", "ムース", "プリン",
                "プリンアラモード", "かぼちゃプリン", "あんにん豆腐", "マンゴプリン", "野菜ゼリー", "二色ゼリー",
                "ブラマンジェ", "カスタードゼリー", "ライスプディング", "フルーツババロア", "ヨーグルトババロア",
                "ババロア", "寒天のフルーツ寄せ", "コーヒーのグラ二ータ", "タピアカココナッツ", "ブラマンジュ", "パンプディング",
                "野菜入りプディング", "クッキー", "絞りだしクッキー", "ジャムクッキー", "バークッキー", "メレンゲ",
                "ビスケット生地のパイ", "スティックパン", "トリュフチョコレート", "アーモンドのチョコレート", "アイスクリームのいちご添え",
                "抹茶金時", "アイスクリームパフェ", "パフェ", "コンポート","果物の甘煮", "バナナのラム酒煮", "果物のワイン煮",
                "栗の渋皮煮", "りんごのフランぺ", "いちごのレモン漬け", "いちごの洋酒味砂糖漬け", "フルーツミックス缶詰",
                "フルーツのチョコレートソースかけ", "フルーツのヨーグルト", "フルーツミックスクリーム","フルーツシャンパン漬け",
                "果物の石衣", "果物のあめかけ", "フルーツのフレッシュチーズかけ", "フルーツのグラタン", "いちごの生クリームかけ",
                "フルーツポンチ", "ウィンナーコーヒー", "キャラメルラテ", "ミックスジュース", "シェイク", "ミルクセーキ"
        };
        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO DessertTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS DessertTable");
        onCreate(db);
    }



}

