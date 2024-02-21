package codes.pattern_matching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test001 {
    public static void main(String[] args) {
        // Test001.f4("hi");
        // Test001.f3("hi");
        // Test001.f2("Hello");
        // Test001.f2(1);
        // Test001.f1();
    }

    public static void f4(Object obj) {
        if (!(obj instanceof String s)) {
            return;
        }

        // The s pattern variable is available oustide of the if statement, as long as your code leaves the method from the if branch
        System.out.println(s); // Java SE 16
    }

    public static void f3(Object obj) {
        if (obj instanceof String s && !s.isEmpty()) {
            int length = s.length();
            System.out.println(length);
        }
    }

    public static void f2(Object obj) {
        if (obj instanceof String s) {// Java SE 16
            System.out.println("This is a string: " + s);
        } else {
            System.out.println("This is not a string");
        }
    }

    public static void f1() {
        String str = """
            Hello World!
        """;
        Pattern pattern = Pattern.compile("\\bWorld\\b");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            System.out.printf("group: %s, start: %d, end: %d.%n", group, start, end);
        }
    }
}
