package cn.supertao.binarySearch;

import cn.supertao.help.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * N叉树遍历
 *
 * @author shidt
 * @date 2021/4/3 21:12
 */
public class NestedIteratorV1 implements Iterator<Integer>{

    private Iterator<Integer> it;


    public NestedIteratorV1(List<NestedInteger> it) {
        final LinkedList<Integer> result = new LinkedList<>();
        for (NestedInteger nestedInteger : it) {
            traverse(nestedInteger, result);
        }

        this.it = result.iterator();
    }

    private void traverse(NestedInteger nestedInteger, LinkedList<Integer> result) {
        if (nestedInteger.isInteger()) {
            result.add(nestedInteger.getInteger());
            return;
        }

        for (NestedInteger child : nestedInteger.getList()) {
            traverse(child, result);
        }
    }


    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Integer next() {
        return it.next();
    }
}
