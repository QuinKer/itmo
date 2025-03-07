package Enums;

public enum InCoords {
    IN("в "),
    ON("на "),
    UNDER("под "),
    IN_FRONT_OF("перед "),
    BETWEEN("между "),
    BEHIND("за "),
    NEXT_TO("к "),
    FROM_UNDER("из-под "),
    NULL("");

    private final String title;

    InCoords(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
