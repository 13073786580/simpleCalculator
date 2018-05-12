package com.hussein.OperatorImpl;

import com.hussein.Operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Description: 减法运算符
 * @author: Hussein
 * @E-mail: 43138199@qq.com
 * @date: 2018/5/11
 * @time: 0:08
 * 2018/5/11 0:08 Hussein create
 * @version: 1.0
 */
public class SubtractionOperator extends Operator {

    private String subtrahendStr;
    private String minuendStr;

    /**
     * 执行运算之前堆栈中的数据
     */
    private Stack<String> lastStack;

    /**
     * @Description: 减法运算
     * @author : Hussein
     * @E-mail：43138199@qq.com
     * @date: 2018/5/9
     * @time: 0:26
     * @return: a
     * @thros:
     * @note: 2018/5/9-0:26 Hussein  create
     */
    @Override
    public String operating() {
        BigDecimal subtrahend = new BigDecimal(subtrahendStr);
        BigDecimal minuend = new BigDecimal(minuendStr);
        return subtrahend.subtract(minuend).toString();
    }

    @Override
    public Stack<String> getLastStack() {
        return lastStack;
    }

    public void setLastStack(Stack<String> lastStack) {
        this.lastStack = (Stack<String>) lastStack.clone();
    }

    public String getSubtrahendStr() {
        return subtrahendStr;
    }

    public void setSubtrahendStr(String subtrahendStr) {
        this.subtrahendStr = subtrahendStr;
    }

    public String getMinuendStr() {
        return minuendStr;
    }

    public void setMinuendStr(String minuendStr) {
        this.minuendStr = minuendStr;
    }
}
