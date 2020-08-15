package pl.majchrosoft;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileCalculator {

    public long calculate(File file) throws FileNotFoundException, CalculatorArgumentException {
        List<String> arguments = parseInput(file);
        Calculator calculator = new Calculator();
        return calculator.calculate(arguments);
    }
    private List<String> parseInput(File file) throws FileNotFoundException {
        ArrayList<String> strings = new ArrayList<>();
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            strings.add(data);
        }
        myReader.close();
        return strings;
    }
}
