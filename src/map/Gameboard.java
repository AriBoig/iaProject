package map;

public class Gameboard {

    Case[][] gameboard;

    public Gameboard(Case[][] gameboard) {
        this.gameboard = gameboard;
    }

    public Case[][] getGameboard() {
        return gameboard;
    }

    public void setGameboard(Case[][] gameboard) {
        this.gameboard = gameboard;
    }

    public void initializeGameBoard(){
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                Coordonnee coordonnee = new Coordonnee(j, i);
                gameboard[i][j].setCoordonnee(coordonnee);
            }
        }
    }

    public void initializeWaterGameBoard(){
        gameboard[0][0].setType(TypeCase.WATER);
        gameboard[0][1].setType(TypeCase.WATER);
        gameboard[0][2].setType(TypeCase.WATER);
    }
}
