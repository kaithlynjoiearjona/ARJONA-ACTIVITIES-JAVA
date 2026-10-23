public class MultiTierDiscountSystem {
    public static void main(String[] args) {
        double purchaseAmount = 3500.00;
        double discountRate = 0.0;

        if (purchaseAmount >= 5000) {
            discountRate = 0.15;
        } else if (purchaseAmount >= 3000) {
            discountRate = 0.10;
        } else if (purchaseAmount >= 1000) {
            discountRate = 0.05;
        } else {
            discountRate = 0.00;
        }

        double discountAmount = purchaseAmount * discountRate;
        double finalPrice = purchaseAmount - discountAmount;

        System.out.println("Original Price: Php " + purchaseAmount);
        System.out.println("Discount Tier:  " + (int)(discountRate * 100) + "%");
        System.out.println("Final Price:    Php " + finalPrice);
    }
}
