import java.util.*;
import java.io.*;
import java.math.*;

class Unit {
    boolean blueTeam;
    int nowX;
    int nowY;
    int count;
    int moveX;
    int moveY;

    public Unit(boolean blueTeam) {
        nowX = 0;
        nowY = 0;
        count = 0;
        moveX = 0;
        moveY = 0;
        this.blueTeam = blueTeam;
    }

    public int getNowX() {
        return nowX;
    }

    public void setNowX(int nowX) {
        this.nowX = nowX;
    }

    public int getNowY() {
        return nowY;
    }

    public void setNowY(int nowY) {
        this.nowY = nowY;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMoveX() {
        return moveX;
    }

    public void setMoveX(int moveX) {
        this.moveX = moveX;
    }

    public int getMoveY() {
        return moveY;
    }

    public void setMoveY(int moveY) {
        this.moveY = moveY;
    }
}

class Player {
    public static String moveUnit(Unit unitBlue, Unit unitRed) {
        String moveUnits = "MOVE 1 "
                + unitBlue.getNowX() + " "
                + unitBlue.getNowY() + " "
                + unitRed.getNowX() + " "
                + unitRed.getNowY();
        return moveUnits;
    }

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
            Unit unitBlue1 = new Unit(true);
            Unit unitRed1 = new Unit(false);

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

                    /*  Find Enemy  */
//                    if (firstCursEnemy && owner == 0) {
                    if (owner == 0) {
//                        firstCursEnemy = false;
//                        startEnemyX = x;
//                        startEnemyY = y + 1;
//                        /*  set for unitRed1   */
                        unitRed1.setNowX(x);
                        unitRed1.setNowY(y);
                        unitRed1.setCount(units);
                    }

                    /*  Find Me   */
//                    if (firstCursMe && owner == 1) {
                    if ( owner == 1) {
//                        firstCursMe = false;
//                        startMeX = x;
//                        startMeY = y + 1;
                        /*  set for unitBlue1   */
                        unitBlue1.setNowX(x);
                        unitBlue1.setNowY(y);
                        unitBlue1.setCount(units);
                    }

                    /*   Set X & Y For Build   */
                    if (canBuild == 1) {
                        System.err.println("canBuild x y - " + x + " " + y);
                        buildX = x;
                        buildY = y;
                        canBuildFlag = true;
                    }

                    /*   Set X & Y For Spawn   */
                    if (canSpawn == 1) {
                        System.err.println("canSpawn x y - " + x + " " + y);
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

            String action = "";

            if (canSpawnFlag) {
                action = action + ("SPAWN 1 " + spawnX + " " + spawnY + ";");
            }

            if (canBuildFlag) {
                action = action + ("BUILD " + buildX + " " + buildY + ";");
            }

            action = action + moveUnit(unitBlue1, unitRed1);
            System.out.println(action);
        }
    }
}