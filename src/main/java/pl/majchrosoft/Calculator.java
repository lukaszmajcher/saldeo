package pl.majchrosoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calculator {

    public long calculate(List<String> arguments) throws CalculatorArgumentException {
        if (Objects.isNull(arguments) || arguments.size()==0)
            return 0;

        List<String> checkedArguments = prepareArguments(arguments);
        long result = Long.parseLong(checkedArguments.get(0));
        for (int i = 1; i < arguments.size(); i += 2) {
            Operation operation = Operation.valueOf(arguments.get(i));
            long arg2 = Long.parseLong(arguments.get(i + 1));
            result = getResult(result, operation, arg2);
            System.out.println(result + " " + operation.name() + " " + arg2 + " = " + result);
        }
        return result;
    }

    private List<String> prepareArguments(List<String> arguments) throws CalculatorArgumentException  {
        List<String> resultList = new ArrayList<>();
        for (String argument : arguments) {
            if (arguments.size() > 1 && argument.equals(Operation.UNDO.name()))
                resultList.remove(resultList.get(resultList.size() - 1));
            else {
                resultList.add(argument);
            }
        }
        return resultList;
    }

    private long getResult(Long arg1, Operation operation, Long arg2) {
        switch (operation) {
            case ADD:
                return arg1 + arg2;
            case MULTIPLY:
                return arg1 * arg2;
            default:
                return 0;
        }
    }
}
