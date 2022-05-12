import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;

public class Desenho extends Canvas {
    private double angInterno = Math.PI / 3; // 90° em radianos

    private Ponto pontoFinal;
    private double altura;
    private int nivel = 3;
    private int tamanho = getTamanho();
    private Galho galhos[] = new Galho[tamanho];

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        criaGalho(g);
        // int largura = getWidth();
        // int altura = getHeight();
        // int[] vx = {0,largura/2,largura};
        // int[] vy = {altura,0,altura};
        // g.fillPolygon(vx,vy,3);

    }

    private void criaGalho(Graphics g) {
        // angInterno = Math.PI * 2 / 3; // 90° em radianos

        double largura = getWidth() - 5;
        altura = getHeight() - 5;
        Ponto ponto = new Ponto(largura / 2, (altura / 4));
        System.out.println(ponto.y);
        // Ponto ponto2 = new Ponto(largura/2, altura);
        g.setColor(Color.BLACK);

        // g.fillPolygon(vx,vy,3);

        // criaTriangRec(g, largura/4, altura/2, 3*largura/4, altura/2, largura/2,
        // altura);
        // g.drawLine((int) (largura / 2), (int) (altura), (int) (largura / 2), (int)
        // (altura * 3 / 4));
        criaLinha(g, ponto, Math.PI / 2, altura / 2, nivel);
        System.out.println("reordenate n funfa");
        // galhos[0] = (new Galho((int) (largura / 2), (int) (altura), (int) (largura /
        // 2), (int) (altura * 3 / 4), 0));
        add(new Galho((int) (largura / 2), (int) (altura), (int) (largura / 2), (int) (altura * 3 / 4), nivel + 1));
        reordenate();
        print();
        drawTree(g);
    }

    private void drawTree(Graphics g) {
        int redTone = (int) ((-102) / nivel);
        int greenTone = (int) ((255 - 51) / nivel);
        // int blueTone = (int) ((-102) / tamanho);
        for (int i = 0; i < galhos.length; i++) {
            // System.out.println(i);
            try {
                g.setColor(
                        new Color(102 + redTone * (nivel - galhos[i].nivel), 51 + greenTone * (nivel - galhos[i].nivel),
                                0));
            } catch (Exception e) {
                e.printStackTrace();
            }
            // System.out.println((redTone + " " + i + "green=> " + greenTone + " " + i));
            // System.out.println(g.getColor());
            g.drawLine(galhos[i].x1, galhos[i].y1, galhos[i].x2, galhos[i].y2);

            // try {
            // Thread.sleep(1);
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
        }
    }

    private void criaLinha(Graphics g, Ponto pontoDeContatoPai, double angInclinacaoPai, double tamanhoPai,
            int contador) {
        if (contador == 0) {
            return;
        }

        // alterna as cores das linhas
        // if (contador % 2 == 0) {
        // g.setColor(Color.RED);
        // } else {
        // g.setColor(Color.BLACK);
        // }
        // ;

        // desenha a linha
        // TODO determinar a direção do ponto 2

        double angleUp = angInclinacaoPai + (angInterno / 2);
        // if (angleUp == 0) {
        // angleUp = Math.PI;
        // }
        // angleUp = angleUp - Math.PI;

        double angleDown = angInclinacaoPai - (angInterno / 2);
        // if (angleDown > 0 && angleDown < Math.PI) {
        // angleDown = -angleDown;
        // System.out.println("rodou aqui" + angleDown);
        // }

        double tamanhoAtual = tamanhoPai * 60 / 100;

        // try {
        // Thread.sleep(0);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }

        pontoFinal = new Ponto(tamanhoAtual * Math.cos(angleUp) +
                pontoDeContatoPai.x,
                tamanhoAtual * Math.sin(angleUp) + pontoDeContatoPai.y);
        g.setColor(Color.RED);
        // g.drawLine((int) pontoDeContatoPai.x, (int) (altura - pontoDeContatoPai.y),
        // (int) pontoFinal.x,
        // (int) (altura - pontoFinal.y));
        add(new Galho((int) pontoDeContatoPai.x, (int) (altura - pontoDeContatoPai.y), (int) pontoFinal.x,
                (int) (altura - pontoFinal.y), contador));

        criaLinha(g, pontoFinal, angleUp, tamanhoAtual, contador - 1);

        pontoFinal = new Ponto(tamanhoAtual * Math.cos(angleDown) + pontoDeContatoPai.x,
                tamanhoAtual * Math.sin(angleDown) + pontoDeContatoPai.y);
        g.setColor(Color.BLACK);
        // g.drawLine((int) pontoDeContatoPai.x, (int) (altura - pontoDeContatoPai.y),
        // (int) pontoFinal.x,
        // (int) (altura - pontoFinal.y));
        add(new Galho((int) pontoDeContatoPai.x, (int) (altura - pontoDeContatoPai.y), (int) pontoFinal.x,
                (int) (altura - pontoFinal.y), contador));
        criaLinha(g, pontoFinal, angleDown, tamanhoAtual, contador - 1);

        // double tamanho =
        // Math.sqrt((pontoDeContatoPai.x-pontoFinal.x)*(pontoDeContatoPai.x-pontoFinal.x)+(pontoDeContatoPai.y-pontoFinal.y)*(pontoDeContatoPai.y-pontoFinal.y));

        // double ajuste = tamanho/(2*Math.sqrt(2));
        // 0 ambos, 1 direita cima, 2 esquerda cima

        // criaLinha(g, pontoFinal,0, tamanhoAtual, contador-1);

        // criaLinha(g, new Ponto(ponto1.x-ajuste, ponto1.y-ajuste), ponto1, contador-1,
        // 0);
        // criaLinha(g, new Ponto(ponto1.x+ajuste, ponto1.y-ajuste), ponto1, contador-1,
        // 0);

        // int yMed1=y2;
        // int yMed2=(ponto2+y2)/2;
        // int yMed3=(ponto2+y2)/2;

        // int xMed1=(x3+x2)/2;
        // int xMed2=(ponto1+x3)/2;
        // int xMed3=(ponto1+x2)/2;

        // g.setColor(Color.WHITE);

        // int[] vx = {ponto1,x2,x3};
        // int[] vy = {ponto2,y2,y3};

        // int[] vx = {xMed1, xMed2, xMed3};
        // int[] vy = {yMed1, yMed2, yMed3};
        // g.fillPolygon(vx,vy,3);

        // criaTriangRec(g, xMed2,yMed2, xMed3, yMed3, x3,y3, contador-1);
        // criaTriangRec(g, ponto1,ponto2,xMed1, yMed1, xMed2, yMed2, contador-1);
        // criaTriangRec(g, xMed1,yMed1,x2, y2, xMed3, yMed3, contador-1);

        // System.out.println(g.getColor());
        // if(g.getColor()== Color.RED){
        // g.setColor(Color.WHITE);
        // }else{
        // g.setColor(Color.BLACK);
        // }

        // recursivo que chamava pra cima
        // criaTriangRec(g, (ponto1+x3)/2, (y3+ponto2)/2, (x2+x3)/2,
        // (y3+ponto2)/2,(ponto1+x2)/2, ponto2);
        // criaTriangRec(g, (ponto1+x3)/2, ponto2/2, (x2+x3)/2, ponto2/2,(ponto1+x2)/2,
        // ponto2);

    };

    public void print() {
        for (int i = 0; i < galhos.length; i++) {
            // System.out.println(i);

            if (this.galhos != null && galhos[i] != null) {
                // System.out.println(i + " " + galhos[i].nivel);
                // System.out.println("Cheguei aqui" + this.galhos[i].nivel);
            }
        }

    }

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
            // System.out.println("passei aqui1");
            while (i >= 0 && galhos[i + 1] != null && galhos[i] != null && galhos[i].nivel < galhos[i + 1].nivel) {
                Galho aux = galhos[i];
                galhos[i] = galhos[i + 1];
                galhos[i + 1] = aux;
                // System.out.println("passei aqui2" + i);
                i--;
            }
        }
    }

    public int getTamanho() {
        for (int i = 0; i <= nivel; i++) {
            tamanho += Math.pow(2, i);
        }
        // System.out.println(tamanho);
        return tamanho;
    }

};
