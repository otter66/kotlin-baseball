package baseball

class BaseballGame {
    private val successNumber: String = ""

    fun countBall(inputNumber: String): Int {
        var count = 0

        for (index in 0 until 3) {
            if (successNumber[index] != inputNumber[index] &&
                successNumber.contains(inputNumber[index])
            ) {
                count++
            }
        }

        return count - 3
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



}