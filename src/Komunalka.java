import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Komunalka {

    public static int count; // Переменная для подсчета всей суммы

    public static void main(String[] args) {
        // Тарифы актуальны на 15.01.18

        // Считываем данные с клавиатуры
        Scanner scan = new Scanner(System.in);

        try {

            System.out.println("---------------------------------------------------------");
            System.out.println("Показания вводятся без начальных нулей!");
            System.out.println("---------------------------------------------------------");

            System.out.print("Введите старые показания за СВЕТ (4 цифры): ");
            int light1 = scan.nextInt();
            System.out.print("Введите новые показания за СВЕТ (4 цифры): ");
            int light2 = scan.nextInt();

            System.out.print("Введите старые показания за ВОДУ (3 цифры): ");
            int water1 = scan.nextInt();
            System.out.print("Введите новые показания за ВОДУ (3 цифры): ");
            int water2 = scan.nextInt();

            System.out.print("Введите старые показания за ГАЗ (4 цифры): ");
            int gas1 = scan.nextInt();
            System.out.print("Введите новые показания за ГАЗ (4 цифры): ");
            int gas2 = scan.nextInt();

            System.out.println("\n<------------------------------------------------------->\n");

            String copy = "";

            // RahitMode ON
            copy += "Свет:\n";
            copy += "Старые показания: " + light1 + "\n";
            copy += "Новые показания: " + light2 + "\n";
            copy += "\n";

            copy += "Вода:\n";
            copy += "Старые показания: " + water1 + "\n";
            copy += "Новые показания: " + water2 + "\n";
            copy += "\n";

            copy += "Газ:\n";
            copy += "Старые показания: " + gas1 + "\n";
            copy += "Новые показания: " + gas2 + "\n";
            copy += "\n\n";

            copy += "Итого за месяц: \n";

            copy += Lights(light1, light2);
            copy += Waters(water1, water2);
            copy += Gas(gas1, gas2);

            copy += "Всего: " + count + "грн";
            // RahitMode OFF

            System.out.println(copy);
            copyToClipboard(copy);


            System.out.println("\n");
            System.out.println("---------------------------------------------------------");
            System.out.println("Текст уже скопирован в буфер обмена! \nВставьте в удобное для вас место используя Ctrl+V");
            System.out.println("---------------------------------------------------------");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scan.hasNext();
    }

    /**
     * Класс подсчета стоимости коммуналки за свет
     * @param oldLight - Показания счетчика за предыдущий месяц
     * @param newLight - Показания счетчика за прошлый месяц
     * @return
     */
    public static String Lights(int oldLight, int newLight) {
        double var;
        int kilowatts; // Сколько всего потребило кВт
        double lightTariff = 0.9; // Тариф по умолчанию 0.90коп до 100кВт
        NumberFormat newDouble = new DecimalFormat("#.##");

        kilowatts = newLight - oldLight;

        // Условие - если больше 100кВт - тариф повышается
        if (kilowatts >= 100) {
            lightTariff = 1.68;
        }

        var = kilowatts * lightTariff;

        Komunalka.count += var;

        return "Оплата за свет: " + newDouble.format(var) + "грн (" + kilowatts + " кВт)\n";
    }

    /**
     * Класс подсчета стоимости коммуналки за воду
     * @param oldWater - Показания счетчика за предыдущий месяц
     * @param newWater - Показания счетчика за прошлый месяц
     * @return
     */
    public static String Waters(int oldWater, int newWater) {
        double var;
        int kybWaters; // Сколько всего потребило кубометров воды
        double waterTariff = 13; // Тариф горводоканала 12,936 грн. (с НДС). Округлил до 13грн за куб.
        NumberFormat newDouble = new DecimalFormat("#.##");

        kybWaters = newWater - oldWater;
        var = kybWaters * waterTariff;

        Komunalka.count += var;

        return "Оплата за воду: " + newDouble.format(var) + "грн (" + kybWaters + " куб.)\n";
    }

    /**
     * Кдасс подсчета стоимости коммуналки за газ
     * @param oldGas - Показания счетчика за предыдущий месяц
     * @param newGas - Показания счетчика за прошлый месяц
     * @return
     */
    public static String Gas(int oldGas, int newGas) {
        double var;
        int kybGas; // Сколько всего потребило кубометров газа
        double gasTariff = 7; // Тариф с сайта 104.ua - 6.9579 грн. за куб.м. Округлил до 7грн
        NumberFormat newDouble = new DecimalFormat("#.##");

        kybGas = newGas - oldGas;
        var = kybGas * gasTariff;

        Komunalka.count += var;

        return "Оплата за газ: " + newDouble.format(var) + "грн (" + kybGas + " куб.)\n";
    }

    public static void copyToClipboard(String str) {
        StringSelection s = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
    }

}
