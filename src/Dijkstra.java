import java.util.Scanner;

public class Dijkstra {
    private int[][] dijkstraMatrix;
    private int[] markedItems;
    private int[] minimumItems;
    private int[] originItems;
    int matrixSize;

    /**
     * Inicializa los tamaños de las matrices y de los arreglos
     * @param matrixSize
     */
    public Dijkstra(int matrixSize) {
        this.matrixSize = matrixSize;
        dijkstraMatrix = new int[matrixSize][matrixSize];
        markedItems = new int[matrixSize];
        minimumItems = new int[matrixSize];
        originItems = new int[matrixSize];
    }

    /**
     * Inicializa los valores de las matrices y de los arreglos
     */
    public void initMatrix() {
        for (int i = 0; i < this.matrixSize; i++) {
            this.markedItems[i] = 0;
            this.originItems[i] = 1;
            this.minimumItems[i] = this.dijkstraMatrix[0][i]; // Explicar esto
        }
        this.markedItems[0] = 1;
        this.originItems[0] = 0;
    }

    /**
     * Solicita al usuario los valores de las matrices y captura
     */
    public void captureValues() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.matrixSize; i++) {
            for (int j = 0; j < this.matrixSize; j++){
                if (i == j){
                    dijkstraMatrix[i][j] = 0;
                } else {
                    dijkstraMatrix[i][j] = 999;
                }
            }
        }

        int vertexConnection = 0;
        int ad = 0;
        for (int i = 0; i < this.matrixSize; i++) {
            System.out.println("Digita el vértice " + i);
            vertexConnection = sc.nextInt();
            System.out.println("Digita el peso " + i);
            ad = sc.nextInt();
            while (ad!= 999) {
                dijkstraMatrix[i][vertexConnection] = ad;
                System.out.println("Digita el adjunto de vértice");
                vertexConnection = sc.nextInt();
                System.out.println("Digita el peso");
                ad = sc.nextInt();
            }
        }
        sc.close();
    }

    /**
     * Añade a al arreglo 'a' cuál de todos los costes es el menor hasta un momento determindao
     * @param a arreglo
     */
    public void setLowerCost(int a[]) {
        a[0] = 999;
        a[1] = 0;
        for (int i = 0; i < this.matrixSize; i++) {
            if(this.markedItems[i]==0 && this.minimumItems[i] < a[0]) {
                a[0]=this.markedItems[i];
                a[1]=i;
            }
        }
    }

    /**
     * Resuelve el algoritmo de Dijstra
     */
    public void solveDijkstra() {
        int [] a = new int [2];
        for (int i = 0; i < this.matrixSize; i++) {
            this.setLowerCost(a);
            int chosenItem =a[1];
            int minValue =a[0];
            this.markedItems[chosenItem] = 1;
            for (int j = 0; j < this.matrixSize; j++) {
                if (markedItems[j] == 0 && minValue + dijkstraMatrix[chosenItem][j] < minimumItems[j]) {
                    minimumItems[j] = dijkstraMatrix[chosenItem][j];
                    originItems[j] = chosenItem;
                }
            }
        }
    }

    public void printDijkstraResults() {
        System.out.println("Mínimos ... \n");
        for (int i = 0; i < this.matrixSize; i++) {
            System.out.println(minimumItems[i] + " ");
        }
    }

    public void print() {
        System.out.println("******* MATRIX DE ADYACENCIA ******\n");
        for (int i = 0; i < this.matrixSize; i++) {
            for (int j = 0; j < this.matrixSize; j++) {
                System.out.println("\t" + dijkstraMatrix[i][j]);
            }
        }
        System.out.print("\n");
    }
}
