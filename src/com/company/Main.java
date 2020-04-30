package com.company;

import com.company.GeneratingPatterns.Singleton.Singleton;
import com.company.StructuralPatterns.Round.RoundHole;
import com.company.StructuralPatterns.Round.RoundPeg;
import com.company.StructuralPatterns.Square.SquarePeg;
import com.company.StructuralPatterns.Adapters.SquarePegAdapter;

public class Main {

    public static void main(String[] args) {

    Singleton someSingleton = Singleton.getInstance();
	Singleton anotherSingleton = Singleton.getInstance();
	System.out.println(someSingleton.toString());
	System.out.println(anotherSingleton.toString());

        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Не скомпилируется.

        // Адаптер решит проблему.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }
    }
}