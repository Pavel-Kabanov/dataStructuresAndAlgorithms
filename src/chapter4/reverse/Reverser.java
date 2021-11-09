package chapter4.reverse;

public class Reverser {
    private String input;
    private String output;

    public Reverser(String input) {
        this.input = input;
    }

    public String doRev() {
        StackX theStack = new StackX(input.length());

        for (int j = 0; j < input.length(); j++) {
            theStack.push(input.charAt(j));
        }

        output = "";
        while (!theStack.isEmpty()) {
            output = output + theStack.pop();
        }

        return output;
    }
}
