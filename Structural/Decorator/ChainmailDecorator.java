package Structural.Decorator;

//zincir zırh
public class ChainmailDecorator extends ArmorDecorator{
    
     public ChainmailDecorator(Armor armor) {
        super(armor);
    }

    @Override
    public String getDescription() {
        return decoratedArmor.getDescription() + " + Zincir Zırh";
    }

    @Override
    public int getDefense() {
        return decoratedArmor.getDefense() + 25;
    }

    @Override
    public int getWeight() {
        return decoratedArmor.getWeight() + 10;
    }
}
