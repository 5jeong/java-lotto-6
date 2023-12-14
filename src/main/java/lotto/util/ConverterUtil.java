package lotto.util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConverterUtil {

    public static List<Integer> convertStringToIntegerList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 경우에 대한 예외 처리
            throw new IllegalArgumentException("숫자를 입력해야합니다.");
        }
    }
    public static Integer convertStringToInt(String str) {
        return Integer.parseInt(str);
    }


}
