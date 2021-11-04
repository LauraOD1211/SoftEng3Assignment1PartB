// Imports
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args){
        // Create everything separately, then add students to modules and courses and vice versa
        // Create 8 students
        Student student1 = new Student("John Smith", 20, new DateTime(2001, 7, 30, 0, 0), 123456, null, null);
        Student student2 = new Student("Mary Jones", 22, new DateTime(1999, 5, 17, 0, 0), 135791, null, null);
        Student student3 = new Student("Harry Wright", 22, new DateTime(1999, 8, 20, 0, 0), 246802, null, null);
        Student student4 = new Student("Mark Small", 20, new DateTime(2001, 1, 2, 0, 0), 943724, null, null);
        Student student5 = new Student("Timothy Stone", 22, new DateTime(1998, 12, 29, 0, 0), 157543, null, null);
        Student student6 = new Student("James Burke", 21, new DateTime(2000, 6, 8, 0, 0), 354843, null, null);
        Student student7 = new Student("Lisa Kelly", 20, new DateTime(2001, 9, 10, 0, 0), 645794, null, null);
        Student student8 = new Student("Carol Ward", 19, new DateTime(2002, 3, 11, 0, 0), 486754, null, null);

        // Create 5 modules
        Module module1 = new Module("Programming","CT101", null, null);
        Module module2 = new Module("Algorithms","CT102", null, null);
        Module module3 = new Module("Networks","CT103", null, null);
        Module module4 = new Module("Software Engineering","CT104", null, null);
        Module module5 = new Module("Professional Skills","CT105", null, null);

        // Create 2 Courses
        CourseProgramme course1 = new CourseProgramme("CSIT", null, null, new DateTime(2021, 9, 1, 0, 0),new DateTime(2022, 5, 31, 0, 0));
        CourseProgramme course2 = new CourseProgramme("ECE", null, null, new DateTime(2021, 9, 1, 0, 0),new DateTime(2022, 5, 31, 0, 0));

        // Add students to modules and vice versa
        module1.setStudents(new ArrayList<>(List.of(student1, student2, student3)));
        module2.setStudents(new ArrayList<>(List.of(student1, student4, student5)));
        module3.setStudents(new ArrayList<>(List.of(student3, student6, student7)));
        module4.setStudents(new ArrayList<>(List.of(student2, student4, student8)));
        module5.setStudents(new ArrayList<>(List.of(student5, student7, student8)));
        student1.setRegisteredModules(new ArrayList<>(List.of(module1, module2)));
        student2.setRegisteredModules(new ArrayList<>(List.of(module1, module4)));
        student3.setRegisteredModules(new ArrayList<>(List.of(module1, module3)));
        student4.setRegisteredModules(new ArrayList<>(List.of(module2, module4)));
        student5.setRegisteredModules(new ArrayList<>(List.of(module2, module5)));
        student6.setRegisteredModules(new ArrayList<>(List.of(module3)));
        student7.setRegisteredModules(new ArrayList<>(List.of(module3, module5)));
        student8.setRegisteredModules(new ArrayList<>(List.of(module4, module5)));

        // Add modules to courses and vice versa
        course1.setModules(new ArrayList<>(List.of(module1, module2, module3, module4)));
        course2.setModules(new ArrayList<>(List.of(module1, module2, module4, module5)));
        module1.setCourses(new ArrayList<>(List.of(course1, course2)));
        module2.setCourses(new ArrayList<>(List.of(course1, course2)));
        module3.setCourses(new ArrayList<>(List.of(course1)));
        module4.setCourses(new ArrayList<>(List.of(course1, course2)));
        module5.setCourses(new ArrayList<>(List.of(course2)));

        // Add students to courses and vice versa
        course1.setStudents(new ArrayList<>(List.of(student1, student2, student3, student8)));
        course2.setStudents(new ArrayList<>(List.of(student4, student5, student6, student7)));
        student1.setCourses(new ArrayList<>(List.of(course1)));
        student2.setCourses(new ArrayList<>(List.of(course1)));
        student3.setCourses(new ArrayList<>(List.of(course1)));
        student4.setCourses(new ArrayList<>(List.of(course2)));
        student5.setCourses(new ArrayList<>(List.of(course2)));
        student6.setCourses(new ArrayList<>(List.of(course2)));
        student7.setCourses(new ArrayList<>(List.of(course2)));
        student8.setCourses(new ArrayList<>(List.of(course1)));

        College college = new College();

        // Print all courses
        college.printCourseInfo(course1);
        college.printCourseInfo(course2);

        // Print all modules
        college.printModuleInfo(module1);
        college.printModuleInfo(module2);
        college.printModuleInfo(module3);
        college.printModuleInfo(module4);
        college.printModuleInfo(module5);

        // Print all students
        college.printStudentInfo(student1);
        college.printStudentInfo(student2);
        college.printStudentInfo(student3);
        college.printStudentInfo(student4);
        college.printStudentInfo(student5);
        college.printStudentInfo(student6);
        college.printStudentInfo(student7);
        college.printStudentInfo(student8);
    }

    // Method to print course data
    public void printCourseInfo(CourseProgramme course) {
        System.out.println("_-_-_COURSE_-_-_");
        DateTimeFormatter fmt = DateTimeFormat.forPattern("d MMMM, yyyy");
        System.out.println("Course Name: "+course.getName());
        System.out.println("Start: "+course.getStartDate().toString(fmt));
        System.out.println("End: "+course.getEndDate().toString(fmt));
        System.out.println("Related modules:");
        for (Module m: course.getModules()) {
            System.out.println("~ "+m.getModuleName());
        }
        System.out.println("Enrolled students:");
        for (Student s: course.getStudents()) {
            System.out.println("~ "+s.getName());
        }
        System.out.println();
    }

    //Method to print module data
    public void printModuleInfo(Module module) {
        System.out.println("_-_-_MODULE_-_-_");
        System.out.println("Module Name: "+module.getModuleName());
        System.out.println("ID: "+module.getID());
        System.out.println("Related courses:");
        for (CourseProgramme c: module.getCourses()) {
            System.out.println("~ "+c.getName());
        }
        System.out.println("Enrolled students:");
        for (Student s: module.getStudents()) {
            System.out.println("~ "+s.getName());
        }
        System.out.println();
    }

    //Method to print student data
    public void printStudentInfo(Student student) {
        System.out.println("_-_-_STUDENT_-_-_");
        DateTimeFormatter fmt = DateTimeFormat.forPattern("d MMMM, yyyy");
        System.out.println("Full Name: "+student.getName());
        System.out.println("Username: "+student.getUsername());
        System.out.println("ID: "+student.getID());
        System.out.println("Age: "+student.getAge());
        System.out.println("Date of birth: "+student.getDOB().toString(fmt));
        System.out.println("Enrolled courses:");
        for (CourseProgramme c: student.getCourses()) {
            System.out.println("~ "+c.getName());
        }
        System.out.println("Enrolled modules:");
        for (Module m: student.getRegisteredModules()) {
            System.out.println("~ "+m.getModuleName());
        }
        System.out.println();
    }
}
