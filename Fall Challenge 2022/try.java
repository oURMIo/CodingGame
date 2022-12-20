import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        
        int startEnemyX = 0;
        int startEnemyY = 0;
        boolean firstCursEnemy = true;

        int startMeX = 0;
        int startMeY = 0;
        boolean firstCursMe = true;

        int buildX = 0;
        int buildY = 0;

        // game loop
        while (true) {
            int myMatter = in.nextInt();    // IT's how many gear y have
            int oppMatter = in.nextInt();   // IT's how many gear Ename have
           
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int scrapAmount = in.nextInt();
                    int owner = in.nextInt(); // 1 = me, 0 = foe, -1 = neutral
                    int units = in.nextInt();
                    int recycler = in.nextInt();
                    int canBuild = in.nextInt();
                    int canSpawn = in.nextInt();
                    int inRangeOfRecycler = in.nextInt();   //Don't know

                    if(firstCursEnemy && owner == 0){
                        firstCursEnemy = false;
                        startEnemyX = x;
                        startEnemyY = y+1;
                    }

                    if(firstCursMe && owner == 1){
                        firstCursMe = false;
                        startMeX = x;
                        startMeY = y+1;
                    }

                    if(canBuild==1){
                        System.err.println("x y - "+x+" "+y);
                        buildX = x;
                        buildY = y;
                    }

                }
            }

            // Write For Me
            System.err.println(" Enemy start - " + startEnemyX + " " + startEnemyY);
            System.err.println(" Me start - " + startMeX + " " + startMeY);
            
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            // System.out.println("BUILD 1 1");

            System.out.println("BUILD "+buildX +" "+buildY);
            System.out.println("WAIT");
        }
    }
}