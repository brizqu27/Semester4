import java.util.Scanner;

class Stack {
    int maxSize;
    char[] stackArray;
    int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }
    public void push(char j) {
        stackArray[++top] = j;
    }
    public char pop() {
        return stackArray[top--];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
}

public class keg1 {
    public static void main(String[] args) {
        System.out.print("Masukan Input: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int stackSize = input.length();
        Stack theStack = new Stack(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.push(ch);
        }

        System.out.print("Reversed : " );
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();
            System.out.print(ch);
        }
    }
}