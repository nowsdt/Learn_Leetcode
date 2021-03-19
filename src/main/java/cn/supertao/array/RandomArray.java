package cn.supertao.array;

import java.util.Arrays;
import java.util.List;

/**
 * @author shidt
 * @date 2021/3/10 9:48
 */
public class RandomArray {
    public static void main(String[] args) {
        randomSetWithBlackList();
        // randomSet();

    }

    public static void randomSet() {
        final RandomizeSet randomizeSet = new RandomizeSet();

        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 7);
        for (Integer num : list) {
            randomizeSet.insert(num);
        }

        System.out.println(randomizeSet);

        randomizeSet.remove(3);

        System.out.println(randomizeSet);

        System.out.println(randomizeSet.getRandom());

    }

    public static void randomSetWithBlackList() {
        final List<Integer> blackList = Arrays.asList(1, 4);

        final RandomizeSetWithBlackList setWithBlackList = new RandomizeSetWithBlackList(5, blackList);

        System.out.println(setWithBlackList);
    }
}
