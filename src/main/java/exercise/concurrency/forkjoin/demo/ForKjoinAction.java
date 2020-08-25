package exercise.concurrency.forkjoin.demo;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;


public class ForKjoinAction extends RecursiveAction {


    /**
     * 包含startIndex
     */
    private int startIndex;

    /**
     * 不包含endIndex
     */
    private int endIndex;
    private int[] arr;

    public ForKjoinAction(int startIndex, int endIndex, int[] arr) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.arr = arr;
    }
    @Override
    protected void compute() {
        if (endIndex - startIndex < 5000) {
            /**这里直接去进行排序，这里需要调用不同的排序算法，后续做相应的性能测试**/
            Arrays.sort(arr, startIndex, endIndex);

        } else {
            int middle = (startIndex + endIndex)/2;
            ForKjoinAction left = new ForKjoinAction(startIndex, middle, arr);
            ForKjoinAction right = new ForKjoinAction(middle, endIndex, arr);

            ForKjoinAction.invokeAll(left, right);
            left.join(); right.join();

            /**这里做归并工作，后续形成自己的工具类**/
            mergeSort(arr, startIndex, middle, endIndex);
        }
    }

    /**
     * 进行合并
     * @param arr
     * @param startIndex
     * @param middle
     * @param endIndex
     */
    private static void mergeSort(int[] arr, final int startIndex,
                                  final int middle, final int endIndex) {
        int start1 = startIndex;
        int start2 = middle;

        int[] tmp = new int[endIndex - startIndex];
        int count = 0;
        while(start1 < middle && start2 < endIndex) {
            if ( arr[start1] < arr[start2]) {
                tmp[count++] = arr[start1++];
            } else {
                tmp[count++] = arr[start2++];
            }
        }

        int leftStart = -1;
        int leftEnd = -1;
        if (start1 < middle) {
            leftStart = start1;
            leftEnd = middle;
        } else {
            leftStart = start2;
            leftEnd = endIndex;
        }

        for (int i = leftStart; i < leftEnd; i++) {
            tmp[count++] = arr[i];
        }
        //复制

        for (int i = startIndex, j=0; i < endIndex; i++,j++) {
            arr[i] = tmp[j];
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //左开右闭
        int a[] = {2, 45, 67, 13, 13, 24, 57};
        mergeSort(a,0, 3, 7);

        for (int i : a) {
            System.out.println(i);
        }

        int len = 10000000;
        a = new int[len];
        Random r = new Random(10000);
        for (int i = 0; i < len; i++) {
            a[i] = r.nextInt(10000);
        }

        long start = System.currentTimeMillis();
        ForKjoinAction forKjoinAction = new ForKjoinAction(0, len, a);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        ForkJoinTask<Void> submit = pool.submit(forKjoinAction);
        submit.get();
        System.out.println("I am done, time consumed:" + (System.currentTimeMillis() - start));
    }
}
