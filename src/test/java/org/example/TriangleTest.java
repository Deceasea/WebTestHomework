package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TriangleTest {
    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);


    @Test
    public void areaTriangle() throws MyException {
        double a = Triangle.triangleArea(3, 2, 1);
        logger.info("Позитивный сценарий");
        assertEquals(a, 3, "Не 3");
    }

    @Test
    public void areaNotTriangle1() throws MyException {
        double b = Triangle.triangleArea(3, 2, 100);
        logger.info("Негативный сценарий");
        assertNotEquals(b, 15, "Не 15");
    }

    @Test
    public void areaNotTriangle2() {
        logger.info("Позитивный сценарий");
        MyException e = Assertions.assertThrows(MyException.class, () -> {
            Triangle.triangleArea(3, 2, 0);
        });
        assertEquals(e.getMessage(), "Это не треугольник!");
    }

    @Test
    public void areaNotTriangle3() {
        logger.info("Негативный сценарий");
        MyException e = Assertions.assertThrows(MyException.class, () -> {
            Triangle.triangleArea(3, 2, -5);
        });
        assertNotEquals(e.getMessage(), "Это треугольник!");
    }

}
