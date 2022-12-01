package advent.of.code.solutions;

import advent.of.code.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/***
 * Part 1 - 74394
 * Part 2 - 212836
 */
public class Day1 extends BaseSolution {

    @Override
    public void transformInputData() {
        long largestSum = 0;
        long sum = 0;
        for (String i : input) {
            if("".equals(i)) {
                if(sum > largestSum) {
                    largestSum = sum;

                }
                sum = 0;
            } else {
                sum += Long.parseLong(i);
            }
        }
        context.put("output1", largestSum);
    }

    @Override
    public void runPart1() {
        setUp("1");
        transformInputData();

        System.out.println(context.get("output1"));
    }

    @Override
    public void runPart2() {
        //setUp("1");
        long largestSum1 = 0;
        long largestSum2 = 0;
        long largestSum3 = 0;
        long sum = 0;
        for (int i = 0; i < input.size(); i++) {

            sum += Long.parseLong("".equals(input.get(i)) ? "0" :input.get(i));

            if ("".equals(input.get(i)) || i == input.size() - 1) {
                if (sum > largestSum1) {
                    largestSum3 = largestSum2;
                    largestSum2 = largestSum1;
                    largestSum1 = sum;
                } else if (sum > largestSum2) {
                    largestSum3 = largestSum2;
                    largestSum2 = sum;
                } else if (sum > largestSum3) {
                    largestSum3 = sum;
                }
                sum = 0;
            }
        }

        System.out.println(largestSum1 + largestSum2 + largestSum3);

        alternateSolution();
    }

    public void alternateSolution() {
        System.out.println();
        System.out.println("Alternate solution");
        List<Long> calories = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < input.size(); i++) {
            sum += Long.parseLong("".equals(input.get(i)) ? "0" : input.get(i));
            if ("".equals(input.get(i)) || i == input.size() - 1) {
                calories.add(sum);
                sum = 0;
            }
        }
        calories.sort((o1, o2) -> o2.compareTo(o1));
        System.out.println(calories.get(0));
        System.out.println(sumOfN(calories, 3));
    }

    private Long sumOfN(List<Long> calories, int i) {
        return calories.get(0) + calories.get(1) + calories.get(2);
    }

}
