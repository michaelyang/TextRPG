package aycmf.textrpg;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import aycmf.textrpg.model.ModelContainer;

/**
 * Created by myang on 5/15/17.
 */

public class TextRPGApplication extends Application {

    private ModelContainer modelContainer = new ModelContainer();

    public ModelContainer getModelContainer() {
        return modelContainer;
    }

    public void newGame(String characterName, int characterIconID) {
        modelContainer.resetForNewGame(characterName, characterIconID);
    }

    public void saveGame() {
        SharedPreferences save = getSharedPreferences("save", 0);
        SharedPreferences.Editor editor = save.edit();
        final Gson gson = new Gson();
        String json = gson.toJson(modelContainer);
        editor.putString("saveData", json);
        editor.commit();
    }

    public void clearGame() {
        SharedPreferences save = getSharedPreferences("save", 0);
        SharedPreferences.Editor editor = save.edit();
        editor.remove("saveData");
        editor.commit();
    }

    public void loadGame() {
        SharedPreferences save = getSharedPreferences("save", 0);
        Gson gson = new Gson();
        String json = save.getString("saveData", "");
        modelContainer = gson.fromJson(json, ModelContainer.class);
    }

    public boolean hasExistingGame() {
        return getSharedPreferences("save",0).contains("saveData");
    }

}
