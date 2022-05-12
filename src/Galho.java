public class Galho {
    public int x1, y1, x2, y2, nivel;
    private Galho[] galhos;

    public Galho(int x1, int y1, int x2, int y2, int nivel) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.nivel = 6;
    }

    public Galho(int tamanho) {
        this.galhos = new Galho[tamanho];
    }

    public void add(Galho galho) {
        for (int i = 0; i < galhos.length; i++) {
            if (galhos[i] == null) {
                galhos[i] = galho;
                break;
                System.out.println("i = " + i + "nivel = " galho.nivel);
            }
        }
    }

}
