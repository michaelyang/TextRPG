package aycmf.textrpg.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import aycmf.textrpg.R;
import aycmf.textrpg.TextRPGApplication;
import aycmf.textrpg.model.Character;

public class StoryView extends RelativeLayout {
    private final TextRPGApplication app;
    private final TextView story;

    public StoryView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        app = (TextRPGApplication) context.getApplicationContext();
        inflate(context, R.layout.story_view, this);

        //characterIcon = (ImageView) findViewById(R.id.characterIcon);
        story = (TextView) findViewById(R.id.story);
        /*
        equippedItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */
    }

}