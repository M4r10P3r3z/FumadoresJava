package main.model;

import java.util.concurrent.ThreadLocalRandom;

public class Fumador implements Runnable {
    private final String nombre;
    private final boolean tienePapel,  tieneTabaco, tieneCerillas;
    private final Mesa mesa;
    public Fumador(String nombre, boolean tienePapel, boolean tieneTabaco,
                   boolean tieneCerillas, Mesa mesa) {
        this.nombre = nombre;
        this.tienePapel = tienePapel;
        this.tieneTabaco = tieneTabaco;
        this.tieneCerillas = tieneCerillas;
        this.mesa = mesa;
    }

    public String getNombre() {
        return nombre;
    }


    public boolean isTienePapel() {
        return tienePapel;
    }

    public boolean isTieneTabaco() {
        return tieneTabaco;
    }

    public boolean isTieneCerillas() {
        return tieneCerillas;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Fumador: " + this.nombre +" quiere fumar");
            try {
                mesa.fumar(this);
                int tiempo = ThreadLocalRandom.current().nextInt(1, 4);
                System.out.println("Fumador: " + this.nombre +" ha terminado de fumar y va a " +
                        "descansar " + tiempo +" segundos");
                Thread.sleep(tiempo*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
