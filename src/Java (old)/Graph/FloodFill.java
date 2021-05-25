import java.util.*;
public class FloodFill {
    public static void fill(int mat[][], int x, int y) {
        if(mat[x][y]==0)
            return;

        mat[x][y] = 0;

        if(x-1>=0) {
            fill(mat,x-1,y); //left
            if(y-1>=0)
                fill(mat,x-1,y-1); //left top
        }
        if(y-1>=0) {
            fill(mat,x,y-1); //top
            if(x+1<mat.length)
                fill(mat,x+1,y-1);// right top
        }
        if(y+1<mat[0].length) {
            fill(mat,x,y+1); //bottom
            if(x-1>=0)
                fill(mat,x-1,y+1); // left bottom
        }
        if(x+1<mat.length) {
            fill(mat,x+1,y); //right
            if(y+1<mat[0].length)
                fill(mat,x+1,y+1); // right bottom
        }
    }

    public static void main(String[] args) {
        int[][] mat=
        { { 1, 1, 0, 0, 0 }, 
          { 0, 1, 0, 0, 1 }, 
          { 1, 0, 0, 1, 1 }, 
          { 0, 0, 0, 0, 0 }, 
          { 1, 0, 1, 0, 1 } }; 
        int m=mat.length;
        int n=mat[0].length;
        int c=0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(mat[i][j]==1) {
                    fill(mat, i, j);
                    c++;
                }
            }
        }
        System.out.println(c);
    }
}