package aycmf.textrpg.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import aycmf.textrpg.R;
import aycmf.textrpg.TextRPGApplication;
import aycmf.textrpg.view.StatusView;

public class StartScreenActivity extends AppCompatActivity {
    private Button startscreen_continue;
    private Button startscreen_newgame;
    private Button startscreen_achievements;
    private Button startscreen_settings;
    private Button startscreen_about;
    private StatusView statusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Resources res = getResources();
        setContentView(R.layout.activity_start_screen);
        statusView = (StatusView) findViewById(R.id.statusView);

        Typeface munro = Typeface.createFromAsset(getAssets(),"munro.ttf");
        startscreen_continue = (Button) findViewById(R.id.startscreen_continue);
        startscreen_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueGame();
            }
        });
        startscreen_continue.setTypeface(munro);

        startscreen_newgame = (Button) findViewById(R.id.startscreen_newgame);
        startscreen_newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
            }
        });
        startscreen_newgame.setTypeface(munro);

        startscreen_achievements = (Button) findViewById(R.id.startscreen_achievements);
        startscreen_achievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartScreenActivity.this, AchievementActivity.class);
                startActivity(i);
                                /*
                clearGame();
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);*/
            }
        });
        startscreen_achievements.setTypeface(munro);

        startscreen_about = (Button) findViewById(R.id.startscreen_about);
        startscreen_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartScreenActivity.this, AboutActivity.class);
                startActivity(i);
            }
        });

        startscreen_about.setTypeface(munro);
        //startscreen_settings = (Button) findViewById(R.id.startscreen_settings);

        setButtonState();
    }

    public void continueGame(){
        final TextRPGApplication app = (TextRPGApplication) getApplicationContext();
        app.load();
        Toast.makeText(StartScreenActivity.this,app.getModelContainer().getCharacter().getName()+app.getModelContainer().getCharacter().getCharacterIconID(),Toast.LENGTH_LONG).show();
    }

    public void newGame(){
        final TextRPGApplication app = (TextRPGApplication) getApplicationContext();
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);//StartScreenActivity.this
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.character_creation_dialog, null);
        final AppCompatEditText characterName = (AppCompatEditText) dialogView.findViewById(R.id.characterName);
        final RadioGroup characterIcon = (RadioGroup) dialogView.findViewById(R.id.characterIcon);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setTitle("Character Creation");
        dialogBuilder.setPositiveButton(android.R.string.ok, null);
        /*
        dialogBuilder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*
                int characterIconID = 1;
                int button = characterIcon.getCheckedRadioButtonId();
                switch (button) {
                    case R.id.male:
                        characterIconID = 1;
                        break;
                    case R.id.female:
                        characterIconID = 2;
                        break;
                }
                Toast.makeText(StartScreenActivity.this,characterIconID+"",Toast.LENGTH_LONG).show();
                app.initializeGame(characterName.getText().toString(), characterIconID);
                app.save();
                //below function call is only for testing purposes. Won't be needed once the GameActivity is implemented
                setButtonState();
                statusView.updateStatus();

                //continueGame(true, characterName.getText().toString());
                //setButtonState(null, null);
            }
        });*/
        dialogBuilder.setNegativeButton(android.R.string.cancel, null);
        final AlertDialog alert = dialogBuilder.create();
        alert.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Button positiveButton = alert.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (characterIcon.getCheckedRadioButtonId() == -1) {
                            ((TextView) findViewById(R.id.characterIconLabel)).requestFocus();
                            //((TextView) findViewById(R.id.characterIconLabel)).setError("Character icon is required.");
                        } else if (characterName.getText().toString().trim().length() == 0) {
                            characterName.setError("Character name is required.");
                        } else {
                            alert.dismiss();
                        }
                    }
                });
            }
        });
        alert.show();
        //alert.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);

        /*
        new AlertDialog.Builder(StartScreenActivity.this)
                .setTitle("Character Name")
                .setMessage(R.string.startscreen_entercharactername)
                .setView(characterName)
                .setIcon(android.R.drawable.ic_input_add)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        app.initializeGame(characterName.getText().toString());
                        app.save();
                        //continueGame(true, characterName.getText().toString());
                        //setButtonState(null, null);
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .create().show();
                */
    }

    public void clearGame(){
        final TextRPGApplication app = (TextRPGApplication) getApplicationContext();
        app.clear();
    }

    private void setButtonState() {
        final TextRPGApplication app = (TextRPGApplication) getApplicationContext();
        startscreen_continue.setEnabled(app.hasExistingGame());
        startscreen_newgame.setEnabled(true);
    }
}
