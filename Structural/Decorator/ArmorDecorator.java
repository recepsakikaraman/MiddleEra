package Structural.Decorator;

public abstract class ArmorDecorator implements Armor{
    
    protected Armor decoratedArmor;

    public ArmorDecorator(Armor armor) {
        this.decoratedArmor = armor;
    }

    @Override
    public String getDescription() {
        return decoratedArmor.getDescription();
    }

    @Override
    public int getDefense() {
        return decoratedArmor.getDefense();
    }

    @Override
    public int getWeight() {
        return decoratedArmor.getWeight();
    }
}
