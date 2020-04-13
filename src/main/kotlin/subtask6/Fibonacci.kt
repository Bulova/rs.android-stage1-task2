package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        var prod: Int
        var firstProdElement = 0
        var secondProdElement = 0
        var match = 0
        for(i in 0 until n){
            firstProdElement = fibonacchi(i)
            secondProdElement = fibonacchi(i+1)
            prod = firstProdElement * secondProdElement
            if(prod == n){
                match = 1
                break
            }
            if(prod > n) {
                match = 0
                break
            }
        }

        return intArrayOf(firstProdElement, secondProdElement, match)
    }

    fun fibonacchi(n: Int): Int{
        if ( n == 0 ) return 0;

        if (n == 1) return 1;
        return fibonacchi(n-2) + fibonacchi(n-1);
    }
}
