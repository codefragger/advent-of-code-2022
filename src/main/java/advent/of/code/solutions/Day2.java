package advent.of.code.solutions;

import advent.of.code.BaseSolution;
import advent.of.code.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Day2 extends BaseSolution {

    /*
    x = rock = 1
    y = paper = 2
    z = scissor = 3

    win = 6
    draw = 3
    lose = 0

     */
    @Override
    public void transformInputData() {
        List<Pair<String>> strategies = new ArrayList<>();
        input.forEach(in -> {
            String[] responses = in.split(" ");
            Pair<String> pair = new Pair<>(responses[0].trim(), responses[1].trim());
            strategies.add(pair);
        });
        context.put("transformedInput", strategies);
    }

    @Override
    public void runPart1() {
        setUp("1");
        transformInputData();
        List<Pair<String>> strategies = (List<Pair<String>>) context.get("transformedInput");
        int score = strategies.stream().mapToInt(s ->getMatchResultScore(s.firstValue, s.secondValue)).sum();
        System.out.println(score);
    }

    @Override
    public void runPart2() {
        /*
            x - lose
            y - draw
            z - win
        */
        List<Pair<String>> strategies = (List<Pair<String>>) context.get("transformedInput");
        int score = strategies.stream().mapToInt(s -> getMatchResultScorePart2(s.firstValue, s.secondValue)).sum();
        System.out.println(score);
    }

    private int getMatchResultScorePart2(String first, String second) {
        if (first.equalsIgnoreCase("A")) {
            if (second.equals("X")) {
                return 0 + getSelectionScore("Z");
            }
            if (second.equals("Y")) {
                return 3 + getSelectionScore("X");
            }
            if (second.equals("Z")) {
                return 6 + getSelectionScore("Y");
            }
        }
        if (first.equalsIgnoreCase("B")) {
            if (second.equals("X")) {
                return 0 + getSelectionScore("X");
            }
            if (second.equals("Y")) {
                return 3 + getSelectionScore("Y");
            }
            if (second.equals("Z")) {
                return 6 + getSelectionScore("Z");
            }
        }
        if (first.equalsIgnoreCase("C")) {
            if (second.equals("X")) {
                return 0 + getSelectionScore("Y");
            }
            if (second.equals("Y")) {
                return 3 + getSelectionScore("Z");
            }
            if (second.equals("Z")) {
                return 6 + getSelectionScore("X");
            }
        }
        return 0;
    }

    public Integer getMatchResultScore(String first, String second) {

        if (first.equalsIgnoreCase("A")) {
            if (second.equals("X")) {
                return 3 + getSelectionScore(second);
            }
            if (second.equals("Y")) {
                return 6 + getSelectionScore(second);
            }
            if (second.equals("Z")) {
                return 0 + getSelectionScore(second);
            }
        }
        if (first.equalsIgnoreCase("B")) {
            if (second.equals("X")) {
                return 0 + getSelectionScore(second);
            }
            if (second.equals("Y")) {
                return 3 + getSelectionScore(second);
            }
            if (second.equals("Z")) {
                return 6 + getSelectionScore(second);
            }
        }
        if (first.equalsIgnoreCase("C")) {
            if (second.equals("X")) {
                return 6 + getSelectionScore(second);
            }
            if (second.equals("Y")) {
                return 0 + getSelectionScore(second);
            }
            if (second.equals("Z")) {
                return 3 + getSelectionScore(second);
            }
        }
        return 0;
    }

    private int getSelectionScore(String second) {
        if (second.equals("X")) {
            return 1;
        }
        if (second.equals("Y")) {
            return 2;
        }
        if (second.equals("Z")) {
            return 3;
        }
        return 0;
    }


}
