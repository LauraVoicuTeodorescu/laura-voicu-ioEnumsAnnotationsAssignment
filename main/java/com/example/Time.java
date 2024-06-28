// Path: /src/main/java/com/example/ExpressionEvaluator.java
package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionEvaluator {

    public static int evaluate(String expression) {
        Pattern pattern = Pattern.compile("([+-]?\\d+\\s*(mm|cm|dm|m|km))");
        Matcher matcher = pattern.matcher(expression);

        int total = 0;

        while (matcher.find()) {
            String[] parts = matcher.group().split("\\s+");
            int value = Integer.parseInt(parts[0]);
            String unit = parts[1];
            total += Converter.toMillimeters(value, unit);
        }

        return total;
    }

    public static void main(String[] args) {
        String expression = "10 cm + 1 m - 10 mm";
        int result = evaluate(expression);
        System.out.println("Result: " + result + " mm");
    }
}
