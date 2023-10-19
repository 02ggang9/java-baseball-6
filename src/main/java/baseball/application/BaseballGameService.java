package baseball.application;

import baseball.entity.Baseball;
import baseball.utils.InputUtil;
import baseball.view.OutputView;

import static baseball.utils.InputUtil.*;

public class BaseballGameService {

    private Baseball baseball;

    public void startGame() {
        baseball = new Baseball();
        guessNumber();

        if (checkRestartGame()) {
            reStartGame();
        }
    }

    private void reStartGame() {
        startGame();
    }

    private boolean checkRestartGame() {
        OutputView.printEndGame();
        OutputView.printRestartGame();
        String number = requireRestartNumber();
        return number.equals(RESTART_NUMBER);
    }

    private void guessNumber() {
        String guessNumber = requireGuessNumber();

        if (!isGuessNumberPerfect(guessNumber)) {
            getBaseballResult(guessNumber);
        }
    }

    private boolean isGuessNumberPerfect(String guessNumber) {
        return baseball.isPerfect(guessNumber);
    }

    private void getBaseballResult(String guessNumber) {
        int ballCount = baseball.countBall(guessNumber);
        int strikeCount = baseball.countStrike(guessNumber);

        OutputView.printBallCount(ballCount);
        OutputView.printStrikeCount(strikeCount);
    }
}
