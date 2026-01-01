package Behavioral.Strategy;

import java.util.List;

import Creational.Factory.Soldier;

public class DefensiveAttack implements AttackStrategy{

    @Override
    public void execute(List<Soldier> soldiers) {
        System.out.println("\n  SAVUNMACI SALDIRI STRATEJİSİ");
        System.out.println("─".repeat(40));
        System.out.println("Birimler kalkan formasyonunda ilerliyor!");

        // Önce savunma pozisyonu al
        for (Soldier soldier : soldiers) {
            soldier.defend();
        }

        // Sonra dikkatli saldırı
        System.out.println("\n...Güvenli mesafe sağlandı, saldırı başlıyor...");
        for (Soldier soldier : soldiers) {
            soldier.attack();
        }

        int totalDamage = soldiers.stream()
                .mapToInt(s -> (int) (s.getPower() * 0.8)) // %20 azaltılmış hasar ekleyelin
                .sum();

        System.out.println("💥 Toplam hasar: " + totalDamage + " (savunmacı mod)");
        System.out.println("  Kayıp: Minimum (savunma formasyonu aktif)");
    }

    @Override
    public String getName() {
        return "Savunmacı Saldırı";
    }

    @Override
    public String getDescription() {
        return "Savunmayı koruyarak dikkatli ilerleme. Daha az hasar ama daha az kayıp.";
    }
    
}
