package aycmf.textrpg.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import aycmf.textrpg.R;
import aycmf.textrpg.TextRPGApplication;

public class StartScreenActivity extends AppCompatActivity {
    private Button startscreen_continue;
    private Button startscreen_newgame;
    private Button startscreen_achievements;
    private Button startscreen_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Resources res = getResources();
        setContentView(R.layout.activity_start_screen);

        startscreen_continue = (Button) findViewById(R.id.startscreen_continue);
        startscreen_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueGame();
            }
        });

        startscreen_newgame = (Button) findViewById(R.id.startscreen_newgame);
        startscreen_newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
            }
        });

        startscreen_achievements = (Button) findViewById(R.id.startscreen_achievements);
        startscreen_achievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearGame();
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        //startscreen_settings = (Button) findViewById(R.id.startscreen_settings);
        setButtonState();
    }

    public void continueGame(){
        final TextRPGApplication app = (TextRPGApplication) getApplicationContext();
        app.load();
        Toast.makeText(StartScreenActivity.this,app.getModelContainer().getCharacter().getName(),Toast.LENGTH_LONG).show();
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
        //dialogBuilder.setMessage("TESTING");
        dialogBuilder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                app.initializeGame(characterName.getText().toString());
                app.save();
                //below function call is only for testing purposes. Won't be needed once the GameActivity is implemented
                setButtonState();
                //continueGame(true, characterName.getText().toString());
                //setButtonState(null, null);
            }
        });
        dialogBuilder.setNegativeButton(android.R.string.cancel, null);
        AlertDialog alert = dialogBuilder.create();
        alert.show();

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
