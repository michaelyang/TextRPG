package aycmf.textrpg.model;

/**
 * Created by myang on 5/10/17.
 */


import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Context;

import com.google.gson.Gson;

import aycmf.textrpg.model.Character;
import aycmf.textrpg.model.Achievements;

public class ModelContainer {

    public final Character character;
    public final Achievements achievements;

    public ModelContainer() {
        character = new Character();
        achievements = new Achievements();
    }

    public void save(Context con) {
        SharedPreferences save = con.getSharedPreferences("save", 0);
        SharedPreferences.Editor editor = save.edit();
        final Gson gson = new Gson();
        String json = gson.toJson(this);
        editor.putString("saveData", json);
        editor.commit();
    }

    public static ModelContainer load(Context con) {
        SharedPreferences save = con.getSharedPreferences("save", 0);
        Gson gson = new Gson();
        String json = save.getString("saveData", null);
        return gson.fromJson(json, ModelContainer.class);
    }

    public void initializeGame(String characterName) {
        character.initializeNewCharacter(characterName);
    }

    public Character getCharacter() {
        return character;
    }
}
