package domain

import values.Command

class ValueInspector {

    fun checkThreeNumber(inputNumber: String): Boolean {
        if (inputNumber.length == 3) return true
        if (inputNumber.all { it in '1'..'9' }) return true
        if ((inputNumber as List<Char>).distinct().size == 3) return true

        throw IllegalArgumentException()
    }

    fun checkGameCommand(inputCommand: String): Boolean {
        if (inputCommand == Command.GAME_RESTART.message ||
            inputCommand == Command.GAME_STOP.message
        ) return true

        throw IllegalArgumentException()
    }

}
