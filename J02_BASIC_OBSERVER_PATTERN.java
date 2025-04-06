import java.util.ArrayList;
import java.util.Iterator;

interface Store {
    void registor(Customer obs);

    void unregistor(Customer obs);

    void notifyAllObservers(String msg);

    void addNewProductIntoStore(String product);
}

interface Customer {
    void notify(String k);
}

class KhanCommunication implements Store {
    ArrayList<Customer> arr = new ArrayList<>();
    ArrayList<String> productList = new ArrayList<>();

    public void registor(Customer obs) {
        arr.add(obs);

    }

    public void unregistor(Customer obs) {
        arr.remove(obs);
    }

    public void notifyAllObservers(String msg) {
        Iterator<Customer> i = arr.iterator();
        while (i.hasNext()) {
            Customer o = i.next();
            o.notify(msg);
        }

    }

    public void addNewProductIntoStore(String product) {
        productList.add(product);
        notifyAllObservers("new product: " + product + " added into our store...");
    }

}

class User implements Customer {
    String name = null;

    User(String name) {
        this.name = name;
    }

    public void notify(String msg) {

        System.out.print("hi, " + name + " " + msg);

    }
}

public class Test {
    public static void main(String[] args) {
        Store khanCommunication = new KhanCommunication();
        Customer anshik = new User("anshik");
        Customer sarb= new User("sarb");
        khanCommunication.registor(anshik);
        khanCommunication.registor(sarb);
        khanCommunication.addNewProductIntoStore("iphone");
    }
}
