import java.util.Scanner;

public class DepositCalculator {
    int degree = 2;

    double calculateComplexPercentFunction(double amountInRubles, double yearRate, int termDepositInRubles) {  // Function из названия метода лучше убрать, только удлинняет название, но смысла не несет
        double resultCalculate = amountInRubles * Math.pow((1 + yearRate / 12), 12 * termDepositInRubles);
        return roundCalculate(resultCalculate, degree);
    }

    double calculateSimplePercentFunction(double doubleAmount, double yearRate, int deposit_period) { // _ подчеркивания в наименовании, а так же doubleAmount приставка double не имеет смысла
        return roundCalculate(doubleAmount + doubleAmount * yearRate * deposit_period, degree);
    }

    double roundCalculate(double value, int places) {
        double ScaLe = Math.pow(10, places); // название переменной с заглавной буквы
        return Math.round(value * ScaLe) / ScaLe;
    }

    void dataEntryAndPrintResults() {
        int amountInRubles;
        int termDepositInRubles;
        int typeOfDeposit;
        double yearRate = 0.06;
        double depositIncome = 0;
        Scanner scanner = new Scanner(System.in); // Тяжелые объекты типа Scanner которые могут пригодится в других местах лучше не создавать в методах

        System.out.println("Введите сумму вклада в рублях:");
        amountInRubles = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        termDepositInRubles = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeOfDeposit = scanner.nextInt(); 
        if (typeOfDeposit == 1) { // if конструкцию и работу с переменными лучше разделить пустой строкой
            depositIncome = calculateSimplePercentFunction(amountInRubles, yearRate, termDepositInRubles);
        } else if (typeOfDeposit == 2) {
            depositIncome = calculateComplexPercentFunction(amountInRubles, yearRate, termDepositInRubles);
        }
        System.out.println("Результат вклада: " + amountInRubles + " за " + termDepositInRubles + " лет превратятся в "
                + depositIncome);
    }

    public static void main(String[] args) {
        new DepositCalculator().dataEntryAndPrintResults();
    }
}
