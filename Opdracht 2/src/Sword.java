public class Sword implements Weapon {
    @Override
    public void useWeapon(int strength) {
        System.out.println("Swing a sword and kill "+strength);
    }
}