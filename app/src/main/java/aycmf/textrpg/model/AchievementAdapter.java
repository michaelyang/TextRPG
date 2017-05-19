package aycmf.textrpg.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import aycmf.textrpg.R;

/**
 * Created by Michael on 5/19/2017.
 */

public class AchievementAdapter extends BaseAdapter{
    private final Context context;
    private final Achievement[] achievementList;

    public AchievementAdapter(Context context, Achievement[] achievementList) {
        this.context = context;
        this.achievementList = achievementList;
    }
    @Override
    public int getCount() {
        return achievementList.length;
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
        // 1
        final Achievement achievement = achievementList[position];
        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.achievement, null);
        }

        // 3
        final TextView achievementName = (TextView) convertView.findViewById(R.id.achievementName);

        achievementName.setText(achievement.getName());

        return convertView;
    }
}
