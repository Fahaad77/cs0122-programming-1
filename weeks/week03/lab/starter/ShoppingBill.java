import java.util.Scanner;

public class ShoppingBill {
  public static void main(String[] args) {
    final double VAT_RATE = 0.15;
    Scanner input = new Scanner(System.in);

    System.out.print("Item name: ");
    String itemName = input.nextLine();

    System.out.print("Unit price: ");
    double unitPrice = input.nextDouble();

    System.out.print("Quantity: ");
    int quantity = input.nextInt();

    double subtotal = unitPrice * quantity;
    double vat = subtotal * VAT_RATE;
    double total = subtotal + vat;

    System.out.printf("Subtotal: %.2f%n", subtotal);
    System.out.printf("VAT: %.2f%n", vat);
    System.out.printf("Total for %s: %.2f%n", itemName, total);

    input.close();
  }
}
