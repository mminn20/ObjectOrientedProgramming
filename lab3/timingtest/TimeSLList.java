package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        SLList<Integer> slList = new SLList<>();
        Stopwatch sw = new Stopwatch();
        int M = 10000;

        // Ns, opCounts, slList 배열
        int power = 0;
        //제출 시 128000
        for (int i = 0; i < 128000; i++) {
            slList.addLast(i);          // slList는 N개
            if (slList.size() == Math.pow(2, power) * 1000) {
                Ns.addLast(slList.size());
                opCounts.addLast(M);
                power++;
                for (int t = 0; t < M; t++) {           // M번 = 10000번 getLast 수행
                    slList.getLast();
                }
                times.addLast(sw.elapsedTime());
            }
        }

        printTimingTable(Ns, times, opCounts);
    }
}
