package com.hussein;

import com.hussein.OperatorImpl.*;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Description: 简单计算器
 * @author: Hussein
 * @E-mail: 43138199@qq.com
 * @date: 2018/5/10
 * @time: 23:55
 * 2018/5/10 23:55 Hussein create
 * @version: 1.1
 */
public class Calculator {

    private static final String ADD = "\\+";
    private static final String SUB = "\\-";
    private static final String MUL = "\\*";
    private static final String DIV = "\\/";
    private static final String SQRT = "sqrt";
    private static final String UNDO = "undo";
    private static final String CLEAR = "clear";

    private static Stack<String> numStack = new Stack<>();
    private static Stack<Operator> operatorStack = new Stack<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("expression：");
            // @Description:输入逆波兰式 2018/5/8 22:32 Hussein
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine().trim();
            // @Description:解析并运算结果 2018/5/9 0:47 Hussein
            analysisRPN(input);
            System.out.print("stack : ");
            Iterator iterator = numStack.iterator();
            while (iterator.hasNext()) {
                String num = (String) iterator.next();
                num = display(num);
                System.out.print(num + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * @param input
     * @Description: 解析并运算结果
     * @author : Hussein
     * @E-mail：43138199@qq.com
     * @date: 2018/5/9
     * @time: 0:50
     * @return: a
     * @thros:
     * @note: 2018/5/9-0:50 Hussein  create
     */
    private static void analysisRPN(String input) {
        String[] rpn = input.split(" ");
        for (String s : rpn) {
            if (s.matches("[0-9]+") || s.matches("[0-9]+.[0-9]+")) {
                // @Description:判断是否为数字，是则存入栈 2018/5/8 22:32 Hussein
                numStack.push(s);
                operatorStack.push(null);
            } else if (s.matches("[\\+\\-\\*\\/\\(\\)]")) {
                if (numStack.size() < 2) {
                    System.out.println("operator <" + s + "> (position: <" + input.indexOf(s) + 1 + ">): insucient parameters");
                    return;
                }
                if (s.matches(ADD)) {
                    AdditionOperator addOperator = new AdditionOperator();
                    addOperator.setLastStack(numStack);
                    addOperator.setAugendStr(numStack.pop());
                    addOperator.setAddendStr(numStack.pop());
                    String result = addOperator.operating();
                    numStack.push(result);
                    operatorStack.push(addOperator);
                } else if (s.matches(SUB)) {
                    SubtractionOperator addOperator = new SubtractionOperator();
                    addOperator.setLastStack(numStack);
                    addOperator.setMinuendStr(numStack.pop());
                    addOperator.setSubtrahendStr(numStack.pop());
                    String result = addOperator.operating();
                    numStack.push(result);
                    operatorStack.push(addOperator);
                } else if (s.matches(MUL)) {
                    MultiplicationOperator addOperator = new MultiplicationOperator();
                    addOperator.setLastStack(numStack);
                    addOperator.setMultiplicandStr(numStack.pop());
                    addOperator.setMultiplierStr(numStack.pop());
                    String result = addOperator.operating();
                    numStack.push(result);
                    operatorStack.push(addOperator);
                } else if (s.matches(DIV)) {
                    DivisionOperator addOperator = new DivisionOperator();
                    addOperator.setLastStack(numStack);
                    addOperator.setDivisorStr(numStack.pop());
                    addOperator.setDividendStr(numStack.pop());
                    String result = addOperator.operating();
                    numStack.push(result);
                    operatorStack.push(addOperator);
                }
            } else if (s.matches(SQRT)) {
                // @Description:开方 2018/5/9 0:53 Hussein
                if (numStack.size() < 1) {
                    System.out.println("operator <" + s + "> (position: <" + input.indexOf(s) + 1 + ">): insucient parameters");
                    return;
                } else {
                    SqrtOperator sqrtOperator = new SqrtOperator();
                    sqrtOperator.setLastStack(numStack);
                    sqrtOperator.setSqrtNum(numStack.pop());
                    String result = sqrtOperator.operating();
                    numStack.push(result);
                    operatorStack.push(sqrtOperator);
                }
            } else if (s.matches(UNDO)) {
                // @Description:回退 2018/5/9 0:53 Hussein
                if (operatorStack.size() == 0) {
                    System.out.println("operator <" + s + "> (position: <" + input.indexOf(s) + 1 + ">): there's no remainder operation can undo");
                    return;
                }
                undo();
            } else if (s.matches(CLEAR)) {
                // @Description:清空 2018/5/9 0:53 Hussein
                ClearOperator clearOperator = new ClearOperator();
                clearOperator.setLastStack((Stack<String>) numStack.clone());
                operatorStack.push(clearOperator);
                numStack.removeAllElements();
            } else {
                // @Description:非法参数 2018/5/9 0:45 Hussein
                System.out.println("operator <" + s + "> (position: <" + input.indexOf(s) + 1 + ">): invalid parameters");
                return;
            }
        }
    }

    /**
     * @param
     * @Description: 回退操作
     * @author : Hussein
     * @E-mail：43138199@qq.com
     * @date: 2018/5/13
     * @time: 16:17
     * @return: a
     * @thros:
     * @note: 2018/5/13-16:17 Hussein  create
     */
    private static void undo() {
        Operator operator = operatorStack.pop();
        if (operator == null) {
            // @Description:若操作符为空代表上次操作为存入数据 2018/5/13 15:03 Hussein
            numStack.pop();
            return;
        }
        Stack<String> lastStack = operator.getLastStack();
        numStack.clear();
        numStack = (Stack<String>) lastStack.clone();
    }

    /**
     * @param num
     * @Description: 展示10位小数
     * @author : Hussein
     * @E-mail：43138199@qq.com
     * @date: 2018/5/10
     * @time: 1:08
     * @return: a
     * @thros:
     * @note: 2018/5/10-1:08 Hussein  create
     */
    private static String display(String num) {
        if (num.contains(".")) {
            String decimal = num.substring(num.indexOf(".") + 1, num.length());
            if (decimal.length() > 10) {
                num = num.substring(0, num.indexOf(".") + 11);
            }
        }
        return num;
    }

}
