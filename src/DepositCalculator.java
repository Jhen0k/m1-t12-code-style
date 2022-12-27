public class DepositCalculator { // После класса надо ставить пустую строку
    private double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double result = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return getRandomScale(result, 2);
    }

    private double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getRandomScale(amount + amount * yearRate * depositPeriod, 2);
    }

    private double getRandomScale(double value, int degree) {
        double scale = Math.pow(10, degree);
        return Math.round(value * scale) / scale;
    }

    public void printBenefitFromDeposit(Deposit deposit) {

        double amountPlusPercentage = 0;

        switch (deposit.getAction()) {
            case 1:
                amountPlusPercentage = calculateSimplePercent(deposit.getAmount(), 0.06, deposit.getPeriod());
                break;
            case 2:
                amountPlusPercentage = calculateComplexPercent(deposit.getAmount(), 0.06, deposit.getPeriod());
                break;
            default:
                System.out.println("Ошибка!: Выберите тип вклада, 1 - вклад с обычным процентом, "
                        + "2 - вклад с капитализацией");
        }
        System.out.println("Результат вклада: " + deposit.getAmount() + " за "
                + deposit.getPeriod() + " лет превратятся в " + amountPlusPercentage);
    }
}
