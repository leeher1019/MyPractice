package com.mypractice.leetcode;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args){
        String string = "[";
        ValidParentheses validParentheses = new ValidParentheses();
        validParentheses.isValid(string);
    }

    public boolean isValid(String s) {
        Stack<Character> stringStack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '{'){
                stringStack.push('}');
            } else if (c == '['){
                stringStack.push(']');
            } else if (c == '('){
                stringStack.push(')');
            } else if (stringStack.isEmpty() || stringStack.pop() != c){
                return false;
            }
        }
        return stringStack.isEmpty();
    }

    public boolean fastIsValid(String s){
        char[] stack = new char[s.length()];
        int head = 0;
        for(char c : s.toCharArray()) {
            switch(c) {
                case '{':
                case '[':
                case '(':
                    stack[head++] = c;
                    break;
                case '}':
                    if(head == 0 || stack[--head] != '{') return false;
                    break;
                case ')':
                    if(head == 0 || stack[--head] != '(') return false;
                    break;
                case ']':
                    if(head == 0 || stack[--head] != '[') return false;
                    break;
            }
        }
        return head == 0;
    }
}
