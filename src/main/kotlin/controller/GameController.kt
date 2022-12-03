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

    fun runGame() {
        setGame()
        startGame()
        outputView.printGameEnd()
    }

    private fun setGame() {
        baseballGame = BaseballGame(numberGenerator.makeNumber())
    }

    private fun startGame() {
        do {
            val gameNumber = baseballGame.getNumber()
            val inputNumber = getValidatedInputNumber()

            printCorrectCount(gameNumber, inputNumber)
        } while (isContinue(inputNumber))
    }

    private fun isContinue(inputNumber: String): Boolean {
        if (baseballRule.countStrike(baseballGame.getNumber(), inputNumber) == 3) {
            outputView.printGameSuccess()

            val inputCommand = getValidatedInputCommand()

            if(inputCommand == Command.GAME_RESTART.message) setGame()
            else return false
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
            throw IllegalArgumentException("[ERROR] '1' 또는 '2'만 입력할 수 있습니다.")
        }
    }

    private fun printCorrectCount(gameNumber: String, inputNumber: String) {
        outputView.printCorrectCount(
            baseballRule.countBall(gameNumber, inputNumber),
            baseballRule.countStrike(gameNumber, inputNumber)
        )
    }

}