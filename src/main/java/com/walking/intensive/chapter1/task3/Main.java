package com.walking.intensive.chapter1.task3;

/**
 * Условие: <a href="https://geometry-math.ru/homework/Java-leap-year.html">ссылка</a>
 */
public class Main {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(isLeap(1975));
        System.out.println(isLeap(1724));
        System.out.println(isLeap(2000));
        System.out.println(isLeap(1300));

    }

    static boolean isLeap(int year) {
        if (year % 4 != 0) { // Если год не кратен 4, то он точно невисокосный
            return false;
        }

        if (year % 100 != 0) { // Если год кратен 4, но не кратен 100, он високосный
            return true;
        }

        return (year / 100) % 4 == 0; // Если год кратен четырём и ста, а результат деления года на 100 не кратен 4, то год невисокосный
    }
}