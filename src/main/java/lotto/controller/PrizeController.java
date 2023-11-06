package lotto.controller;

import lotto.domain.lottery.Lotto;
import lotto.domain.parser.Parser;
import lotto.domain.prize.Prize;
import lotto.exception.LottoException;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

import java.util.List;

import static lotto.view.constants.PrintMessage.REQUEST_JACKPOT_BONUS_NUMBER;
import static lotto.view.constants.PrintMessage.REQUEST_JACKPOT_NUMBER;

public class PrizeController {
    private PrizeController() {
    }

    public static Prize requestJackpotNumbers() {
        OutputWriter.printMessage(REQUEST_JACKPOT_NUMBER);
        Lotto prizeNumbers = readJackpotNumbers();

        OutputWriter.printNewLine();
        OutputWriter.printMessage(REQUEST_JACKPOT_BONUS_NUMBER);
        return requestBonusNumber(prizeNumbers);
    }

    public static Prize requestBonusNumber(final Lotto prizeNumbers) {
        try {
            final String bonusNumberInput = InputReader.readLine();
            return Prize.of(prizeNumbers, bonusNumberInput);
        } catch (LottoException exception) {
            OutputWriter.println(exception.getMessage());
            return requestBonusNumber(prizeNumbers);
        }
    }

    private static Lotto readJackpotNumbers() {
        try {
            final String jackpotNumbers = InputReader.readLine();
            List<Integer> numbers = Parser.splitByDelimiter(jackpotNumbers);

            return new Lotto(numbers);
        } catch (LottoException exception) {
            OutputWriter.println(exception.getMessage());
            return readJackpotNumbers();
        }
    }
}
