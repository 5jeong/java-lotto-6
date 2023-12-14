package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import lotto.util.ConverterUtil;
import lotto.view.InputView;

public class LottoBuyer {
    private final int purchaseAmount;

    private List<Lotto> purchaseLottos = new ArrayList<>();

    private static final String AMOUNT_REGEX = "[0-9]+";
    public LottoBuyer(String purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = ConverterUtil.convertStringToInt(purchaseAmount);
    }

    private void validate(String purchaseAmount) {
        if (isNotDigit(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        if(isNotThousand(purchaseAmount)){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위를 입력해야 합니다.");
        }
    }

    private boolean isNotThousand(String purchaseAmount) {
        int amount = ConverterUtil.convertStringToInt(purchaseAmount);
        return amount % 1000 !=0;
    }

    private boolean isNotDigit(String purchaseAmount) {
        return !Pattern.compile(AMOUNT_REGEX).matcher(purchaseAmount).matches();
    }

    public int purchaseCount(){
        return purchaseAmount / 1000;
    }

    public void purchaseLotto(Lotto lotto){
        purchaseLottos.add(lotto);
    }

    public List<Lotto> getPurchaseLottos() {
        return Collections.unmodifiableList(purchaseLottos);
    }

    public Double rateOfReturn(int totalPrize){
        return (double) totalPrize / purchaseAmount * 100;
    }
}
