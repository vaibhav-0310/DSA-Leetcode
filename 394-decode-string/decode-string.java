class Solution {
    public String decodeString(String s) {
         Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the repeat number (may have multiple digits)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current repeat count and current string to stacks
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Pop the repeat count and previous string
                StringBuilder decoded = stringStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decoded.append(current);
                }
                current = decoded;
            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }

}