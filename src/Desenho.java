import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class Desenho extends Canvas {
    private double angInterno;

    private Ponto pontoFinal;
    private double altura;
    private int nivel, tamanho, sleepTime;
    private Galho[] galhos;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        initVariables();
        setTamanho();
        criaGalhos();
        reordenate();
        drawTree(g2d);
    }

    /**
     * Classe utilizada para determinar os valores de entrada
     * 
     * @author Lucas Araújo
     */
    private void initVariables() {
        angInterno = Math.PI / 3; // 90° em radianos
        nivel = 10;
        sleepTime = 0;
    }

    private void criaGalhos() {
        double largura = getWidth() - 5;
        altura = getHeight() - 5;
        Ponto ponto = new Ponto(largura / 2, (altura / 4));

        criaLinha(ponto, Math.PI / 2, altura / 2, nivel);
        add(new Galho((int) (largura / 2), (int) (altura), (int) (largura / 2), (int) (altura * 3 / 4), nivel + 1));
        // print(); //imprime o vetor

    }

    private void drawTree(Graphics2D g) {

        int redTone = (int) ((-102) / nivel);
        int greenTone = (int) ((255 - 51) / nivel);
        for (int i = 0; i < galhos.length; i++) {
            try {
                g.setColor(
                        new Color(102 + redTone * (nivel - galhos[i].nivel), 51 + greenTone * (nivel - galhos[i].nivel),
                                0));
            } catch (Exception e) {
            }
            try {
                g.setStroke(new BasicStroke((int) Math.pow(1.5, galhos[i].nivel)));
            } catch (Exception e) {

            }

            g.drawLine(galhos[i].x1, galhos[i].y1, galhos[i].x2, galhos[i].y2);

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
    }

    private void criaLinha(Ponto pontoDeContatoPai, double angInclinacaoPai, double tamanhoPai,
            int contador) {
        if (contador == 0) {
            return;
        }

        double angleUp = angInclinacaoPai + (angInterno / 2);

        double angleDown = angInclinacaoPai - (angInterno / 2);

        double tamanhoAtual = tamanhoPai * 60 / 100;

        pontoFinal = new Ponto(tamanhoAtual * Math.cos(angleUp) +
                pontoDeContatoPai.x,
                tamanhoAtual * Math.sin(angleUp) + pontoDeContatoPai.y);

        add(new Galho((int) pontoDeContatoPai.x, (int) (altura - pontoDeContatoPai.y), (int) pontoFinal.x,
                (int) (altura - pontoFinal.y), contador));

        criaLinha(pontoFinal, angleUp, tamanhoAtual, contador - 1);

        pontoFinal = new Ponto(tamanhoAtual * Math.cos(angleDown) + pontoDeContatoPai.x,
                tamanhoAtual * Math.sin(angleDown) + pontoDeContatoPai.y);

        add(new Galho((int) pontoDeContatoPai.x, (int) (altura - pontoDeContatoPai.y), (int) pontoFinal.x,
                (int) (altura - pontoFinal.y), contador));
        criaLinha(pontoFinal, angleDown, tamanhoAtual, contador - 1);

    };

    public class Ponto {
        private double x;
        private double y;

        public Ponto() {
            this.x = 0;
            this.y = 0;
        }

        public Ponto(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

    public void print() {
        for (int i = 0; i < galhos.length; i++) {

            if (this.galhos != null && galhos[i] != null) {
                System.out.println(i + " " + galhos[i].nivel);
            }
        }

    }

    public void add(Galho galho) {
        // quando eu insiro o primeiro valor como galho[0] =... ele buga
        for (int i = 0; i < galhos.length; i++) {
            if (galhos[i] == null) {
                galhos[i] = galho;
                break;
            }
        }
    }

    public void reordenate() {
        for (int j = 0; j < galhos.length - 1; j++) {
            int i = j;
            while (i >= 0 && galhos[i + 1] != null && galhos[i] != null && galhos[i].nivel < galhos[i + 1].nivel) {
                Galho aux = galhos[i];
                galhos[i] = galhos[i + 1];
                galhos[i + 1] = aux;
                i--;
            }
        }
    }

    public void setTamanho() {
        for (int i = 0; i <= nivel; i++) {
            tamanho += Math.pow(2, i);
        }

        galhos = new Galho[tamanho];
    }

};
