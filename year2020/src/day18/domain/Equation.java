package day18.domain;

import day18.domain.operands.ComplexOperand;
import day18.domain.operands.Operand;
import day18.domain.operands.SimpleOperand;
import day18.domain.operations.Addition;
import day18.domain.operations.Multiplication;
import day18.domain.operations.Operation;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Equation {

    private final String raw;

    public Equation(String raw) {
        this.raw = raw;
    }

    public long solve() {
        int depth = 0;
        Operation operation = null;
        Operand left = null;
        Operand right = null;
        String sub = "";
        char[] equationChars = raw.toCharArray();
        for (int i = 0; i < equationChars.length; i++) {
            char currentChar = equationChars[i];
            sub += currentChar;

            switch(currentChar) {
                case '(':
                    depth++;
                    break;
                case ')':
                    depth--;
                    if (depth == 0) {
                        sub = sub.substring(1, sub.length() - 1);
                        if (left == null) {
                            left = new ComplexOperand(new Equation(sub));
                        } else {
                            right = new ComplexOperand(new Equation(sub));
                        }
                        sub = "";
                    }
                    break;
                case '+':
                    if (depth == 0) {
                        operation = new Addition();
                        sub = "";
                    }
                    break;
                case '*':
                    if (depth == 0) {
                        operation = new Multiplication();
                        sub = "";
                    }
                    break;
                default:
                    if (depth == 0) {
                        if (left == null) {
                            left = new SimpleOperand(parseLong(sub));
                        } else {
                            right = new SimpleOperand(parseLong(sub));
                        }
                        sub = "";
                    }
            }

            if (left != null && operation != null && right != null) {
                left = new SimpleOperand(operation.perform(left, right));
                operation = null;
                right = null;
            }
        }

        return left.getValue();
    }

    @Override
    public String toString() {
        return "Equation: " + raw;
    }
}
