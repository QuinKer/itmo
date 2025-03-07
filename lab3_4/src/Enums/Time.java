package Enums;

public enum Time {
    STILL("по-прежнему "),
    JUST("только "),
    ALREADY("уже "),
    NULL("");

    private final String title;

    Time(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
