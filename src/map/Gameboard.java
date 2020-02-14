/**
 * @author AB
 */
package map;

/**
 * Classe qui fait office de carte de la simulation
 * @author Aristide Boisgontier & Isaë Le Moigne
 * @date 06/02/2020
 */

public class Gameboard {

    private int tailleX;
    private int tailleY;
    private Cell[][] gameboard;

    public Gameboard() {
        this.tailleX = 21;
        this.tailleY = 21;
        gameboard = new Cell[tailleX][tailleY];

        for (int i = 0; i < tailleX; i++) {
            for (int j = 0; j < tailleY; j++) {
                Coordinate coordinate = new Coordinate(j, i);
                gameboard[i][j] = new Cell(map.TypeCase.IMPASSABLE_AREA,0,false, coordinate,0,0,0);
            }
        }

    }

    public void setValueOfWaterCells(){
        for (int i = 0; i < tailleX; i++) {
            for (int j = 0; j < tailleY; j++) {
                if (gameboard[i][j].getType().equals(TypeCase.WATER)){
                    gameboard[i][j].setWaterNb(200000);
                }
            }
        }
    }

    public void setValueOfFoodCells(){
        for (int i = 0; i < tailleX; i++) {
            for (int j = 0; j < tailleY; j++) {
                if (gameboard[i][j].getType().equals(TypeCase.FOOD)){
                    gameboard[i][j].setFoodNb(100);
                }
            }
        }
    }

    public void setValueOfOreCells(){
        for (int i = 0; i < tailleX; i++) {
            for (int j = 0; j < tailleY; j++) {
                if (gameboard[i][j].getType().equals(TypeCase.ORE)){
                    gameboard[i][j].setFoodNb(100);
                }
            }
        }
    }

    public int getTailleX() {
        return tailleX;
    }

    public void setTailleX(int tailleX) {
        this.tailleX = tailleX;
    }

    public int getTailleY() {
        return tailleY;
    }

    public void setTailleY(int tailleY) {
        this.tailleY = tailleY;
    }

    public Cell[][] getGameboard() {
        return gameboard;
    }

    public void setGameboard(Cell[][] gameboard) {
        this.gameboard = gameboard;
    }

    public void initializeWaterGameBoard(){
        gameboard[0][0].setType(TypeCase.WATER);
        gameboard[0][1].setType(TypeCase.WATER);
        gameboard[0][2].setType(TypeCase.WATER);
        gameboard[0][3].setType(TypeCase.WATER);
        gameboard[1][0].setType(TypeCase.WATER);
        gameboard[2][0].setType(TypeCase.WATER);
        gameboard[3][0].setType(TypeCase.WATER);
        gameboard[1][1].setType(TypeCase.WATER);
        gameboard[10][3].setType(TypeCase.WATER);
        gameboard[10][4].setType(TypeCase.WATER);
        gameboard[11][4].setType(TypeCase.WATER);
        gameboard[19][2].setType(TypeCase.WATER);
        gameboard[19][4].setType(TypeCase.WATER);
        gameboard[18][4].setType(TypeCase.WATER);
        gameboard[20][4].setType(TypeCase.WATER);
        gameboard[19][5].setType(TypeCase.WATER);
        gameboard[18][5].setType(TypeCase.WATER);
        gameboard[17][5].setType(TypeCase.WATER);
        gameboard[18][6].setType(TypeCase.WATER);
        gameboard[17][6].setType(TypeCase.WATER);
        gameboard[16][6].setType(TypeCase.WATER);
        gameboard[17][7].setType(TypeCase.WATER);
        gameboard[20][10].setType(TypeCase.WATER);
        gameboard[19][10].setType(TypeCase.WATER);
        gameboard[19][11].setType(TypeCase.WATER);
        gameboard[18][11].setType(TypeCase.WATER);
        gameboard[18][12].setType(TypeCase.WATER);
        gameboard[16][11].setType(TypeCase.WATER);
        gameboard[15][12].setType(TypeCase.WATER);
        gameboard[9][11].setType(TypeCase.WATER);
        gameboard[3][12].setType(TypeCase.WATER);
        gameboard[5][13].setType(TypeCase.WATER);
        gameboard[5][14].setType(TypeCase.WATER);
        gameboard[5][15].setType(TypeCase.WATER);
        gameboard[4][15].setType(TypeCase.WATER);
        gameboard[0][19].setType(TypeCase.WATER);
        gameboard[2][20].setType(TypeCase.WATER);
        gameboard[3][19].setType(TypeCase.WATER);
        gameboard[4][19].setType(TypeCase.WATER);
        gameboard[20][20].setType(TypeCase.WATER);
        gameboard[19][20].setType(TypeCase.WATER);
        gameboard[18][20].setType(TypeCase.WATER);
        gameboard[17][20].setType(TypeCase.WATER);
        gameboard[20][19].setType(TypeCase.WATER);
        gameboard[19][19].setType(TypeCase.WATER);
        gameboard[20][18].setType(TypeCase.WATER);
        gameboard[19][18].setType(TypeCase.WATER);
        gameboard[18][18].setType(TypeCase.WATER);
        gameboard[20][17].setType(TypeCase.WATER);
        gameboard[11][3].setType(TypeCase.WATER);
        gameboard[12][4].setType(TypeCase.WATER);
        gameboard[8][19].setType(TypeCase.WATER);
        gameboard[9][19].setType(TypeCase.WATER);
    }

    public void initializeBaseGameBoard(){
        gameboard[10][10].setType(TypeCase.BASE);
    }

    public void initializeOreGameBoard(){
        gameboard[19][0].setType(TypeCase.ORE);
        gameboard[5][6].setType(TypeCase.ORE);
        gameboard[3][7].setType(TypeCase.ORE);
        gameboard[11][14].setType(TypeCase.ORE);
        gameboard[16][19].setType(TypeCase.ORE);
    }

    public void initializeFoodGameBoard(){
        gameboard[18][1].setType(TypeCase.FOOD);
        gameboard[20][3].setType(TypeCase.FOOD);
        gameboard[14][4].setType(TypeCase.FOOD);
        gameboard[13][5].setType(TypeCase.FOOD);
        gameboard[17][8].setType(TypeCase.FOOD);
        gameboard[14][12].setType(TypeCase.FOOD);
        gameboard[15][13].setType(TypeCase.FOOD);
        gameboard[9][13].setType(TypeCase.FOOD);
        gameboard[4][13].setType(TypeCase.FOOD);
        gameboard[4][14].setType(TypeCase.FOOD);
        gameboard[3][14].setType(TypeCase.FOOD);
        gameboard[2][15].setType(TypeCase.FOOD);
        gameboard[1][15].setType(TypeCase.FOOD);
        gameboard[18][16].setType(TypeCase.FOOD);
        gameboard[5][20].setType(TypeCase.FOOD);
    }

    public void initializeTreeGameBoard(){
        gameboard[0][10].setType(TypeCase.TREE);
        gameboard[0][11].setType(TypeCase.TREE);
        gameboard[0][12].setType(TypeCase.TREE);
        gameboard[0][13].setType(TypeCase.TREE);
        gameboard[20][12].setType(TypeCase.TREE);
        gameboard[19][12].setType(TypeCase.TREE);
        gameboard[20][13].setType(TypeCase.TREE);
        gameboard[19][13].setType(TypeCase.TREE);
        gameboard[18][13].setType(TypeCase.TREE);
        gameboard[17][13].setType(TypeCase.TREE);
        gameboard[16][13].setType(TypeCase.TREE);
        gameboard[19][14].setType(TypeCase.TREE);
        gameboard[18][14].setType(TypeCase.TREE);
        gameboard[17][14].setType(TypeCase.TREE);
        gameboard[16][14].setType(TypeCase.TREE);
        gameboard[15][14].setType(TypeCase.TREE);
        gameboard[18][15].setType(TypeCase.TREE);
        gameboard[16][15].setType(TypeCase.TREE);
        gameboard[15][15].setType(TypeCase.TREE);
    }

    public void initializeDryMedow(){
        gameboard[4][0].setType(TypeCase.DRY_MEDOW);
        gameboard[4][1].setType(TypeCase.DRY_MEDOW);
        gameboard[3][1].setType(TypeCase.DRY_MEDOW);
        gameboard[2][1].setType(TypeCase.DRY_MEDOW);
        gameboard[1][2].setType(TypeCase.DRY_MEDOW);
        gameboard[13][0].setType(TypeCase.DRY_MEDOW);
        gameboard[14][0].setType(TypeCase.DRY_MEDOW);
        gameboard[15][0].setType(TypeCase.DRY_MEDOW);
        gameboard[17][0].setType(TypeCase.DRY_MEDOW);
        gameboard[18][0].setType(TypeCase.DRY_MEDOW);
        gameboard[10][1].setType(TypeCase.DRY_MEDOW);
        gameboard[14][1].setType(TypeCase.DRY_MEDOW);
        gameboard[16][1].setType(TypeCase.DRY_MEDOW);
        gameboard[17][1].setType(TypeCase.DRY_MEDOW);
        gameboard[5][2].setType(TypeCase.DRY_MEDOW);
        gameboard[9][2].setType(TypeCase.DRY_MEDOW);
        gameboard[4][3].setType(TypeCase.DRY_MEDOW);
        gameboard[5][3].setType(TypeCase.DRY_MEDOW);
        gameboard[9][3].setType(TypeCase.DRY_MEDOW);
        gameboard[0][4].setType(TypeCase.DRY_MEDOW);
        gameboard[4][4].setType(TypeCase.DRY_MEDOW);
        gameboard[5][4].setType(TypeCase.DRY_MEDOW);
        gameboard[6][4].setType(TypeCase.DRY_MEDOW);
        gameboard[8][4].setType(TypeCase.DRY_MEDOW);
        gameboard[9][4].setType(TypeCase.DRY_MEDOW);
        gameboard[0][5].setType(TypeCase.DRY_MEDOW);
        gameboard[1][5].setType(TypeCase.DRY_MEDOW);
        gameboard[7][5].setType(TypeCase.DRY_MEDOW);
        gameboard[8][5].setType(TypeCase.DRY_MEDOW);
        gameboard[9][5].setType(TypeCase.DRY_MEDOW);
        gameboard[1][6].setType(TypeCase.DRY_MEDOW);
        gameboard[0][7].setType(TypeCase.DRY_MEDOW);
        gameboard[1][7].setType(TypeCase.DRY_MEDOW);
        gameboard[1][8].setType(TypeCase.DRY_MEDOW);
        gameboard[2][8].setType(TypeCase.DRY_MEDOW);
        gameboard[3][8].setType(TypeCase.DRY_MEDOW);
        gameboard[4][8].setType(TypeCase.DRY_MEDOW);
        gameboard[9][8].setType(TypeCase.DRY_MEDOW);
        gameboard[11][8].setType(TypeCase.DRY_MEDOW);
        gameboard[0][9].setType(TypeCase.DRY_MEDOW);
        gameboard[2][9].setType(TypeCase.DRY_MEDOW);
        gameboard[3][9].setType(TypeCase.DRY_MEDOW);
        gameboard[4][9].setType(TypeCase.DRY_MEDOW);
        gameboard[5][9].setType(TypeCase.DRY_MEDOW);
        gameboard[6][9].setType(TypeCase.DRY_MEDOW);
        gameboard[1][10].setType(TypeCase.DRY_MEDOW);
        gameboard[3][10].setType(TypeCase.DRY_MEDOW);
        gameboard[4][10].setType(TypeCase.DRY_MEDOW);
        gameboard[5][10].setType(TypeCase.DRY_MEDOW);
        gameboard[15][10].setType(TypeCase.DRY_MEDOW);
        gameboard[16][10].setType(TypeCase.DRY_MEDOW);
        gameboard[3][11].setType(TypeCase.DRY_MEDOW);
        gameboard[6][11].setType(TypeCase.DRY_MEDOW);
        gameboard[7][11].setType(TypeCase.DRY_MEDOW);
        gameboard[2][12].setType(TypeCase.DRY_MEDOW);
        gameboard[4][12].setType(TypeCase.DRY_MEDOW);
        gameboard[5][12].setType(TypeCase.DRY_MEDOW);
        gameboard[7][12].setType(TypeCase.DRY_MEDOW);
        gameboard[14][14].setType(TypeCase.DRY_MEDOW);
        gameboard[13][15].setType(TypeCase.DRY_MEDOW);
        gameboard[0][16].setType(TypeCase.DRY_MEDOW);
        gameboard[1][16].setType(TypeCase.DRY_MEDOW);
        gameboard[4][16].setType(TypeCase.DRY_MEDOW);
        gameboard[5][16].setType(TypeCase.DRY_MEDOW);
        gameboard[19][16].setType(TypeCase.DRY_MEDOW);
        gameboard[20][16].setType(TypeCase.DRY_MEDOW);
        gameboard[16][17].setType(TypeCase.DRY_MEDOW);
        gameboard[8][20].setType(TypeCase.DRY_MEDOW);
        gameboard[9][20].setType(TypeCase.DRY_MEDOW);
        gameboard[16][20].setType(TypeCase.DRY_MEDOW);
    }

    public void initializeNormalMedow(){
        gameboard[17][2].setType(TypeCase.NORMAL_MEDOW);
        gameboard[17][3].setType(TypeCase.NORMAL_MEDOW);
        gameboard[17][4].setType(TypeCase.NORMAL_MEDOW);
        gameboard[16][4].setType(TypeCase.NORMAL_MEDOW);
        gameboard[15][4].setType(TypeCase.NORMAL_MEDOW);
        gameboard[15][5].setType(TypeCase.NORMAL_MEDOW);
        gameboard[20][5].setType(TypeCase.NORMAL_MEDOW);
        gameboard[7][6].setType(TypeCase.NORMAL_MEDOW);
        gameboard[8][6].setType(TypeCase.NORMAL_MEDOW);
        gameboard[9][6].setType(TypeCase.NORMAL_MEDOW);
        gameboard[19][6].setType(TypeCase.NORMAL_MEDOW);
        gameboard[8][7].setType(TypeCase.NORMAL_MEDOW);
        gameboard[18][7].setType(TypeCase.NORMAL_MEDOW);
        gameboard[10][8].setType(TypeCase.NORMAL_MEDOW);
        gameboard[12][8].setType(TypeCase.NORMAL_MEDOW);
        gameboard[13][8].setType(TypeCase.NORMAL_MEDOW);
        gameboard[19][8].setType(TypeCase.NORMAL_MEDOW);
        gameboard[20][8].setType(TypeCase.NORMAL_MEDOW);
        gameboard[19][9].setType(TypeCase.NORMAL_MEDOW);
        gameboard[20][9].setType(TypeCase.NORMAL_MEDOW);
        gameboard[18][10].setType(TypeCase.NORMAL_MEDOW);
        gameboard[12][11].setType(TypeCase.NORMAL_MEDOW);
        gameboard[15][11].setType(TypeCase.NORMAL_MEDOW);
        gameboard[17][11].setType(TypeCase.NORMAL_MEDOW);
        gameboard[20][11].setType(TypeCase.NORMAL_MEDOW);
        gameboard[12][12].setType(TypeCase.NORMAL_MEDOW);
        gameboard[13][12].setType(TypeCase.NORMAL_MEDOW);
        gameboard[16][12].setType(TypeCase.NORMAL_MEDOW);
        gameboard[17][12].setType(TypeCase.NORMAL_MEDOW);
        gameboard[3][13].setType(TypeCase.NORMAL_MEDOW);
        gameboard[13][13].setType(TypeCase.NORMAL_MEDOW);
        gameboard[14][13].setType(TypeCase.NORMAL_MEDOW);
        gameboard[13][14].setType(TypeCase.NORMAL_MEDOW);
        gameboard[14][15].setType(TypeCase.NORMAL_MEDOW);
        gameboard[20][15].setType(TypeCase.NORMAL_MEDOW);
        gameboard[14][16].setType(TypeCase.NORMAL_MEDOW);
        gameboard[0][17].setType(TypeCase.NORMAL_MEDOW);
        gameboard[1][17].setType(TypeCase.NORMAL_MEDOW);
        gameboard[2][17].setType(TypeCase.NORMAL_MEDOW);
        gameboard[3][17].setType(TypeCase.NORMAL_MEDOW);
        gameboard[11][17].setType(TypeCase.NORMAL_MEDOW);
        gameboard[12][17].setType(TypeCase.NORMAL_MEDOW);
        gameboard[18][17].setType(TypeCase.NORMAL_MEDOW);
        gameboard[19][17].setType(TypeCase.NORMAL_MEDOW);
        gameboard[1][18].setType(TypeCase.NORMAL_MEDOW);
        gameboard[8][18].setType(TypeCase.NORMAL_MEDOW);
        gameboard[10][19].setType(TypeCase.NORMAL_MEDOW);
        gameboard[7][20].setType(TypeCase.NORMAL_MEDOW);
        gameboard[4][17].setType(TypeCase.NORMAL_MEDOW);
    }

    public void initializeOilyMedow(){
        gameboard[5][0].setType(TypeCase.OILY_MEDOW);
        gameboard[12][0].setType(TypeCase.OILY_MEDOW);
        gameboard[16][0].setType(TypeCase.OILY_MEDOW);
        gameboard[5][1].setType(TypeCase.OILY_MEDOW);
        gameboard[11][1].setType(TypeCase.OILY_MEDOW);
        gameboard[12][1].setType(TypeCase.OILY_MEDOW);
        gameboard[13][1].setType(TypeCase.OILY_MEDOW);
        gameboard[15][1].setType(TypeCase.OILY_MEDOW);
        gameboard[2][2].setType(TypeCase.OILY_MEDOW);
        gameboard[3][2].setType(TypeCase.OILY_MEDOW);
        gameboard[4][2].setType(TypeCase.OILY_MEDOW);
        gameboard[10][2].setType(TypeCase.OILY_MEDOW);
        gameboard[11][2].setType(TypeCase.OILY_MEDOW);
        gameboard[12][2].setType(TypeCase.OILY_MEDOW);
        gameboard[13][2].setType(TypeCase.OILY_MEDOW);
        gameboard[14][2].setType(TypeCase.OILY_MEDOW);
        gameboard[15][2].setType(TypeCase.OILY_MEDOW);
        gameboard[16][2].setType(TypeCase.OILY_MEDOW);
        gameboard[2][3].setType(TypeCase.OILY_MEDOW);
        gameboard[3][3].setType(TypeCase.OILY_MEDOW);
        gameboard[10][3].setType(TypeCase.OILY_MEDOW);
        gameboard[12][3].setType(TypeCase.OILY_MEDOW);
        gameboard[13][3].setType(TypeCase.OILY_MEDOW);
        gameboard[14][3].setType(TypeCase.OILY_MEDOW);
        gameboard[15][3].setType(TypeCase.OILY_MEDOW);
        gameboard[16][3].setType(TypeCase.OILY_MEDOW);
        gameboard[10][4].setType(TypeCase.OILY_MEDOW);
        gameboard[13][4].setType(TypeCase.OILY_MEDOW);
        gameboard[2][5].setType(TypeCase.OILY_MEDOW);
        gameboard[6][5].setType(TypeCase.OILY_MEDOW);
        gameboard[10][5].setType(TypeCase.OILY_MEDOW);
        gameboard[11][5].setType(TypeCase.OILY_MEDOW);
        gameboard[12][5].setType(TypeCase.OILY_MEDOW);
        gameboard[14][5].setType(TypeCase.OILY_MEDOW);
        gameboard[0][6].setType(TypeCase.OILY_MEDOW);
        gameboard[6][6].setType(TypeCase.OILY_MEDOW);
        gameboard[10][6].setType(TypeCase.OILY_MEDOW);
        gameboard[11][6].setType(TypeCase.OILY_MEDOW);
        gameboard[12][6].setType(TypeCase.OILY_MEDOW);
        gameboard[13][6].setType(TypeCase.OILY_MEDOW);
        gameboard[14][6].setType(TypeCase.OILY_MEDOW);
        gameboard[15][6].setType(TypeCase.OILY_MEDOW);
        gameboard[8][6].setType(TypeCase.OILY_MEDOW);
        gameboard[18][8].setType(TypeCase.OILY_MEDOW);
        gameboard[16][8].setType(TypeCase.OILY_MEDOW);
        gameboard[9][7].setType(TypeCase.OILY_MEDOW);
        gameboard[10][7].setType(TypeCase.OILY_MEDOW);
        gameboard[11][7].setType(TypeCase.OILY_MEDOW);
        gameboard[12][7].setType(TypeCase.OILY_MEDOW);
        gameboard[13][7].setType(TypeCase.OILY_MEDOW);
        gameboard[14][7].setType(TypeCase.OILY_MEDOW);
        gameboard[15][7].setType(TypeCase.OILY_MEDOW);
        gameboard[19][7].setType(TypeCase.OILY_MEDOW);
        gameboard[20][7].setType(TypeCase.OILY_MEDOW);
        gameboard[20][6].setType(TypeCase.OILY_MEDOW);
        gameboard[0][8].setType(TypeCase.OILY_MEDOW);
        gameboard[8][8].setType(TypeCase.OILY_MEDOW);
        gameboard[1][9].setType(TypeCase.OILY_MEDOW);
        gameboard[8][9].setType(TypeCase.OILY_MEDOW);
        gameboard[9][9].setType(TypeCase.OILY_MEDOW);
        gameboard[11][9].setType(TypeCase.OILY_MEDOW);
        gameboard[12][9].setType(TypeCase.OILY_MEDOW);
        gameboard[15][9].setType(TypeCase.OILY_MEDOW);
        gameboard[16][9].setType(TypeCase.OILY_MEDOW);
        gameboard[17][9].setType(TypeCase.OILY_MEDOW);
        gameboard[18][9].setType(TypeCase.OILY_MEDOW);
        gameboard[2][10].setType(TypeCase.OILY_MEDOW);
        gameboard[9][10].setType(TypeCase.OILY_MEDOW);
        gameboard[13][10].setType(TypeCase.OILY_MEDOW);
        gameboard[14][10].setType(TypeCase.OILY_MEDOW);
        gameboard[17][10].setType(TypeCase.OILY_MEDOW);
        gameboard[1][11].setType(TypeCase.OILY_MEDOW);
        gameboard[2][11].setType(TypeCase.OILY_MEDOW);
        gameboard[4][11].setType(TypeCase.OILY_MEDOW);
        gameboard[5][11].setType(TypeCase.OILY_MEDOW);
        gameboard[13][11].setType(TypeCase.OILY_MEDOW);
        gameboard[14][11].setType(TypeCase.OILY_MEDOW);
        gameboard[1][12].setType(TypeCase.OILY_MEDOW);
        gameboard[6][12].setType(TypeCase.OILY_MEDOW);
        gameboard[8][12].setType(TypeCase.OILY_MEDOW);
        gameboard[9][12].setType(TypeCase.OILY_MEDOW);
        gameboard[1][13].setType(TypeCase.OILY_MEDOW);
        gameboard[2][13].setType(TypeCase.OILY_MEDOW);
        gameboard[6][13].setType(TypeCase.OILY_MEDOW);
        gameboard[7][13].setType(TypeCase.OILY_MEDOW);
        gameboard[8][13].setType(TypeCase.OILY_MEDOW);
        gameboard[11][13].setType(TypeCase.OILY_MEDOW);
        gameboard[0][14].setType(TypeCase.OILY_MEDOW);
        gameboard[1][14].setType(TypeCase.OILY_MEDOW);
        gameboard[2][14].setType(TypeCase.OILY_MEDOW);
        gameboard[6][14].setType(TypeCase.OILY_MEDOW);
        gameboard[7][14].setType(TypeCase.OILY_MEDOW);
        gameboard[8][14].setType(TypeCase.OILY_MEDOW);
        gameboard[9][14].setType(TypeCase.OILY_MEDOW);
        gameboard[10][14].setType(TypeCase.OILY_MEDOW);
        gameboard[20][14].setType(TypeCase.OILY_MEDOW);
        gameboard[0][15].setType(TypeCase.OILY_MEDOW);
        gameboard[3][15].setType(TypeCase.OILY_MEDOW);
        gameboard[6][15].setType(TypeCase.OILY_MEDOW);
        gameboard[8][15].setType(TypeCase.OILY_MEDOW);
        gameboard[9][15].setType(TypeCase.OILY_MEDOW);
        gameboard[10][15].setType(TypeCase.OILY_MEDOW);
        gameboard[17][15].setType(TypeCase.OILY_MEDOW);
        gameboard[19][15].setType(TypeCase.OILY_MEDOW);
        gameboard[2][16].setType(TypeCase.OILY_MEDOW);
        gameboard[3][16].setType(TypeCase.OILY_MEDOW);
        gameboard[6][16].setType(TypeCase.OILY_MEDOW);
        gameboard[7][16].setType(TypeCase.OILY_MEDOW);
        gameboard[15][16].setType(TypeCase.OILY_MEDOW);
        gameboard[16][16].setType(TypeCase.OILY_MEDOW);
        gameboard[17][16].setType(TypeCase.OILY_MEDOW);
        gameboard[10][17].setType(TypeCase.OILY_MEDOW);
        gameboard[17][17].setType(TypeCase.OILY_MEDOW);
        gameboard[0][18].setType(TypeCase.OILY_MEDOW);
        gameboard[7][18].setType(TypeCase.OILY_MEDOW);
        gameboard[9][18].setType(TypeCase.OILY_MEDOW);
        gameboard[10][18].setType(TypeCase.OILY_MEDOW);
        gameboard[11][18].setType(TypeCase.OILY_MEDOW);
        gameboard[12][18].setType(TypeCase.OILY_MEDOW);
        gameboard[13][18].setType(TypeCase.OILY_MEDOW);
        gameboard[14][18].setType(TypeCase.OILY_MEDOW);
        gameboard[5][19].setType(TypeCase.OILY_MEDOW);
        gameboard[6][19].setType(TypeCase.OILY_MEDOW);
        gameboard[7][19].setType(TypeCase.OILY_MEDOW);
        gameboard[11][19].setType(TypeCase.OILY_MEDOW);
        gameboard[12][19].setType(TypeCase.OILY_MEDOW);
        gameboard[13][19].setType(TypeCase.OILY_MEDOW);
        gameboard[14][19].setType(TypeCase.OILY_MEDOW);
        gameboard[15][19].setType(TypeCase.OILY_MEDOW);
        gameboard[3][20].setType(TypeCase.OILY_MEDOW);
        gameboard[6][20].setType(TypeCase.OILY_MEDOW);
        gameboard[10][20].setType(TypeCase.OILY_MEDOW);
        gameboard[11][20].setType(TypeCase.OILY_MEDOW);
        gameboard[12][20].setType(TypeCase.OILY_MEDOW);
        gameboard[13][20].setType(TypeCase.OILY_MEDOW);
        gameboard[14][20].setType(TypeCase.OILY_MEDOW);
        gameboard[15][20].setType(TypeCase.OILY_MEDOW);
    }

    public void initializeDesertGameBoard(){
        gameboard[6][0].setType(TypeCase.DESERT);
        gameboard[7][0].setType(TypeCase.DESERT);
        gameboard[8][0].setType(TypeCase.DESERT);
        gameboard[9][0].setType(TypeCase.DESERT);
        gameboard[10][0].setType(TypeCase.DESERT);
        gameboard[11][0].setType(TypeCase.DESERT);
        gameboard[6][1].setType(TypeCase.DESERT);
        gameboard[7][1].setType(TypeCase.DESERT);
        gameboard[8][1].setType(TypeCase.DESERT);
        gameboard[9][1].setType(TypeCase.DESERT);
        gameboard[6][2].setType(TypeCase.DESERT);
        gameboard[7][2].setType(TypeCase.DESERT);
        gameboard[8][2].setType(TypeCase.DESERT);
        gameboard[6][3].setType(TypeCase.DESERT);
        gameboard[7][3].setType(TypeCase.DESERT);
        gameboard[7][4].setType(TypeCase.DESERT);
    }

    public void initializeScreeGameBoard(){
        gameboard[20][0].setType(TypeCase.SCREE);
        gameboard[20][1].setType(TypeCase.SCREE);
        gameboard[19][1].setType(TypeCase.SCREE);
        gameboard[20][2].setType(TypeCase.SCREE);
        gameboard[18][2].setType(TypeCase.SCREE);
        gameboard[1][3].setType(TypeCase.SCREE);
        gameboard[18][3].setType(TypeCase.SCREE);
        gameboard[19][3].setType(TypeCase.SCREE);
        gameboard[1][4].setType(TypeCase.SCREE);
        gameboard[2][4].setType(TypeCase.SCREE);
        gameboard[3][4].setType(TypeCase.SCREE);
        gameboard[3][5].setType(TypeCase.SCREE);
        gameboard[4][5].setType(TypeCase.SCREE);
        gameboard[5][5].setType(TypeCase.SCREE);
        gameboard[2][6].setType(TypeCase.SCREE);
        gameboard[3][6].setType(TypeCase.SCREE);
        gameboard[4][6].setType(TypeCase.SCREE);
        gameboard[2][7].setType(TypeCase.SCREE);
        gameboard[4][7].setType(TypeCase.SCREE);
        gameboard[5][7].setType(TypeCase.SCREE);
        gameboard[6][7].setType(TypeCase.SCREE);
        gameboard[7][7].setType(TypeCase.SCREE);
        gameboard[5][8].setType(TypeCase.SCREE);
        gameboard[6][8].setType(TypeCase.SCREE);
        gameboard[7][8].setType(TypeCase.SCREE);
        gameboard[16][7].setType(TypeCase.SCREE);
        gameboard[14][8].setType(TypeCase.SCREE);
        gameboard[15][8].setType(TypeCase.SCREE);
        gameboard[7][9].setType(TypeCase.SCREE);
        gameboard[10][9].setType(TypeCase.SCREE);
        gameboard[13][9].setType(TypeCase.SCREE);
        gameboard[14][9].setType(TypeCase.SCREE);
        gameboard[7][10].setType(TypeCase.SCREE);
        gameboard[8][10].setType(TypeCase.SCREE);
        gameboard[11][10].setType(TypeCase.SCREE);
        gameboard[12][10].setType(TypeCase.SCREE);
        gameboard[8][11].setType(TypeCase.SCREE);
        gameboard[10][11].setType(TypeCase.SCREE);
        gameboard[11][11].setType(TypeCase.SCREE);
        gameboard[10][12].setType(TypeCase.SCREE);
        gameboard[11][12].setType(TypeCase.SCREE);
        gameboard[10][13].setType(TypeCase.SCREE);
        gameboard[12][13].setType(TypeCase.SCREE);
        gameboard[12][14].setType(TypeCase.SCREE);
        gameboard[12][15].setType(TypeCase.SCREE);
        gameboard[11][15].setType(TypeCase.SCREE);
        gameboard[8][16].setType(TypeCase.SCREE);
        gameboard[9][16].setType(TypeCase.SCREE);
        gameboard[10][16].setType(TypeCase.SCREE);
        gameboard[11][16].setType(TypeCase.SCREE);
        gameboard[12][16].setType(TypeCase.SCREE);
        gameboard[13][16].setType(TypeCase.SCREE);
        gameboard[5][17].setType(TypeCase.SCREE);
        gameboard[6][17].setType(TypeCase.SCREE);
        gameboard[7][17].setType(TypeCase.SCREE);
        gameboard[8][17].setType(TypeCase.SCREE);
        gameboard[9][17].setType(TypeCase.SCREE);
        gameboard[13][17].setType(TypeCase.SCREE);
        gameboard[14][17].setType(TypeCase.SCREE);
        gameboard[15][17].setType(TypeCase.SCREE);
        gameboard[2][18].setType(TypeCase.SCREE);
        gameboard[3][18].setType(TypeCase.SCREE);
        gameboard[4][18].setType(TypeCase.SCREE);
        gameboard[5][18].setType(TypeCase.SCREE);
        gameboard[6][18].setType(TypeCase.SCREE);
        gameboard[15][18].setType(TypeCase.SCREE);
        gameboard[16][18].setType(TypeCase.SCREE);
        gameboard[17][18].setType(TypeCase.SCREE);
        gameboard[1][19].setType(TypeCase.SCREE);
        gameboard[2][19].setType(TypeCase.SCREE);
        gameboard[18][19].setType(TypeCase.SCREE);
        gameboard[17][19].setType(TypeCase.SCREE);
        gameboard[0][20].setType(TypeCase.SCREE);
        gameboard[1][20].setType(TypeCase.SCREE);
    }
}

