package lotto.view;

import lotto.dto.LottoNumberResponse;
import lotto.dto.LottoNumberResponses;
import lotto.exception.ErrorMessage;
import lotto.view.constants.PrintMessage;

import static lotto.view.constants.PrintMessage.RESPONSE_PURCHASE_COUNT;

public class OutputView {
    public static void printMessage(final PrintMessage message) {
        println(message.getMessage());
    }

    public static void printError(final ErrorMessage message) {
        println(message.getMessage());
    }

    public static void println(final Object data) {
        System.out.println(data);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printPurchaseLottoNumbers(final LottoNumberResponses responses) {
        responses.lottoResponses()
                .stream()
                .map(LottoNumberResponse::numbers)
                .forEach(OutputView::println);
        printNewLine();
    }

    public static void printPurchaseCount(LottoNumberResponses responses) {
        String formattedMessage = String.format(RESPONSE_PURCHASE_COUNT.getMessage(), responses.purchaseCount());
        println(formattedMessage);
    }
}
