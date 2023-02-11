package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Triangle {
    static Logger logger = LoggerFactory.getLogger(Triangle.class);
    public static void main(String[] args) throws MyException {
        int a = 3;
        int b = 5;
        int c = 7;
        double x = triangleArea(a,b,c);
        System.out.println(x);
        logger.info("тест");
        }
        public static double triangleArea(int a, int b, int c) throws MyException {
        if (a<= 0 || b <= 0 || c <= 0){
            throw new MyException("Это не треугольник!");
        }
            double i = (a + b + c) / 2;
            return i;
        }
    }


