package aycmf.textrpg.model;

/**
 * Created by myang on 5/10/17.
 */


public class ModelContainer {

    public final Character character;
    public final Statistics statistics;

    public ModelContainer() {
        this.character = new Character();
        this.statistics = new Statistics();
    }

    public void resetForNewGame(String characterName, int characterIconID) {
        character.resetForNewGame(characterName, characterIconID);
        statistics.resetForNewGame();
    }

    public Character getCharacter() {
        return character;
    }
}
