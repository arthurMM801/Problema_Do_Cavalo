package Lab3.desafioCavalo;

public class Cavalo {
    public static void main(String[] args) {

        // CRIA TABULEIRO
        int[][] tabuleiro = new int[8][8];

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                tabuleiro[i][j] = 0;

        tabuleiro[0][0] = 1;
        resolveProblema(0, 0, tabuleiro);

    }

    private static boolean resolveProblema(int i, int j, int[][] tabuleiro) {

        // DEFINE MOVIMENTOS DO CAVALO
        int[] dx = {2,1,-1,-2,-2,-1,1,2};
        int[] dy = {1,2,2,1,-1,-2,-2,-1};
        int k = 0;

        // WHILE PARA TENTAR OS MOVIMENTO DO CAVALO COM O dx[k] e dy[k]
        do{
            // VERIFICA SE O MOVIMENTO E POSSIVEL
            int x = dx[k]+i, y = dy[k]+j;
            if(x < 8  && x >= 0 && y < 8 && y >=0 && tabuleiro[x][y] == 0){
                // PREENCHE COM 1 AS CASA VISITADAS DO TABULEIRO
                tabuleiro[x][y] = 1;
                imprime(tabuleiro);

                // CASO O CAMINHO FUTURO NAO COMPLETAR O TAB "DESFAZER" MOVIMENTO
                if(!resolveProblema(x, y, tabuleiro)) {
                    tabuleiro[x][y] = 0;
                    imprime(tabuleiro);
                }
            }
            k++;

            // QUANDO NAO TIVER MAIS MOVIMENTOS
            if(k == 8) {
                System.out.println("erro volta");
                return false;
            }
        } while (!verificaTabuleiro(tabuleiro));
        return true;
    }

    private static void imprime(int[][] tabuleiro){
        for (int n = 0; n < 8; n++) {
            System.out.println();
            for (int m = 0; m < 8; m++)
                System.out.print(tabuleiro[n][m]+" ");
        }
        System.out.println();
    }

    private static boolean verificaTabuleiro(int[][] tabuleiro){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if(tabuleiro[i][j] == 0)
                    return false;
        return true;
    }
}
