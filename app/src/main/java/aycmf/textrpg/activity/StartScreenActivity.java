package aycmf.textrpg.activity;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Toast;

import aycmf.textrpg.R;
import aycmf.textrpg.model.ModelContainer;

public class StartScreenActivity extends AppCompatActivity {
    private boolean hasExistingGame = false;
    private ModelContainer modelContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Resources res = getResources();
        setContentView(R.layout.activity_start_screen);
        modelContainer = ModelContainer.load(this);
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
    }

}
