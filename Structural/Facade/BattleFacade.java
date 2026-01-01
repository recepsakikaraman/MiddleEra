package Structural.Facade;

import java.util.List;

import Creational.Singleton.Kingdom;
import Creational.Factory.Soldier;
import Behavioral.Strategy.AggressiveAttack;
import Behavioral.Strategy.AttackStrategy;
import Behavioral.command.AttackCommand;
import Behavioral.command.BattleCommand;
import Behavioral.command.BattleInvoker;
import Behavioral.command.DefendCommand;
import Behavioral.command.RetreatCommand;


public class BattleFacade {
    

    private Kingdom kingdom;
    private AttackStrategy strategy;
    private BattleInvoker invoker;

    public BattleFacade() {
        this.kingdom = Kingdom.getInstance();
        this.strategy = new AggressiveAttack(); // Varsayılan strateji
        this.invoker = new BattleInvoker();
    }

     // Saldırı stratejisini değiştirir
     
    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
        System.out.println("?Strateji değiştirildi: " + strategy.getName());
    }

    //Orduyu Hazırla
    public void prepareArmy() {
        System.out.println("\n... ORDU HAZIRLANIYOR...");
        System.out.println("═".repeat(40));

        List<Soldier> army = kingdom.getArmy();
        if (army.isEmpty()) {
            System.out.println("!!?  Ordunuz boş! Önce asker eğitin.");
            return;
        }

        System.out.println(" Toplam asker: " + army.size());
        int totalPower = army.stream().mapToInt(Soldier::getPower).sum();
        System.out.println(" Toplam güç: " + totalPower);
    }

    //Savaş başlatır
    public void startBattle(String enemyName) {
        System.out.println("\n");
        System.out.println("|--------------------------------------------|");
        System.out.println("|            XXX  SAVAŞ BAŞLIYOR! XXX         |");
        System.out.println("|________________________________________|");
        System.out.println("| Düşman: " + padRight(enemyName, 30) + "|");
        System.out.println("| Strateji: " + padRight(strategy.getName(), 28) + "|");
        System.out.println("|________________________________________|");

        // 1. Orduyu hazırla
        prepareArmy();

        List<Soldier> army = kingdom.getArmy();
        if (army.isEmpty()) {
            System.out.println("X Savaş iptal edildi - ordusuz savaşa mı girilir!");
            return;
        }

        // 2. Stratejiyi uygula
        System.out.println("\n Strateji uygulanıyor: " + strategy.getName());
        strategy.execute(army);

        // 3. Saldırı komutunu yürüt
        System.out.println("\n Saldırı emri veriliyor...");
        BattleCommand attackCmd = new AttackCommand(army);
        invoker.executeCommand(attackCmd);

        // 4. Savunma pozisyonu al
        System.out.println("\n Savunma pozisyonu alınıyor...");
        BattleCommand defendCmd = new DefendCommand(army);
        invoker.executeCommand(defendCmd);

        // 5. Savaş sonucu
        displayBattleResult(enemyName);
    }

    // Hızlı baskın
    public void quickRaid(String targetName) {
        System.out.println("\n HIZLI BASKIN: " + targetName);
        System.out.println("─".repeat(40));

        List<Soldier> army = kingdom.getArmy();
        if (army.size() < 2) {
            System.out.println(" Baskın için en az 2 asker gerekli!");
            return;
        }

        // Sadece ilk 3 askeri gönder
        List<Soldier> raidTeam = army.subList(0, Math.min(3, army.size()));

        BattleCommand raidAttack = new AttackCommand(raidTeam);
        invoker.executeCommand(raidAttack);

        System.out.println("+++ Baskın tamamlandı!");
    }

    //Geri çekilme
    public void retreat() {
        System.out.println("\n GERİ ÇEKİLME EMRİ!");
        System.out.println("─".repeat(40));

        List<Soldier> army = kingdom.getArmy();
        BattleCommand retreatCmd = new RetreatCommand(army);
        invoker.executeCommand(retreatCmd);
    }

   //Son emri geri al
    public void undoLastOrder() {
        System.out.println("\n  Son emir geri alınıyor...");
        invoker.undoLastCommand();
    }

    private void displayBattleResult(String enemyName) {
        System.out.println("\n");
        System.out.println("|----------------------------------------|");
        System.out.println("|           +++ SAVAŞ SONUCU ++            |");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("| " + padRight(kingdom.getName() + " vs " + enemyName, 38) + "|");
        System.out.println("| Sonuç: " + padRight("ZAFERİ!", 31) + "|");
        System.out.println("| Ganimet: " + padRight("+500 Altın", 29) + "|");
        System.out.println("|________________________________________|");

        kingdom.addGold(500);
    }

    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
