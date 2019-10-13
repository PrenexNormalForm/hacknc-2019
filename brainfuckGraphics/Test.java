package brainfuckGraphics;

public class Test{
    public static void main(String[] args){
        String fuckyeah = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        BrainfuckInterpreter b = new BrainfuckInterpreter( new BrainfuckProgram(fuckyeah));
        b.execAll();
    }
}
