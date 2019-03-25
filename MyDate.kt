package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

operator fun MyDate.rangeTo(other: MyDate): : Comparable<MyDate> {
    return when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)
operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

data class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)

operator fun TimeInterval.times(n: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, n)

operator fun MyDate.plus(interval: RepeatedTimeInterval): MyDate = addTimeIntervals(interval.ti, interval.n)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR

    operator fun times(number: Int) = RepeatedTimeInterval(this, number)
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterator<MyDate> {
    var date: MyDate = start

    override fun next(): MyDate {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        val result = current
        current = current.nextDay()
        return result
    }

    override fun hasNext(): Boolean {
        return start <= date && date <= endInclusive
    }
}