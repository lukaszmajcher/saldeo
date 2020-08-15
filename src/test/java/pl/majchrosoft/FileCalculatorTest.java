package pl.majchrosoft;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileCalculatorTest {

    @Test
    void calculate() throws Exception{

        FileCalculator calculator = new FileCalculator();

        URL resource = getClass().getClassLoader().getResource("testFiles/test.txt");
        File testFile = new File(resource.getPath());

        assertEquals(22, calculator.calculate(testFile));
    }

}
