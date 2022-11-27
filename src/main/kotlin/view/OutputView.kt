package view

import values.Notification

class OutputView {

    fun printGameStart() {
        println(Notification.GAME_START)
    }

    fun printRequestNumber() {
        print(Notification.REQUEST_NUMBER)
    }

    fun printCorrectCount(ball: Int, strike: Int) {
        // todo 숫자야구 클래스에서 볼, 스트라이크 개수 가지고있게 하여 가져다쓰도록 하기
        when {
            ball == 0 && strike == 0 -> println(Notification.CORRECT_NOTHING)
            ball >= 1 && strike == 0 -> println("${ball}볼")
            ball == 0 && strike >= 1 -> println("${strike}스트라이크")
            ball >= 1 && strike >= 1 -> println("${ball}볼 ${strike}스트라이크")
        }
    }

    fun printGameSuccess() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    fun printRequestCommand() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

}