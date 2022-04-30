import javax.swing.JFrame;

public class TreeBranchFractal extends JFrame {

    public TreeBranchFractal() {
        initGui();
    }

    private void initGui(){
        setTitle("Triângulo de Sierpinsk");
        setSize(750,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Desenho desenho = new Desenho();
        add(desenho);

        setVisible(true);
    }


    public static void main(String[] args) throws Exception {
        // TreeBranchFractal ts= new TreeBranchFractal();
        new TreeBranchFractal();
    }
}
