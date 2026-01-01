package Behavioral.command;

import java.util.List;

import Creational.Factory.Soldier;

//geri çekilme
public class RetreatCommand implements BattleCommand {

     private List<Soldier> soldiers;
    private boolean executed = false;

    public RetreatCommand(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }
    
      @Override
    public void execute() {
       System.out.println("!!**GERİ ÇEKİLME EMRİ VERİLDİ**!!");
       System.out.println("Tüm birimler Güvenli Bölgeye çekilsin");
       for(Soldier soldier : soldiers){
        System.out.println(soldier.getDescription()+ " geri çekiliyor!");
       }
       executed = true;
    }

    @Override
    public void undo() {
        if (executed){
            System.out.println(" !! GERİ ÇEKİLME EMRİ İPTAL - "
            +"BİRİMLER POZİSYONLARINA DÖNÜYO!");   
             for (Soldier soldier : soldiers) {
                soldier.defend();
            }        
            executed = false;
        }

    }

    @Override
    public String getCommandName() {
        return "Geri Çekilme Komutu";
    }
    
}
