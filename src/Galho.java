public class Galho {
    public int x1, y1, x2, y2, nivel;
    private Galho[] galhos;

    public Galho(int x1, int y1, int x2, int y2, int nivel) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.nivel = nivel;
    }

    public Galho(int tamanho) {
        this.galhos = new Galho[tamanho];
    }

}
