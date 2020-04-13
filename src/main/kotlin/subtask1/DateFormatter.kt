package subtask1

import java.time.LocalDate
import java.time.format.*
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        var formatter = DateTimeFormatter.ofPattern("d M uuuu").withResolverStyle(ResolverStyle.STRICT)
        var date: LocalDate

        try {
            date = LocalDate.parse("${day} ${month} ${year}", formatter)
        } catch(e: DateTimeParseException) {
            return "Такого дня не существует"
        }
        return  StringBuilder().append(day)
                .append(" ")
                .append(date.month.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("RU")))
                .append(", ")
                .append(date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("RU")))
                .toString()
    }
}
