import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n\n\n\n\n\n******** ALGORITMO DE DIJKSTRA ***********\n\n");
        int matrixSize = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el tamaño de la matriz");
        matrixSize = sc.nextInt();
        Dijkstra dijkstraObject = new Dijkstra(matrixSize);
        dijkstraObject.captureValues();
        dijkstraObject.print();
        dijkstraObject.initMatrix();
        dijkstraObject.solveDijkstra();
    }
}
