package brainfuckGraphics;

import java.util.Scanner;
import java.io.*;

public class Main {

    public static String readFile(String filePath) {
        try {
            File brainfuckProgram = new File(filePath);
            Scanner fuck = new Scanner(brainfuckProgram);
            String bfString = "";
            while (fuck.hasNextLine()) {
                String line = fuck.nextLine();
                bfString = bfString + "\n" + line;
            }
            fuck.close();
            return bfString;
        } catch (FileNotFoundException e) {
            System.out.printf("file: '%s' does not exist\nExiting...\n", filePath);
            System.exit(1);
        }
        return "NO";
    }

    public static void main(String[] args) {
        String bfString = readFile(args[0]);
        BrainfuckProgram programObject = new BrainfuckProgram(bfString);
        BrainfuckInterpreter interpreterObject = new BrainfuckInterpreter(programObject);
        BrainfuckController mainEngine = new BrainfuckController(interpreterObject);
        mainEngine.execute();
        mainEngine.draw();
        System.out.println("done");
    }
}
