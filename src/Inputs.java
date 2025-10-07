import java.util.Scanner;

public class Inputs {
    private Scanner sc;

    public Inputs(){
        sc = new Scanner(System.in);
    }
    public void colocarnum(int[][] tabuleiro) {
        System.out.println("Digite a posição e o número que deseja colocar(linha, coluna, número)");
        int v = 0;
        while (v == 0) {

            String r = sc.nextLine();
            String[] separa = r.split(",");
            int[] partes = new int[3];
            try {
                for (int x = 0; x < 3; x++) {
                    partes[x] = Integer.parseInt(separa[x].trim());
                }
                int p1 = partes[0] - 1;
                int p2 = partes[1] - 1;
                int n = partes[2];
                if (Menu.validar(p1, p2, n, tabuleiro) && (tabuleiro[p1][p2] == 0)) {
                    tabuleiro[p1][p2] = n;
                    Menu.imprimirtab(tabuleiro);
                } else {
                    System.out.println("Posição inválida!");
                }

                v = 1;
            } catch (NumberFormatException e) {
                System.out.println("Posição inválida! Digite novamente:");
                v = 0;
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Posição inválida! Digite novamente:");
                v = 0;
            }
        }
    }

    public void removernum(int[][] tabuleiro) {
        System.out.println("Digite a posição do número que deseja remover(linha, coluna)");
        int v = 0;
        while (v == 0) {
            String r = sc.nextLine();
            String[] separa = r.split(",");
            int[] partes = new int[2];
            try {
                for (int x = 0; x < 2; x++) {
                    partes[x] = Integer.parseInt(separa[x].trim());
                }
                int p1 = partes[0] - 1;
                int p2 = partes[1] - 1;
                if (!(tabuleiro[p1][p2] == 0)) {
                    tabuleiro[p1][p2] = 0;
                    Menu.imprimirtab(tabuleiro);
                } else {
                    System.out.println("Posição inválida!");
                }
                v = 1;
            } catch (NumberFormatException e) {
                System.out.println("Posição inválida! Digite novamente:");
                v = 0;
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Posição inválida! Digite novamente:");
                v = 0;
            }
        }
    }
}
