package advent.of.code;

import advent.of.code.solutions.Day1;
import com.sun.tools.javac.Main;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Executor {

    public static void main(String[] args) throws IOException {
        BaseSolution soln = new Day1();
        soln.run();

        //getClasspathEntriesByPath("day_1").forEach(i -> System.out.println(i));
    }


    private static List<String> getClasspathEntriesByPath(String path) throws IOException {
        InputStream is = Main.class.getClassLoader().getResourceAsStream(path);

        StringBuilder sb = new StringBuilder();
        while (is.available()>0) {
            byte[] buffer = new byte[1024];
            sb.append(new String(buffer, Charset.defaultCharset()));
        }

        return Arrays
                .asList(sb.toString().split("\n"))          // Convert StringBuilder to individual lines
                .stream()                                   // Stream the list
                .filter(line -> line.trim().length()>0)     // Filter out empty lines
                .collect(Collectors.toList());              // Collect remaining lines into a List again
    }
}
