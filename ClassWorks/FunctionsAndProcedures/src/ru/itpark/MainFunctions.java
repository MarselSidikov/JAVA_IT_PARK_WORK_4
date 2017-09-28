package ru.itpark;
import static java.lang.Math.*;
public class MainFunctions {

    public static double f(double x) {
        return cos(x);
    }

    public static double integrate(double a, double b, int n) {
        double result = 0;
        // рассчитать ширину разбиения
        double l = abs(a - b) / n;
        // начинаем с левой границы
        // пока не достигли правой
        // с шагом h
        for (double x = a; x <= b; x = x + l) {
            // считаем сумму площадей прямоугольников
            result = result + f(x) * l;
        }
        return result;
    }

    public static void main(String[] args) {
        double integrateOfSin =
                integrate(0.1, PI, 1000000);
        System.out.println(integrateOfSin);
    }
}
