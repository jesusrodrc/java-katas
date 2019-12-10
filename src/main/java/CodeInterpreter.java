/*Inspired from real-world Brainf**k, we want to create an interpreter of that language which will support the following
instructions (the machine memory or 'data' should behave like a potentially infinite array of bytes, initialized to 0):

    > increment the data pointer (to point to the next cell to the right).
    < decrement the data pointer (to point to the next cell to the left).
    + increment (increase by one, truncate overflow: 255 + 1 = 0) the byte at the data pointer.
    - decrement (decrease by one, treat as unsigned byte: 0 - 1 = 255 ) the byte at the data pointer.
    . output the byte at the data pointer.
    , accept one byte of input, storing its value in the byte at the data pointer.
    [ if the byte at the data pointer is zero, then instead of moving the instruction pointer forward to the next command,
      jump it forward to the command after the matching ] command.
    ] if the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward to the next command,
      jump it back to the command after the matching [ command.

    The function will take in input...

     the program code, a string with the sequence of machine instructions,
     the program input, a string, eventually empty, that will be interpreted as an array of bytes using each character's ASCII code and will be consumed by the , instruction

    ... and will return ...

     the output of the interpreted code (always as a string), produced by the . instruction.*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CodeInterpreter {

    private int[] bytes = new int[255];
    private int pointer = 0;
    private Deque<Character> code;
    private Stack<Character> consumedCode;

    public CodeInterpreter(String codeString) {
        this.code = new LinkedList<>();
        for (Character c : codeString.toCharArray()) {
            code.add(c);
        }
        for (int i=0;i<bytes.length;i++) {
            bytes[i] = 0;
        }
    }

    public String process(String input) {
        StringBuilder output = new StringBuilder();
        Queue<Character> queueInput = new LinkedList<>();
        for (Character c : input.toCharArray()) {
            queueInput.add(c);
        }
        consumedCode = new Stack<>();
        while (!code.isEmpty()) {
            Character instruction = code.poll();
            consumedCode.push(instruction);
            processInstruction(instruction, output, queueInput);
        }
        return output.toString();
    }

    private void processInstruction(Character instruction, StringBuilder output, Queue<Character> input) {
        switch (instruction) {
            case '>' : pointer = pointer + 1;
                       return;
            case '<' : pointer = pointer - 1;
                       return;
            case'+' :  if (bytes[pointer] == 255) {bytes[pointer] = 0;} else {bytes[pointer] = bytes[pointer]+1;}
                       return;
            case '-' : if (bytes[pointer] == 0) {bytes[pointer] = 255;} else {bytes[pointer] = bytes[pointer]-1;}
                       return;
            case '.' : output.append((char) bytes[pointer]);
                       return;
            case ',' : if (!input.isEmpty()) bytes[pointer] = (byte) input.poll().charValue();
                       return;
            case '[' : if (bytes[pointer] == 0) advanceToNextBracket();
                       return;
            case ']' : if (bytes[pointer] != 0) goBackToBracket();
                       return;
            default: return;
        }
    }

    private void advanceToNextBracket() {
        int foundOpeningBrackets = 0;
        while(!code.isEmpty() && !(foundOpeningBrackets == 0 && code.peek() == ']')) {
            Character character = code.poll();
            consumedCode.push(character);
            if (character == '[') {
                foundOpeningBrackets++;
            }
            if (character == ']') {
                foundOpeningBrackets--;
            }
        }
        consumedCode.push(code.poll());
    }

    private void goBackToBracket() {
        int foundClosingBrackets = 0;
        code.addFirst(consumedCode.pop());
        while(!consumedCode.isEmpty() && !(foundClosingBrackets == 0 && consumedCode.peek() == '[')) {
            Character character = consumedCode.pop();
            if (character == ']') {
                foundClosingBrackets++;
            }
            if (character == '[') {
                foundClosingBrackets--;
            }
            code.addFirst(character);
        }
    }
}
