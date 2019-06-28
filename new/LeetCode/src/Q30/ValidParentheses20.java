package Q30;

import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {
        System.out.println(new ValidParentheses20().isValid("[(])"));
    }

    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeft(c))
                stack.push(c);
            else if (isRight(c)) {
                if(stack.empty())
                    return false;
                char t = stack.pop();
                if (!isMatch(t, c))
                    return false;
            } else
                return false;
        }
        return stack.empty();
    }

    public boolean isMatch(char a, char b) {
        switch (a) {
            case '(':
                return b == ')';

            case '[':
                return b == ']';

            case '{':
                return b == '}';

            default:
                return false;
        }
    }

    public boolean isLeft(char a) {
        return a == '(' || a == '[' || a == '{';
    }

    public boolean isRight(char a) {
        return a == ')' || a == ']' || a == '}';
    }
}
