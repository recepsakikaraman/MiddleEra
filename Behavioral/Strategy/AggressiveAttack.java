package Behavioral.Strategy;

import java.util.List;

import Creational.Factory.Soldier;

public class AggressiveAttack implements AttackStrategy{

     @Override
    public void execute(List<Soldier> soldiers) {
        System.out.println("\n !!* AGRESİF SALDIRI STRATEJİSİ");
        System.out.println("─".repeat(40));
        System.out.println("Tüm birimler saldırıya geçiyor!");

        for (Soldier soldier : soldiers) {
            soldier.attack();
        }

        int totalDamage = soldiers.stream()
                .mapToInt(s -> (int) (s.getPower() * 1.5)) // %50 bonus hasar ekledil
                .sum();

        System.out.println(" Toplam hasar: " + totalDamage + " (+%50 agresif bonus)");
    }

    @Override
    public String getName() {
        return "Agresif Saldırı";
    }

    @Override
    public String getDescription() {
        return "Tüm güçleri saldırıya yoğunlaştır, savunmayı görmezden gel.";
    }
    
}
