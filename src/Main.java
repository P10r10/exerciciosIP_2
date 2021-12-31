public class Main {

/*
 * Auxiliary
 */

    static void displayArrayInt(int[] v){
        for (int i = 0; i < v.length; i++)
            System.out.print(v[i] + " ");
        System.out.println();
    }

    static void displayMatrixInt(int[][] m){
        for (int i = 0; i < m.length; i++)
            displayArrayInt(m[i]);
    }

    static void displayArrayChar(char[] v){
        if (v.length != 0)
            System.out.print("{");
        for (int i = 0; i < v.length; i++)
            System.out.print("'" + v[i] + (i == v.length - 1 ? "'}" : "', "));
    }

/*
 * Desenvolva uma função para determinar se um inteiro é múltiplo de três.
 */
    static boolean isMultiple3(int nb){
        return nb % 3 == 0;
    }

    static void test_1(){
        System.out.println("TEST 1:");
        for (int i = 0; i < 17; i++)
            System.out.println(i + " is muliple of 3: " + isMultiple3(i));
        System.out.println();
    }

/*
 * Desenvolva uma função capaz de devolver a percentagem de múltiplos de
 * três presentes num intervalo fechado ([a, b]). Use a função
 * desenvolvida na alínea anterior.
 */
    static double percentageMultiple3(int a, int b){
        int count = 0;
        for (int i = a; i < b; i++)
            if (isMultiple3(i))
                count++;
        return (double) count / (a + b) * 100;
    }

    static void test_2(){
        System.out.println("TEST 2:");
        System.out.printf("Multiples of 3 between 5 and 55: %.2f%%\n",
                percentageMultiple3(5, 55));
        System.out.printf("Multiples of 3 between 1 and 9: %.2f%%\n",
                percentageMultiple3(1, 9));
        System.out.printf("Multiples of 3 between 0 and 16: %.2f%%\n",
                percentageMultiple3(0, 16));
        System.out.printf("Multiples of 3 between 100 and 200: %.2f%%\n",
                percentageMultiple3(100, 200));
        System.out.println();
    }
/*
 * Desenvolva uma função que dado um vetor de inteiros não vazio, remove
 * o primeiro elemento e devolve o resto do vetor.
 * Dado {1, 2, 3} a função deve devolver {2, 3}.
 */

    static int[] removeFirst(int[] v) {
        int[] res = new int[v.length - 1];
        for (int i = 0; i < v.length - 1; i++)
            res[i] = v[i + 1];
        return res;
    }

    static void test_3(){
        int[] v1 = {1, 2, 3, 4, 5};
        int[] v2 = {4, 3, 2};
        int[] v3 = {6, 7, 8, 9};
        int[] v4 = {9};
        System.out.println("TEST 3:");
        System.out.print("Before: ");
        displayArrayInt(v1);
        System.out.print("After: ");
        displayArrayInt(removeFirst(v1));
        System.out.print("Before: ");
        displayArrayInt(v2);
        System.out.print("After: ");
        displayArrayInt(removeFirst(v2));
        System.out.print("Before: ");
        displayArrayInt(v3);
        System.out.print("After: ");
        displayArrayInt(removeFirst(v3));
        System.out.print("Before: ");
        displayArrayInt(v4);
        System.out.print("After: ");
        displayArrayInt(removeFirst(v4));
        System.out.println();
    }

/*
 * Desenvolva uma função recursiva que recebe um vetor de inteiros
 * não vazio, e devolve o produto dos seus elementos. Use a função
 * desenvolvida na alínea anterior.
 * Dado {2, 3, 4} a função deve devolver 24.
 */

    static int productVecElems(int[] v){
        if (v.length == 0)
            return 1;
        return productVecElems(removeFirst(v)) * v[0];
    }

    static void test_4(){
        int[] v1 = {4, 3, 2};
        int[] v2 = {1, 2, 3};
        int[] v3 = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        System.out.println("TEST 4:");
        System.out.print("Product of ");
        displayArrayInt(v1);
        System.out.println("is: " + productVecElems(v1));
        System.out.print("Product of ");
        displayArrayInt(v2);
        System.out.println("is: " + productVecElems(v2));
        System.out.print("Product of ");
        displayArrayInt(v3);
        System.out.println("is: " + productVecElems(v3));
    }
/*
 * Desenvolva uma função que recebe um carácter e um vector de
 * caracteres e devolve o tamanho da maior sequência desse carácter.
 * Caso não exista deve devolver zero.
 * Dado ‘0’ e {'a', '2'} a função deve devolver 0.
 * Dado ‘0’ e {'0', '0', 'b', '3', '7'} a função deve devolver 2.
 * Dado ‘0’ e {'c', '3', ‘0’, ‘0,’ 'a', '1', ’0’, ‘0’, ‘0’} a função deve devolver 3.
 * Dado ‘0’ e {‘0’} a função deve devolver 1.
 */
    static int sizeLongestSequence(char c, char[] v){
        int count = 0, longest = 0;
        for (int i = 0; i < v.length; i++)
            if (v[i] == c){
                count++;
                if (count > longest)
                    longest = count;
            }
            else
                count = 0;
        return longest;
    }

    static void test_5(){
        char[] v1 = {'a', '2'};
        char[] v2 = {'0', '0', 'b', '3', '7'};
        char[] v3 = {'c', '3', '0', '0', 'a', '1', '0', '0', '0'};
        char[] v4 = {'0'};
        System.out.println("\nTEST 5:");
        System.out.print("Longest sequence of '0' in ");
        displayArrayChar(v1);
        System.out.println(": " + sizeLongestSequence('0', v1));
        System.out.print("Longest sequence of '0' in ");
        displayArrayChar(v2);
        System.out.println(": " + sizeLongestSequence('0', v2));
        System.out.print("Longest sequence of '0' in ");
        displayArrayChar(v3);
        System.out.println(": " + sizeLongestSequence('0', v3));
        System.out.print("Longest sequence of '0' in ");
        displayArrayChar(v4);
        System.out.println(": " + sizeLongestSequence('0', v4));
    }

/*
 * Desenvolva um procedimento que dada uma matriz de inteiros quadrada
 * coloque a 1 os elementos da diagonal secundária.
 */
    static void secondaryDiagonal(int[][] m){
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m.length; j++)
                if (j == m.length - 1 - i)
                    m[i][j] = 1;
    }

    static void test_6(){
        System.out.println("\nTEST 6:");
        System.out.println("Before: ");
        int[][]m = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}};
        displayMatrixInt(m);
        System.out.println("After: ");
        secondaryDiagonal(m);
        displayMatrixInt(m);
        int[][]m2 = {{1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 0, 1, 2},
                    {3, 4, 5, 6}};
        displayMatrixInt(m2);
        System.out.println("After: ");
        secondaryDiagonal(m2);
        displayMatrixInt(m2);
    }
/* Desenvolva uma função que devolve o mínimo múltiplo comum entre
 * dois números naturais. O mínimo múltiplo comum entre dois números
 * naturais é o primeiro número natural que é divisível pelos dois números.
 * lcm(3, 2) ➝ 6
 * lcm(3, 6) ➝ 6
 * lcm(21, 9) ➝ 63
 */
    static int lcm(int a, int b){
        int res = a * b;
        for (int i = res; i >= Math.max(a, b); i--){
            if (i % a == 0 && i % b == 0)
                res = i;
        }
        return res;
    }

    static void test_7(){
        System.out.println("\nTEST 7:");
        System.out.println("lcm(3, 2): " + lcm(3, 2));
        System.out.println("lcm(3, 6): " + lcm(3, 6));
        System.out.println("lcm(21, 9): " + lcm(21, 9));
        System.out.println("lcm(458, 650): " + lcm(458, 650));
        System.out.println("lcm(116, 58): " + lcm(116, 58));
    }

    static int binaryToDecimal(int[] vec){
        int res = 0;
        for (int i = vec.length - 1; i >= 0 ; i--)
            res += vec[i] * Math.pow(2, vec.length - 1 - i);
        return res;
    }

    static void test_8(){
        System.out.println("\nTEST 8:");
        int[] v1 = {1, 1, 0, 0};
        int[] v2 = {1, 0, 0, 0};
        int[] v3 = {0, 1, 1, 1};
        int[] v4 = {1, 1, 1, 1};
        int[] v5 = {1, 0, 0, 0, 0};
        int[] v6 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Binary 1100 = " + binaryToDecimal(v1));
        System.out.println("Binary 1000 = " + binaryToDecimal(v2));
        System.out.println("Binary 0111 = " + binaryToDecimal(v3));
        System.out.println("Binary 1111 = " + binaryToDecimal(v4));
        System.out.println("Binary 10000 = " + binaryToDecimal(v5));
        System.out.println("Binary 11111111 = " + binaryToDecimal(v6));
    }

    public static void main(String[] args){
//        test_1();
//        test_2();
//        test_3();
//        test_4();
//        test_5();
//        test_6();
//        test_7();
        test_8();
    }
}
