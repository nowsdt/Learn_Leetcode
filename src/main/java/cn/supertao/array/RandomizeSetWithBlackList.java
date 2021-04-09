package cn.supertao.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * 插入 删除 随机返回 都是O(1)的时间复杂度
 *
 * @author shidt
 * @date 2021/3/10 9:49
 */
public class RandomizeSetWithBlackList {
    private Integer SZ;
    // public List<Integer> blackList;


    public Map<Integer, Integer> valToIndex = new HashMap<>(16);
    private final Random random = new Random();


    public RandomizeSetWithBlackList(int N, List<Integer> blackList) {
        this.SZ = N - blackList.size();
        // this.blackList = new ArrayList<>(blackList);

        for (Integer num : blackList) {
            valToIndex.put(num, 666);
        }

        int last = N -1;
        for (Integer num : blackList) {
            if (num > SZ) {
                continue;
            }
            while (valToIndex.containsKey(num)) {
                last--;
            }
            valToIndex.put(num, last--);
        }


    }

    public Integer pick() {
        final int index = random.nextInt(SZ);
        if (valToIndex.containsKey(index)) {
            return valToIndex.get(index);
        }
        return index;
    }

    @Override
    public String toString() {
        return "RandomizeSetWithBlackList{"  +
                ", valToIndex=" + valToIndex +
                '}';
    }
}
