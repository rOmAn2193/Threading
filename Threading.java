package threading;

import static threading.Tools.sleep;

public class Threading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 3;
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }

        Room room = new Room(n);

        for (int i = 0; i < n; ++i) {
            Philosopher p = new Philosopher(i, n);
            room.addPhilosopher(p);
        }

        room.go();
        sleep(10000);
        room.stop();
        // TODO code application logic here
    }

}
