import enums.StudyProfile;
import model.Student;
import model.University;
import utils.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        University university = new University();
        university.setId("119991");
        university.setFullName("Московский государственный университет");
        university.setShortName("МГУ");
        university.setYearOfFoundation(1949);
        university.setMainProfile(StudyProfile.ENGINEERING);

        Student student1 = new Student();
        student1.setFullName("Алексей Андреев");
        student1.setUniversityId("119991");
        student1.setCurrentCourseNumber(2);
        student1.setAvgExamScore(85.5f);

        Student student2 = new Student();
        student2.setFullName("Кирилл Приказчиков");
        student2.setUniversityId("119991");
        student2.setCurrentCourseNumber(3);
        student2.setAvgExamScore(90.0f);

        List<Student> students = Arrays.asList(student1, student2);

        students.stream()
                .sorted(ComparatorUtil.getStudentComparator(enums.StudentComparatorType.AVG_EXAM_SCORE))
                .forEach(System.out::println);

        System.out.println("Информация об университете:\n" + university);
    }
}