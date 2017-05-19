package aycmf.textrpg.model;

/**
 * Created by myang on 5/10/17.
 */

public class Achievement {
    final String achievementName;
    final int achievementId;

    public Achievement (String achievementName, int achievementId) {
        this.achievementName = achievementName;
        this.achievementId = achievementId;
    }
    public String getName () {
        return achievementName;
    }
}
