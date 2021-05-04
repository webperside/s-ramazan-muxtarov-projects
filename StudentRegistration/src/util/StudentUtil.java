package util;

import beans.Student;
import main.Config;

public class StudentUtil {

    public static Student createStudent(){
        String name = InputUtil.inputText("Ad :");
        String surname = InputUtil.inputText("Soyad :");
        String className = InputUtil.inputText("Sinif adi :");
        int age = InputUtil.inputNumber("Yash :");

        return new Student(name, surname, className, age);
    }

    public static void printAllStudents(){
        for(int i = 0; i < Config.students.length ; i++){
            Student st = Config.students[i];
            System.out.println((i+1) + ". " + st.getFullInfo());
        }
    }
}
