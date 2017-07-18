package app.tt.Parts;

/**
 * Created by daszabo on 2017.07.10..
 */
public class Teacher implements Comparable<Teacher>{
    private String name;
    private int factor;

    public Teacher(String name) {
        this.name = name;
        this.factor = 1;
    }

    public Teacher(String name, int factor) {
        this.name = name;
        this.factor = factor;
    }

    public String getName() {
        return name;
    }

    public int getFactor() {
        return factor;
    }

    @Override
    public int compareTo(Teacher o) {
        if(this.factor>o.factor){
            return 1;
        }
        if(this.factor==o.factor){
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return name+" "+factor+"\n";
    }
}
