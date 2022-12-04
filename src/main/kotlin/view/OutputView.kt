package view

import values.Command
import values.Notification

class OutputView {

    fun printGameStart() {
        println(Notification.GAME_START.message)
    }

    fun printRequestNumber() {
        print(Notification.REQUEST_NUMBER.message)
    }

    fun printCorrectCount(ball: Int, strike: Int) {
        // todo 숫자야구 클래스에서 볼, 스트라이크 개수 가지고있게 하여 가져다쓰도록 하기
        when {
            ball == 0 && strike == 0 -> println(Notification.CORRECT_NOTHING.message)
            ball >= 1 && strike == 0 -> println("${ball}볼")
            ball == 0 && strike >= 1 -> println("${strike}스트라이크")
            ball >= 1 && strike >= 1 -> println("${ball}볼 ${strike}스트라이크")
        }
    }

    fun printGameSuccess() {
        println(Notification.GAME_SUCCESS.message)
    }

    fun printRequestCommand() {
        println("게임을 새로 시작하려면 ${Command.GAME_RESTART.message}, 종료하려면 ${Command.GAME_STOP.message}를 입력하세요.")
    }

    fun printGameEnd() {
        println(Notification.GAME_END.message)
    }

}