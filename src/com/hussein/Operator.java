package com.hussein;

import java.util.Stack;

/**
 * @Description: 运算符
 * @author: Hussein
 * @E-mail: 43138199@qq.com
 * @date: 2018/5/11
 * @time: 0:03
 * 2018/5/11 0:03 Hussein create
 * @version: 1.0
 */
public abstract class Operator {

    /**
     * @param
     * @Description: 运算方法
     * @author : Hussein
     * @E-mail：43138199@qq.com
     * @date: 2018/5/11
     * @time: 0:19
     * @return: a
     * @thros:
     * @note: 2018/5/11-0:19 Hussein  create
     */
    public abstract String operating();

    public abstract Stack<String> getLastStack();
}
