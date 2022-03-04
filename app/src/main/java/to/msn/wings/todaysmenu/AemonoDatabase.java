package to.msn.wings.todaysmenu;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class AemonoDatabase extends SQLiteOpenHelper{
    static final private String DBNAME = "AemonoMenudb.sqlite";
    static final private int VERSION = 1;

    AemonoDatabase(Context context){
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE AemonoTable("+" number Integer PRIMARY KEY,menu TEXT)");
        int[] number={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
        };

        String[] menu={"きゅうりの酢の物", "紅白なます", "キャベツの酢の物", "鶏肉のおろし和え", "春雨の酢の物", "ずいきごま酢和え",
                "たたきごぼう", "三杯酢漬", "野菜の黄身酢かけ", "ピーナッツ酢和え", "わけぎと貝のぬた", "なまこの酢の物", "みどり酢和え",
                "酢れんこん", "もずく酢", "ところてん", "わかめの酢の物", "青菜の白和え", "青菜のゴマ和え", "大根の明太子", "青菜のおひたし",
                "白菜のおひたし", "山芋のり醤油和え", "野菜の海苔巻き", "野菜ののり巻き", "たけのこ木の芽和え", "焼きなす", "蒸しなすのナムル",
                "たたききゅうり", "オクラのからし醤油和え", "人参のピーナッツ和え", "野菜のホワイトソース和え"
        };
        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO AemonoTable(number,menu) VALUES(?,?)");
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
        db.execSQL("DROP TABLE IF EXISTS AemonoTable");
        onCreate(db);
    }



}