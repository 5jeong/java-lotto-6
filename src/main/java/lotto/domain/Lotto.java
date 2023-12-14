package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
        if (isNotLottoNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 1~45사이의 숫자여야 합니다.");
        }
    }

    private boolean isNotLottoNumber(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                return true;
            }
        }
        return false;
    }


    private boolean isDuplicateNumber(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();

        return numbers.size() != distinctCount;
    }


    public boolean containBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(num1 -> numbers.contains(num1))
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
