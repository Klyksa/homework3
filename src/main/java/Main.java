import enums.StudyProfile;
import io.XlsWriter;
import model.Student;
import model.University;
import model.Statistics;
import utils.JsonUtil;
import utils.StatisticsUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Создание университета
            University university = new University();
            university.setId("119991");
            university.setFullName("Московский государственный университет");
            university.setShortName("МГУ");
            university.setYearOfFoundation(1949);
            university.setMainProfile(StudyProfile.ENGINEERING);

            // Создание студентов
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

            // Генерация статистики
            List<University> universities = Arrays.asList(university);
            List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);

            // Сериализация коллекций (если необходимо)
            String studentJson = JsonUtil.studentListToJson(students);
            String universityJson = JsonUtil.universityToJson(university);

            // Выводим получившиеся JSON-строки в консоль
            System.out.println("Сериализованные студенты:\n" + studentJson);
            System.out.println("Сериализованный университет:\n" + universityJson);

            // Запись статистики в Excel
            String filePath = "statistics.xlsx";  // Путь к файлу
            XlsWriter.writeXlsStatistics(statisticsList, filePath);
            System.out.println("Статистика успешно записана в файл " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}