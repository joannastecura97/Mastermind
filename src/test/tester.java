package test;

import mastermind_calc.Calculations;
import mastermind_calc.Counter;
import org.junit.jupiter.api.*;
import sample.Color;

import java.util.ArrayList;
import java.util.Arrays;

public class tester {
    @BeforeAll
    static void init() {
        System.out.println("Witamy w testach!");
    }

    @BeforeEach
    void setup() {
        System.out.println("Zaraz uruchmimy kolejny test...");
    }


    @Test
    @DisplayName("Test poprawnego obliczania kolorów")
    void calculateColor() {
        Counter counter1 = new Counter(4,0);
        Counter counter = Calculations.calcPositionAndColor("1234", "1234");

        Assertions.assertEquals(counter.getColorCounter(), counter1.getColorCounter());
    }

    @Test
    @DisplayName("Test poprawnego obliczania pozycji")
    void calculatePosition() {
        Counter counter1 = new Counter(1,1);
        Counter counter = Calculations.calcPositionAndColor("1043", "1524");

        Assertions.assertEquals(counter.getPositionCounter(), counter1.getPositionCounter());
    }


    @Test
    @DisplayName("Test ustawiania klucza")
    void setKey() {
        Color color = new Color();
        String red = "0xb62a2aff";
        String green = "0x248e39ff";
        String blue = "0x1e90ffff";
        String yellow = "0xfff200ff";
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(red,green,blue,yellow));
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(5,1,0,2));
        ArrayList<Integer> arrayInt2;
        arrayInt2=color.setMyKey(strings);
        Assertions.assertTrue(arrayInt.toString().equals(arrayInt2.toString()));
    }
}



