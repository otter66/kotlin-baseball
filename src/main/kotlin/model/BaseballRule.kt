package model

import values.Command

class BaseballRule {

    fun checkNumber(inputNumber: String): Boolean {
        if (inputNumber.length != 3) throw IllegalArgumentException("[ERROR] 세자리의 숫자만 입력할 수 있습니다.")
        if (!inputNumber.all { it in '1'..'9' }) throw IllegalArgumentException("[ERROR] 각 자리수는 1 ~ 9 에 포함되는 숫자만 입력할 수 있습니다.")
        if (inputNumber.toCharArray().distinct().size != 3) throw IllegalArgumentException("[ERROR] 중복이 없는 세자리 숫자만 입력할 수 있습니다.")

        return true
    }

    fun checkCommand(inputCommand: String): Boolean {
        if (inputCommand == Command.GAME_RESTART.message ||
            inputCommand == Command.GAME_STOP.message
        ) return true

        throw IllegalArgumentException()
    }

    fun countBall(computerNumber: String, inputNumber: String): Int {
        var count = 0

        for (index in 0 until 3) {
            if (computerNumber[index] == inputNumber[index]) continue
            if (computerNumber.contains(inputNumber[index])) count++
        }

        return count
    }

    fun countStrike(computerNumber: String, inputNumber: String): Int {
        var count = 0

        for(index in 0 until 3) {
            if (computerNumber[index] == inputNumber[index]) count++
        }

        return count
    }

}
