package Creational.Singleton;

import java.util.ArrayList;
import java.util.List;

import Behavioral.Observer.KingdomEvent;
import Behavioral.Observer.KingdomSubject;
import Creational.Factory.Soldier;

public class Kingdom extends KingdomSubject{
    
    private static final Kingdom INSTANCE = new Kingdom();
    
    private String name;
    private int gold;
    private List<Soldier> army;
    
    private Kingdom() {
        this.name = "Orta Çağ Krallığı";
        this.gold = 1000;
        this.army = new ArrayList<>();
    }
    
    // Global erişim noktası
    public static Kingdom getInstance() {
        return INSTANCE;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getGold() {
        return gold;
    }
    
    public List<Soldier> getArmy() {
        return new ArrayList<>(army); // Defensive copy
    }
    
    public int getArmySize() {
        return army.size();
    }
    
    // Setters ve işlemler
    public void setName(String name) {
        this.name = name;
        notifyObservers(new KingdomEvent("NAME_CHANGE", "Krallık adı değişti: " + name));
    }
    
    public void addGold(int amount) {
        this.gold += amount;
        notifyObservers(new KingdomEvent("GOLD_CHANGE", "Hazineye " + 
        amount + " altın eklendi. Toplam: " + gold));
    }
    
    public boolean spendGold(int amount) {
        if (gold >= amount) {
            gold -= amount;
            notifyObservers(new KingdomEvent("GOLD_SPENT", amount + 
            " altın harcandı. Kalan: " + gold));
            return true;
        }
        return false;
    }
    
    public void addSoldier(Soldier soldier) {
        army.add(soldier);
        notifyObservers(new KingdomEvent("SOLDIER_ADDED", "Orduya yeni asker katıldı: "
         + soldier.getDescription()));
    }
    
    public void displayStatus() {
        System.out.println("\n|--------------------------------------|");
        System.out.println("|         KRALLIK DURUMU                 |");
        System.out.println("|----------------------------------------|");
        System.out.println("| Krallık: " + padRight(name, 29) + "|");
        System.out.println("| Altın: " + padRight(String.valueOf(gold), 31) + "|");
        System.out.println("| Ordu Sayısı: " + padRight(String.valueOf(army.size()), 25) + "|");
        System.out.println("|_________________________________________|");
    }
    
    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
