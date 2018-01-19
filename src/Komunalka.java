//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.Scanner;

public class Komunalka {

    public static int count; // Переменная для подсчета всей суммы

    public static void main(String[] args) {
        // Тарифы актуальны на 15.01.18

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Считываем данные с клавиатуры
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите старые показания за СВЕТ: ");
        int light1 = scan.nextInt();
        System.out.print("Введите новые показания за СВЕТ: ");
        int light2 = scan.nextInt();

        System.out.print("Введите старые показания за ВОДУ: ");
        int water1 = scan.nextInt();
        System.out.print("Введите новые показания за ВОДУ: ");
        int water2 = scan.nextInt();

        System.out.print("Введите старые показания за ГАЗ: ");
        int gas1 = scan.nextInt();
        System.out.print("Введите новые показания за ГАЗ: ");
        int gas2 = scan.nextInt();

        System.out.println("\nИтого за месяц: ");

        // Выводим стоимость за Свет
        Lights(light1, light2); // Показания вводить без нолей в начале строки

        // Выводим стоимость за Воду
        Waters(water1, water2); // Показания вводить без нолей в начале строки

        //Выводим стоимость за Газ
        Gas(gas1, gas2); // Показания вводить без нолей в начале строки

        System.out.println("Всего: " + count + "грн");
    }

    /**
     * Класс подсчета стоимости коммуналки за свет
     * @param oldLight - Показания счетчика за предыдущий месяц
     * @param newLight - Показания счетчика за прошлый месяц
     * @return
     */
    public static double Lights(int oldLight, int newLight) {
        double var;
        int kilowatts; // Сколько всего потребило кВт
        double lightTariff = 0.9; // Тариф по умолчанию 0.90коп до 100кВт

        kilowatts = newLight - oldLight;

        // Условие - если больше 100кВт - тариф повышается
        if (kilowatts >= 100) {
            lightTariff = 1.68;
        }

        var = kilowatts * lightTariff;

        Komunalka.count += var;

        System.out.println("Оплата за СВЕТ: " + var + "грн (" + kilowatts + " кВт)");
        return 0;
    }

    /**
     * Класс подсчета стоимости коммуналки за воду
     * @param oldWater - Показания счетчика за предыдущий месяц
     * @param newWater - Показания счетчика за прошлый месяц
     * @return
     */
    public static double Waters(int oldWater, int newWater) {
        double var;
        int kybWaters; // Сколько всего потребило кубометров воды
        double waterTariff = 13; // Тариф горводоканала 12,936 грн. (с НДС). Округлил до 13грн за куб.

        kybWaters = newWater - oldWater;
        var = kybWaters * waterTariff;

        Komunalka.count += var;

        System.out.println("Оплата за ВОДУ: " + var + "грн (" + kybWaters + " куб.)");
        return 0;
    }

    /**
     * Кдасс подсчета стоимости коммуналки за газ
     * @param oldGas - Показания счетчика за предыдущий месяц
     * @param newGas - Показания счетчика за прошлый месяц
     * @return
     */
    public static double Gas(int oldGas, int newGas) {
        double var;
        int kybGas; // Сколько всего потребило кубометров газа
        double gasTariff = 7; // Тариф с сайта 104.ua - 6.9579 грн. за куб.м. Округлил до 7грн

        kybGas = newGas - oldGas;
        var = kybGas * gasTariff;

        Komunalka.count += var;

        System.out.println("Оплата за ГАЗ: " + var + "грн (" + kybGas + " куб.)");
        return 0;
    }

}
