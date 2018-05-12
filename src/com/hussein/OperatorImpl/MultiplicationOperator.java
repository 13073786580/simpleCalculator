package com.hussein.OperatorImpl;

import com.hussein.Operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Description: 乘法运算符
 * @author: Hussein
 * @E-mail: 43138199@qq.com
 * @date: 2018/5/11
 * @time: 0:14
 * 2018/5/11 0:14 Hussein create
 * @version: 1.0
 */
public class MultiplicationOperator extends Operator {

    private String multiplierStr;
    private String multiplicandStr;

    /**
     * 执行运算之前堆栈中的数据
     */
    private Stack<String> lastStack;

    /**
     * @Description: 乘法运算（保留15位小数，向下取整）
     * @author : Hussein
     * @E-mail：43138199@qq.com
     * @date: 2018/5/9
     * @time: 0:34
     * @return: a
     * @thros:
     * @note: 2018/5/9-0:34 Hussein  create
     */
    @Override
    public String operating() {
        BigDecimal multiplier = new BigDecimal(multiplierStr);
        BigDecimal multiplicand = new BigDecimal(multiplicandStr);
        return setScale(multiplier.multiply(multiplicand).toString());
    }

    /**
     * @param bigDecimal
     * @Description: 调整精度
     * @author : Hussein
     * @E-mail：43138199@qq.com
     * @date: 2018/5/9
     * @time: 1:14
     * @return: a
     * @thros:
     * @note: 2018/5/9-1:14 Hussein  create
     */
    private static String setScale(String bigDecimal) {
        if (!bigDecimal.contains(".")) {
            // @Description:结果为整数，无需调整 2018/5/9 1:16 Hussein
            return bigDecimal.toString();
        } else {
            return bigDecimal.substring(0, bigDecimal.indexOf(".") + 16);
        }
    }

    @Override
    public Stack<String> getLastStack() {
        return lastStack;
    }

    public void setLastStack(Stack<String> lastStack) {
        this.lastStack = (Stack<String>) lastStack.clone();
    }

    public String getMultiplierStr() {
        return multiplierStr;
    }

    public void setMultiplierStr(String multiplierStr) {
        this.multiplierStr = multiplierStr;
    }

    public String getMultiplicandStr() {
        return multiplicandStr;
    }

    public void setMultiplicandStr(String multiplicandStr) {
        this.multiplicandStr = multiplicandStr;
    }
}
