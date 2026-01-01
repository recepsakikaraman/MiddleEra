package Structural.Decorator;

public class HelmetDecorator extends ArmorDecorator{
    
    public HelmetDecorator(Armor armor) {
        super(armor);
    }

    @Override
    public String getDescription() {
        return decoratedArmor.getDescription() + " + Miğfer";
    }

    @Override
    public int getDefense() {
        return decoratedArmor.getDefense() + 15;
    }

    @Override
    public int getWeight() {
        return decoratedArmor.getWeight() + 5;
    }
}
