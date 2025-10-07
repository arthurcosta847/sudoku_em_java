import java.util.Random;

public class Tabuleiro {
    public int[][] tabuleiro = new int[4][4];
    public boolean[][] fixo = new boolean[4][4];

    public boolean iniciar() {
        
        Random rand = new Random();
        int quantidade = 5;
        int preenchidos = 0;

        while (preenchidos != quantidade) {
            int p1 = rand.nextInt(4);
            int p2 = rand.nextInt(4);
            if (tabuleiro[p1][p2] == 0) {
                int n = rand.nextInt(4) + 1;
                if (Menu.validar(p1, p2, n, tabuleiro)) {
                    tabuleiro[p1][p2] = n;
                    fixo[p1][p2] = true;
                    preenchidos++;
                }
            }
        }
        Menu.imprimirtab(tabuleiro);
        return true;
    }

    public void limpar() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (!fixo[x][y]) {
                    tabuleiro[x][y] = 0;
                }
            }
        }
        System.out.println("O tabuleiro foi limpo!");
        Menu.imprimirtab(tabuleiro);
    }
}
