package Structural.Adapter;

public class WeaponAdapter implements ModernWeapon{

    private OldWeapon oldWeapon;

    public WeaponAdapter(OldWeapon oldWeapon) {
        this.oldWeapon = oldWeapon;
        System.out.println(oldWeapon.getOldName() + " yeni sisteme uyarlandı.");
    }

    @Override
    public void attack() {
        // Eski sistemin metodlarını kullanarak yeni silahlar geliştiriyoz
        System.out.println("[Uyarlanmış Silah] " + getName() + " ile saldırı!");
        oldWeapon.swing();
        oldWeapon.thrust();
    }

    @Override
    public int getDamage() {
        // eski hassarın üstüne ekleme yapıyoz
        return (int) (oldWeapon.getOldDamage() * 1.2);
    }

    @Override
    public String getName() {
        return oldWeapon.getOldName() + " (Uyarlanmış)";
    }

    @Override
    public String getType() {
        return "Eski çağ silahı";
    }
}
