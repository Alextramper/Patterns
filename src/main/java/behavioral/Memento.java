package behavioral;

public class Memento {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("Level 2", 32999);
        System.out.println(game);

        Fileclass file = new Fileclass();
        file.setSave(game.save());

        game.set("Level 4", 65999);
        System.out.println(game);

        System.out.println("Loading...");
        game.load(file.getSave());
    }
}

class Game {
    private String level;
    private int ms;
    public void set(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }
    public void load(Save save) {
        level = save.getLevel();
        ms = save.getMs();
    }
    public Save save() { return new Save(level, ms); }
    @Override
    public String toString() {
        return "Game level = " + level + ", ms = " + ms;
    }
}

class Save {
    private final String level;
    private final int ms;
    public Save (String level, int ms) {
        this.level = level;
        this.ms = ms;
    }
    public String getLevel() { return level; }
    public int getMs() { return ms; }
}

class Fileclass {
    Save save;
    public Save getSave() { return save; }
    public void setSave(Save save) { this.save = save; }
}

