package Structural.Decorator;

// plaka zırh
public class PlateDecorator extends ArmorDecorator{
    
    public PlateDecorator(Armor armor) {
        super(armor);
    }

    @Override
    public String getDescription() {
        return decoratedArmor.getDescription() + " + Plaka Zırh";
    }

    @Override
    public int getDefense() {
        return decoratedArmor.getDefense() + 40;
    }

    @Override
    public int getWeight() {
        return decoratedArmor.getWeight() + 20;
    }
}
