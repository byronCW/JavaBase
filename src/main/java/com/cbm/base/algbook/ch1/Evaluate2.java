package com.cbm.base.algbook.ch1;


import org.apache.commons.lang3.math.NumberUtils;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * ClassName: Evaluate <br/> 
 * Description: Dijkstra的双栈算术表达式求值算法. <br/> 
 * Function: 双栈算术表达式求值. <br/> 
 * Reason: N/A. <br/> 
 * date: 2016年11月3日 下午11:41:19 <br/> 
 * 
 * @author byron 
 * @version  
 * @since JDK 1.7
 */
public class Evaluate2 {

	public static void main(String[] args) {
//		calculate();
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		while (!StdIn.isEmpty()) {
			// 读取字符串，如果是运算符则压入ops栈
			String s = StdIn.readString();
			if (s.equals("(")) {
				// do nothing
				;
			} else if (s.equals("+")) {
				ops.push(s);
			} else if (s.equals("+")) {
				ops.push(s);
			} else if (s.equals("-")) {
				ops.push(s);
			} else if (s.equals("*")) {
				ops.push(s);
			} else if (s.equals("/")) {
				ops.push(s);
			} else if (s.equals("sqrt")) {
				ops.push(s);
			} else if (s.equals(")")) {
				// 如果是“)”，则分别弹出运算符和操作数进行计算，并将结果压入操作数栈
				String op = ops.pop();
				Double v = vals.pop();
				if (op.equals("+")) {
					v = vals.pop() + v;
				} else if (op.equals("-")) {
					v = vals.pop() - v;
				} else if (op.equals("*")) {
					v = vals.pop() * v;
				} else if (op.equals("/")) {
					v = vals.pop() / v;
				} else if (op.equals("sqrt")) {
					v = Math.sqrt(v);
				}
				vals.push(v);
			} else {
				// 如果读取的字符即不是运算符也不是括号，则将其压入操作数栈
				vals.push(NumberUtils.createDouble(s));
			}
		}
		StdOut.println(vals.pop());
	}
	
	public static void calculate() {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		while (!StdIn.isEmpty()) {
			// 读取字符串，如果是运算符则压入ops栈
			String s = StdIn.readString();
			if (s.equals("(")) {
				// do nothing
				;
			} else if (s.equals("+")) {
				ops.push(s);
			} else if (s.equals("+")) {
				ops.push(s);
			} else if (s.equals("-")) {
				ops.push(s);
			} else if (s.equals("*")) {
				ops.push(s);
			} else if (s.equals("/")) {
				ops.push(s);
			} else if (s.equals("sqrt")) {
				ops.push(s);
			} else if (s.equals(")")) {
				// 如果是“)”，则分别弹出运算符和操作数进行计算，并将结果压入操作数栈
				String op = ops.pop();
				Double v = vals.pop();
				if (op.equals("+")) {
					v = vals.pop() + v;
				} else if (op.equals("-")) {
					v = vals.pop() - v;
				} else if (op.equals("*")) {
					v = vals.pop() * v;
				} else if (op.equals("/")) {
					v = vals.pop() / v;
				} else if (op.equals("sqrt")) {
					v = Math.sqrt(v);
				}
				vals.push(v);
			} else {
				// 如果读取的字符即不是运算符也不是括号，则将其压入操作数栈
				vals.push(NumberUtils.createDouble(s));
			}
		}
		StdOut.println(vals.pop());
//		System.out.println(vals.pop());
	}
	
}
