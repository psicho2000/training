package de.psicho.codewars.calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BrainLuck {
    Loop codeTree;

    public BrainLuck(String code) {
        codeTree = new Loop(code);
        codeTree.setBase();
        codeTree.reset();
    }

    public String process(String input) {
        Input.set(input);
        Output.reset();
        codeTree.interpret();
        return Output.get();
    }
}

class Data {
    Element head;
    Element tail;
    Element pointer;
    Element NULL;

    public Data() {
        NULL = new Element((byte) 0);
        NULL.next = NULL;
        NULL.prev = NULL;
        head = NULL;
        tail = NULL;
        pointer = NULL;
        append((byte) 0);
    }

    public void incPtr() {
        if (pointer.next == NULL) {
            append((byte) 0);
        }
        pointer = pointer.next;
    }

    public void decPtr() {
        if (pointer.prev == NULL) {
            prepend((byte) 0);
        }
        pointer = pointer.prev;
    }

    public void incData() {
        pointer.data++;
    }

    public void decData() {
        pointer.data--;
    }

    public void storeData(byte data) {
        pointer.data = data;
    }

    public byte getData() {
        return pointer.data;
    }

    private void append(byte data) {
        if (tail == NULL) {
            tail = new Element(data);
            tail.next = NULL;
            tail.prev = NULL;
            head = tail;
            pointer = head;
        } else if (head == tail) {
            tail = new Element(data);
            tail.next = NULL;
            tail.prev = head;
            head.next = tail;
        } else {
            Element newEle = new Element(data);
            newEle.next = NULL;
            newEle.prev = tail;
            tail.next = newEle;
            tail = newEle;
        }
    }

    private void prepend(byte data) {
        if (head == NULL) {
            head = new Element(data);
            head.next = NULL;
            head.prev = NULL;
            tail = head;
            pointer = head;
        } else if (head == tail) {
            head = new Element(data);
            head.next = tail;
            head.prev = NULL;
            tail.prev = head;
        } else {
            Element newEle = new Element(data);
            newEle.next = head;
            newEle.prev = NULL;
            head.prev = newEle;
            head = newEle;
        }
    }

    class Element {
        byte data;
        Element next;
        Element prev;

        public Element(byte argData) {
            data = argData;
        }
    }
}

class Input {
    private static Queue<Character> in;

    public static void set(String input) {
        in = new LinkedList<Character>();
        for (Character c : input.toCharArray()) {
            in.add(c);
        }
    }

    public static byte getChar() {
        Character nextChar = in.poll();
        if (nextChar == null) {
            return 0;
        } else {
            String s = String.valueOf(nextChar);
            char[] buf = s.toCharArray();
            return (byte) buf[0];
        }
    }
}

class Output {
    private static StringBuilder out = new StringBuilder();

    public static void append(byte b) {
        char c = (char) (b & 0xFF);
        out.append(c);
    }

    public static String get() {
        return out.toString();
    }

    public static void reset() {
        out = new StringBuilder();
    }
}

class Command {
    // command is either atom or loop, never both
    Character atom = null;
    Loop loop = null;

    // create command with atom > < + - . ,
    public Command(Character argAtom) {
        atom = argAtom;
    }

    // create command with loop []
    public Command(String argLoop) {
        loop = new Loop(argLoop);
    }
}

/*
 * base is not being looped. If code starts with loop, base loop contains the starting loop itself.
 */
class Loop {
    List<Command> codeTree = new ArrayList<Command>();
    boolean isBase = false;
    static Data data = new Data();

    public Loop(String code) {
        int loopStart = code.indexOf('[');
        int loopEnd = -1;
        while (loopStart > -1) {
            // add commands before loop start
            addAtoms(code.substring(loopEnd + 1, loopStart));

            // add loop
            loopEnd = findMatchingBrace(code, loopStart + 1);
            codeTree.add(new Command(code.substring(loopStart + 1, loopEnd)));

            loopStart = code.indexOf('[', loopEnd);
        }
        // add commands after last ] or whole code, if no loop exists
        addAtoms(code.substring(loopEnd + 1));
    }

    private int findMatchingBrace(String code, int start) {
        for (int numOpenBraces = 1, i = start, n = code.length(); i < n; i++) {
            char c = code.charAt(i);

            if (c == '[')
                numOpenBraces++;
            if (c == ']')
                numOpenBraces--;
            if (numOpenBraces == 0)
                return i;
        }
        return -1;
    }

    public void interpret() {
        if (isBase) {
            // don't loop the base
            excecuteCommands();
        } else {
            if (data.getData() != 0) { // do the loop for [
                do {
                    excecuteCommands();
                } while (data.getData() != 0); // do the loop for ]
            }
        }
    }

    private void excecuteCommands() {
        for (Command c : codeTree) {
            if (c.loop != null) {
                c.loop.interpret();
            } else {
                switch (c.atom) {
                case '>':
                    data.incPtr();
                    break;
                case '<':
                    data.decPtr();
                    break;
                case '+':
                    data.incData();
                    break;
                case '-':
                    data.decData();
                    break;
                case '.':
                    Output.append(data.getData());
                    break;
                case ',':
                    data.storeData(Input.getChar());
                    break;
                }
            }
        }
    }

    private void addAtoms(String atoms) {
        for (Character c : atoms.toCharArray()) {
            codeTree.add(new Command(c));
        }
    }

    public void setBase() {
        isBase = true;
    }

    public void reset() {
        data = new Data();
    }
}