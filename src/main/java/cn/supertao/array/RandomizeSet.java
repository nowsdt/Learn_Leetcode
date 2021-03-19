package cn.supertao.array;

import java.util.ArrayList;
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
public class RandomizeSet {
    public List<Integer> nums = new ArrayList<>(16);
    public Map<Integer, Integer> valToIndex = new HashMap<>(16);
    private final Random random = new Random();

    public Boolean insert(Integer val) {
        if (valToIndex.containsKey(val)) {
            return Boolean.FALSE;
        }

        valToIndex.put(val, nums.size());
        nums.add(val);
        return Boolean.TRUE;
    }

    public Boolean remove(int val) {
        if (!valToIndex.containsValue(val)) {
            return Boolean.FALSE;
        }
        final Integer index = valToIndex.get(val);

        final Integer lastNum = nums.get(nums.size() - 1);
        valToIndex.put(lastNum, index);

        // 交换
        nums.set(index, lastNum);
        nums.set(nums.size() -1, val);

        nums.remove(nums.size() - 1);
        valToIndex.remove(val);


        return Boolean.TRUE;
    }

    public Integer getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

    @Override
    public String toString() {
        return "RandomizeSet{" + "nums=" + nums +
                ", valToIndex=" + valToIndex +
                '}';
    }
}
