public class Knight extends Character {

    public Knight() {
        setStrength(2);
    }
    public void fight() {
        weapon.useWeapon(strength);
// other fighting behaviors
    }
}