package map;

public class Case {
    private TypeCase type;
    private int capacite;
    private boolean metamorphose;
    private Coordonnee coordonnee;

    public Case(TypeCase type, int capacite, boolean metamorphose, Coordonnee coordonnee) {
        this.type = type;
        this.capacite = capacite;
        this.metamorphose = metamorphose;
        this.coordonnee = coordonnee;
    }

    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
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
