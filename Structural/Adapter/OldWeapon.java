package Structural.Adapter;

public class OldWeapon{
    private String name;
    private int oldDamage;

    public OldWeapon(String name, int damage) {
        this.name = name;
        this.oldDamage = damage;
    }

    public void swing() {
        System.out.println("[Eski Silah] " + name + " sallanıyor!");
    }

    public void thrust() {
        System.out.println("[Eski Silah] " + name + " ile rakip tartılıyor!");
    }

    public int getOldDamage() {
        return oldDamage;
    }

    public String getOldName() {
        return name;
    }
}
