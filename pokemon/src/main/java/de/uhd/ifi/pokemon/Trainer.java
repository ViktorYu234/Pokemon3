package de.uhd.ifi.pokemon;
import java.util.ArrayList;

public class Trainer {
    private String firstname;
    private String lastname;
    private ArrayList<Pokemon> pokemons;

    public Trainer(String first, String last, ArrayList<Pokemon> mons) {
        this.firstname = first;
        this.lastname = last;
        this.pokemons = mons;
    }

    public Trainer(String first, String last) {
        this.firstname = first;
        this.lastname = last;
        this.pokemons = new ArrayList<Pokemon>();
    }

    public String toString() {
        if (this.getPokemons().isEmpty())
            return this.firstname + " " + this.lastname;
        return this.firstname + " " + this.lastname + ":\n" + this.askPokemon();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return firstname + " " + lastname;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    // Neues Pokemon zu einem Trainer hinzufügen
    public void addPokemon(Pokemon toAdd) {
        Trainer oldTrainer = toAdd.getTrainer();
        if (oldTrainer != this) {
            if (oldTrainer != null) {
                oldTrainer.removePokemon(toAdd);
            }
            pokemons.add(toAdd);
            toAdd.setTrainer(this);
        }
    }

    public void removePokemon(Pokemon toRemove) {
        pokemons.remove(toRemove);
        toRemove.setTrainer(null);
    }

    // Abfrage von einzelnen Pokemons über den Trainer
    public String askPokemon(int num) {
        return pokemons.get(num).toString();
    }

    // Abfrage aller Pokemons eines Trainers
    public String askPokemon() {
        String text = "";
        for (Pokemon p: pokemons) {
            if (text == "")
                text = text + p.toString();
            else
                text = text + "\n" + p.toString();
        }
        return text;
    }

    // Abfrage aller Pokemons eines Trainers von einem bestimmten Type
    public String askPokemon(Type type) {
        String text = "";
        for (Pokemon p: pokemons) {
            if (p.getType() == type) {
                if (text == "")
                    text = text + p.toString();
                else
                    text = text + "\n" + p.toString();
            }
        }
        return text;
    }
}
