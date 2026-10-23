public class FavoriteThingsArray {
    public static void main(String[] args) {
        String[] myFavs = {"Matcha", "Reading", "Make up", "Going out", "Coffee"};

        System.out.println("My Top 5 Favorite Things:");
        for (int i = 0; i < myFavs.length; i++) {
            System.out.println((i + 1) + ". " + myFavs[i]);
        }

        System.out.println("\nTotal Items: " + myFavs.length);
    }
}
