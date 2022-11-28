package advent.of.code;

import java.io.InputStream;
import java.util.*;

public abstract class BaseSolution {

    public static String INPUT_PATH= "day_%s/input_%s.txt";

    public String day;

    public List<String> input;

    public Map<String, Object> context = new HashMap<>();


    public BaseSolution(String day) {
        this.day = day;
    }

    public BaseSolution() {
        day = this.getClass().getSimpleName().replace("Day", "");
    }



    public List<String> readInput(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        List<String> input = new ArrayList<>();
        while(scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }

        return input;
    }

    public abstract void transformInputData();

    public List<String> readTestInput() {
        return readInput(this.getClass().getClassLoader().getResourceAsStream(String.format(INPUT_PATH, day, "test")));
    }

    public List<String> readInput1() {
        return readInput(this.getClass().getClassLoader().getResourceAsStream(String.format(INPUT_PATH, day, "1")));
    }

    public List<String> readInput2() {
        return readInput(this.getClass().getClassLoader().getResourceAsStream(String.format(INPUT_PATH, day, "2")));
    }

    public void setUp(String inputRef) {
        switch (inputRef) {
            case "1" -> this.input = readInput1();
            case "2" -> this.input = readInput2();
            default -> this.input = readTestInput();
        }
    }

    public void run() {
        runPart1();
        runPart2();
    }

    public abstract void runPart1();

    public abstract void runPart2();
}

