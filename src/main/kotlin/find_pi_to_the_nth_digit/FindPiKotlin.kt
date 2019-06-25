package find_pi_to_the_nth_digit


class FindPiKotlin {
    private val pi: String = "14159265358979323846264338327950288419716939937510582097494459230"


    fun findNthDigitOfPI(nth: Int): Int {
        return if (nth < 1) -1 else Integer.valueOf(pi.substring(nth - 1, nth))
    }

}