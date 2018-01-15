public class Komunalka {

    public static void main(String[] args) {
        // Тарифы актуальны на 15.01.18

        System.out.println("В этом месяце");

        // Выводим стоимость за Свет
        Lights(7468, 7658); // Показания вводить без нолей в начале строки

        // Выводим стоимость за Воду
        Waters(263, 277); // Показания вводить без нолей в начале строки

        //Выводим стоимость за Газ
        Gas(1231, 1304); // Показания вводить без нолей в начале строки
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

        System.out.println("Оплата за ГАЗ: " + var + "грн (" + kybGas + " куб.)");
        return 0;
    }

}
