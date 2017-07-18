package app.tt.Parts;

/**
 * Az időpontok rendezésére szolgáló osztály
 */
public class Time implements Comparable<Time> {
    private int hour;
    private int minute;
    private Days day;
    private int factor;

    private Time(Days day, int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
        this.day = day;
        this.factor = 1;
    }

    public static Time makeTime(Days day, int hour, int minute) {
        if (hour <= 7 || hour >= 22 || minute < 0 || minute > 59 || day == Days.SZO || day == Days.V) {
            return null;
        }
        return new Time(day, hour, minute);
    }

    int getHour() {
        return this.hour;
    }

    int getMinute() {
        return this.minute;
    }

    Days getDay() {
        return this.day;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj.getClass().toString().equals("Time"))) {
            return false;
        }
        Time other = (Time) obj;
        return (this.day == other.day && this.hour == other.hour && this.minute == other.minute);
    }

    public int compareTo(Time other) {
        if (other.getDay() == this.getDay()) {
            if (other.getHour() == this.getHour()) {
                if (other.getMinute() == this.getMinute()) {
                    return 0;
                } else if (other.getMinute() < this.getMinute()) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (other.getHour() < this.getHour()) {
                return 1;
            } else {
                return -1;
            }
        } else if (other.getDay().ordinal() < this.getDay().ordinal()) {
            return 1;
        } else {
            return -1;
        }
    }

    boolean isBefore(Time other) {
        return this.compareTo(other) == -1;
    }

    @Override
    public String toString() {
        if (minute < 10) {
            return hour + ":0" + minute;
        }
        return hour + ":" + minute;
    }

    public boolean compareFactor(int otherFactor) {
        return this.getFactor() > otherFactor;
    }

    public int getFactor() {
        return factor;
    }

}
