package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.activation.UnsupportedDataTypeException
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        when (blockB) {
            Int::class -> return getSum(blockA)
            String::class -> return getAllStrings(blockA)
            LocalDate::class -> return getMaxDate(blockA)
            else -> throw UnsupportedDataTypeException()
        }
    }

    fun getSum(blockA: Array<Any>): Int{
        var sum = 0
        for(element in blockA){
            if(element is Int) {
                sum += element
            }
        }
        return sum
    }

    fun getAllStrings(blockA: Array<Any>): String{
        var text = ""
        for(element in blockA){
            if(element is String) {
                text += element
            }
        }
        return text
    }

    fun getMaxDate(blockA: Array<Any>): String{
        var maxDate: LocalDate = LocalDate.MIN
        for(element in blockA){
            if(element is LocalDate) {
                if(element > maxDate) maxDate = element
            }
        }
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return maxDate.format(formatter)
    }
}
