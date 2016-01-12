package threading;

import java.util.logging.Level;
import java.util.logging.Logger;
import static threading.Tools.*;


public class Philosopher implements Runnable {
    private int id;
    private int size;
    private Chopstick left;
    private Chopstick right;
    public Philosopher(int _id, int _size) {
        this.id=_id;
        this.size=_size;
    }
    public int getID() { return id; }
    
    public void setLeftChopstick(Chopstick chopstick) {
        this.left = chopstick;
    }

    public void setRightChopstick(Chopstick chopstick) {
        this.right = chopstick;
    }
    
    private Thread thread = null;
    
    public void go()
    {
        System.out.println("Time to go...");
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private boolean running = false;
    
    public void stop() { 
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
        }
        System.out.println("Philosopher # " + getID() + " stopped.");
        thread = null;
    }
    
    @Override
    public void run() {
        while (running) {
            System.out.println("Philosopher #" + getID() + " is thinking...");
            sleep(rand(50,150));
            System.out.println("Philosopher #" + getID() + " is hungry...");
            left.pickUp(this);
            sleep(rand(5,15));
            right.pickUp(this);
            System.out.println("Philosopher #" + getID() + " is eating...");
            sleep(rand(50,150));
            right.drop();
            sleep(rand(5,15));
            left.drop();
        }
    }
}
