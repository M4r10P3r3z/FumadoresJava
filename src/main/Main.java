package main;

import main.model.Estanquero;
import main.model.Fumador;
import main.model.Mesa;

public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Estanquero estanquero = new Estanquero(mesa);
        Fumador fumador1 = new Fumador("Tiene Papel", true,
                false, false, mesa);
        Fumador fumador2 = new Fumador("Tiene Tabaco", false,
                true, false, mesa);
        Fumador fumador3 = new Fumador("Tiene Cerillas", false,
                false, true, mesa);
        new Thread(estanquero).start();
        new Thread(fumador1).start();
        new Thread(fumador2).start();
        new Thread(fumador3).start();
    }
}
