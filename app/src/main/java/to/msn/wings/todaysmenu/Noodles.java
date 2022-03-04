package to.msn.wings.todaysmenu;


import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;


public class Noodles extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_noodles);


        NoodlesDatabase dbHelper = new NoodlesDatabase(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT menu" + " FROM NoodlesTable  ORDER BY RANDOM() LIMIT 1";

        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();

        String Choice = c.getString(c.getColumnIndex("menu"));

        ((EditText) findViewById(R.id.Noodlesmenu)).setText(Choice);


    }
}