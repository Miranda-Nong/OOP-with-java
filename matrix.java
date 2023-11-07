import java.util.Scanner; 
public class matrix { 
private int[][] matrix1; 
private int[][] matrix2; 
private int[][] result; 
public matrix(int[][] matrix1, int[][] matrix2) { 
this.matrix1 = matrix1; 
this.matrix2 = matrix2; 
this.result = new int[matrix1.length][matrix2[0].length]; 
} 
public void multiplyMatrices() { 
for (int i = 0; i < matrix1.length; i++) { 
for (int j = 0; j < matrix2[0].length; j++) { 
for (int k = 0; k < matrix2.length; k++) { 
result[i][j] += matrix1[i][k] * matrix2[k][j]; 
} 
} 
} 
} 
public void displayResult() { 
System.out.println("Resultant Matrix:"); 
for (int i = 0; i < result.length; i++) { 
for (int j = 0; j < result[0].length; j++) { 
System.out.print(result[i][j] + " "); 
} 
System.out.println(); 
}} 
public void finalize() { 
System.out.println("Object is being garbage collected"); 
} 
public static void main(String[] args) { 
Scanner s = new Scanner(System.in); 
System.out.print("Enter the dimension of first matrix: "); 
int a = s.nextInt(); 
int b = s.nextInt(); 
int[][] matrix1 = new int[a][b]; 
System.out.print("Enter the dimensions of second matrix: "); 
int c = s.nextInt(); 
int d = s.nextInt(); 
int[][] matrix2 = new int[c][d]; 
System.out.println("Enter the first matrix: "); 
for(int i = 0; i < a; i++){ 
for(int j = 0; j < b; j++){ 
matrix1[i][j] = s.nextInt(); 
} 
} 
System.out.println("Enter the second matrix: "); 
for(int i = 0; i < c; i++){ 
for(int j = 0; j < d; j++){ 
matrix2[i][j] = s.nextInt(); 
} 
} 
s.close(); 
matrix mm = new matrix(matrix1, matrix2); 
mm.multiplyMatrices(); 
mm.displayResult(); 
mm = null; 
System.gc(); 
}
}
