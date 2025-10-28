
interface Engine {
    void startEngine();
}

interface MusicSystem {
    void playMusic();
}

class Car implements Engine, MusicSystem {
    public void startEngine() {
        System.out.println("Engine started: Vroom Vroom!");
    }
    public void playMusic() {
        System.out.println("Music playing: Lo-fi beats" );
    }
}

public class q4{
    public static void main(String[] args) {
        Car c = new Car();
        c.startEngine();
        c.playMusic();
    }
}
