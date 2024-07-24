package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

public class University {
    @SerializedName("id_university")
    private String id;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("short_name")
    private String shortName;

    @SerializedName("foundation_year")
    private int yearOfFoundation;

    @SerializedName("main_profile")
    private StudyProfile mainProfile;
    public University() {
        this.id = "";
        this.fullName = "";
        this.shortName = "";
        this.yearOfFoundation = 0;
        this.mainProfile = null;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    // Метод toString
    @Override
    public String toString() {
        return "Идентификатор университета: " + id + "\nПолное имя: " + fullName + "\nКраткое название: " + shortName + "\nГод основания: " + yearOfFoundation + "\nОсновной профиль: " + mainProfile.getProfileName();
    }
}