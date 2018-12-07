import java.util.Scanner;

public class Lmao {

    public static void main( String[] args ) {

        Scanner scan = new Scanner( System.in );

        System.out.println("Genome Thingy, idk");
        System.out.println("--------------------------");
        System.out.println("Enter Genome: ");
        String genome = scan.next();

        boolean foundStart = false;
        int startloc = -1;
        boolean foundEnd = false;

        int endLoc = -1;

        for ( int i = 0; i < genome.length() - 3; i += 3 ) {
            if ( genome.substring( i, i + 3 ).equalsIgnoreCase( "ATG" ) && !foundStart ) {
                foundStart = true;
                startloc = i;
                System.out.println( genome.substring( i, i + 3 ) );
            } else if ( genome.substring( i, i + 3 ).equalsIgnoreCase( "agg" )  ){
                foundEnd = true;
                endLoc = i;
                System.out.println( genome.substring( i, i + 3 ) );
            }
        }

        if ( startloc >= 0 && endLoc >= 0 ) {
            if ( endLoc - ( startloc + 2 ) % 3 == 0) {
                System.out.println( genome.substring( startloc, endLoc + 3 ) );
            }
        }


    }
}
