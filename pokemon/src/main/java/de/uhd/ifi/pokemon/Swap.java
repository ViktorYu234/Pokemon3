package de.uhd.ifi.pokemon;

import java.util.Date;

public class Swap {
    private Trainer t1, t2;
    private Pokemon p1, p2;
    private java.util.Date date;
    private String ID;
    private static int nextID = 0;

    public Trainer getTrainer(int num) {
        Trainer[] list = {t1,t2};
        return list[num];
    }

    public Pokemon getPokemon(int num) {
        Pokemon[] list = {p1,p2};
        return list[num];
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String execute(Pokemon p1, Pokemon p2) {
        if(p1 == null || p2 == null) return "Zu wenige Pokemons angegeben.";
        if(p1.getTrainer() == null) return "Pokemon " + p1.getName() + " verfügt über keinen Trainer";
        if(p2.getTrainer() == null) return "Pokemon " + p2.getName() + " verfügt über keinen Trainer";
        if(!p1.isSwapAllowed()) return "Pokemon " + p1.getName() + " ist nicht zum Tauschen freigegeben";
        if(!p2.isSwapAllowed()) return "Pokemon " + p2.getName() + " ist nicht zum Tauschen freigegeben";
        if(p1.getTrainer() == p2.getTrainer()) return "Pokemon " + p1.getName() + " kann nicht mit " + p1.getName() + " getauscht werden, da beide den Trainer " + p1.getTrainer().getName() + " haben";

        this.p1 = p1;
        this.p2 = p2;
        this.t1 = p1.getTrainer();
        this.t2 = p2.getTrainer();
        this.date = new Date();
        this.ID = Integer.toString(nextID++);
        t1.addPokemon(p2);
        t2.addPokemon(p1);
//        p1.setTrainer(t2);
//        p2.setTrainer(t1);
        p1.addSwap(this);
        p2.addSwap(this);
        return "Pokemon " + p1.getName() + " (" + t1.getName() + ") erfolgreich mit " + p2.getName() + " (" + t2.getName() + ") getauscht";
    }

    public String toString() {
        if(ID == null) return "ERROR";
        return p1.getName() + " (" + t1.getName() + ") swapped with " + p2.getName() + " (" + t2.getName() + ") on day " + date + "; ID: " + ID;
    }
}
