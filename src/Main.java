import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void printOptions(ArrayList buyList) {
        System.out.println("---------------------");
        System.out.println("Список покупок:");
        for (int i = 0; i < buyList.size(); i++) {
            System.out.println(i+1 + ". " + buyList.get(i));
        }
        System.out.println("---------------------");

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);



        int number;
        String removedProduct;
        String text;
        ArrayList<String> buyList = new ArrayList<>();

        while (true) {
            System.out.println("Выберете операцию:");
            System.out.println("1. Добавить");
            System.out.println("2. Показать");
            System.out.println("3. Удалить");

            number = input.nextInt();

            switch (number) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    text = input2.nextLine();
                    buyList.add(text);
                    break;
                case 2:
                    printOptions(buyList);
                    break;
                case 3:
                    printOptions(buyList);
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    text = input2.nextLine();
                    try {
                        removedProduct = buyList.get(Integer.parseInt(text)-1);
                        buyList.remove(Integer.parseInt(text)-1);
                        System.out.println("Покупка \"" + removedProduct + "\" удалена!");
                        printOptions(buyList);
                    } catch (NumberFormatException exception) {
                        removedProduct = text;
                        int index = 0;
                        for (String product: buyList) {
                            if (product.equals(text)) {
                                buyList.remove(index);
                                System.out.println("Покупка \"" + removedProduct + "\" удалена!");
                                printOptions(buyList);
                                break;
                            } else {
                                if (index + 1 == buyList.size()) {
                                    System.out.println("Покупки \"" + removedProduct + "\" не найдено в списке!");
                                    printOptions(buyList);
                                }
                            }
                        }
                    }


            }





        }
    }
}
