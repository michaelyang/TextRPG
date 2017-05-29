package aycmf.textrpg.view;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import aycmf.textrpg.R;
import aycmf.textrpg.TextRPGApplication;
import aycmf.textrpg.activity.AchievementActivity;
import aycmf.textrpg.activity.StartScreenActivity;
import aycmf.textrpg.fragment.InventoryFragment;
import aycmf.textrpg.model.Character;

/**
 * TODO: document your custom view class.
 */
public class StatusView extends RelativeLayout {
    private final TextRPGApplication app;
    private final ImageView characterIcon;
    private final TextView characterName;
    private final TextView characterStats;
    private final ImageButton inventoryIcon;

    public StatusView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        app = (TextRPGApplication) context.getApplicationContext();
        app.load();
        inflate(context, R.layout.status_view, this);

        characterIcon = (ImageView) findViewById(R.id.characterIcon);
        characterName = (TextView) findViewById(R.id.characterName);
        characterStats = (TextView) findViewById(R.id.characterStats);
        inventoryIcon = (ImageButton) findViewById(R.id.inventoryIcon);
        inventoryIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        updateStatus();
   }

   public void updateStatus() {
       if(app.hasExistingGame() && app.isInitialized()) {
           Character character = app.getModelContainer().getCharacter();
           if (character.getCharacterIconID() == 1) {
               characterIcon.setImageResource(R.drawable.male);
           } else {
               characterIcon.setImageResource(R.drawable.female);
           }
           characterName.setText(character.getName());
           //characterStats.setText("Str: " + character.getStrength() + " Dex: " + character.getDexterity() + " Luk: " + character.getLuck() + " Int: " + character.getIntelligence());
           inventoryIcon.setImageResource(R.drawable.bag);
       } else {
           characterIcon.setImageResource(R.drawable.unknown);
           characterName.setText("");
       }
   }
}