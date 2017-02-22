/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplication;

import java.util.Scanner;

/**
 *
 * @author boss
 */
public class multiplication {

//--------------iterative method -------------------------   
    public int[][] iterative(int p, int q, int m,int first[][],int second[][]){
        
        int multiply[][] = new int[m][q];
         int sum = 0; 
        
         for (int c = 0 ; c < m ; c++ )
         {
            for (int d = 0 ; d < q ; d++ )
            {   
               for (int k = 0 ; k < p ; k++ )
               {
                  sum = sum + first[c][k]*second[k][d];
               }

               multiply[c][d] = sum;
                System.out.print(multiply[c][d]);
               sum = 0;
            }
         }
 
         
         return multiply;
      }
    //-----------strassens------------    
    public int[][] Strassens(int[][] A, int[][] B)
    {        
        int n = A.length;
        int[][] R = new int[n][n];
        
        if (n == 1)
            R[0][0] = A[0][0] * B[0][0];
        else
        {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
 
            /** Dividing matrix A into 4 halves **/
            split(A, A11, 0 , 0);
            split(A, A12, 0 , n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);
            /** Dividing matrix B into 4 halves **/
            split(B, B11, 0 , 0);
            split(B, B12, 0 , n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2, n/2);
 
           
 
            int [][] M1 = Strassens(add(A11, A22), add(B11, B22));
            int [][] M2 = Strassens(add(A21, A22), B11);
            int [][] M3 = Strassens(A11, sub(B12, B22));
            int [][] M4 = Strassens(A22, sub(B21, B11));
            int [][] M5 = Strassens(add(A11, A12), B22);
            int [][] M6 = Strassens(sub(A21, A11), add(B11, B12));
            int [][] M7 = Strassens(sub(A12, A22), add(B21, B22));
 
           
            int [][] C11 = add(sub(add(M1, M4), M5), M7);
            int [][] C12 = add(M3, M5);
            int [][] C21 = add(M2, M4);
            int [][] C22 = add(sub(add(M1, M3), M2), M6);
 
            /** join 4 halves into one result matrix **/
            join(C11, R, 0 , 0);
            join(C12, R, 0 , n/2);
            join(C21, R, n/2, 0);
            join(C22, R, n/2, n/2);
        }
        /** return result **/  
        
        return R;
    }
    //dividing into two parts
    public int[][] sub(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
    
    //add two matrices
    public int[][] add(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
   
    //split matrix into two child matrices 
    public void split(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
    
   //join matrices
    public void join(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }    
    
    
    
    
    
    ///---------------check whether the answer is correct---------
    // its subtracts the both results and if the result is zero then returns true
       public static boolean equal(int m,int q,int[][] a, int[][] b) {
        if ((a == null) || (b == null)) {
            throw new IllegalArgumentException("null argument");
        }
        int multiply[][] = new int[m][q];
        int check=0;
        for(int i=0;i< m;i++){
            for(int j=0;j<q;j++){
                multiply[i][j]=a[i][j]-b[i][j];
                System.out.print(multiply[i][j]);
            }
        }
        for(int i=0;i< m;i++){
            for(int j=0;j<q;j++){
                if(multiply[i][j]==0){
                    check=0;
                }else{
                    check++;
                }
                    
            }
        }
        if(check==0){
            return true;
        }else{
            return false;
        }
     
    }
}

    

