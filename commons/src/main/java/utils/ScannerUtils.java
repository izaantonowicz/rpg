package utils;

import exception.InvalidateCLiValueException;

import java.util.List;
import java.util.Scanner;

public class ScannerUtils {

    public static String getValidateStringWithMessage(String message) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(message);
            System.out.print(MessageValues.PRESS);
            try {
                return validateStringFromCLi(scanner.next());
            } catch (InvalidateCLiValueException e) {
                CommunicationUtils.printMessage(MessageValues.INVALIDATE_VALUE_EXCEPTION);
            }

        }
    }

    public static Integer getValidateIntegerWithMessage(String message, Integer minValue, Integer maxValue) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(message);
            System.out.print(MessageValues.PRESS);
            try {
                return ScannerUtils.validateIntFromCLi(scanner.next(), minValue, maxValue);
            } catch (InvalidateCLiValueException e) {
                CommunicationUtils.printMessage(MessageValues.INVALIDATE_VALUE_EXCEPTION);
            }
        }
    }

    public static Integer getValidateIntegerWithMessage(String message, List<Integer> options) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(message);
            System.out.print(MessageValues.PRESS);
            try {
                return ScannerUtils.validateIntFromCLi(scanner.next(), options);
            } catch (InvalidateCLiValueException e) {
                CommunicationUtils.printMessage(MessageValues.INVALIDATE_VALUE_EXCEPTION);
            }
        }
    }


    private static Integer validateIntFromCLi(String value, Integer minValue, Integer maxValue) throws InvalidateCLiValueException {
        Integer convertedValue;
        try {
            convertedValue = Integer.valueOf(value);
        } catch (Exception e) {
            throw new InvalidateCLiValueException();
        }

        if (validate(minValue, maxValue, convertedValue)) {
            return convertedValue;
        } else {
            throw new InvalidateCLiValueException();
        }
    }

    private static Integer validateIntFromCLi(String value, List<Integer> values) throws InvalidateCLiValueException {
        Integer convertedValue;
        try {
            convertedValue = Integer.valueOf(value);
        } catch (Exception e) {
            throw new InvalidateCLiValueException();
        }

        if (validate(convertedValue, values)) {
            return convertedValue;
        } else {
            throw new InvalidateCLiValueException();
        }
    }

    private static String validateStringFromCLi(String value) throws InvalidateCLiValueException {
        int maxStringLength = 20;
        if (value.length() > maxStringLength) {
            throw new InvalidateCLiValueException();
        } else
            return value;
    }

    private static boolean validate(Integer minValue, Integer maxValue, Integer convertedValue) {
        return convertedValue >= minValue && convertedValue <= maxValue;
    }

    private static boolean validate(Integer convertedValue, List<Integer> values) throws InvalidateCLiValueException {
        if (values.contains(convertedValue)) {
            return true;
        } else {
            throw new InvalidateCLiValueException();
        }
    }
}
