import java.util.*;

public class Menu {
       public static boolean validar(int p1, int p2, int n, int[][] tabuleiro) {
        for (int x = 0; x < 4; x++) {
            if (tabuleiro[p1][x] == n)
                return false;
        }

        for (int x = 0; x < 4; x++) {
            if (tabuleiro[x][p2] == n)
                return false;
        }

        int iniciol = (p1 / 2) * 2;
        int inicioc = (p2 / 2) * 2;

        for (int x = iniciol; x < iniciol + 2; x++) {
            for (int y = inicioc; y < inicioc + 2; y++) {
                if (tabuleiro[x][y] == n)
                    return false;
            }
        }
        return true;
    }

    public static void imprimirtab(int[][] tabuleiro) {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                System.out.print(tabuleiro[x][y] + " ");
                if (y == 1) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if (x == 1) {
                System.out.println("---------");

            }
        }
    }

    

    

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Tabuleiro tab = new Tabuleiro();
        Inputs input = new Inputs();
        boolean terminou = false;
        boolean comecou = false;
        int opcao = -1;
        System.out.println("===================================================================");
        System.out.println("                              Menu");
        System.out.println("===================================================================");
        System.out.println("");
        System.out.println("1 - Iniciar um novo jogo");
        System.out.println("2 - Colocar um novo número (De 1 a 4)");
        System.out.println("3 - Remover um número");
        System.out.println("4 - Limpar");
        System.out.println("5 - Finalizar o jogo");
        System.out.println(
                "(OBS: se o jogo iniciar com números onde não deveriam, utilize a opção de remover um número (3))");
        do {
            int z = 0;
            System.out.println("Sua opção:");
            String entrada = sc.nextLine();
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida!");
                continue;
            }
            switch (opcao) {
                case 1:
                    if (comecou) {
                        System.out.println("Você já começou um jogo!");
                    } else {
                        comecou = tab.iniciar();
                    }
                    break;
                case 2:
                    if (!comecou) {
                        System.out.println("Você não começou o jogo!");
                    } else {
                        input.colocarnum(tab.tabuleiro);
                    }
                    break;
                case 3:
                    if (!comecou) {
                        System.out.println("Você não começou o jogo!");
                    } else
                        input.removernum(tab.tabuleiro);
                    break;
                case 4:
                    if (!comecou) {
                        System.out.println("Você não começou o jogo!");
                    } else {
                        tab.limpar();
                    }
                    break;
                case 5:
                    System.out.println("O jogo foi encerrado!");
                    terminou = true;
                    break;
                default:
                    System.out.println("Opção Inválida! Selecione uma opção do menu!");

            }
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    if (tab.tabuleiro[x][y] != 0) {

                        z++;
                    }
                }
            }
            if (z == 16) {
                terminou = true;
                System.out.println("Você venceu! Parabéns!!");
                System.out.println("O jogo terminou!");
            }
        } while (!terminou);
        sc.close();
    }
}
