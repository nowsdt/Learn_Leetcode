package cn.supertao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author shidt
 * @date 2021/5/8 10:17
 */
public class Test {

    @org.junit.Test
    public void test() {
        int[] nums = {4, 5, 7, 9, 1, 3, 6};
        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    public int findKthLargest(int[] nums, int k) {

        int lo = 0, hi = nums.length - 1;
        k = nums.length - k;


        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start > end) return;

        int p = partition(nums, start, end);
        quickSort(nums, start, p - 1);
        quickSort(nums, p + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        if (start >= end) return start;

        int i = start, j = end + 1;

        int p = nums[start];

        while (true) {
            while (nums[++i] < p) {
                if (i == end) {
                    break;
                }
            }

            while (nums[--j] > p) {
                if (j == start) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            swap(nums, i, j);
        }

        swap(nums, start, j);

        return j;

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static class Stack2Queue {
        private final Stack<Integer> s1 = new Stack<>();
        private final Stack<Integer> s2 = new Stack<>();

        public void offer(Integer data) {
            s1.push(data);
        }

        public Integer pop() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            return s2.pop();
        }

        public boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    @org.junit.Test
    public void testStack2Queue() {
        final Stack2Queue queue = new Stack2Queue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }

    }


    public static class Queue2Stack {
        private final LinkedList<Integer> s1 = new LinkedList<>();
        private Integer top;

        public void push(Integer data) {
            top = data;
            s1.offer(data);
        }

        public Integer peek() {
            return top;
        }

        public boolean isEmpty() {
            return s1.isEmpty();
        }
    }

    public void merge(int A[], int m, int B[], int n) {
        //因为题目明确说了A数组足够大，所以直接在A数组操作
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;//AB合并后最后一个元素所在位置
        while(i >= 0 && j >= 0)//AB合并，谁大就先放谁
            A[index --] = A[i] > B[j] ? A[i --] : B[j --];
        while(j >= 0)//如果B没有遍历完，那么之间丢在A数组里面
            A[index --] = B[j --];

    }

    @org.junit.Test
    public void testMerge() {
        int[] a = new int[8];

        int[] tmp = {1,4,5,7};
        for (int i = 0; i < tmp.length; i++) {
            a[i] = tmp[i];
        }

        int[] b = {2,3,6,8};
        merge(a, 4, b, 4);

        System.out.println(Arrays.toString(a));
    }

}
