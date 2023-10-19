package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

import static baseball.utils.Message.*;

public class InputUtil {

    public static final String RESTART_NUMBER = "1";
    public static final String END_NUMBER = "2";

    public static String requireGuessNumber() {
        System.out.println(REQUIRE_NUMBER_MESSAGE.getMessage());
        String guessNumber = Console.readLine();
        isGuessNumberValid(guessNumber);
        return Console.readLine();
    }

    private static void isGuessNumberValid(String guessNumber) {
        if (isGuessNumberDigit(guessNumber) && isGuessNumberLengthThree(guessNumber) && isGuessNumberDuplicate(guessNumber)) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private static boolean isGuessNumberDuplicate(String guessNumber) {
        char firstNumber = guessNumber.charAt(0);
        char secondNumber = guessNumber.charAt(1);
        char thirdNumber = guessNumber.charAt(2);

        return firstNumber != secondNumber && secondNumber != thirdNumber && firstNumber != thirdNumber;
    }

    private static boolean isGuessNumberLengthThree(String guessNumber) {
        return guessNumber.length() == 3;
    }


    private static boolean isGuessNumberDigit(String value) {
        return value.chars()
                .allMatch(Character::isDigit);
    }


    public static String requireRestartNumber() {
        String inputNumber = Console.readLine();
        isRestartNumberValid(inputNumber);
        return inputNumber;
    }

    private static void isRestartNumberValid(String inputNumber) {
        if (inputNumber.equals(RESTART_NUMBER) || inputNumber.equals(END_NUMBER)) {
            return;
        }

        throw new IllegalArgumentException();
    }
}
