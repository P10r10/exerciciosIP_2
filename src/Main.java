public class Main {
/*
 * Desenvolva uma função para determinar se um inteiro é múltiplo de três.
 */
    static boolean isMultiple3(int nb){
        return nb % 3 == 0;
    }

    static void test_1(){
        for (int i = 0; i < 17; i++)
            System.out.println(i + " is muliple of 3: " + isMultiple3(i));
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
        System.out.printf("Muliples of 3 between 5 and 55: %.2f%%\n", percentageMultiple3(5, 55));
        System.out.printf("Muliples of 3 between 1 and 9: %.2f%%\n", percentageMultiple3(1, 9));
        System.out.printf("Muliples of 3 between 0 and 16: %.2f%%\n", percentageMultiple3(0, 16));
        System.out.printf("Muliples of 3 between 100 and 200: %.2f%%\n", percentageMultiple3(100, 200));
    }

    public static void main(String[] args) {
        test_2();
    }
}
