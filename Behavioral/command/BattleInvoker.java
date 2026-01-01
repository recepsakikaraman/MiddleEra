package Behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class BattleInvoker {
    private List<BattleCommand> commandHistory =new ArrayList<>();
    public void executeCommand(BattleCommand command){
        command.execute();
        commandHistory.add(command);
        System.out.println("KOMUT KAYIT ALTINA ALINDI : " +  command.getCommandName());
    }
    public void undoLastCommand(){
        if(!commandHistory.isEmpty()){
            BattleCommand lastCommand = 
            commandHistory.remove(commandHistory.size()-1);
            lastCommand.undo();
            System.out.println("KOMUT GERİ ALINDI : "+ lastCommand.getCommandName());
        }else {
            System.out.println("GERİ ALINACAK KOMUT YOK");
        }
    }
    public void undoAllCommands(){
        System.out.println("TÜM KOMUTLAR GERİ ALINIYO...");
        while (!commandHistory.isEmpty()){
            undoLastCommand();
        }
    }

    public void showHistory(){
        System.out.println("KoMuT GeÇmİşİ : ");
        System.out.println("-".repeat(30));
        if(commandHistory.isEmpty()){
            System.out.println("Geçmiş boş");
        }else{
            for(int i = 0; i< commandHistory.size(); i++){
                System.out.println((i+1)+". "
                +commandHistory.get(i).getCommandName());
            }
        }
    }
    
    public int getHistorySize(){
        return commandHistory.size();
    }

}
