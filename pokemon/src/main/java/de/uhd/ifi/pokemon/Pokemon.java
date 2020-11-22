package de.uhd.ifi.pokemon;

import java.util.List;

public class Pokemon {
    private String name;
    private Type type;
    private int number;
    private static int nextNumber = 0;
    private Trainer trainer;
    private List<Swap> swaps;
    private List<Competition> competitions;
    private boolean isSwapAllowed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name; // this bezieht sich auf das aktuelle objekt
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public boolean isSwapAllowed() {
        return isSwapAllowed;
    }

    public void setSwapAllowed(boolean swapAllowed) {
        isSwapAllowed = swapAllowed;
    }

    public List<Swap> getSwaps() {
        return swaps;
    }

    public void addSwap(Swap newSwap) {
//        swaps.add(newSwap);
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void addCompetition(Competition newCompetition) {
//        competitions.add(newCompetition);
    }

    public String toString() {
        return this.name + "(num: " + this.number + "), typ:" + this.type + ", swappable:" + this.isSwapAllowed;
    }

    public Pokemon(String name, Type type, boolean swappable) {
        this.name = name;
        this.type = type;
        this.number = nextNumber++;
        this.isSwapAllowed = swappable;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}