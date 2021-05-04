package util;

import beans.Student;
import main.Config;

import java.util.Scanner;

public class MenuUtil {

    public static void processMenu(int menu){
        switch (menu){
            case 1:
                registerStudentMenu();
                break;
            case 2:
                printAllStudentsMenu();
                break;
            case 3:
//                updateStudent();
                updateSameStudent();
                break;
            case 4:
                searchStudents();
                break;
            case 5:
                System.out.println("Istifadeniz uchun teshekkurler");
                System.exit(0);
                break;
            default:
                System.out.println("Duzgun daxil edin!");
                break;
        }
    }

    private static void registerStudentMenu(){
        System.out.print("Nece telebeni qeydiyyatdan kecirmek isteyirsen? ");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        Config.students = new Student[count];

        for(int i = 0 ; i < Config.students.length ; i++){
            Student st = StudentUtil.createStudent();
            Config.students[i] = st;
        }

        StudentUtil.printAllStudents();
    }

    private static void printAllStudentsMenu(){
        StudentUtil.printAllStudents();
    }

    private static void searchStudents(){
        String param = InputUtil.inputText("Ad, soyad ve ya sinif adi daxil edin: ");

        param = param.toLowerCase(); //RaMazaN -> ramazan

        for(int i = 0 ; i < Config.students.length ; i++){
            Student st = Config.students[i];
            if(st.getName().toLowerCase().contains(param)
                    || st.getSurname().toLowerCase().contains(param)
                    || st.getClassName().toLowerCase().contains(param)){
                System.out.println(st.getFullInfo());
            }
        }
    }

    private static void updateStudent(){
        StudentUtil.printAllStudents();

        int index = InputUtil.inputNumber("Telebenin sira nomresini daxil edin: ");

        Student st = StudentUtil.createStudent();

        System.out.println(Config.students[index-1]);

        Config.students[index-1] = st;

        System.out.println(Config.students[index-1]);

    }

    private static void updateSameStudent(){
        StudentUtil.printAllStudents();

        int index = InputUtil.inputNumber("Telebenin sira nomresini daxil edin: ");

        String name = InputUtil.inputText("Ad :");
        String surname = InputUtil.inputText("Soyad :");
        String className = InputUtil.inputText("Sinif adi :");
        int age = InputUtil.inputNumber("Yash :");

        Student st = Config.students[index-1];

        System.out.println(Config.students[index - 1]);

        st.setName(name);
        st.setSurname(surname);
        st.setClassName(className);
        st.setAge(age);

        System.out.println(Config.students[index - 1]);
    }
}
