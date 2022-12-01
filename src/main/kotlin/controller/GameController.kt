package controller

import model.BaseballGame
import model.BaseballRule
import model.NumberGenerator
import values.Command
import view.InputView
import view.OutputView

class GameController {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()
    private val baseballRule: BaseballRule = BaseballRule()
    private val numberGenerator: NumberGenerator = NumberGenerator()
    private lateinit var baseballGame: BaseballGame

    var inputNumber: String = ""

    private fun setGame() {
        baseballGame = BaseballGame(numberGenerator.makeNumber())
    }

    fun runGame() {
        setGame()

        while (true) {
            proceedTurn()
            if (isContinue(inputNumber)) setGame()
            else {
                outputView.printGameEnd()
                break
            }
        }

    }

    private fun proceedTurn() {
        val gameNumber = baseballGame.getNumber()
        inputNumber = getValidatedInputNumber()

        outputView.printCorrectCount(
            baseballRule.countBall(gameNumber, inputNumber),
            baseballRule.countStrike(gameNumber, inputNumber)
        )
    }

    private fun isContinue(inputNumber: String): Boolean {
        if (baseballRule.countStrike(baseballGame.getNumber(), inputNumber) == 3) {
            outputView.printGameSuccess()
            outputView.printRequestCommand()

            val inputCommand = getValidatedInputCommand()

            return inputCommand == Command.GAME_RESTART.message
        }

        return true
    }

    private fun getValidatedInputNumber(): String {
        try {
            outputView.printRequestNumber()
            val input = inputView.readThreeNumber()
            baseballRule.checkNumber(input)
            return input
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(e.message)
        }
    }

    private fun getValidatedInputCommand(): String {
        try {
            outputView.printRequestCommand()
            val input = inputView.readCommand()
            baseballRule.checkCommand(input)
            return input
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("[ERROR] '1' 또는 '2'만 입력할 수 있습니다.  ")
        }
    }

}