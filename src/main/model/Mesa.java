package main.model;

import java.util.Random;

public class Mesa {
    boolean hayPapel, hayTabaco, hayCerillas;

    public Mesa() {
    }

    public synchronized void fabricar() throws InterruptedException {
        Thread.sleep(2000);
        int aleatorio = new Random().nextInt(1,4);
        this.hayPapel = true;
        this.hayTabaco = true;
        this.hayCerillas = true;
        switch (aleatorio) {
            case 1 -> {
                this.hayPapel = false;
                System.out.println("El estanquero reparte tabaco y cerillas");
            }
            case 2 -> {
                this.hayTabaco = false;
                System.out.println("El estanquero reparte papel y cerillas");
            }
            case 3 -> {
                this.hayCerillas = false;
                System.out.println("El estanquero reparte tabaco y papel");
            }
        }
        notifyAll();
        wait();
    }
    public synchronized void fumar(Fumador fumador) throws InterruptedException {
        if (fumador.isTieneCerillas()) {
            while (!(this.hayPapel && this.hayTabaco)) wait();
        }
        else if (fumador.isTienePapel()) {
            while (!(this.hayCerillas && this.hayTabaco)) wait();
        }
        else if (fumador.isTieneTabaco()) {
            while (!(this.hayCerillas && this.hayPapel)) wait();
        }
        this.hayPapel = false;
        this.hayTabaco = false;
        this.hayCerillas = false;
        System.out.println("Fumador: " + fumador.getNombre() + " va a empezar a fumar");
        notifyAll();
    }

}

