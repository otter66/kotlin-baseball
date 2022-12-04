package model

import values.Command

class BaseballRule {

    fun checkNumber(inputNumber: String): Boolean {
        require(inputNumber.length == 3) { "[ERROR] 세자리의 숫자만 입력할 수 있습니다." }
        require(inputNumber.all { it in '1'..'9' }) { "[ERROR] 각 자리수는 1 ~ 9 에 포함되는 숫자만 입력할 수 있습니다." }
        require(inputNumber.toCharArray().distinct().size == 3) { "[ERROR] 중복이 없는 세자리 숫자만 입력할 수 있습니다." }

        return true
    }

    fun checkCommand(inputCommand: String): Boolean {
        require(
            inputCommand == Command.GAME_RESTART.message ||
            inputCommand == Command.GAME_STOP.message
        )

        return true
    }

    fun countBall(computerNumber: String, inputNumber: String): Int {
        var count = 0

        repeat(3) { index ->
            if (computerNumber[index] != inputNumber[index] &&
                computerNumber.contains(inputNumber[index])) count++
        }

        return count
    }

    fun countStrike(computerNumber: String, inputNumber: String): Int {
        var count = 0

        repeat(3) { index ->
            if (computerNumber[index] == inputNumber[index]) count++
        }

        return count
    }

}
