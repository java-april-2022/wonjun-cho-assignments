public class Mammal {
    int energyLevel;

    public Mammal (int energy) {
        energyLevel = energy;
    }
    public int displayEnergy () {
        System.out.println(energyLevel);
        return energyLevel;
    }
}