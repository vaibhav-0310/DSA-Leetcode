// Assuming NestedInteger class is already defined with the following methods:
// - NestedInteger() initializes an empty nested list.
// - NestedInteger(int value) initializes a single integer.
// - void add(NestedInteger ni) adds a NestedInteger element to this NestedInteger.
// - boolean isInteger() returns true if this NestedInteger holds a single integer.
// - Integer getInteger() returns the single integer that this NestedInteger holds, if it holds a single integer.
// - List<NestedInteger> getList() returns the nested list that this NestedInteger holds, if it holds a nested list.

public class Solution {
    public NestedInteger deserialize(String s) {
        Object parsed = parse(s);
        return dfs(parsed);
    }

    private Object parse(String s) {
        if (s.charAt(0) == '[') {
            List<Object> list = new ArrayList<>();
            int start = 1, depth = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '[') depth++;
                else if (s.charAt(i) == ']') depth--;
                else if (s.charAt(i) == ',' && depth == 0) {
                    list.add(parse(s.substring(start, i)));
                    start = i + 1;
                }
            }
            if (start < s.length() - 1) list.add(parse(s.substring(start, s.length() - 1)));
            return list;
        } else {
            return Integer.parseInt(s);
        }
    }

    private NestedInteger dfs(Object input) {
        if (input instanceof Integer) {
            return new NestedInteger((int) input);
        }
        NestedInteger ni = new NestedInteger();
        for (Object obj : (List<Object>) input) {
            ni.add(dfs(obj));
        }
        return ni;
    }
}