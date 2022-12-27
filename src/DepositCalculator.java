import java.util.Scanner;
public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().assistUserCalculateProfitFromDeposit();
    }

        Scanner scanner = new Scanner(System.in);
        double calculateComplexPercent(double a, double y, int d) {
            double pay = a * Math.pow((1 + y / 12), 12 * d);
            return getRandomScale(pay, 2);
        }

        double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
            return getRandomScale(amount + amount * yearRate * depositPeriod, 2);
        }

        double getRandomScale(double value, int places) {
            double ScaLe = Math.pow(10, places);
            return Math.round(value * ScaLe) / ScaLe;
        }

        void assistUserCalculateProfitFromDeposit() {
            System.out.println("Введите сумму вклада в рублях:");
            int amount = scanner.nextInt();

            System.out.println("Введите срок вклада в годах:");
            int period = scanner.nextInt( );

            System.out.println   ("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
            int action = scanner.nextInt();

            double amountPlusPercentage = 0;

            switch (action) {
                case 1: amountPlusPercentage = calculateSimplePercent(amount, 0.06, period);
                        break;
                case 2: amountPlusPercentage = calculateComplexPercent(amount, 0.06, period);
                        break;
            }
            System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в "
                    + amountPlusPercentage);
        }
}
