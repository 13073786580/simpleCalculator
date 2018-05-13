package com.hussein.OperatorImpl;

import com.hussein.Operator;

import java.util.Stack;

/**
 * @Description: 清空操作符
 * @author: Hussein
 * @E-mail: 43138199@qq.com
 * @date: 2018/5/13
 * @time: 16:12
 * 2018/5/13 16:12 Hussein create
 * @version: 1.0
 */
public class ClearOperator extends Operator {
    /**
     * 执行运算之前堆栈中的数据
     */
    private Stack<String> lastStack;

    @Override
    public String operating() {
        return null;
    }

    public void setLastStack(Stack<String> lastStack) {
        this.lastStack = lastStack;
    }

    @Override
    public Stack<String> getLastStack() {
        return lastStack;
    }
}
