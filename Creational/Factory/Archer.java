package Creational.Factory;

public class Archer implements Soldier{
    
    private String name;
    private int power;
    private int health;

    public Archer() {
        this.name = "Okçu";
        this.power = 60;
        this.health = 70;
    }

    @Override
    public void attack() {
        System.out.println(name + " uzak mesafeden ok yağmuru başlatıyor!"+
         "(Güç: " + power + ")");
    }

    @Override
    public void defend() {
        System.out.println(name + " geri çekilerek mesafe koruyor!");
    }

    @Override
    public String getDescription() {
        return name + " [Güç: " + power + ", Can: " + health + "]";
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public int getHealth() {
        return health;
    }
}
