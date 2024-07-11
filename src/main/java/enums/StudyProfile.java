package enums;

public enum StudyProfile {
    MEDICINE("Медицина"),
    ENGINEERING("Инженерия"),
    BUSINESS("Бизнес");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}