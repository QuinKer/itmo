package Enums;

public enum Color {
    GREEN("зелёный"),
    YELLOW("жёлтый"),
    BLUE("голубой"),
    ORANGE("оранжевый"),
    BRIGHT_BLUE("ярко-синий"),
    GREENY_YELLOW("зеленовато-жёлтый"),
    NONE("");
    private final String title;

    Color(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
