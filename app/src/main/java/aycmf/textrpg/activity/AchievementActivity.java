package aycmf.textrpg.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;

import aycmf.textrpg.R;
import aycmf.textrpg.model.Achievement;
import aycmf.textrpg.model.AchievementAdapter;

public class AchievementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        Achievement a = new Achievement("a",1);
        Achievement b = new Achievement("b",2);
        Achievement c = new Achievement("c",3);
        Achievement d = new Achievement("d",4);
        Achievement e = new Achievement("e",5);

        Achievement[] list = {
                a,b,c,d,e
        };

        //ArrayAdapter<String> aAdapter = new ArrayAdapter<String>(this,R.layout.achievement,R.id.achievementName,a);
        GridView achievementGrid = (GridView) findViewById(R.id.achievementGridView);
        //achievementGrid.setNumColumns(3);
        //achievementGrid.setVerticalSpacing(50);
        //achievementGrid.setHorizontalSpacing(30);
        //achievementGrid.setAdapter(aAdapter);
        AchievementAdapter achievementAdapter = new AchievementAdapter(this, list);
        achievementGrid.setAdapter(achievementAdapter);
    }

}
