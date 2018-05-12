import com.hussein.Operator;
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
 * @version: 1.0
 */
public class Calculator {

    private static final String ADD = "\\+";
    private static final String SUB = "\\-";
    private static final String MUL = "\\*";
    private static final String DIV = "\\/";
    private static final String SQRT = "sqrt";
    private static final String UNDO = "undo";
    private static final String CLEAR = "clear";
    private static final double deviation = 0.00000000000001;

    private static Stack<String> numStack = new Stack<>();
    private static Stack<Operator> operatorStack = new Stack<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("expression：");
            // @Description:输入逆波兰式 2018/5/8 22:32 Hussein
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
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
                undo();
            } else if (s.matches(CLEAR)) {
                // @Description:清空 2018/5/9 0:53 Hussein
                numStack.removeAllElements();
            } else {
                // @Description:非法参数 2018/5/9 0:45 Hussein
                System.out.println("operator <" + s + "> (position: <" + input.indexOf(s) + 1 + ">): invalid parameters");
                return;
            }
        }
    }

    private static void undo() {
        Operator operator = operatorStack.pop();
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
            if (decimal.length() > 15) {
                num = num.substring(0, num.indexOf(".") + 11);
            }
        }
        return num;
    }
//    /**
//     * @param
//     * @Description: 二分法求平方根
//     * @author : Hussein
//     * @E-mail：43138199@qq.com
//     * @date: 2018/5/9
//     * @time: 23:59
//     * @return: a
//     * @thros:
//     * @note: 2018/5/9-23:59 Hussein  create
//     */
//    private static void sqrt() {
//        String trashNum = numStack.pop();
//        trash.push(trashNum);
//        double num = Double.valueOf(trashNum);
//        double max = Double.valueOf(num);
//        double min = 0, middle =0, tempDeviation = 0;
//        do {
//            middle = (max + min) / 2;
//            double middleSquare = middle * middle;
//            if (middleSquare > num) {
//                max = middle;
//                tempDeviation = middleSquare - num;
//            } else {
//                min = middle;
//                tempDeviation = num - middleSquare;
//            }
//        } while (tempDeviation > deviation);
//        stack.push(String.valueOf(middle));
//    }

}
