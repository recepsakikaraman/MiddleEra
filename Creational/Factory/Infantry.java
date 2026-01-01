package Creational.Factory;
//piyade sınıfı
public class Infantry implements Soldier {
    
    private String name;
    private int power;
    private int health;

    public Infantry() {
        this.name = "Piyade";
        this.power = 45;
        this.health = 100;
    }

    @Override
    public void attack() {
        System.out.println("XXX  " + name + " mızrağıyla saldırıya geçiyor!"+
        " (Güç: " + power + ")");
    }

    @Override
    public void defend() {
        System.out.println(name + " kalkan duvarı oluşturuyor!");
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
