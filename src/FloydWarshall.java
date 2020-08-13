public class FloydWarshall
{
    final static int INF = (Integer.MAX_VALUE/2)-1;
    void fWarshall(int V, int adjMat[][]) {
        int matrix[][] = new int[V][V];
        int i, j, k;
        for (i=0;i<V;i++) {
            for (j=0;j<V;j++) {
                matrix[i][j] = adjMat[i][j];
            }
        }
        for (k=0;k<V;k++) {
            for (i=0;i<V;i++) {
                for (j=0;j<V;j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }

        for (i=0;i<V;i++) {
            for (j=0;j<V;j++) {
                if (matrix[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int matrix[][] = { { 0, 3, INF, 5 },
                           { 2, 0, INF, 4 },
                           { INF, 1, 0, INF },
                           { INF, INF, 2, 0 }};
        FloydWarshall graph=new FloydWarshall();
        graph.fWarshall(4, matrix);
    }
}