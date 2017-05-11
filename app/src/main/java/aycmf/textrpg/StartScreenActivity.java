package aycmf.textrpg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import aycmf.textrpg.R;
import aycmf.textrpg.model.ModelContainer;

public class StartScreenActivity extends AppCompatActivity {
    private boolean hasExistingGame = false;
    private ModelContainer modelContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //final Resources res = getResources();
        setContentView(R.layout.activity_start_screen);
        /*
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
                            //continueGame(true, characterName.getText().toString());
                            //setButtonState(null, null);
                        }
                    })
                    .setNegativeButton(android.R.string.cancel, null)
                    .create().show();
        } else {

        }
        */
    }

}
