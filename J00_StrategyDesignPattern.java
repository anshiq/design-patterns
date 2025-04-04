// Strategy Interface that defines flying behavior
interface Canfly {
    String status(); // Returns flying status
}

// Concrete Strategy: Implements flying behavior for animals that can fly
class canFlyClass implements Canfly {
    @Override
    public String status() {
        return "Yes, it can fly!!!";
    }
}

// Concrete Strategy: Implements flying behavior for animals that can't fly
class cantFlyClass implements Canfly {
    @Override
    public String status() {
        return "No, it can't fly!!!";
    }
}

// Context Class: Animal uses a flying behavior strategy
class Animal {
    String name;
    private Canfly status = null; // Strategy is composed here

    // Constructor sets the name and the flying strategy
    Animal(String name, Canfly status) {
        this.name = name;
        this.status = status;
    }

    // Calls the strategy's status method to check if it can fly
    public void canItFly() {
        System.out.println(status.status());
    }

    // Displays all details of the animal
    public void allDetails() {
        System.out.println(status.status()); // Flying ability
        System.out.println(name);            // Name of the animal
    }
}

// Concrete Animal: Dog, which can't fly
class Dog extends Animal {
    Dog(String name) {
        super(name, new cantFlyClass()); // Injects the no-flying behavior
    }
}

// Concrete Animal: Sparrow, which can fly
class Sparrow extends Animal {
    Sparrow(String name) {
        super(name, new canFlyClass()); // Injects the flying behavior
    }
}

// Driver class to test the Strategy Pattern in action
public class J00_StrategyDesignPattern{
    public static void main(String[] arg) {
        Dog dog = new Dog("shaky");           // Create a Dog named "shaky"
        Sparrow sparrow = new Sparrow("chinki"); // Create a Sparrow named "chinki"

        // Output details of each animal
        dog.allDetails();
        sparrow.allDetails();
    }
}
