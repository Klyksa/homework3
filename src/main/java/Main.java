import enums.StudyProfile;
import io.XlsWriter;
import model.Statistics;
import model.Student;
import model.University;
import utils.StatisticsUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            // Загрузка конфигурации логгирования
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));

            // Создание университета
            University university = new University();
            university.setId("119991");
            university.setFullName("Московский государственный университет");
            university.setShortName("МГУ");
            university.setYearOfFoundation(1949);
            university.setMainProfile(StudyProfile.ENGINEERING);
            logger.info("Университет успешно создан: " + university.getFullName());

            // Создание студентов
            Student student1 = new Student();
            student1.setFullName("Алексей Андреев");
            student1.setUniversityId("119991");
            student1.setCurrentCourseNumber(2);
            student1.setAvgExamScore(85.5f);
            logger.info("Студент добавлен: " + student1.getFullName());

            Student student2 = new Student();
            student2.setFullName("Кирилл Приказчиков");
            student2.setUniversityId("119991");
            student2.setCurrentCourseNumber(3);
            student2.setAvgExamScore(90.0f);
            logger.info("Студент добавлен: " + student2.getFullName());

            List<Student> students = Arrays.asList(student1, student2);

            // Генерация статистики
            List<University> universities = Arrays.asList(university);
            List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
            logger.info("Статистика успешно сгенерирована для студентов.");

            // Запись статистики в Excel
            String filePath = "statistics.xlsx";  // Путь к файлу
            try {
                XlsWriter.writeXlsStatistics(statisticsList, filePath);
                logger.info("Статистика успешно записана в файл " + filePath);
            } catch (Exception e) { // Ловим более общий класс исключений
                logger.log(Level.SEVERE, "Ошибка при записи в Excel", e);
            }

        } catch (SecurityException | IOException e) { // Слушаем только те исключения, которые могут быть брошены
            logger.log(Level.SEVERE, "Ошибка при выполнении программы", e);
        }
    }
}
