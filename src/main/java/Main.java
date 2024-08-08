import model.FullInfo;
import model.Statistics;
import model.Student;
import model.University;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            FullInfo fullInfo = new FullInfo();
            List<Student> students = new ArrayList<>();
            List<University> universities = new ArrayList<>();
            List<Statistics> statistics = new ArrayList<>();

            // Добавляем студентов, университеты, статистику и т.д.
            fullInfo.setStudentList(students)
                    .setUniversityList(universities)
                    .setStatisticsList(statistics)
                    .setProcessDate(new Date());

            // Сериализация в XML
            JAXBContext jaxbContext = JAXBContext.newInstance(FullInfo.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File xmlFile = new File("output.xml");
            marshaller.marshal(fullInfo, xmlFile);
            System.out.println("XML файл успешно создан!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}