package domain

import values.Command

class ValueInspector {

    fun checkThreeNumber(inputNumber: String): Boolean {
        if (inputNumber.length != 3) throw IllegalArgumentException()
        if (!inputNumber.all { it in '1'..'9' }) throw IllegalArgumentException()
        if (inputNumber.toCharArray().distinct().size != 3) throw IllegalArgumentException()

        return true
    }

    fun checkGameCommand(inputCommand: String): Boolean {
        if (inputCommand == Command.GAME_RESTART.message ||
            inputCommand == Command.GAME_STOP.message
        ) return true

        throw IllegalArgumentException()
    }

}
