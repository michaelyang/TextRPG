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

public class AchievementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        String [] a = {
                "a","b","c","d","e"
        };

        ArrayAdapter<String> aAdapter = new ArrayAdapter<String>(this,R.layout.achievement,R.id.achievementName,a);
        GridView achievementGrid = new GridView(this);
        achievementGrid.setNumColumns(3);
        achievementGrid.setVerticalSpacing(50);
        achievementGrid.setHorizontalSpacing(30);
        achievementGrid.setAdapter(aAdapter);

        LinearLayout achievementView = (LinearLayout) findViewById(R.id.achievementView);
        achievementGrid.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        achievementView.addView(achievementGrid);

    }

}
