package com.hussein.OperatorImpl;

import com.hussein.Operator;

import java.util.Stack;

/**
 * @Description: 开方运算符
 * @author: Hussein
 * @E-mail: 43138199@qq.com
 * @date: 2018/5/12
 * @time: 23:37
 * 2018/5/12 23:37 Hussein create
 * @version: 1.0
 */
public class SqrtOperator extends Operator {

    /**
     * 精度
     */
    private static final double deviation = 0.00000000000001;

    private String sqrtNum;
    /**
     * 执行运算之前堆栈中的数据
     */
    private Stack<String> lastStack;

    @Override
    public String operating() {
        double num = Double.valueOf(sqrtNum);
        double max = Double.valueOf(num);
        double min = 0, middle =0, tempDeviation = 0;
        do {
            middle = (max + min) / 2;
            double middleSquare = middle * middle;
            if (middleSquare > num) {
                max = middle;
                tempDeviation = middleSquare - num;
            } else {
                min = middle;
                tempDeviation = num - middleSquare;
            }
        } while (tempDeviation > deviation);
        return Double.toString(middle);
    }

    public String getSqrtNum() {
        return sqrtNum;
    }

    public void setSqrtNum(String sqrtNum) {
        this.sqrtNum = sqrtNum;
    }

    @Override
    public Stack<String> getLastStack() {
        return lastStack;
    }

    public void setLastStack(Stack<String> lastStack) {
        this.lastStack = (Stack<String>) lastStack.clone();
    }
}
