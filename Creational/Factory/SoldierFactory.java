package Creational.Factory;

public class SoldierFactory {
    
    public enum SoldierType {
        KNIGHT, // Şövalye
        ARCHER, // Okçu
        INFANTRY // Piyade
    }

    /**
     * Belirtilen türde asker oluşturur
     * 
     * @param type Asker türü
     * @return Oluşturulan Soldier nesnesi
     */
    public static Soldier createSoldier(SoldierType type) {
        switch (type) {
            case KNIGHT:
                System.out.println("|_| Şövalye eğitiliyor...");
                return new Knight();
            case ARCHER:
                System.out.println("|_| Okçu eğitiliyor...");
                return new Archer();
            case INFANTRY:
                System.out.println("|_| Piyade eğitiliyor...");
                return new Infantry();
            default:
                throw new IllegalArgumentException("Komutan böyle askerimiz mi var??? " + type);
        }
    }

    // Rastgele bir asker türü oluşturur
     
    public static Soldier createRandomSoldier() {
        SoldierType[] types = SoldierType.values();
        int randomIndex = (int) (Math.random() * types.length);
        return createSoldier(types[randomIndex]);
    }
}
