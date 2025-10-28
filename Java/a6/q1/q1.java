package Java.a6.q1;
abstract class Bank {
    abstract double getROI(); // abstract method
}

class SBI extends Bank {
    @Override
    double getROI() {
        return 6.5; // SBI rate
    }
}

class PNB extends Bank {
    @Override
    double getROI() {
        return 7.0; // PNB rate
    }
}

class BOI extends Bank {
    @Override
    double getROI() {
        return 6.8; // BOI rate
    }
}

public class q1 {
    public static void main(String[] args) {
        Bank bank; // super class reference

        bank = new SBI();
        System.out.println("SBI Rate of Interest: " + bank.getROI() + "%");

        bank = new PNB();
        System.out.println("PNB Rate of Interest: " + bank.getROI() + "%");

        bank = new BOI();
        System.out.println("BOI Rate of Interest: " + bank.getROI() + "%");
    }
}
