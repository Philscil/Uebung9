package p1;
import java.util.random.RandomGenerator;

public class P1_main {
    public static void main(String[] args) {
        int[] arr = randomArray4(3);
        
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static int[] randomArray(int x) {
        RandomGenerator randGen = RandomGenerator.getDefault();
        int[] arr = new int[x];
        
        for (int i = 0; i < x; i++) {
            arr[i] = randGen.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        return arr;
    }

    public static int[] randomArray2(int x) {
        RandomGenerator randGen = RandomGenerator.getDefault();
        int[] arr = new int[x];
        
        for (int i = 0; i < x; i++) {
            arr[i] = randGen.nextInt(0, x);
        }

        return arr;
    }

    public static int[] randomArray3() {
        RandomGenerator randGen = RandomGenerator.getDefault();
        int[] arr = new int[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = randGen.nextInt(55,76);
        }

        return arr;
    }

    public static int[] randomArray4(int n) {
        RandomGenerator randGen = RandomGenerator.getDefault();
        int[] arr = new int[n + 1];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = randGen.nextInt(1,51);
            sum += arr[i];
        }

        arr[n] = sum / n;

        return arr;
    }
}
