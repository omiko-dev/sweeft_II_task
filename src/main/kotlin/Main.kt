fun main() {
    // 1)
//    println(singleNumber(listOf(1, 1, 4, 2, 2)))

    // 2)
//    println(minSplit(133))

    // 3)
//    println(longestPrefix(listOf("koki", "kokk", "kojr")))

    // 4)
//    println(binaryStringSum("1011", "11111"))

    // 5)
//    println(countVariants(2))

    // 6)
//    val myData = MyDataStructure()
//    with(myData){
//        add(5)
//        add(7)
//        add(11)
//        remove(7)
//        print(data)
//    }
}

class MyDataStructure {
    private val _data = mutableListOf<Int>()
    val data get() = _data.toList()
    private val pointers = mutableMapOf<Int, Int>()

    fun add(value: Int) {
        _data.add(value)
        pointers[value] = _data.size - 1
    }

    fun remove(value: Int) {
        val index = pointers[value] ?: return
        _data.removeAt(index)
        pointers.remove(value)
        for (i in index..<_data.size) {
            pointers[_data[i]] = i - 1
        }
    }
}

fun singleNumber(nums: List<Int>): Int {
    return 2 * nums.toSet().sum() - nums.sum()
}

fun minSplit(amount: Int): Int {
    val coins = listOf(50, 20, 10, 5, 1).sortedDescending()
    var coinCount = 0
    var remainingAmount = amount

    for (coin in coins) {
        while (remainingAmount >= coin) {
            remainingAmount -= coin
            coinCount++
        }
    }

    return if (remainingAmount == 0) coinCount else -1
}

fun longestPrefix(array: List<String>): String {
    if (array.isEmpty()) return ""

    var prefix = array[0]
    for (word in array) {
        while (!word.startsWith(prefix)) {
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty()) return ""
        }
    }
    return prefix
}

fun binaryStringSum(a: String, b: String): String {
    val num1 = Integer.parseInt(a, 2)
    val num2 = Integer.parseInt(b, 2)
    val sum = num1 + num2
    return Integer.toBinaryString(sum)
}

fun countVariants(stearsCount: Int): Int {
    if (stearsCount <= 1) {
        return 1
    }
    return countVariants(stearsCount - 1) + countVariants(stearsCount - 2)
}