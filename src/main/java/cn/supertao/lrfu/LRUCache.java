package cn.supertao.lrfu;

import cn.supertao.help.DoubleLinkedList;
import cn.supertao.help.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shidt
 * @date 2021/3/22 17:03
 */
public class LRUCache {
    // Map<key,Node>
    private final Map<Integer, Node> map;
    private final DoubleLinkedList cache;
    private final Integer cap;

    public LRUCache(Integer capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleLinkedList();
    }

    public void put(Integer key, Integer val) {
        // makeRecentUse
        if (map.containsKey(key)) {
            final Node node = new Node(key, val);
            delKey(key);
            addRecently(node);
        }

        if (cap.equals(cache.size())) {
            removeLeastRecently();
        }

        addRecently(new Node(key, val));

    }

    public Integer get(Integer key) {
        if (map.containsKey(key)) {
            final Node node = map.get(key);
            makeRecently(node);
            return node.value;
        }
        return -1;
    }

    private void delKey(Integer key) {
        final Node remove = map.remove(key);
        cache.remove(remove);
    }

    private void makeRecently(Node node) {
        cache.remove(node);
        cache.addLast(node);
    }
    private void addRecently(Node node) {
        map.put(node.key, node);
        cache.addLast(node);
    }

    private void removeLeastRecently() {
        final Node node = cache.removeFirst();
        map.remove(node.key);
    }

}
