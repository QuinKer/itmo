package Enums;

public enum Gender {
    MALE("М"),
    FEMALE("Ж"),
    NOR("Н");
    private final String title;

    Gender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
