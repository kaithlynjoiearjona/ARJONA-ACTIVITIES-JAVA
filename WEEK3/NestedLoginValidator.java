public class NestedLoginValidator {
    public static void main(String[] args) {
        String inputUsername = "joie_admin";
        String inputPassword = "pass123Word";
        boolean isAccountActive = true;

        String correctUsername = "joie_admin";
        String correctPassword = "pass123Word";

        if (inputUsername.equals(correctUsername)) {
            if (inputPassword.equals(correctPassword)) {
                if (isAccountActive) {
                    System.out.println("Login Successful: Welcome back!");
                } else {
                    System.out.println("Login Failed: Account is currently locked or suspended.");
                }
            } else {
                System.out.println("Login Failed: Incorrect password.");
            }
        } else {
            System.out.println("Login Failed: Username not found.");
        }
    }
}
