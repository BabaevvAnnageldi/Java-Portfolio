import java.util.Scanner;
/**
 * A program to calculate the total bill for cosmetic products, applying discounts and tax.
 * @author Annageldi
 * @version 1.0
 */
public class CosmeticBill {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

           // Product prices
        final double LIPSTICK_PRICE = 45.0;
        final double FOUNDATION_PRICE = 80.0;
        final double PERFUME_PRICE = 150.0;

        // Input product type
        System.out.println("Available products: Lipstick Foundation, Perfume");
        System.out.print("Enter product type: ");
        
        String productType = input.nextLine().trim().toLowerCase();

        // Validate product type and get price
        double price;
        switch (productType) {
            case "lipstick":
                price = LIPSTICK_PRICE;
                break;
            case "foundation":
                price = FOUNDATION_PRICE;
                break;
            case "perfume":
                price = PERFUME_PRICE;
                break;
            default:
                System.out.println("Error: Invalid product type.");
                return; // Exit program if input is invalid
        }

        // Input quantity
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be positive.");
            return; // Exit program if input is invalid
        }

        // Input membership status
        System.out.print("Are you a member? (yes/no): ");
        String isMember = input.next().trim().toLowerCase();
        boolean memberDiscount = isMember.equals("yes");

        // Calculate total cost before discounts
        double totalCost = price * quantity;

        // Apply quantity-based discount
        double discountRate = 0.0;
        if (quantity >= 3 && quantity <= 6) {
            discountRate = 0.15; 
        } else if (quantity > 6) {
            discountRate = 0.20; 
        }

        double discountAmount = totalCost * discountRate;
        double costAfterDiscount = totalCost - discountAmount;

        // Apply additional 5% member discount if applicable
        if (memberDiscount) {
            double memberDiscountAmount = costAfterDiscount * 0.05;
            costAfterDiscount -= memberDiscountAmount;
        }

        // Calculate 8% Sales and Service Tax
        double tax = costAfterDiscount * 0.08;
        double finalBill = costAfterDiscount + tax;

        // Display the bill
        System.out.println("\n=== FINAL BILL ===");
        System.out.printf("Product: %s%n", productType);
        System.out.printf("Quantity: %d%n", quantity);
        System.out.printf("Unit Price: MYR %.2f%n", price);
        System.out.printf("Total before discounts: MYR %.2f%n", totalCost);
        if (discountRate > 0) {
            System.out.printf("Quantity Discount (%d%%): MYR -%.2f%n", (int)(discountRate * 100), discountAmount);
        }
        if (memberDiscount) {
            System.out.printf("Member Discount (5%%): MYR -%.2f%n", costAfterDiscount * 0.05);
        }
        System.out.printf("Price after discounts: MYR %.2f%n", costAfterDiscount);
        System.out.printf("Sales & Service Tax (8%%): MYR %.2f%n", tax);
        System.out.printf("TOTAL AMOUNT DUE: MYR %.2f%n", finalBill);
        
        input.close(); // Close the scanner
    }
}
