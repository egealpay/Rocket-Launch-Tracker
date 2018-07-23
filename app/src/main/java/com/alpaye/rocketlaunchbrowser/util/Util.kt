package com.alpaye.rocketlaunchbrowser.util

import java.text.SimpleDateFormat
import java.util.*

class Util() {
    companion object {
        fun stringToDate(str: String): GregorianCalendar{
            val date = SimpleDateFormat("MMMM dd, yyyy HH:mm:ss z").parse(str)
            val calendar = GregorianCalendar()
            calendar.time = date
            return calendar
        }
    }
}