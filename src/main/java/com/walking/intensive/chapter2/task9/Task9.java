package com.walking.intensive.chapter2.task9;

/**
 * Условие: <a href="https://geometry-math.ru/homework/Java-pascalTriangle.html">ссылка</a>
 */
public class Task9 {
    public static void main(String[] args) {
        System.out.println(getPascalTriangle(25));
    }

    static String getPascalTriangle(int n) {
        StringBuilder result;
        result = new StringBuilder();

        int maxRowLength = getRow(n).length();

        for (int i = 0; i < n; i++) {
            String row = getRow(i);
            int spacesQuantity = (maxRowLength - row.length()) / 2;

            for (int j = 0; j < spacesQuantity; j++) {
                result.append(" ");
            }

            result.append(row)
                    .append("\n");
        }

        return result.toString();
    }

    static String getRow(int rowIndex) {
        long element = 1L; // element(0,0) = 0! / (0! * (0 - 0)!)

        StringBuilder rowResultBuilder = new
                StringBuilder(String.valueOf(element))
                .append(" ");

        for (int i = 0; i < rowIndex; i++) {
            element = element * (rowIndex - i) / (i + 1);

            rowResultBuilder.append(element)
                    .append(" ");
        }

        return rowResultBuilder.toString();
    }
}