package com.liu.study.arithmetic.classic;

import com.liu.study.arithmetic.util.CustomStack;

/**
 * 简单的计算器实现
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/11 9:13
 */
public class SimpleCalculatorImplDemo {

    public static void main(String[] args) {

        test();
    }

    /**
     * <note>
     *     一、如果操作数栈中有已经存在运算符，比较当前操作符，与栈顶的操作符的优先级。
     *          1. 如果当前运算符小于或者等于栈顶的运算符。需要从数字栈弹出两个数字，并进行运算，把运算结果压入数栈。
     *          2. 如果当前运算符大于或者等于栈顶的运算符。直接把符号压入符号栈中。
     * </note>
     *
     * 100-（2*3*4-5+3）+6/2
     * = 100 - 24 - 5 + 3 + 3
     * = 100 - 22  + 6 / 2
     * = 100 - 22 + 3
     * = 100 - 25
     */
    public static void test() {
        String expressionString = "7*2*2-5+1-5+3-4";

        int index = 0;
        String str = "";
        CustomStack<Integer> numberStack = new CustomStack<>();
        CustomStack<String> operationStack = new CustomStack<>();

        while (true) {

            if (index == expressionString.length()) {
                break;
            }

            if (str.matches("\\d+$")) {
                str = expressionString.substring(index, index + 1);
                index++;


                // 01、判断当前运算符与栈顶的运算符的优先级。
                if (!operationStack.isEmpty()) {
                    String topPeep = operationStack.peep();
                    if (!firstGreaterSecond(str, topPeep)) {
                        int second = numberStack.pop();
                        int first = numberStack.pop();
                        int calc = calc(first, second, operationStack.pop());
                        numberStack.push(calc);
                    }
                }
                operationStack.push(str);

            } else {
                String newStr = null;
                int realIndex = index;
                for (int i = index; i < expressionString.length(); i++) {
                    index++;
                    newStr = expressionString.substring(realIndex, index);
                    if (!newStr.matches("\\d+$") && i != expressionString.length()) {
                        index--;
                        newStr = expressionString.substring(realIndex, index);
                        break;
                    }
                }
                if (newStr == null) {
                    break;
                } else {
                    str = newStr;
                }
                if (!str.isEmpty()) {
                    numberStack.push(Integer.parseInt(str));
                }
            }
        }

        operationStack.show();
        System.out.println();
        numberStack.show();

        while (true) {
            if (operationStack.isEmpty()) {
                break;
            }

            String operation = operationStack.pop();
            int second = numberStack.pop();
            int first = numberStack.pop();
            int calc = calc(first, second, operation);
            numberStack.push(calc);
        }

        System.out.println(numberStack.pop());
    }

    public static int calc(int first, int second, String operation) {
        if ("+".equals(operation)) {
            return first + second;
        } else if ("-".equals(operation)) {
            return first - second;
        } else if ("*".equals(operation)) {
            return first * second;
        } else if ("/".equals(operation)) {
            return first/second;
        }
        throw new RuntimeException("运算符错误。");
    }

    /**
     * 判断是否是运算符。
     *
     * @param operation
     * @return
     */
    public static boolean isOperationalCharacter(String operation) {
        if ("+".equals(operation) || "-".equals(operation) || "*".equals(operation) || "/".equals(operation)) {
            return true;
        }
        return false;
    }

    /**
     * 判断第一个符号的优先级大于第二个。
     * @param first
     * @param second
     * @return
     */
    public static boolean firstGreaterSecond(String first, String second) {
        if ("*".equals(first) || "/".equals(first)) {
            if ("+".equals(second) || "-".equals(second)) {
                return true;
            }
        }
        return false;
    }

}
