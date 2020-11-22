package de.uhd.ifi.pokemon;

import java.util.Date;

public class Competition {
    private Trainer t1, t2;
    private Pokemon p1, p2;
    private Pokemon winner;
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

    public int getStrength(Pokemon p) {
        Type type;
        type = p.getType();
        if(type == Type.WATER) return 1;
        if(type == Type.POISON) return 2;
        return 0;
    }

    public String execute(Pokemon p1, Pokemon p2) {
        if(p1 == null || p2 == null) return "Zu wenige Pokemons angegeben.";
        if(p1.getTrainer() == null) return "Pokemon " + p1.getName() + " verfügt über keinen Trainer";
        if(p2.getTrainer() == null) return "Pokemon " + p2.getName() + " verfügt über keinen Trainer";
//        if(!p1.isSwapAllowed()) return "Pokemon " + p1.getName() + " ist nicht zum Tauschen freigegeben";
//        if(!p2.isSwapAllowed()) return "Pokemon " + p2.getName() + " ist nicht zum Tauschen freigegeben";
        if(p1.getTrainer() == p2.getTrainer()) return "Pokemon " + p1.getName() + " kann kein Tunier mit " + p2.getName() + " machen, da beide den Trainer " + p1.getTrainer().getName() + " haben";

        int s1, s2;
        this.p1 = p1;
        this.p2 = p2;
        this.t1 = p1.getTrainer();
        this.t2 = p2.getTrainer();
        this.date = new Date();
        this.ID = Integer.toString(nextID++);
        s1 = getStrength(p1);
        s2 = getStrength(p2);
        if(s1 > s2 || s1 == s2 && java.lang.Math.random() < 0.5) { // p1 gewinnt
            this.winner = p1;
            t1.addPokemon(p2);
//            p2.setTrainer(t1);
            p2.addCompetition(this);
            return "Pokemon " + p1.getName() + " (" + t1.getName() + ") hat das Tunier gegen " + p2.getName() + " (" + t2.getName() + ") gewonnen";
        }
        else { // p2 gewinnt
            this.winner = p2;
            t2.addPokemon(p1);
//            p1.setTrainer(t2);
            p1.addCompetition(this);
            return "Pokemon " + p2.getName() + " (" + t2.getName() + ") hat das Tunier gegen " + p1.getName() + " (" + t1.getName() + ") gewonnen";
        }
    }

    public String toString() {
        if(ID == null) return "ERROR";
        return p1.getName() + " (" + t1.getName() + ") competited against " + p2.getName() + " (" + t2.getName() + ") on day " + date + ", " + winner.getName() + " won the competition; ID: " + ID;
    }
}
