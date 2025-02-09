package main.java.com.mikitarudy.simulation.tool;

public class Constants {
    public static final String THREE = "\uD83C\uDF33";
    public static final String ROCK = "\uD83D\uDDFB";
    public static final String GRASS = "\uD83C\uDF40";
    public static final String HERBIVORE = "\uD83D\uDC30";
    public static final String PREDATOR = "\uD83D\uDC3A";
    public static final String EMPTY_CELL = "\uD83C\uDFFD";
    public static final String BLANK = " ";
    public static final String MOVE_LOG = "%s сделал ход из %s в %s\n";
    public static final String SPAWN_ENTITY = "Добавлен %s на позицию %s\n";
    public static final String WELCOME = """
            Добро пожаловать в Симуляцию
            Введите:
            [1] - запустить симуляцию
            [0] - выйти из приложения
            """;
    public static final String PAUSE = """
            [1] - запустить автоматическую симуляцию
            [2] - сделать шаг симуляции
            [0] - выйти из приложения
            """;
    public static final String INFINITY = """
            [1] - остановить симуляцию
            """;
    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String ZERO = "0";
    public static final String INCORRECT_INPUT = "Неверный ввод, введите корректное значение.";
    public static final String SIMULATION_START = "Симуляция запущена:";
}
