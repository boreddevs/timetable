package app.tt;

import app.tt.Parts.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * Created by daszabo on 2017.07.10..
 */
//Óra tárgya,Óra típusa, Kezdő ideje, Végző ideje, Tanár neve, Helye
public class FileReader {
    private Set<Teacher> teachers = new HashSet<>();
    private Set<Lesson> lessons = new HashSet<>();
    private final String delimiter = ";";

    public Set[] read(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(delimiter);
                try {
                    Lesson_Type type = Lesson_Type.UNDEFINED;
                    if (parts[1].equals("EA"))
                        type = Lesson_Type.EA;
                    if (parts[1].equals("GY"))
                        type = Lesson_Type.GY;
                    String[] alltime = parts[2].split("-");
                    String[] stime = alltime[0].split(":");
                    Time startTime = Time.makeTime(DaySelect(stime[0]), Integer.parseInt(stime[1]), Integer.parseInt(stime[2]));
                    String etime = alltime[1];
                    Time endTime = Time.makeTime(DaySelect(stime[0]), Integer.parseInt(etime.substring(0, 2)), Integer.parseInt(etime.substring(3, 5)));
                    String room = etime.substring(6, etime.length() - 1);
                    Teacher teacher = new Teacher(parts[3]);
                    teachers.add(teacher);
                    Lesson l = Lesson.makeLesson(parts[0], type, startTime, endTime, room, teacher);
                    lessons.add(l);

                    System.out.println(l.toString());
                } catch (NumberFormatException e) {
                    System.out.println("NumberFormatException 46");
                }

            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFoundException 50");
        }
        return new Set[]{teachers, lessons};
    }

    private Days DaySelect(String day) {
        switch (day) {
            case "H":
                return Days.H;
            case "K":
                return Days.K;
            case "SZE":
                return Days.SZE;
            case "CS":
                return Days.CS;
            case "P":
                return Days.P;
            case "SZO":
                return Days.SZO;
            case "V":
                return Days.V;
        }
        return null;
    }
}