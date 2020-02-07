package map;

public class Case {
    private TypeCase type;
    private int capacite;
    private boolean metamorphose;
    int x;
    int y;

    public Case(TypeCase type, int capacite, boolean metamorphose, int x, int y) {
        this.type = type;
        this.capacite = capacite;
        this.metamorphose = metamorphose;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TypeCase getType() {
        return type;
    }

    public void setType(TypeCase type) {
        this.type = type;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public boolean isMetamorphose() {
        return metamorphose;
    }

    public void setMetamorphose(boolean metamorphose) {
        this.metamorphose = metamorphose;
    }
}
