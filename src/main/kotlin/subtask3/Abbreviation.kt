package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val shortString: String
        val longString: String

        if (a.length > b.length) {
            shortString = b
            longString = a
        } else {
            shortString = a
            longString = b
        }
        var regexpBuilder: StringBuilder = StringBuilder()
        for(symbol in shortString){
            regexpBuilder.append(".*").append(symbol)
        }
        regexpBuilder.append(".*")

        if (longString.toUpperCase().contains(regexpBuilder.toString().toRegex())) return "YES" else return "NO"
    }
}
