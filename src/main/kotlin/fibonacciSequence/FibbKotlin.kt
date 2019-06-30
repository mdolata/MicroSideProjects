package fibonacciSequence


class FibbKotlin {

    fun generateFibbonaci(n: Int): List<Int> {
        return fibb(0, 1, n)
    }

    private fun fibb(first: Int, second: Int, n: Int): List<Int> {
        return if (n <= 0) {
            emptyList()
        } else {
            val current = first + second
            listOf(first) + fibb(second, current, n-1)
        }
    }
}