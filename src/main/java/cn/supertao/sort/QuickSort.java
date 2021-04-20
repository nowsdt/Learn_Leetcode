package cn.supertao.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author shidt
 * @date 2021/4/15 15:25
 */
public class QuickSort {

    public static void main(String[] args) {

    }

    @Test
    public void testSort() {
        int[] nums = {1,4,5,7,9,5};
        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 时间复杂度 o(nlogn)
     * @param arr
     * @param lo
     * @param hi
     */
    public void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        final int p = partition(arr, lo, hi);
        quickSort(arr, lo, p-1);
        quickSort(arr, p +1, hi);

    }

    public int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        int i = lo, j = hi + 1;

        int p = nums[lo];
        while (true) {
            while (nums[++i] < p ) {
                if (i == hi) break;
            }

            while (nums[--j] > p) {
                if (j == lo) break;
            }

            if (i >= j) break;

            swap(nums, i, j);
        }

        swap(nums, j , lo);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
