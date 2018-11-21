public class Knife implements Weapon {
    @Override
    public void useWeapon(int strength) {
        System.out.println("Stab a knife and kill "+strength);
    }
}