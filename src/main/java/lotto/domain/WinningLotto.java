package lotto.domain;

import java.util.List;
import java.util.regex.Pattern;
import lotto.util.ConverterUtil;

public class WinningLotto {
    private final Lotto winningnumber;
    private final int bonusNumber;

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static final String BONUS_NUMBER_REGEX = "[0-9]+";

    public WinningLotto(Lotto winningnumber, String bonusNumber) {
        validate(bonusNumber);
        this.winningnumber = winningnumber;
        this.bonusNumber = ConverterUtil.convertStringToInt(bonusNumber);
    }

    private void validate(String bonusNumber) {
        if(isNotDigit(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        if(isNotBonusNumber(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 1~45사이의 숫자여야 합니다.");
        }
        if(isDuplicateWinningNumber(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 당첨번호와 중복되면 안됩니다..");
        }
    }

    private boolean isDuplicateWinningNumber(String bonusNumber) {
        long distinctCount = winningnumber.getNumbers().stream()
                .distinct()
                .count();

        return winningnumber.getNumbers().size() != distinctCount;
    }

    private boolean isNotBonusNumber(String bonusNumber) {
        int bonusNum = ConverterUtil.convertStringToInt(bonusNumber);
        return bonusNum < 1 || bonusNum > 45;
    }

    private boolean isNotDigit(String bonusNumber) {
        return !Pattern.compile(BONUS_NUMBER_REGEX).matcher(bonusNumber).matches();
    }

    public int judgeMatchCount(Lotto lotto){
        return winningnumber.matchCount(lotto);
    }

    public boolean judgeBonusMatch(Lotto lotto){
        return lotto.containBonusNumber(bonusNumber);
    }


}
