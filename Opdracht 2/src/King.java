public class King extends Character {
    public King() {
        setStrength(4);
    }

    public void fight() {
        weapon.useWeapon(strength);
// other fighting behaviors
    }
}