# 게임이름
## ✅ 게임 실행 기능
- 게임 시작 기능: 콘솔 실행
- 게임 종료 기능:

## ✅ 입력 기능
- 로또 구입 금액 입력
  - 1,000원 단위로 입력받기
  - 1,000원 단위가 아니면 예외처리
- 당첨 번호 입력
  -  번호는 쉼표(,)를 기준으로 구분한다.
- 보너스 번호 입력
  - 
## ✅ 출력 기능
- 발행된 로또 출력기능
- 당첨 통계 출력
- 총 수익률 출력
- 금액은 2,000,000 형식으로 출력


## ✅ 게임 로직 기능

### 로또 생성 로직
- List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); 사용
- 오름차순으로 발행해서 출력
- 로또 번호와 보너스 번호는 1~45사이의 숫자여야함
### 당첨 및 수익률 로직
- 1등부터 5등만 출력
- 수익률은 소수점 둘째 자리에서 반올림 (ex. 100.0%, 51.5%, 1,000,000.0%)

## ✅ 검증 및 예외처리

**◼ 입력 검증**
- 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 해당 부분부터 입력을 다시 받습니다.
- 구입 금액 검증
  - 구입금액이 숫자가 아닐때 검증
  - 1,000원 단위가 아닐때 검증
- 당첨 번호 및 보너스 번호 검증
  - 쉼표로 구분했는지 검증
  - 1~45 숫자인지 검증



