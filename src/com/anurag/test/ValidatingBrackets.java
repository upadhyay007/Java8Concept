package com.anurag.test;

import java.util.Stack;

public class ValidatingBrackets {
	public static void main(String[] args) {
		System.out.println(isValidBracketString("[([()])]"));
	}

	static boolean isValidBracketString(String string) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < string.length(); i++) {
			
			if (string.charAt(i) == '{' || string.charAt(i) == '[' || string.charAt(i) == '(') {
				stack.push(string.charAt(i));
			} else if (string.charAt(i) == '}' || string.charAt(i) == ']' || string.charAt(i) == ')') {
				if (stack.size() == 0)
					return false;
				switch (stack.pop()) {
				case '(':
					if (string.charAt(i) != ')')
						return false;
					break;
				case '[':
					if (string.charAt(i) != ']')
						return false;
					break;
				case '{':
					if (string.charAt(i) != '}')
						return false;
					break;
				}
			}
		}
		return stack.size() == 0;
	}
}
