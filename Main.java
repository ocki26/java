import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static List<Student> studentList = new ArrayList<>();
    public static void main (String[]args)
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("1 nhập thông tin sinh viên ");
            System.out.println("2 in danh sách sinh viên ");
            System.out.println("3 xoa danh sach sinh vien");
            System.out.println("4 sắp xếp sinh viên theo gragde");
            System.out.println("5 tìm kiếm sinh viên theo tên và mã");
            System.out.println("6 tìm kiếm sinh viên theo điểm");
            System.out.println("0 thoát ");
            System.out.println("nhập lựa chọn của bạn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    addstudent(scanner);
                    break;
                case 2:
                    printliststuent();
                    break;
                case 3:
                    deletestudent(scanner);
                    break;
                case 4:
                    softstudentbygrade();
                    break;
                case 5:
                    frindstudentbyname(scanner);
                    break;
                case 6:
                    frindstudentbymark(scanner);
                    break;
                case 7:
                    System.out.println("thoát");
                    break;
                default:
                    System.out.println("lựa chọn không hợp lệ");
            }


        }while (choice !=0 );


    }
    public static void addstudent(Scanner scanner){
        System.out.println("nhap ten");
        String name = scanner.nextLine();
        System.out.println("nhaptuoi");
        int age = scanner.nextInt();
        System.out.println("nhap email");
        String email = scanner.nextLine();
        System.out.println("nhap phone");
        String phone = scanner.nextLine();
        System.out.println("nhap code");
        String code =scanner.nextLine();
        System.out.println("nhap gender,0 male,1,female");
        int gender = scanner.nextInt();
        System.out.println("nhap garde");
        float garde = scanner.nextFloat();
        scanner.nextLine();

        Student student = new Student(name, age, email, phone, code, gender, garde);
        studentList.add(student);

    }
    public static void printliststuent()
    {
        for (Student student : studentList) {
            System.out.println(student);
        }

    }
    public static void deletestudent(Scanner scanner){
        System.out.println("nhập mã sinh viên cần xóa");
        String code = scanner.nextLine();
        studentList.removeIf(student -> student.getCode().equals(code));
        System.out.println("xóa sinh viên thành công");

    }
    public static void softstudentbygrade(){
        studentList.sort(Comparator.comparing(Student :: getGrade));
        System.out.println("Sắp xếp thành công");

    }
    public static void frindstudentbyname(Scanner scanner){
        System.out.println("tìm sinh viên theo mã");
        String input = scanner.nextLine();
        for(Student student : studentList){
            if(student.getCode().equals(input)||student.getName().equalsIgnoreCase(input)){
                System.out.println(student);
            }


        }
    }

    public static void frindstudentbymark(Scanner scanner){
        System.out.println("nhâpj điểm");
        float X = scanner.nextFloat();
        for(Student student : studentList){
            if(student.getGrade() >=X){
                System.out.println(student);
            }
        }
    }




    public static class Student {
        private String name;
        private int age;
        private String email;
        private String phone;
        private String code;
        private int gender;
        private float grade;
        public  Student(String name,int age ,String email,String phone,String code,int gender,float grade){
            this.name = name;
            this.age = age;
            this.email = email;
            this.phone = phone;
            this.code = code;
            this.gender = gender;
            this.grade = grade;

        }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }
        public int getGender() { return gender; }
        public void setGender(int gender) { this.gender = gender; }
        public float getGrade() { return grade; }
        public void setGrade(float grade) { this.grade = grade; }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", code='" + code + '\'' +
                    ", gender=" + gender +
                    ", grade=" + grade +
                    '}';
        }
    }
}