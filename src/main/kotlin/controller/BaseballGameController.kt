package controller

import baseball.BaseballGame
import view.OutputView

class BaseballGameController {
    private val inputController: InputController = InputController()
    private val outputView: OutputView = OutputView() // todo output도 view, controller 분리
    private val baseballGame: BaseballGame = BaseballGame()

    fun runGame() {
        setGame()
    }

    private fun setGame() {
        outputView.printGameStart()
        // baseballGame.setSuccessNumber()
    }
}