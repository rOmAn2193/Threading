
package threading;

public class Chopstick {

    private int id;
    private int size;
    private Philosopher owner = null;
    private Object lock = new Object();

    public Chopstick(int _id, int _size) {
        this.id = _id;
        this.size = _size;
    }

    public int getID() {
        return id;
    }

    public void pickUp(Philosopher _owner) {
        synchronized (lock) {
            while (owner != null) {
                System.out.println("Philosopher # " + _owner.getID()
                        + " waiting for chopstick # " + getID());
                try {
                    lock.wait();
                } catch (InterruptedException ex) {
                }
            }
            owner = _owner;
            System.out.println("Philosopher # " + owner.getID()
                    + " got chopstick # " + getID());
        }
    }

    public void drop() {
        synchronized (lock) {
            System.out.println("Philosopher # " + owner.getID()
                    + " dropped chopstick # " + getID());
            owner = null;
            lock.notifyAll();
        }
    }
}
