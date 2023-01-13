import java.util.*;

class Field {
    int x;
    int y;
    boolean blue;
    int countUnit;

    public Field(int x, int y, boolean blue, int countUnit) {
        this.x = x;
        this.y = y;
        this.blue = blue;
        this.countUnit = countUnit;
    }
}

class Player {
    public static String moveUnit(int blueX, int blueY, int redX, int redY) {
        return "MOVE 1 "
                + blueX + " "
                + blueY + " "
                + redX + " "
                + redY + ";";
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();

        int buildX = 0;
        int buildY = 0;
        int spawnX = 0;
        int spawnY = 0;

        int enemyX = 0;
        int enemyY = 0;
        int meX = 0;
        int meY = 0;

        Field[] fieldsBlue = new Field[40];
        Field[] fieldsRed = new Field[40];
        int countBlue = 0;
        int countRed = 0;

        // game loop
        while (true) {
            int myMatter = in.nextInt();    // IT's how many gear y have
            int oppMatter = in.nextInt();   // IT's how many gear Ename have
            StringBuilder action = new StringBuilder();
            countBlue = countRed = 0;

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
                    if (owner == 0) {
                        fieldsRed[countRed] = new Field(x, y, false, units);
                        countRed++;
                    }

                    /*  Find Me   */
                    if (owner == 1 && units > 0) {
                        fieldsBlue[countBlue] = new Field(x, y, true, units);
                        countBlue++;
                    }

                    if (canSpawn == 1) {
                        spawnX = x;
                        spawnY = y;
                        canSpawnFlag = true;
                    }
                }
            }

            if (canSpawnFlag) {
                action.append("SPAWN 1 ").append(spawnX).append(" ").append(spawnY).append(";");
            }

            if (canBuildFlag) {
                action.append("BUILD ").append(buildX).append(" ").append(buildY).append(";");
            }

            for (int i = 0; i < countBlue; i++) {
                action.append(moveUnit(fieldsBlue[i].x, fieldsBlue[i].y, fieldsRed[i].x, fieldsRed[i].y));
            }
            System.out.println(action);
        }
    }
}
