package subtask4

class Pangram {

    fun getResult(inputString: String): String {

        return if(isPangram(inputString)){
            getResultWithUppercase(inputString, true)
        } else{
            getResultWithUppercase(inputString, false)
        }
    }

    // Pangram - a sentence that contains each letter of the alphabet at least one time.
    private fun isPangram(inputString: String): Boolean {
        val alphabet = VOWELS + CONSONANTS
        for(symbol in alphabet){
            if(!inputString.contains(symbol, ignoreCase = true)){
                return false
            }
        }
        return true
    }

    private fun getResultWithUppercase(inputString: String, vowelsToUpperCase: Boolean): String {
        val listOfCapitalizedVowels : MutableList<String> = mutableListOf()
        for(word in getAllWords(inputString)){
            var count = 0
            var wordCopy = ""
            for(symbol in word.withIndex()){
                if((VOWELS.contains(symbol.value, ignoreCase = true) && vowelsToUpperCase)
                    || (CONSONANTS.contains(symbol.value, ignoreCase = true) && !vowelsToUpperCase)){
                    wordCopy += symbol.value.toUpperCase()
                    count++
                } else{
                    wordCopy += symbol.value
                }
            }
            listOfCapitalizedVowels.add(count.toString() + wordCopy)
        }

        val firstSymbolComparator = Comparator { str1: String, str2: String -> str1.get(0) - str2.get(0) }
        return listOfCapitalizedVowels.sortedWith(firstSymbolComparator).joinToString(" ")
    }

    private fun getAllWords(inputString: String): MutableList<String>{
        var result = mutableListOf<String>()
        for(resultString in inputString.split(" ")){
            if(!resultString.isEmpty() && resultString != "\n"){
                result.add(resultString)
            }
        }
        return result
    }

    companion object{
        val VOWELS = "aeiouy"
        val CONSONANTS = "BCDFGHJKLMNPQRSTVWXZ"
    }
}
