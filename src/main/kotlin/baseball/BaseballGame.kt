package baseball

class BaseballGame {
    private var successNumber: String = ""

    fun countBall(inputNumber: String): Int {
        val countChecker: MutableList<Boolean> = mutableListOf(false, false, false)
        var count = 0

        for (index in 0 until 3) {
            if (successNumber[index] == inputNumber[index]) countChecker[index] = true
            if (countChecker[index]) continue
            if (successNumber.contains(inputNumber[index])) count++
        }

        return count
    }

    fun countStrike(inputNumber: String): Int {
        var count = 0

        for(index in 0 until 3) {
            if (successNumber[index] == inputNumber[index]) count++
        }

        return count
    }

    fun isSuccess(inputNumber: String): Boolean {
        for (index in 0 until 3) {
            if (successNumber[index] != inputNumber[index]) return false
        }

        return true
    }

    fun setSuccessNumber(number: String) {
        successNumber = number
    }

}