package aycmf.textrpg.model;

/**
 * Created by myang on 5/10/17.
 */

public class Achievement {

    final int id;
    final String name;
    final String iconId;
    final String description;

    public Achievement (int id, String name, String iconId, String description) {
        this.id = id;
        this.name = name;
        this.iconId = iconId;
        this.description = description;
    }

    public String getName () {
        return name;
    }
}
