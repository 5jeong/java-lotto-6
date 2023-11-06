package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import lotto.util.ConverterUtil;

public class InputWinningNumberValidator {
    private static final int WINNING_LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String LOTTO_BONUS_NUMBER_REGEX = "[0-9]+";
    private static final String LOTTO_WINNING_NUMBERS_REGEX = "([0-9]+,?)+";


    public static void validateWinningNumber(String winningNumber) {
        if (isNotSeparateByComma(winningNumber)) {
            System.out.println("[ERROR] 당첨 번호는 쉼표로 구분한 숫자를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        if (isNotLottoNumber(winningNumber)) {
            System.out.println("[ERROR] 로또 번호는 1~45사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (incorrectLottoNumberSize(winningNumber)) {
            System.out.println("[ERROR] 로또번호는 6개만 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        if (isOverlapLottoNumber(winningNumber)) {
            System.out.println("[ERROR] 중복된 로또 번호를 입력하였습니다.");
            throw new IllegalArgumentException();
        }

    }

    public static void validateBonusNumber(String bonusNumber) {
        if (isNotDigit(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (isNotLottoBonutNumber(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNotLottoNumber(String purchaseAmount) {
        List<Integer> winningNumbers = ConverterUtil.covertStringToList(purchaseAmount);
        for (int winningNumber : winningNumbers) {
            if (winningNumber < MIN_LOTTO_NUMBER || winningNumber > MAX_LOTTO_NUMBER) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNotSeparateByComma(String purchaseAmount) {
        return !Pattern.compile(LOTTO_WINNING_NUMBERS_REGEX).matcher(purchaseAmount).matches();

    }

    private static boolean incorrectLottoNumberSize(String purchaseAmount) {
        List<Integer> winningNumbers = ConverterUtil.covertStringToList(purchaseAmount);
        return winningNumbers.size() != WINNING_LOTTO_SIZE;
    }

    private static boolean isOverlapLottoNumber(String purchaseAmount) {
        List<Integer> winningNumbers = ConverterUtil.covertStringToList(purchaseAmount);
        HashSet<Integer> lottoNums = new HashSet<>();
        for (int num : winningNumbers) {
            lottoNums.add(num);
        }
        return lottoNums.size() != WINNING_LOTTO_SIZE;
    }

    private static boolean isNotDigit(String bonusNumber) {
        return !Pattern.compile(LOTTO_BONUS_NUMBER_REGEX).matcher(bonusNumber).matches();
    }

    private static boolean isNotLottoBonutNumber(String bonusNumber) {
        int bonusNum = Integer.parseInt(bonusNumber);
        if (bonusNum < MIN_LOTTO_NUMBER || bonusNum > MAX_LOTTO_NUMBER) {
            return true;
        }
        return false;
    }

}
