package cn.supertao.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shidt
 * @date 2019/8/5 13:26
 */
public class MapUtils {
    public static HashMap newHashMapWithExpectedSize(int expectedSize) {
        final float size = expectedSize / 0.75F + 1.0F;
        return new HashMap((int) size);
    }
}
