import java.util.*;
import java.io.*;
import java.math.*;

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

        int spawnX = 0;
        int spawnY = 0;

        // game loop
        while (true) {
            int myMatter = in.nextInt();    // IT's how many gear y have
            int oppMatter = in.nextInt();   // IT's how many gear Ename have

            boolean canSpawnFlag = false;
            boolean canBuildFlag = false;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int scrapAmount = in.nextInt();
                    int owner = in.nextInt(); // 1 = me, 0 = foe, -1 = neutral
                    int units = in.nextInt();
                    int recycler = in.nextInt();
                    int canBuild = in.nextInt();
                    int canSpawn = in.nextInt();
                    int inRangeOfRecycler = in.nextInt();

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
                        System.err.println("canBuild x y - "+x+" "+y);
                        buildX = x;
                        buildY = y;
                        canBuildFlag = true;
                    }

                    if(canSpawn==1){
                        System.err.println("canSpawn x y - "+x+" "+y);
                        spawnX = x;
                        spawnY = y;
                        canSpawnFlag = true;
                    }
                }
            }

            // Write For Me
/*
            System.err.println(" Enemy start - " + startEnemyX + " " + startEnemyY);
            System.err.println(" Me start - " + startMeX + " " + startMeY);
*/
            
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            // System.out.println("BUILD 1 1");

            String action = "";
            
            if (canSpawnFlag) {
                action = action + ("SPAWN 1 " + spawnX + " " + spawnY + ";");
            }
            
            if (canBuildFlag) {
                action = action + ("BUILD " + buildX + " " + buildY + ";");
            }


            action = action + ("MOVE 1 " + startMeX + " " + (startMeY - 1) + " " + startEnemyX + " " + (startEnemyY - 1));
            System.out.println(action);
        }
    }
}