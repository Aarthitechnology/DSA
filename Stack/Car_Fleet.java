import java.util.*;

public class Car_Fleet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        int n = sc.nextInt();

        int[] position = new int[n];
        int[] speed = new int[n];

        for (int i = 0; i < n; i++) {
            position[i] = sc.nextInt();
            speed[i] = sc.nextInt();
        }

        System.out.println(carFleet(target, position, speed));
        sc.close();
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] car = new int[n][2];

        for (int i = 0; i < n; i++) {
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }

        Arrays.sort(car, (a, b) -> b[0] - a[0]); // sort by position desc

        Stack<Double> time = new Stack<>();

        for (int i = 0; i < n; i++) {
            int pos = car[i][0], sp = car[i][1];
            double t = (double) (target - pos) / sp;  // correct time

            if (!time.isEmpty() && t <= time.peek()) {
                continue; // merge
            }
            time.push(t); // new fleet
        }

        return time.size();
    }
}
