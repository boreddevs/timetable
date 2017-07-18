package app.tt.Parts;

/**
 * Created by daszabo on 2017.07.10..
 */
public class Lesson {
    private String subject;
    private Lesson_Type type;
    private Time startTime;
    private Time endTime;
    private Teacher teacher;
    private String room;

    private Lesson(String subject, Lesson_Type type, Time startTime, Time endTime, String room, Teacher teacher) {
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher = teacher;
        this.type = type;
        this.room = room;
    }

    public static Lesson makeLesson(String subject, Lesson_Type type, Time startTime, Time endTime, String room, Teacher teacher) {
        if (subject.length() < 2 || startTime == null || endTime == null || !startTime.isBefore(endTime)) {
            return null;
        }

        return new Lesson(subject, type, startTime, endTime, room, teacher);
    }

    public String getSubject() {
        return this.subject;
    }

    public Lesson_Type getType() {
        return this.type;
    }

    public Time getStartTime() {
        Time current = this.startTime;
        return Time.makeTime(current.getDay(), current.getHour(), current.getMinute());
    }

    public Time getEndTime() {
        Time current = this.endTime;
        return Time.makeTime(current.getDay(), current.getHour(), current.getMinute());
    }

    public Teacher getTeacher() {
        Teacher current = this.teacher;
        return new Teacher(current.getName());
    }

    public String getRoom() {
        return this.room;
    }

    public boolean isCollidingWith(Lesson other) {
        Time a1 = this.startTime;
        Time a2 = this.endTime;
        Time b1 = other.startTime;
        Time b2 = other.endTime;
        if (a2.isBefore(b1) || b2.isBefore(a1) || a2.equals(b1) || b2.equals(a1)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return subject + " " + type.toString() + ", " + startTime.getDay().toString() + ": " + startTime.toString() + "-" + endTime.toString() + ", " + teacher.getName() + ", @(" + room + ")";
    }
}
