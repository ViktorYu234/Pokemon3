package de.uhd.ifi.pokemon;

public class PokemonTest {

    public static void main(String[] args) {
        Pokemon p1 = new Pokemon("Javamon",Type.FIRE,false);

        // Test of getter of name
        System.out.println("Testen von getName");
        System.out.println("Name von Pokemon p1:");
        System.out.println(p1.getName());

        System.out.println();
        System.out.println("Testen von getType");
        System.out.println("Typ von Pokemon p1:");
        System.out.println(p1.getType());

        System.out.println();
        System.out.println("Testen von setName");
        p1.setName("p1 Androidmon");
        System.out.println("Name von Pokemon p1:");
        System.out.println(p1.getName());

        System.out.println();
        System.out.println("Testen von setType");
        p1.setType(Type.POISON);
        System.out.println("Typ von Pokemon p1:");
        System.out.println(p1.getType());

        System.out.println();
        System.out.println("Testen von toString");
        System.out.println(p1);

        Pokemon p2;
        p2 = new Pokemon("p2 Eclipsemon",Type.WATER,false);

        System.out.println();
        System.out.println("Testen von p2 num");
        System.out.println(p2);

        Trainer t1 = new Trainer("Maria", "Lustig");

        System.out.println();
        System.out.println("Testen von t1 Trainer");
        System.out.println(t1);

        t1.addPokemon(p1);

        System.out.println();
        System.out.println("Testen von hinzufügen von p1 zu t1");
        System.out.println(t1);

        t1.addPokemon(p2);

        System.out.println();
        System.out.println("Testen von hinzufügen von p2 zu t1");
        System.out.println(t1);

        System.out.println();
        System.out.println("Testen von ask Type.WATER von t1");
        System.out.println(t1.askPokemon(Type.WATER));

        Trainer t2 = new Trainer("Manuel", "Hart");
        t2.addPokemon(p1);

        System.out.println();
        System.out.println("Testen von hinzufügen von p1 zu t2");
        System.out.println(t1);
        System.out.println(t2);

        Pokemon p3 = new Pokemon("p3 Swappermon",Type.FIRE,true);
        Pokemon p4 = new Pokemon("p4 Changemon",Type.POISON,true);
        t1.addPokemon(p3);
        t2.addPokemon(p4);

        Swap swap = new Swap();

        System.out.println();
        System.out.println("Testen von swap von p1 mit p2 (nicht swappable)");
        System.out.println(swap.execute(p1,p2));
        System.out.println(swap);

        swap = new Swap();

        System.out.println();
        System.out.println("Testen von swap von p3 mit p3 (gleicher Trainer)");
        System.out.println(swap.execute(p3,p3));
        System.out.println(swap);

        swap = new Swap();

        System.out.println();
        System.out.println("Testen von swap von p3 mit p4");
        System.out.println(swap.execute(p3,p4));
        System.out.println(swap);

        System.out.println();
        System.out.println(t1);
        System.out.println(t2);

        System.out.println();
        System.out.println("Testen von competition von p2 mit p4");
        Competition competition = new Competition();
        System.out.println();
        System.out.println(competition.execute(p2,p4));
        System.out.println(competition);
        System.out.println();
        System.out.println(t1);
        System.out.println(t2);

        System.out.println();
        System.out.println("Testen von competition von p3 mit p4");
        competition = new Competition();
        System.out.println();
        System.out.println(competition.execute(p3,p4));
        System.out.println(competition);
        System.out.println();
        System.out.println(t1);
        System.out.println(t2);

        System.out.println();
        System.out.println("Testen von competition von p1 mit p4");
        competition = new Competition();
        System.out.println();
        System.out.println(competition.execute(p1,p4));
        System.out.println(competition);
        System.out.println();
        System.out.println(t1);
        System.out.println(t2);
    }
}