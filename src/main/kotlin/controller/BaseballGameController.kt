package controller

import baseball.BaseballGame
import baseball.SuccessNumberMaker
import values.Command
import view.OutputView

class BaseballGameController {
    private val inputController: InputController = InputController()
    private val outputView: OutputView = OutputView() // todo output도 view, controller 분리
    private val baseballGame: BaseballGame = BaseballGame()
    private val successNumberMaker: SuccessNumberMaker = SuccessNumberMaker()

    private var inputNumber = ""

    fun runGame() {
        outputView.printGameStart()
        setGameInfo()

        while (true) {
            proceedTurn()
            if (!isContinue()) break
        }

    }

    private fun isContinue(): Boolean {
        if (baseballGame.isSuccess(inputNumber)) {
            outputView.printGameSuccess()
            outputView.printRequestCommand()
            val inputCommand = inputController.getCommand()

            if (inputCommand == Command.GAME_RESTART.message) setGameInfo()
            else {
                outputView.printGameEnd()
                return false
            }
        }

        return true
    }

    private fun setGameInfo() {
        baseballGame.setSuccessNumber(successNumberMaker.makeSuccessNumber())
    }

    private fun proceedTurn() {
        outputView.printRequestNumber()
        val inputNumber = inputController.getThreeNumber()
        outputView.printCorrectCount(baseballGame.countBall(inputNumber), baseballGame.countStrike(inputNumber))
    }

}