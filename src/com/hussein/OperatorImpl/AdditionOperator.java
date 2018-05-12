package com.hussein.OperatorImpl;

import com.hussein.Operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Description: 加法运算符
 * @author: Hussein
 * @E-mail: 43138199@qq.com
 * @date: 2018/5/11
 * @time: 0:05
 * 2018/5/11 0:05 Hussein create
 * @version: 1.0
 */
public class AdditionOperator extends Operator {
    private String addendStr;
    private String augendStr;

    /**
     * 执行运算之前堆栈中的数据
     */
    private Stack<String> lastStack;

    /**
     * @Description: 加法运算
     * @author : Hussein
     * @E-mail：43138199@qq.com
     * @date: 2018/5/8
     * @time: 0:03
     * @return: a
     * @thros:
     * @note: 2018/5/8-0:03 Hussein  create
     */
    @Override
    public String operating() {
        BigDecimal addend = new BigDecimal(addendStr);
        BigDecimal augend = new BigDecimal(augendStr);
        return addend.add(augend).toString();
    }

    @Override
    public Stack<String> getLastStack() {
        return lastStack;
    }

    public void setLastStack(Stack<String> lastStack) {
        this.lastStack = (Stack<String>) lastStack.clone();
    }

    public String getAddendStr() {
        return addendStr;
    }

    public void setAddendStr(String addendStr) {
        this.addendStr = addendStr;
    }

    public String getAugendStr() {
        return augendStr;
    }

    public void setAugendStr(String augendStr) {
        this.augendStr = augendStr;
    }
}
