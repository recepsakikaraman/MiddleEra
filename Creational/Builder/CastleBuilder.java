package Creational.Builder;

public class CastleBuilder {
    
    private Castle castle;

    public CastleBuilder(String name) {
        this.castle = new Castle(name);
        System.out.println(name + " Kalesi inşaatı başladı...");
    }

    public CastleBuilder addTowers(int count) {
        castle.setTowers(count);
        System.out.println(count + " adet kule eklendi.");
        return this;
    }

    public CastleBuilder addWalls(int count) {
        castle.setWalls(count);
        System.out.println(count + " adet duvar örüldü.");
        return this;
    }

    public CastleBuilder setWallHeight(int meters) {
        castle.setWallHeight(meters);
        System.out.println("Duvar yüksekliği " + meters + " metre olarak belirlendi.");
        return this;
    }

    public CastleBuilder addMoat() {
        castle.setHasMoat(true);
        System.out.println("Hendek kazıldı ve su dolduruldu.");
        return this;
    }

    public CastleBuilder addDrawbridge() {
        castle.setHasDrawbridge(true);
        System.out.println("Asma köprü inşa edildi.");
        return this;
    }

    public CastleBuilder addGreatHall() {
        castle.setHasGreatHall(true);
        System.out.println("Büyük salon inşa edildi.");
        return this;
    }

    public CastleBuilder addDungeon() {
        castle.setHasDungeon(true);
        System.out.println("Zindan kazıldı.");
        return this;
    }

    //kaleyi tamamla
    public Castle build() {
        System.out.println("+++" + castle.getName() + " Kalesi tamamlandı!\n");
        return castle;
    }

    // Hazır kale şablonları

     // Küçük bir karakol oluşturur
     
    public static Castle createOutpost(String name) {
        return new CastleBuilder(name)
                .addTowers(2)
                .addWalls(4)
                .setWallHeight(5)
                .build();
    }

     // Orta büyüklükte bir kale oluşturur
     
    public static Castle createFortress(String name) {
        return new CastleBuilder(name)
                .addTowers(4)
                .addWalls(8)
                .setWallHeight(10)
                .addMoat()
                .addDrawbridge()
                .addDungeon()
                .build();
    }

    //kraliyet kalesi
    public static Castle createRoyalCastle(String name) {
        return new CastleBuilder(name)
                .addTowers(8)
                .addWalls(16)
                .setWallHeight(20)
                .addMoat()
                .addDrawbridge()
                .addGreatHall()
                .addDungeon()
                .build();
    }
}
