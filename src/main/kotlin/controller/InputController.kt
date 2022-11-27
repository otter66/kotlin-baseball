package controller

import domain.ValueInspector
import view.InputView

class InputController {
    private val inputView: InputView = InputView()
    private val valueInspector: ValueInspector = ValueInspector()

    fun getThreeNumber(): String {
        val input = inputView.readThreeNumber()

        try {
            if (valueInspector.checkThreeNumber(input)) return input
            else throw IllegalArgumentException()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("[ERROR] 세자리 숫자만 입력할 수 있습니다.")
        }

    }

    fun getCommand(): String {
        val input = inputView.readCommand()

        try {
            if (valueInspector.checkGameCommand(input)) return input
            else throw IllegalArgumentException()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("[ERROR] '1' 또는 '2'만 입력할 수 있습니다.")
        }
    }

}