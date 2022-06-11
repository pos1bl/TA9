import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Corruption {
    public double corruption(int N, int P) {
        Random random = new Random();
        double percent = (100 - (double) P) / 100;
        List<Double> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            long G = random.nextInt(10000);
            list.add((double) G);
        }

        double temp;

        double firstMin = 10_001;
        double secondMin = 10_001;
        int firstMinIndex = 0;
        int secondMinIndex = 0;

        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < firstMin) {
                    secondMin = firstMin;
                    secondMinIndex = firstMinIndex;
                    firstMin = list.get(i);
                    firstMinIndex = i;

                } else if (list.get(i) < secondMin) {
                    secondMin = list.get(i);
                    secondMinIndex = i;
                }
            }
            temp = (firstMin + secondMin) * percent;
            list.set(firstMinIndex, temp);
            list.remove(list.get(secondMinIndex));
            firstMin = 10_000 * N;
            secondMin = 10_000 * N;

        }
        return list.get(0);
    }
}
