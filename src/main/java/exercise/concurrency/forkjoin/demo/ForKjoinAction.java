package exercise.concurrency.forkjoin.demo;

import java.util.Arrays;
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
            left.fork();
            ForKjoinAction right = new ForKjoinAction(middle, endIndex, arr);
            right.fork();

            left.join();right.join();

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
    private static void mergeSort(int[] arr, int startIndex, int middle, int endIndex) {

    }
}
