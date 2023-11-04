package main.model;

public class Estanquero implements Runnable{
    private final Mesa mesa;

    public Estanquero(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public void run() {
        while (true) {
            try {
                mesa.fabricar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
