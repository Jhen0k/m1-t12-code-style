import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите сумму вклада в рублях:");
            String amount = scanner.next();

            System.out.println("Введите срок вклада в годах:");
            String period = scanner.next();

            System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
            String action = scanner.next();

            boolean isNumberUserInput = IsStringNumber.isNumeric(amount) // Проверяем ввел ли пользователь число.
                                     && IsStringNumber.isNumeric(period)
                                     && IsStringNumber.isNumeric(action);

            if (isNumberUserInput) { // Если все данные коректны, то создаем новый класс deposit и отправляем его в калькулятор
                Deposit deposit = new Deposit(Integer.parseInt(amount),
                                              Integer.parseInt(period),
                                              Integer.parseInt(action));

                depositCalculator.printBenefitFromDeposit(deposit);
            } else System.out.println("Ошибка! Для ввода используйте цифры 0-9.");
        }
    }
}
