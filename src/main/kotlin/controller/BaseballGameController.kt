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

    fun runGame() {
        var inputNumber = ""
        var inputCommand = ""

        outputView.printGameStart()
        setGameInfo()

        while (true) {
            outputView.printRequestNumber()
            inputNumber = inputController.getThreeNumber()
            outputView.printCorrectCount(baseballGame.countBall(inputNumber), baseballGame.countStrike(inputNumber))

            if(baseballGame.isSuccess(inputNumber)) {
                outputView.printRequestCommand()
                inputCommand = inputController.getCommand()

                if (inputCommand == Command.GAME_RESTART.message) setGameInfo()
                else break
            }
        }

    }

    private fun setGameInfo() {
        baseballGame.setSuccessNumber(successNumberMaker.makeSuccessNumber())
    }


}