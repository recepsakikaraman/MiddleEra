package Behavioral.command;

import java.util.List;

import Creational.Factory.Soldier;

public class DefendCommand implements BattleCommand {

   private List<Soldier> soldiers;
    private boolean executed = false; // attack emri verild

    //constructor
    public DefendCommand(List<Soldier> soldiers){
        this.soldiers=soldiers;
    }

    @Override
    public void execute() {
       System.out.println("!!**SAVUNMA EMRİ VERİLDİ**!!");
       for(Soldier soldier : soldiers){
        soldier.defend();
       }
       executed = true;
    }

    @Override
    public void undo() {
        if (executed){
            System.out.println(" !! SAVUNMA EMRİ İPTAL - BİRİMLER SALDIRIYA HAZIR!");           
            executed = false;
        }

    }

    @Override
    public String getCommandName() {
        return "Savunma Komutu";
    }
    
}
