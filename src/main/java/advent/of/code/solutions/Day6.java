package advent.of.code.solutions;

import advent.of.code.BaseSolution;

import java.util.Set;
import java.util.stream.Collectors;

public class Day6 extends BaseSolution {

    @Override
    public void transformInputData() {

    }

    @Override
    public void runPart1() {
        setUp("1");
        String message = input.get(0);
        message.chars().mapToObj(Character::toString);
        int size = 4;
        int output = execute(message, size);
        System.out.println(output);
    }

    private int execute(String message, int size) {
        int output;
        for (int i = 0; i < message.length(); i++) {
            Set<String> set = message.substring(i, i + size).chars().mapToObj(Character::toString).collect(Collectors.toSet());
            if(set.size() == size) {
                return i + size;
            }
        }
        return 0;
    }

    @Override
    public void runPart2() {
        String message = input.get(0);
        message.chars().mapToObj(Character::toString);
        int size = 14;
        int output = execute(message, size);
        System.out.println(output);
    }


}
