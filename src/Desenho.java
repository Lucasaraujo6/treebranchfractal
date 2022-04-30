import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
public class Desenho extends Canvas{

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        criaTriangulo(g);
        // int largura = getWidth();
        // int altura = getHeight();
        // int[] vx = {0,largura/2,largura};
        // int[] vy = {altura,0,altura};
        // g.fillPolygon(vx,vy,3);
        

    }

    private void criaTriangulo(Graphics g) {
        double largura = getWidth()-5;
        double altura = getHeight()-5;
        Ponto ponto1 = new Ponto(largura/2, altura/2);
        Ponto ponto2 = new Ponto(largura/2, altura);
        g.setColor(Color.BLACK);
        // g.fillPolygon(vx,vy,3);
        
        //criaTriangRec(g, largura/4, altura/2, 3*largura/4, altura/2, largura/2, altura);
        criaLinha(g, ponto1, ponto2, 5, 0);

    }
    
    private void criaLinha(Graphics g, Ponto ponto1, Ponto ponto2, int contador, int direcao) {
        if(contador==1){
            return;
        }
        
        if(contador % 2 == 1 ) { g.setColor(Color.RED); }else{g.setColor(Color.BLACK);};
        g.drawLine((int)ponto1.x, (int)ponto1.y, (int)ponto2.x, (int)ponto2.y);

        double tamanho = Math.sqrt((ponto1.x-ponto2.x)*(ponto1.x-ponto2.x)+(ponto1.y-ponto2.y)*(ponto1.y-ponto2.y));
        double ajuste = tamanho/(2*Math.sqrt(2));

        //0 ambos, 1 direita cima, 2 esquerda cima
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(direcao==0){
            criaLinha(g, new Ponto(ponto1.x-ajuste, ponto1.y-ajuste), ponto1, contador-1, 1);
            criaLinha(g, new Ponto(ponto1.x+ajuste, ponto1.y-ajuste), ponto1, contador-1, 2);
        }else if (direcao==1){

        } else if (direcao==2){

        };



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
        //     g.setColor(Color.WHITE); 
        // }else{
        //     g.setColor(Color.BLACK);
        // }

        //recursivo que chamava pra cima
        // criaTriangRec(g, (ponto1+x3)/2, (y3+ponto2)/2, (x2+x3)/2, (y3+ponto2)/2,(ponto1+x2)/2, ponto2);
        // criaTriangRec(g, (ponto1+x3)/2, ponto2/2, (x2+x3)/2, ponto2/2,(ponto1+x2)/2, ponto2);
        
     
    };
    
    
    public class Ponto{
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

};
