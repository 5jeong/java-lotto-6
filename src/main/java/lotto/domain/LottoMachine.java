package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.NumberGenerator;


public class LottoMachine implements NumberGenerator {

    private static final int RANDOM_LOWER_INCLUSIVE = 1;
    private static final int RANDOM_UPPER_INCLUSIVE = 45;
    private static final int RANDOM_NUMBER_COUNT = 6;


    @Override
    public List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE,
                RANDOM_NUMBER_COUNT);
        return ascendingOrder(numbers);
    }
    private List<Integer> ascendingOrder(List<Integer> numbers) {
        List<Integer> lotto = new ArrayList<>(numbers);
        Collections.sort(lotto);
        return lotto;
    }
}
