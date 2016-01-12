package threading;


public class Room {
    private int size;
    private Chopstick [] chopsticks;
    private Philosopher [] philosophers;
    public Room(int _size) {
        this.size = _size;
        this.chopsticks = new Chopstick[this.size];
        for (int i=0; i<this.size; ++i) {
            this.chopsticks[i] = new Chopstick(i,this.size);
        }
        this.philosophers = new Philosopher[this.size];
    }
    public void addPhilosopher(Philosopher philosopher) {
        int id = philosopher.getID();
        this.philosophers[id]=philosopher;
        philosopher.setLeftChopstick(this.chopsticks[(id+1)%this.size]);
        philosopher.setRightChopstick(this.chopsticks[id]);
    }

    public void go()
    {
        for (int i=0; i<this.size; ++i) {
            philosophers[i].go();
        }
    }
    
    public void stop()
    {
        for (int i=0; i<this.size; ++i) {
            philosophers[i].stop();
        }
    }
}
