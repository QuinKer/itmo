package Enums;

public enum Location {
    FENCE("загородка "),
    GATE("калитка ");

    private final String title;

    Location(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
