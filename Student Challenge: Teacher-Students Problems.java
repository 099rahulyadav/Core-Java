class Whiteboard {
    int no_of_student = 0;
    String text;
    int count = 0;

    public void attendence() {
        no_of_student++;
    }

    synchronized public void write(String str) {
        System.out.println("Teacher is writing: " + str);
        while (count != 0) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        text = str;
            count = no_of_student;
            notifyAll();
        
    }

    synchronized public String read() {
        while (count == 0) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        String t = text;
        count--;
        if (count == 0) 
            notify();
        return t;
    }

}

class Teacher extends Thread {

    Whiteboard wh;
    String[] notes={"Java is language","It supports OOPS","Its platform independent","end"};

    public Teacher(Whiteboard wh) {
        this.wh = wh;
    }
    public void run() {
        for (int i = 0; i < notes.length; i++) {
            wh.write(notes[i]);
        }
    }
}

class Student extends Thread {
    Whiteboard wh;
    String name;

    public Student(Whiteboard wh, String name) {
        this.name = name;
        this.wh = wh;

    }
    public void run() {
        String text;
        wh.attendence();
        do{
            text = wh.read();
            System.out.println(name+ " Reading "+ text);
            System.out.flush();
        } while (!text.equals("end"));
    }
}

public class TeacherWhiteBoardStudent {
    public static void main(String[] args) {
    Whiteboard wh = new Whiteboard();
    Teacher t = new Teacher(wh);
    Student s1 = new Student(wh, "1.REX");
    Student s2 = new Student(wh, "2.Ramesh");
    t.start();
    s1.start();
    s2.start();
}
}
