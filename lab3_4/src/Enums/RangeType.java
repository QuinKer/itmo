package Enums;

public enum RangeType {
    FURTHER("дальше "),
    CLOSER("ближе "),
    NULL("");

    private final String title;

    RangeType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
