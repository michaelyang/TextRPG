package aycmf.textrpg.activity;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import aycmf.textrpg.R;
import aycmf.textrpg.model.ModelContainer;

public class StartScreenActivity extends AppCompatActivity {
    private boolean hasExistingGame = false;
    private ModelContainer modelContainer;
    private Button startscreen_continue;
    private Button startscreen_newgame;
    private Button startscreen_achivements;
    private Button startscreen_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Resources res = getResources();
        setContentView(R.layout.activity_start_screen);
        modelContainer = ModelContainer.load(this);

        startscreen_continue = (Button) findViewById(R.id.startscreen_continue);
        startscreen_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueGame();
            }
        });

        if (modelContainer == null) {
            startscreen_continue.setEnabled(false);
        }

        startscreen_newgame = (Button) findViewById(R.id.startscreen_newgame);
        startscreen_newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AppCompatEditText characterName = new AppCompatEditText(StartScreenActivity.this);
                new AlertDialog.Builder(StartScreenActivity.this)
                        .setTitle("Test")
                        .setMessage(R.string.startscreen_entercharactername)
                        .setView(characterName)
                        .setIcon(android.R.drawable.ic_input_add)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                modelContainer = new ModelContainer();
                                modelContainer.initializeGame(characterName.getText().toString());
                                modelContainer.save(StartScreenActivity.this);
                                //continueGame(true, characterName.getText().toString());
                                //setButtonState(null, null);
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, null)
                        .create().show();
            }
        });

        startscreen_achivements = (Button) findViewById(R.id.startscreen_achievements);
        startscreen_settings = (Button) findViewById(R.id.startscreen_settings);

        /*
        if (modelContainer == null) {
            final AppCompatEditText characterName = new AppCompatEditText(this);
            new AlertDialog.Builder(this)
                    .setTitle("Test")
                    .setMessage(R.string.startscreen_entercharactername)
                    .setView(characterName)
                    .setIcon(android.R.drawable.ic_input_add)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            modelContainer = new ModelContainer();
                            modelContainer.initializeGame(characterName.getText().toString());
                            modelContainer.save(StartScreenActivity.this);
                            //continueGame(true, characterName.getText().toString());
                            //setButtonState(null, null);
                        }
                    })
                    .setNegativeButton(android.R.string.cancel, null)
                    .create().show();
        } else {
            Toast.makeText(this, "Successfully Loaded for "+ modelContainer.getCharacter().getName(), Toast.LENGTH_SHORT).show();
        }
        */
    }
    public void continueGame(){

    }
}
