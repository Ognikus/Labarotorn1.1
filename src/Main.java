import java.util.*;
import java.util.Scanner;

public class Main {

    //Ввести n строк с консоли, найти самую короткую строку.
    // Вывести эту строку и ее длину.
    public static void Task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // съедаем символ переноса строки

        String shortest = null;
        int shortestLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку " + (i + 1) + ": ");
            String input = scanner.nextLine();
            if (input.length() < shortestLength) {
                shortest = input;
                shortestLength = input.length();
            }
        }

        System.out.println("Самая короткая строка: " + shortest);
        System.out.println("Длина строки: " + shortestLength);
    }

    // Ввести n строк с консоли.
    // Упорядочить и вывести строки в порядке возрастания их длин, а также (второй приоритет) значений этих их длин.
    public static void Task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // съедаем символ переноса строки

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        // Сортируем массив строк по длине и выводим отсортированный массив
        sortStringsByLength(strings);
        System.out.println("Строки, отсортированные по длине:");
        printStrings(strings);

        // Сортируем массив строк по длине и значениям длины и выводим отсортированный массив
        sortStringsByLengthAndValue(strings);
        System.out.println("Строки, отсортированные по длине и значениям длины:");
        printStrings(strings);
    }

    private static void sortStringsByLength(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].length() > strings[j].length()) {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
    }

    private static void sortStringsByLengthAndValue(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].length() > strings[j].length() ||
                        (strings[i].length() == strings[j].length() && strings[i].compareTo(strings[j]) > 0)) {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
    }

    private static void printStrings(String[] strings) {
        for (String s : strings) {
            System.out.println(s);
        }

    }

    // Ввести n строк с консоли.
    // Вывести на консоль те строки, длина которых меньше средней, также их длины.
    public static void Task3() {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества строк
        System.out.print("Введите количество строк: ");
        int n = scanner.nextInt();

        // Создание массива строк
        String[] strings = new String[n];

        // Ввод строк
        System.out.println("Введите строки:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }

        // Вычисление средней длины строки
        int totalLength = 0;
        for (String str : strings) {
            totalLength += str.length();
        }
        double averageLength = (double) totalLength / n;

        // Вывод строк, длина которых меньше средней
        System.out.println("Строки, длина которых меньше средней:");
        for (String str : strings) {
            if (str.length() < averageLength) {
                System.out.println(str + " (длина: " + str.length() + ")");
            }
        }
    }

    //В каждом слове текста k-ю букву заменить заданным символом.
    // Если k больше длины слова, корректировку не выполнять.
    public static void Task4() {
        Scanner scanner = new Scanner(System.in);

        // Ввод текста и k
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();
        System.out.print("Введите номер буквы для замены: ");
        int k = scanner.nextInt();
        System.out.print("Введите символ для замены: ");
        char replacement = scanner.next().charAt(0);

        // Разделение текста на слова
        String[] words = text.split(" ");

        // Замена k-й буквы в каждом слове
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (k <= word.length()) {
                char[] chars = word.toCharArray();
                chars[k - 1] = replacement;
                words[i] = new String(chars);
            }
        }

        // Вывод обновленного текста
        System.out.println("Обновленный текст:");
        System.out.println(String.join(" ", words));
    }

    //  В русском тексте каждую букву заменить ее номером в алфавите.
    //  В одной строке печатать текст с двумя пробелами между буквами, в следующей строке внизу под каждой буквой печатать ее номер.
    public static void Task5() {
        String text = "Пример текста для задачи на Java";
        StringBuilder encodedText = new StringBuilder();
        StringBuilder numbers = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                int code = Character.toLowerCase(ch) - 'а' + 1;
                encodedText.append(code).append("  ");
                numbers.append(ch).append(" ");
                numbers.append(code).append("\n");
            } else {
                encodedText.append(ch).append("  ");
                numbers.append(ch).append("\n");
            }
        }

        System.out.println(encodedText);
        System.out.println(numbers);
    }

    // Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами.
    // Между последовательностями подряд идущих букв оставить хотя бы один пробел.
    public static void Task6() {
        String text = "Этот текст со     знаками препинания, цифрами 123 и другими символами!";

        // Удаляем все символы, кроме букв и пробелов
        String cleanedText = text.replaceAll("[^\\p{L}\\s]+", "");

        // Между последовательностями подряд идущих букв оставляем один пробел
        cleanedText = cleanedText.replaceAll("(\\p{L}+)\\s+(\\p{L}+)", "$1 $2");

        // Выводим очищенный текст
        System.out.println(cleanedText);
    }

    //Из текста удалить все слова заданной длины, начинающиеся на согласную букву
    public static void Task7() {
        Scanner scanner = new Scanner(System.in);

        // Вводим исходный текст
        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        // Вводим длину слова, которое нужно удалить
        System.out.println("Введите длину слова:");
        int length = scanner.nextInt();

        // Разбиваем текст на отдельные слова
        String[] words = text.split(" ");

        // Создаем новый массив, в котором будут храниться только нужные слова
        String[] newWords = new String[words.length];
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() != length || isVowel(word.charAt(0))) {
                newWords[j++] = word;
            }
        }

        // Объединяем оставшиеся слова в одну строку
        String result = "";
        for (int i = 0; i < j; i++) {
            result += newWords[i] + " ";
        }

        // Выводим получившуюся строку на консоль
        System.out.println(result);
    }

    // Метод, который проверяет, является ли заданная буква гласной или согласной
    public static boolean isVowel(char ch) {
        String vowels = "аеёиоуыэюя";
        return vowels.indexOf(Character.toLowerCase(ch)) != -1;
    }

    public static void Task8() {
        // Залупа ебаная!
    }

    //Найти и напечатать, сколько раз повторяется в тексте каждое слово.
    public static void Task9() {
        String text = "Это пример текста. В этом текста слово это повторяется - два раза. А слово текста - три раза.";

        // Удаляем знаки препинания и переводим текст в нижний регистр
        text = text.replaceAll("[^\\p{L}\\p{Nd}]+", " ").toLowerCase();

        // Разбиваем текст на слова
        String[] words = text.split(" ");

        // Создаем HashMap для хранения частоты повторения слов
        Map<String, Integer> wordFreq = new HashMap<>();

        // Считаем количество повторений каждого слова
        for (String word : words) {
            if (!wordFreq.containsKey(word)) {
                wordFreq.put(word, 1);
            } else {
                int freq = wordFreq.get(word);
                wordFreq.put(word, freq + 1);
            }
        }

        // Выводим результаты
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            System.out.println("'" + entry.getKey() + "' повторяется " + entry.getValue() + " раз(а)");
        }
    }

    public static void Task10() {
        String text = "Это текст. Он содержит несколько предложений! В каждом предложении мы будем искать гласные и согласные буквы. А ещё я люблю яйца";

        // Разбиваем текст на предложения
        String[] sentences = text.split("[.!?]");

        // Проходимся по каждому предложению
        for (String sentence : sentences) {
            // Инициализируем счетчики гласных и согласных букв
            int vowels = 0;
            int consonants = 0;

            // Проходимся по каждому символу в предложении
            for (int i = 0; i < sentence.length(); i++) {
                char c = Character.toLowerCase(sentence.charAt(i));
                if (c == 'а' || c == 'е' || c == 'ё' || c == 'и' || c == 'о' || c == 'у' || c == 'ы' || c == 'э' || c == 'ю' || c == 'я') {
                    // Текущий символ является гласной буквой
                    vowels++;
                } else if (c >= 'б' && c <= 'я') {
                    // Текущий символ является согласной буквой
                    consonants++;
                }
            }

            // Определяем, каких букв больше в данном предложении
            String result = "В предложении \"" + sentence.trim() + "\": ";
            if (vowels > consonants) {
                result += "больше гласных букв (" + vowels + ")";
            } else if (consonants > vowels) {
                result += "больше согласных букв (" + consonants + ")";
            } else {
                result += "одинаковое количество гласных и согласных букв (" + vowels + ")";
            }

            // Выводим результат для данного предложения
            System.out.println(result);
        }
    }

    public static void Task11(){

    }

    public static void Task12(){

    }
    public static void Task13(){
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex(0, 0));
        vertices.add(new Vertex(0, 2));
        vertices.add(new Vertex(4, 4));
        vertices.add(new Vertex(4, 0));
        Polygon polygon = new Polygon(vertices);
        double area = calculateArea(polygon.getVertices());
        System.out.println("Площадь многоугольника: " + area);
    }
    public static double calculateArea(List<Vertex> vertices) {
        int n = vertices.size();
        double area = 0;
        for (int i = 0; i < n; i++) {
            Vertex vertex1 = vertices.get(i);
            Vertex vertex2 = vertices.get((i + 1) % n);
            area += (vertex1.getX() + vertex2.getX()) * (vertex2.getY() - vertex1.getY());
        }
        return Math.abs(area) / 2;
    }
    public static void main(String[] args) {
        //Task1();
        //Task2();
        //Task3();
        //Task4();
        //Task5();
        //Task6();
        //Task7();
        //Task8();
        //Task9();
        //Task10();
        //Task11();
        //Task12();
        Task13();
    }
}
