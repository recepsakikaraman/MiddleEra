package Creational.Builder;

public class Castle {
    
    private String name;
    private int towers; // kule sayısı
    private int walls;  //duvar sayisi
    private int wallHeight; // Duvar yüksekliği
    private boolean hasMoat; // Hendek
    private boolean hasDrawbridge; // Asma köprü
    private boolean hasGreatHall; // Büyük salon
    private boolean hasDungeon; // Zindan

    Castle(String name) {
        this.name = name;
        this.towers = 0;
        this.walls = 0;
        this.wallHeight = 0;
        this.hasMoat = false;
        this.hasDrawbridge = false;
        this.hasGreatHall = false;
        this.hasDungeon = false;
    }

    void setTowers(int towers) {
        this.towers = towers;
    }

    void setWalls(int walls) {
        this.walls = walls;
    }

    void setWallHeight(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    void setHasMoat(boolean hasMoat) {
        this.hasMoat = hasMoat;
    }

    void setHasDrawbridge(boolean hasDrawbridge) {
        this.hasDrawbridge = hasDrawbridge;
    }

    void setHasGreatHall(boolean hasGreatHall) {
        this.hasGreatHall = hasGreatHall;
    }

    void setHasDungeon(boolean hasDungeon) {
        this.hasDungeon = hasDungeon;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getTowers() {
        return towers;
    }

    public int getWalls() {
        return walls;
    }

    public int getDefenseRating() {
        int rating = 0;
        rating += towers * 15;
        rating += walls * 10;
        rating += wallHeight * 5;
        rating += hasMoat ? 30 : 0;
        rating += hasDrawbridge ? 20 : 0;
        rating += hasDungeon ? 10 : 0;
        return rating;
    }

    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n ").append(name).append(" Kalesi\n");
        sb.append("─".repeat(40)).append("\n");
        sb.append(" Kule Sayısı: ").append(towers).append("\n");
        sb.append(" Duvar Sayısı: ").append(walls).append("\n");
        sb.append(" Duvar Yüksekliği: ").append(wallHeight).append(" metre\n");
        sb.append(" Hendek: ").append(hasMoat ? "Var +" : "Yok -").append("\n");
        sb.append(" Asma Köprü: ").append(hasDrawbridge ? "Var +" : "Yok -").append("\n");
        sb.append(" Büyük Salon: ").append(hasGreatHall ? "Var +" : "Yok -").append("\n");
        sb.append("  Zindan: ").append(hasDungeon ? "Var +" : "Yok -").append("\n");
        sb.append("─".repeat(40)).append("\n");
        sb.append("  Savunma Puanı: ").append(getDefenseRating()).append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
