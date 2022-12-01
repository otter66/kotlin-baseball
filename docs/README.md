
# Class Diagram
<img src="https://raw.githubusercontent.com/otter66/kotlin-baseball/refactoring/docs/images/class_diagram.png" alt="drawing" height="300"/>

# Structure

## ui
- InputView : 사용자로부터 값을 입력 받는 클래스
    - readNumber() : 사용자로부터 3자리 숫자를 입력 받는다.
    - readCommand() : 사용자로부터 게임 재시작/종료 여부를 나타내는 명령어를 받는다.
- OutputView : 사용자가 확인할 수 있는 화면에 양식에 맞추어 정보를 출력하는 클래스
    - printCorrectCount() : 사용자에게 볼과 스트라이크 일치 개수를 형식에 맞춰 출력한다.
    - printNotification() : 요청, 알림 등과 같은 변경이 없는 알림 문구를 출력한다.

## controller
- GameController : 연산의 종류에 따라 담당 클래스에 배정시키는 등의 역할을 하는 클래스
    - noticeGameStatus() : 게임의 진행 상태 등을 출력한다. - outputView
    - setGame() : 게임에 필요한 정보를 초기화한다. (세자리 숫자 생성) - numberGenerator
    - runGame() : 게임의 각 턴을 진행시키며, 턴의 상태에 따라 진행 밎 종료르 한다.
    - proceedTurn() : 게임의 턴을 진행시킨다.

## domain
- BasebollRule : 게임의 규칙에 따른 연산을 실행하는 클래스
    - isNormalNumber() : 세자리 숫자가 게임 규칙에 맞는지 확인한다.
    - isNormalCommand() : 게임 재시작/종료 여부가 게임 규칙에 맞는지 확인한다.
    - countBall() : Ball의 개수를 센다.
    - countStrike() : Strike의 개수를 센다.
- NumberGenerator : 게임에서 사용할 숫자 발행을 하는 클래스
    - makeNumber() : 세자리 숫자를 만든다.



<br><br><br><br><br><br><br><br><br>   

## 기능 구현 목록

- 입력 
    - [x] 세자리 숫자를 입력 받는다.
    - [x] 재시작 여부를 입력 받는다.

- 출력
    - [x] 게임 시작을 알리는 문구를 출력한다. "숫자 야구 게임을 시작합니다."
    - [x] 세자리 숫자 입력 요청 문구를 출력한다. "숫자를 입력해주세요 :"
    - [x] 볼과 스트라이크 개수를 출력한다. "1볼 1스트라이크"
    - [x] 성공을 알리는 문구를 출력한다. "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    - [x] 재시작 여부 입력 요청 문구를 출력한다. "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    
- 입력 검사
    - [x] 세자리 숫자 검사
        - [x] 세자리인지 확인
        - [x] 각각 1~9에 속하는지 확인
        - [x] 중복이 없는지 확인
    - [x] 재시작 여부 검사
        - [x] 1 또는 2 인지 확인 

- 숫자 야구 게임
    - [x] 볼 개수 세기
    - [x] 스트라이크 개수 세기
    - [x] 게임 성공 여부 판단
