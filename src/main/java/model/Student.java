package model;

public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    public Student() {
        this.fullName = "";
        this.universityId = "";
        this.currentCourseNumber = 0;
        this.avgExamScore = 0.0f;
    }

    // Геттеры и сеттеры
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    // Метод toString
    @Override
    public String toString() {
        return "Имя студента: " + fullName + "\nИдентификатор университета: " + universityId + "\nНомер текущего курса: " + currentCourseNumber + "\nСредний балл за экзамен: " + avgExamScore;
    }
}