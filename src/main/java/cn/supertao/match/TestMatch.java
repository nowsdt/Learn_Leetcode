package cn.supertao.match;

import org.junit.Test;

import java.util.Stack;

/**
 * @author shidt
 * @date 2021/3/31 10:56
 */
public class TestMatch {

    @Test
    public void test1() {
        assert testBracketMatch("([][][][]))");
    }


    /**
     * 压栈和取栈
     * '(','[','{' 这三个就压栈
     * ')',']','}' 这三个就取栈，取栈时判断一下是不是对应的括号，如果是就取栈成功，不是就不能取。
     * 这样最后看栈是不是为空，不为空就说明顺序不正确
     * @param input
     * @return
     */
    public boolean testBracketMatch(String input) {
        if (input == null || input.length() == 0) {
            return Boolean.TRUE;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0, len = input.length(); i < len; i++) {
            final char charAt = input.charAt(i);
            if(stack.isEmpty()) {
                stack.push(charAt);
                continue;
            }

            System.out.println(charAt);
            System.out.println("==before==");
            System.out.println(stack);

            if (charAt == '}' && stack.peek() == '{') {
                stack.pop();
            }

            else if (charAt == ']' && stack.peek() == '[') {
                stack.pop();
            }
            else if (charAt == ')' && stack.peek() == '(') {
                stack.pop();
            }

            else {
                stack.push(charAt);
            }

            System.out.println("==after==");
            System.out.println(stack);
            System.out.println();
            System.out.println();
        }

        System.out.println(stack);
        return stack.isEmpty();
    }
}
