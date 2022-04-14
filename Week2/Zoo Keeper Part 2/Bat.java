public class Bat extends Mammal{
    public Bat () {
        super(300);
    }

    public void fly () {
        System.out.println("Flied");
        energyLevel -= 50;
    }

    public void eatHumans () {
        System.out.println("so- well, never mind");
        energyLevel += 25;
    }

    public void attackTown () {
        System.out.println("ON FIRE");
        energyLevel -= 100;
    }
}