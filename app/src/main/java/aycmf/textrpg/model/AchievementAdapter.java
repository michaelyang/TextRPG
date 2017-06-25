package aycmf.textrpg.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import aycmf.textrpg.R;

/**
 * Created by Michael on 5/19/2017.
 */

public class AchievementAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<Achievement> achievements;

    public AchievementAdapter(Context context, ArrayList<Achievement> achievements) {
        this.context = context;
        this.achievements = achievements;
    }

    @Override
    public int getCount() {
        return achievements.size();
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Achievement achievement = achievements.get(position);
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.achievement, null);
        }
        final TextView achievementName = (TextView) convertView.findViewById(R.id.achievementName);
        final ImageView achievementIcon = (ImageView) convertView.findViewById(R.id.achievementIcon);

        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(achievement.iconId,"drawable",context.getPackageName());

        achievementName.setText(achievement.getName());
        achievementIcon.setImageResource(resourceId);
        //AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        //dialogBuilder.setTitle("Test Title");
        //dialogBuilder.setMessage(achievement.description);
        //dialogBuilder.show();

        return convertView;

    }
}
