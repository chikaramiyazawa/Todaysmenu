package to.msn.wings.todaysmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.view.ViewGroup;
import android.widget.ScrollView;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int matchParent = ViewGroup.LayoutParams.MATCH_PARENT;
        int wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT;

        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ScrollView.LayoutParams(
                matchParent, wrapContent));
    }


    public void rice_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.Rice.class);

        startActivity(i);
    }

    public void donssushi_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.DonSushi.class);

        startActivity(i);
    }

    public void bread_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.Bread.class);

        startActivity(i);
    }

    public void noodles_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.Noodles.class);

        startActivity(i);
    }

    public void meat_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.Meat.class);

        startActivity(i);
    }

    public void fish_onClick(View view){
        Intent i =new Intent(this,to.msn.wings.todaysmenu.Fish.class);

        startActivity(i);
    }

    public void egg_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.Egg.class);

        startActivity(i);
    }

    public void tofu_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.Tofu.class);

        startActivity(i);
    }

    public void vegetable_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.Vegetable.class);

        startActivity(i);
    }

    public void salad_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.Salad.class);

        startActivity(i);
    }

    public void aemono_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.Aemono.class);
        startActivity(i);
    }

    public void soup_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.Soup.class);
        startActivity(i);
    }

    public void westernchinese_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.WesternChinese.class);
        startActivity(i);
    }

    public void japanesesweets_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.JapaneseSweets.class);
        startActivity(i);
    }

    public void dessert_onClick(View view){
        Intent i = new Intent(this,to.msn.wings.todaysmenu.Dessert.class);
        startActivity(i);
    }




}