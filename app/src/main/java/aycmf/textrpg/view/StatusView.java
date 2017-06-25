package aycmf.textrpg.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import aycmf.textrpg.R;
import aycmf.textrpg.TextRPGApplication;
import aycmf.textrpg.model.Character;

public class StatusView extends RelativeLayout {
    private final TextRPGApplication app;
    private final ImageView characterIcon;
    private final TextView characterName;
    private final TextView characterStats;
    private final ImageView equippedItem;

    public StatusView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        app = (TextRPGApplication) context.getApplicationContext();
        inflate(context, R.layout.status_view, this);

        characterIcon = (ImageView) findViewById(R.id.characterIcon);
        characterName = (TextView) findViewById(R.id.characterName);
        characterStats = (TextView) findViewById(R.id.characterStats);
        equippedItem = (ImageView) findViewById(R.id.inventoryIcon);
        /*
        equippedItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */
        updateStatus();
   }

   public void updateStatus() {
       if(app.hasExistingGame()) {
           Character character = app.getModelContainer().getCharacter();
           if (character.getCharacterIconID() == 1) {
               characterIcon.setImageResource(R.drawable.male);
           } else {
               characterIcon.setImageResource(R.drawable.female);
           }
           characterName.setText(character.getName());
           characterStats.setText("Str: " + character.getStrength() + " Dex: " + character.getDexterity() + " Luk: " + character.getLuck() + " Int: " + character.getIntelligence());
           equippedItem.setImageResource(R.drawable.bag);
       } else {
           characterIcon.setImageResource(R.drawable.unknown);
           characterName.setText("");
       }
   }
}