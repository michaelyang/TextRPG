package aycmf.textrpg.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import aycmf.textrpg.R;
import aycmf.textrpg.TextRPGApplication;
import aycmf.textrpg.view.StatusView;
import aycmf.textrpg.view.StoryView;

public class MainActivity extends AppCompatActivity {

    private StatusView statusView;
    private StoryView storyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TextRPGApplication app = (TextRPGApplication) getApplicationContext();
        setContentView(R.layout.activity_main);

        statusView = (StatusView) findViewById(R.id.statusView);

    }
}
