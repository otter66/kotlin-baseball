package values

enum class Notification(val message: String) {
    GAME_START("숫자 야구 게임을 시작합니다."),
    REQUEST_NUMBER("숫자를 입력해주세요 : "),
    GAME_SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    REQUEST_COMMAND("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    CORRECT_NOTHING("낫싱"),
    GAME_END("게임 종료")
}