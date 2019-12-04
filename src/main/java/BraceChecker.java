/*Write a function that takes a string of braces,and determines if the order of the braces is valid.
It should return true if the string is valid,and false if it's invalid.

This Kata is similar to the Valid Parentheses Kata,but introduces new characters:brackets[],and curly braces{}.
Thanks to@arnedag for the idea!

All input strings will be nonempty,and will only consist of parentheses,brackets and curly braces:()[]{}.

What is considered Valid?
A string of braces is considered valid if all braces are matched with the correct brace.*/

import java.util.Stack;

public class BraceChecker {

    public boolean isValid(String braces) {
        Stack<Character> stack = new Stack<>();
        for (Character c : braces.toCharArray()) {
            if (Pairs.isFirstMember(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !Pairs.getFirstMember(c).equals(stack.pop())) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private enum Pairs {
        BRACES('(',')'),
        BRACKETS('[',']'),
        CURLY_BRACES('{','}');



        private Character firstMember;
        private Character secondMember;

        Pairs(Character firstMember, Character secondMember) {
            this.firstMember = firstMember;
            this.secondMember = secondMember;
        }

        public Character getFirstMember() {
            return firstMember;
        }

        public Character getSecondMember() {
            return secondMember;
        }

        public static boolean isFirstMember(Character c) {
            for (Pairs p : Pairs.values()) {
                if (p.firstMember.equals(c)) {
                    return true;
                }
            }
            return false;
        }

        public static Character getFirstMember(Character c) {
            for (Pairs p : Pairs.values()) {
                if (p.getSecondMember().equals(c)) {
                    return p.getFirstMember();
                }
            }
            return 'a';
        }
    }
}
