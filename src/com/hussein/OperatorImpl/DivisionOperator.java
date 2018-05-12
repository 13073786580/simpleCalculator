package com.hussein.OperatorImpl;

import com.hussein.Operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Description: 除法运算符
 * @author: Hussein
 * @E-mail: 43138199@qq.com
 * @date: 2018/5/11
 * @time: 0:18
 * 2018/5/11 0:18 Hussein create
 * @version: 1.0
 */
public class DivisionOperator extends Operator {

    private String dividendStr;
    private String divisorStr;

    /**
     * 执行运算之前堆栈中的数据
     */
    private Stack<String> lastStack;

    /**
     * @Description: 除法运算（保留15位小数，向下取整）
     * @author : Hussein
     * @E-mail：43138199@qq.com
     * @date: 2018/5/9
     * @time: 0:40
     * @return: a
     * @thros:
     * @note: 2018/5/9-0:40 Hussein  create
     */
    @Override
    public String operating() {
        BigDecimal dividend = new BigDecimal(dividendStr);
        BigDecimal divisor = new BigDecimal(divisorStr);
        return dividend.divide(divisor, 15, BigDecimal.ROUND_DOWN).toString();
    }

    @Override
    public Stack<String> getLastStack() {
        return lastStack;
    }

    public void setLastStack(Stack<String> lastStack) {
        this.lastStack = (Stack<String>) lastStack.clone();
    }

    public String getDividendStr() {
        return dividendStr;
    }

    public void setDividendStr(String dividendStr) {
        this.dividendStr = dividendStr;
    }

    public String getDivisorStr() {
        return divisorStr;
    }

    public void setDivisorStr(String divisorStr) {
        this.divisorStr = divisorStr;
    }
}
