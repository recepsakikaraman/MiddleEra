import java.util.List;

import Behavioral.Observer.RoyalAdvisor;
import Behavioral.Observer.Spy;
import Behavioral.Strategy.AggressiveAttack;
import Behavioral.Strategy.AttackStrategy;
import Behavioral.Strategy.DefensiveAttack;
import Behavioral.Strategy.GuerrillaAttack;
import Behavioral.command.AttackCommand;
import Behavioral.command.BattleCommand;
import Behavioral.command.BattleInvoker;
import Behavioral.command.DefendCommand;
import Creational.Builder.Castle;
import Creational.Builder.CastleBuilder;
import Creational.Factory.Soldier;
import Creational.Factory.SoldierFactory;
import Creational.Singleton.Kingdom;
import Structural.Adapter.ModernWeapon;
import Structural.Adapter.OldWeapon;
import Structural.Adapter.WeaponAdapter;
import Structural.Decorator.Armor;
import Structural.Decorator.BasicArmor;
import Structural.Decorator.ChainmailDecorator;
import Structural.Decorator.HelmetDecorator;
import Structural.Decorator.PlateDecorator;
import Structural.Facade.BattleFacade;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n");
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|                                                              |");
        System.out.println("|               MIDDLE ERA - TASARIM DESENLERİ DEMO            |");
        System.out.println("|                                                              |");
        System.out.println("|______________________________________________________________|");

        // 1. SINGLETON PATTERN - Kingdom oluşturalım
        //başlık yazdıralım
        printSection("1. SINGLETON PATTERN - Kingdom");

        Kingdom kingdom = Kingdom.getInstance();
        kingdom.setName("Anadolu Krallığı");

        // Observer'ları ekle (Observer pattern ile entegre)
        RoyalAdvisor advisor = new RoyalAdvisor("Vezir Ahmet");
        Spy spy = new Spy("Gölge");
        kingdom.attach(advisor);
        kingdom.attach(spy);

        kingdom.displayStatus();

        // Singleton'ın aynı instance olduğunu göster
        Kingdom sameKingdom = Kingdom.getInstance();
        System.out.println("\n Singleton Doğrulama: kingdom == sameKingdom ? " +
                (kingdom == sameKingdom ? "+ EVET (Tek bir kırallık)" : "- HAYIR"));

        // 2. FACTORY PATTERN - SoldierFactory asker üretimi yapalım
        //başlık yazdıralım
        printSection("2. FACTORY PATTERN - SoldierFactory");

        System.out.println("Farklı türde askerler oluşturuluyor...\n");

        Soldier knight = SoldierFactory.createSoldier(SoldierFactory.SoldierType.KNIGHT);
        kingdom.addSoldier(knight);

        Soldier archer = SoldierFactory.createSoldier(SoldierFactory.SoldierType.ARCHER);
        kingdom.addSoldier(archer);

        Soldier infantry = SoldierFactory.createSoldier(SoldierFactory.SoldierType.INFANTRY);
        kingdom.addSoldier(infantry);

        // Rastgele asker -- istersek for döngüsünde belli sayıda üretebiliriz
        System.out.println("\nRastgele asker oluşturuluyor...");
        Soldier random = SoldierFactory.createRandomSoldier();
        kingdom.addSoldier(random);

        System.out.println("\n Ordu Listesi:");
        for (Soldier s : kingdom.getArmy()) {
            System.out.println("   • " + s.getDescription());
        }

        // 3. BUILDER PATTERN - CastleBuilder kale oluşturalım
        //başlık yazdıralım
        printSection("3. BUILDER PATTERN - CastleBuilder");

        System.out.println("Özel kale inşa ediliyor...\n");

        Castle customCastle = new CastleBuilder("Kartal Yuvası")
                .addTowers(6)
                .addWalls(12)
                .setWallHeight(15)
                .addMoat()
                .addDrawbridge()
                .addGreatHall()
                .build();

        System.out.println(customCastle.getDescription());

        System.out.println("\nHazır şablon kullanarak kale oluşturuluyor...\n");
        Castle fortress = CastleBuilder.createFortress("Demir Kapı");
        System.out.println(fortress.getDescription());

        // 4. DECORATOR PATTERN - ArmorDecorator zırhı düzenleyelim
        //başlık yazdıralım
        printSection("4. DECORATOR PATTERN - ArmorDecorator");

        System.out.println("Zırh oluşturuluyor ve geliştiriliyor...\n");

        // Temel zırh
        Armor basicArmor = new BasicArmor();
        System.out.println("Temel: " + basicArmor.getDescription());
        System.out.println("   Savunma: " + basicArmor.getDefense() + ", Ağırlık: " + basicArmor.getWeight());

        // Zincir zırh ekle
        Armor chainmail = new ChainmailDecorator(basicArmor);
        System.out.println("\n+ Zincir zırh eklendi: " + chainmail.getDescription());
        System.out.println("   Savunma: " + chainmail.getDefense() + ", Ağırlık: " + chainmail.getWeight());

        // Plaka zırh ekle
        Armor plated = new PlateDecorator(chainmail);
        System.out.println("\n+ Plaka zırh eklendi: " + plated.getDescription());
        System.out.println("   Savunma: " + plated.getDefense() + ", Ağırlık: " + plated.getWeight());

        // Miğfer ekle
        Armor fullArmor = new HelmetDecorator(plated);
        System.out.println("\n+ Miğfer eklendi: " + fullArmor.getDescription());
        System.out.println("   Savunma: " + fullArmor.getDefense() + ", Ağırlık: " + fullArmor.getWeight());

        // 5. ADAPTER PATTERN - WeaponAdapter
        //başlık yazdıralım
        printSection("5. ADAPTER PATTERN - WeaponAdapter");

        System.out.println("Eski silah sistemi yeni sisteme uyarlanıyor...\n");

        // Eski bir silah
        OldWeapon oldSword = new OldWeapon("EXCALİBUR ", 50);
        System.out.println("Eski silah oluşturuldu: " + oldSword.getOldName());
        System.out.println("Eski hasar değeri: " + oldSword.getOldDamage());

        // Adapter ile yeni sisteme uyarla
        ModernWeapon adaptedSword = new WeaponAdapter(oldSword);
        System.out.println("\nYeni sistem bilgileri:");
        System.out.println("Ad: " + adaptedSword.getName());
        System.out.println("Tür: " + adaptedSword.getType());
        System.out.println("Yeni hasar değeri: " + adaptedSword.getDamage() + " (1.2x bonus)");
        System.out.println("\nSaldırı testi:");
        adaptedSword.attack();

        // 6. FACADE PATTERN - BattleFacade facade ile savaı başlatalom.
        //başlık yazdıralım
        printSection("6. FACADE PATTERN - BattleFacade");

        System.out.println("Savaş sistemi arayüzü aktif...\n");

        BattleFacade battleFacade = new BattleFacade();

        // Strateji değiştir
        battleFacade.setStrategy(new GuerrillaAttack());

        // Hızlı baskın
        battleFacade.quickRaid("Düşman Karakolu");

        // 7. STRATEGY PATTERN - AttackStrategy stratejiyi ayarlayalm
        //başlık yazdıralım
        printSection("7. STRATEGY PATTERN - AttackStrategy");

        System.out.println("Farklı saldırı stratejileri test ediliyor...\n");

        List<Soldier> army = kingdom.getArmy();

        AttackStrategy aggressive = new AggressiveAttack();
        System.out.println("Strateji: " + aggressive.getName());
        System.out.println("Açıklama: " + aggressive.getDescription());
        aggressive.execute(army);

        AttackStrategy defensive = new DefensiveAttack();
        System.out.println("\n\nStrateji: " + defensive.getName());
        System.out.println("Açıklama: " + defensive.getDescription());
        defensive.execute(army);

        // 8. OBSERVER PATTERN - KingdomObserver
        printSection("8. OBSERVER PATTERN - KingdomObserver");

        System.out.println("Observer'lar krallık olaylarını dinliyor...\n");
        System.out.println("Mevcut observer sayısı: " + kingdom.getObserverCount());

        // Altın ekle - observer'lar bilgilendirilecek
        System.out.println("\nAltın ekleniyor...");
        kingdom.addGold(200);

        // Yeni asker - observer'lar bilgilendirilecek
        System.out.println("\nYeni asker ekleniyor...");
        Soldier newKnight = SoldierFactory.createSoldier(SoldierFactory.SoldierType.KNIGHT);
        kingdom.addSoldier(newKnight);

        // Observer'ı kaldır
        System.out.println("\nCasus ayrılıyor...");
        kingdom.detach(spy);

        // 9. COMMAND PATTERN - BattleCommand
        printSection("9. COMMAND PATTERN - BattleCommand");

        System.out.println("Savaş komutları yürütülüyor ve geri alınıyor...\n");

        BattleInvoker invoker = new BattleInvoker();

        // Komutları yürüt
        BattleCommand attack = new AttackCommand(army);
        invoker.executeCommand(attack);

        BattleCommand defend = new DefendCommand(army);
        invoker.executeCommand(defend);

        // Geçmişi göster
        invoker.showHistory();

        // Son komutu geri al
        System.out.println("\nSon komut geri alınıyor...");
        invoker.undoLastCommand();

        // Güncel geçmiş
        invoker.showHistory();

        // Savaş özeti
        printSection("ÖZET - Kullanılan Tasarım Desenleri");

        System.out.println("|------------------------------------------------------------------------|");
        System.out.println("| Kategori      | Desen                 | Uygulama                       |");
        System.out.println("|---------------|-----------------------|--------------------------------|");
        System.out.println("| Creational    | Singleton             | Kingdom sınıfı                 |");
        System.out.println("| Creational    | Factory               | SoldierFactory                 |");
        System.out.println("| Creational    | Builder               | CastleBuilder                  |");
        System.out.println("|---------------|-----------------------|--------------------------------|");
        System.out.println("| Structural    | Decorator             | ArmorDecorator                 |");
        System.out.println("| Structural    | Adapter               | WeaponAdapter                  |");
        System.out.println("| Structural    | Facade                | BattleFacade                   |");
        System.out.println("|---------------|-----------------------|--------------------------------|");
        System.out.println("| Behavioral    | Strategy              | AttackStrategy                 |");
        System.out.println("| Behavioral    | Observer              | KingdomObserver                |");
        System.out.println("| Behavioral    | Command               | BattleCommand                  |");
        System.out.println("|________________________________________________________________________|");

        // Final durum
        System.out.println("\n");
        kingdom.displayStatus();

        System.out.println("\n Oyun tamamlandı!");
    }

    private static void printSection(String title) {
        System.out.println("\n");
        System.out.println("═".repeat(60));
        System.out.println("  " + title);
        System.out.println("═".repeat(60));
        System.out.println();
    }
    
}
