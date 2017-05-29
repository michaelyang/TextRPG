package aycmf.textrpg.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import aycmf.textrpg.R;
import aycmf.textrpg.model.Achievement;
import aycmf.textrpg.model.AchievementAdapter;

public class AchievementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        ArrayList<Achievement> achievements = new ArrayList<>();

        try {
            JSONArray achievementArray = new JSONArray(loadJSON());
            for (int i = 0; i < achievementArray.length(); i++) {
                JSONObject achievement = achievementArray.getJSONObject(i);
                achievements.add(new Achievement(achievement.getInt("id"), achievement.getString("name"), achievement.getString("iconId"), achievement.getString("description")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GridView achievementGrid = (GridView) findViewById(R.id.achievementGridView);
        AchievementAdapter achievementAdapter = new AchievementAdapter(this, achievements);
        achievementGrid.setAdapter(achievementAdapter);
    }

    public String loadJSON() {
        String json = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.achievements);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
