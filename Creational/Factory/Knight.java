package Creational.Factory;

public class Knight implements Soldier{
    
    private String name;
    private int power;
    private int health;

    public Knight() {
        this.name = "Şövalye";
        this.power = 85;
        this.health = 120;
    }

    @Override
    public void attack() {
        System.out.println("XXX  " + name + " kılıcıyla güçlü bir saldırı yapıyor!"+
        " (Güç: " + power + ")");
    }

    @Override
    public void defend() {
        System.out.println(name + " kalkanıyla savunma pozisyonu alıyor!");
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
