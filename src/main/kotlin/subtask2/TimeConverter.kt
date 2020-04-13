package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val hourInt = hour.toInt()
        val minuteInt = minute.toInt()

        if(1 > hourInt || hourInt > 12 || 0 > minuteInt || minuteInt > 60) return ""
        if(minuteInt == 0) return mapHours.get(hourInt) + OCLOCK
        if(minuteInt == 15 || minuteInt == 30) return mapMinutes.get(minuteInt) + PAST + mapHours.get(hourInt)
        if(minuteInt == 45) return mapMinutes.get(minuteInt) + TO + mapHours.get(hourInt + 1)
        if(minuteInt in 1..20) return mapMinutes.get(minuteInt) + MINUTES + PAST + mapHours.get(hourInt)
        if(minuteInt in 21..29) return mapMinutes.get(minuteInt/10*10) + " " + mapMinutes.get(minuteInt%10) + MINUTES + PAST + mapHours.get(hourInt)
        if(60 - minuteInt in 1..20) return mapMinutes.get(60 - minuteInt) + MINUTES + TO + mapHours.get(hourInt + 1)
        if(60 - minuteInt in 21..29) return mapMinutes.get((60 -minuteInt)/10*10) + " " + mapMinutes.get((60-minuteInt)%10) + MINUTES + TO + mapHours.get(hourInt + 1)

        else return mapMinutes.get(minuteInt) + TO + mapHours.get(hourInt+1)
    }

    companion object CONSTS {
        const val OCLOCK = " o' clock"
        const val TO = " to "
        const val PAST = " past "
        const val MINUTES = " minutes"

        val mapHours: Map<Int, String> = mapOf<Int, String>(
            1 to "one",
            2 to "two",
            3 to "three",
            4 to "four",
            5 to "five",
            6 to "six",
            7 to "seven",
            8 to "eight",
            9 to "nine",
            10 to "ten",
            11 to "eleven",
            12 to "twelve"
        )

        val mapMinutes = mapOf(
            1 to "one",
            2 to "two",
            3 to "three",
            4 to "four",
            5 to "five",
            6 to "six",
            7 to "seven",
            8 to "eight",
            9 to "nine",
            10 to "ten",
            11 to "eleven",
            12 to "twelve",
            13 to "eleven",
            14 to "eleven",
            15 to "quarter",
            16 to "eleven",
            17 to "eleven",
            18 to "eleven",
            19 to "eleven",
            20 to "twenty",
            30 to "half",
            40 to "twenty",
            45 to "quarter",
            50 to "twenty"
        )
    }
}
