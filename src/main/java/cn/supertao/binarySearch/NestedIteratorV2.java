package cn.supertao.binarySearch;

import cn.supertao.help.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * N叉树遍历
 *
 * 惰性求值
 *
 * @author shidt
 * @date 2021/4/3 21:12
 */
public class NestedIteratorV2 implements Iterator<Integer>{

    private LinkedList<NestedInteger> list;


    public NestedIteratorV2(List<NestedInteger> data) {

        this.list = new LinkedList<>(data);
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
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            final List<NestedInteger> tmpList = this.list.remove(0).getList();
            for (int i = tmpList.size() - 1; i >  0; i--) {
                list.addFirst(tmpList.get(i));
            }
        }
        return list.isEmpty();
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }
}
