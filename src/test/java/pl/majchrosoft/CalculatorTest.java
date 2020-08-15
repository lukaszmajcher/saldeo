package pl.majchrosoft;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void addOperationTest() throws Exception{
        List<String> arguments = Arrays.asList("3", "ADD", "2");
        assertEquals(5, calculator.calculate(arguments));
    }

    @Test
    void multiplyOperationTest() throws Exception{
        List<String> arguments = Arrays.asList("3", "MULTIPLY", "2");
        assertEquals(6, calculator.calculate(arguments));
    }

    @Test
    void manyOperationsTest() throws Exception{
        List<String> arguments = Arrays.asList("3", "MULTIPLY", "2", "ADD", "2");
        assertEquals(8, calculator.calculate(arguments));
    }

    @Test
    void emptyOperationTest() throws Exception{
        List<String> arguments = Collections.emptyList();
        assertEquals(0, calculator.calculate(arguments));
    }

    //TODO zapezpieczyć przed nieprawidłowymi argumentami
    @Test
    void illegalOperationTest() throws Exception{
        List<String> arguments = Arrays.asList("3", "AAA", "2");
        assertEquals(6, calculator.calculate(arguments));
    }

    @Test
    void illegalOperationTest2() throws Exception{
        List<String> arguments = Arrays.asList("3", "ADD");
        assertEquals(6, calculator.calculate(arguments));
    }


}
