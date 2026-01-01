package Structural.Decorator;

public class BasicArmor implements Armor{
    
    @Override
    public String getDescription() {
        return "Temel Deri Zırh";
    }

    @Override
    public int getDefense() {
        return 10;
    }

    @Override
    public int getWeight() {
        return 5;
    }
}
