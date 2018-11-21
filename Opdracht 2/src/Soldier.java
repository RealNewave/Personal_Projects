public class Soldier extends Character {
    public Soldier() {
        setStrength(1);
    }
    public void fight() {
        weapon.useWeapon(strength);
// other fighting behaviors
    }
}