package Behavioral.Strategy;

import java.util.List;

import Creational.Factory.Soldier;

public class GuerrillaAttack  implements AttackStrategy{

     @Override
    public void execute(List<Soldier> soldiers) {
        System.out.println("\n GERİLLA SALDIRI STRATEJİSİ");
        System.out.println("─".repeat(40));
        System.out.println("Birimler gizlice konumlanıyor...");

        int wave = 1;
        int soldiersPerWave = Math.max(1, soldiers.size() / 3);

        for (int i = 0; i < soldiers.size(); i += soldiersPerWave) {
            System.out.println("\n Dalga " + wave + " saldırıya geçiyor!");

            int end = Math.min(i + soldiersPerWave, soldiers.size());
            for (int j = i; j < end; j++) {
                soldiers.get(j).attack();
            }

            System.out.println(" Dalga " + wave + " geri çekiliyor...");
            wave++;
        }

        int totalDamage = soldiers.stream()
                .mapToInt(s -> (int) (s.getPower() * 1.2)) // %20 sürpriz bonusu
                .sum();

        System.out.println("\n Toplam hasar: " + totalDamage + " (+%20 sürpriz bonus)");
        System.out.println(" Düşman şaşkın - süpriz saldiri yapıldı!");
    }

    @Override
    public String getName() {
        return "Gerilla Saldırısı";
    }

    @Override
    public String getDescription() {
        return "Küçük gruplar halinde vur-kaç taktiği. Sürpriz avantajı.";
    }
    
}
