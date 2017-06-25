package aycmf.textrpg.model;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myang on 5/10/17.
 */

public class Character {
    Item equippedItem;

    //shortened death timer
    public int strength;
    //????
    public int dexterity;
    //increased effect on usable items
    public int intelligence;
    //higher chance to find usable item
    public int luck;
    public String name;
    public boolean alive;
    public int characterIconID;
    //public List<Integer> completedAchievements;

    public Character() {
    }

    public void resetForNewGame(String name, int characterIconID) {
        this.name = name;
        this.strength = 1;
        this.dexterity = 1;
        this.intelligence = 1;
        this.luck = 1;
        this.characterIconID = characterIconID;
        this.alive = true;
        //this.completedAchievements = new ArrayList<>();
        //this.equippedItem = null;
    }

    public int getCharacterIconID() {
        return characterIconID;
    }

    public int getStrength() {
        return strength;
    }

    public void changeStrength(int changeAmount) {
        strength = Math.min(strength + changeAmount, 0);
    }

    public int getDexterity() {
        return dexterity;
    }

    public void changeDexterity(int changeAmount) {
        dexterity = Math.min(dexterity + changeAmount, 0);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void changeIntelligence(int changeAmount) {
        intelligence = Math.min(intelligence + changeAmount, 0);
    }

    public int getLuck() {
        return luck;
    }

    public void changeLuck(int changeAmount) {
        luck = Math.min(luck + changeAmount, 0);
    }
    /*
    public Item getEquippedItem() {
        return equippedItem;
    }
    public void equipItem(Item item) {
        equippedItem = item;
    }
*/
    public String getName() {
        return name;
    }

    public void revive() {
        alive = true;
    }

    public void death() {
        alive = false;
        /*new CountDownTimer(1800000, 1000) {
            public void onTick (long millisUntilFinished) {
                deathTimerView.setText("Seconds Remaining: " + millisUntilFinished/ 1000);
            }
            public void onFinish(){
                revive();
            }
        }.start();
        */
    }
}