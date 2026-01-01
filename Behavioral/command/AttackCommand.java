package Behavioral.command;

import java.util.List;

import Creational.Factory.Soldier;

public class AttackCommand implements BattleCommand{

    private List<Soldier> soldiers;
    private boolean executed = false; // attack emri verild

    //constructor
    public AttackCommand(List<Soldier> soldiers){
        this.soldiers=soldiers;
    }

    @Override
    public void execute() {
       System.out.println("!!**SALDIRI EMRİ VERİLDİ**!!");
       for(Soldier soldier : soldiers){
        soldier.attack();
       }
       executed = true;
    }

    @Override
    public void undo() {
        if (executed){
            System.out.println(" !! SALDIRI EMRİ İPTAL - BİRİMLER GERİ ÇEKİL!");
            for(Soldier soldier : soldiers){
                soldier.defend();
            }
            executed = false;
        }

    }

    @Override
    public String getCommandName() {
        return "Saldiri Komutu";
    }
    
}
