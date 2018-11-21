public class Axe implements Weapon {
    @Override
    public void useWeapon(int strength) {
        System.out.println("Chop an axe and kill "+strength);
    }

}