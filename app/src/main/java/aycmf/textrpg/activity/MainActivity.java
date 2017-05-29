package aycmf.textrpg.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import aycmf.textrpg.R;
import aycmf.textrpg.TextRPGApplication;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        final TextRPGApplication app = (TextRPGApplication) getApplicationContext();
    }
}
