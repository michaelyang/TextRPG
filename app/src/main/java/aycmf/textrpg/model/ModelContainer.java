package aycmf.textrpg.model;

/**
 * Created by myang on 5/10/17.
 */


public class ModelContainer {

    public final Character character;
    //public final Achievement achievement;

    public ModelContainer() {
        this.character = new Character();
        //this.achievement = new Achievement();
    }
    public ModelContainer(Character character, Achievement achievement) {
        this.character = character;
        //this.achievement = achievement;
    }

    public void initializeModelContainer(String characterName, int characterIconID) {
        character.initializeNewCharacter(characterName, characterIconID);
    }

    public Character getCharacter() {
        return character;
    }
}
