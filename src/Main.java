public class Main {

/*
 * Auxiliary
 */

    static void displayArray(int[] v){
        for (int i = 0; i < v.length; i++)
            System.out.print(v[i] + " ");
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
        displayArray(v1);
        System.out.print("\nAfter: ");
        displayArray(removeFirst(v1));
        System.out.print("\nBefore: ");
        displayArray(v2);
        System.out.print("\nAfter: ");
        displayArray(removeFirst(v2));
        System.out.print("\nBefore: ");
        displayArray(v3);
        System.out.print("\nAfter: ");
        displayArray(removeFirst(v3));
        System.out.print("\nBefore: ");
        displayArray(v4);
        System.out.print("\nAfter: ");
        displayArray(removeFirst(v4));
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
        System.out.println("\nTEST 4:");
        System.out.print("Product of ");
        displayArray(v1);
        System.out.println("is: " + productVecElems(v1));
        System.out.print("Product of ");
        displayArray(v2);
        System.out.println("is: " + productVecElems(v2));
        System.out.print("Product of ");
        displayArray(v3);
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
    //static int sizeLongestSequence(char c, char[] vec){

    public static void main(String[] args){
        test_1();
        test_2();
        test_3();
        test_4();
    }
}
