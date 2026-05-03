public class CreateAccountValidator {

    public boolean isValidEmail(String email) {
        return email != null &&
                email.contains("@") &&
                email.contains(".");
    }

    public boolean isValidPassword(String password) {
        return password != null &&
                password.length() >= 8;
    }

    public boolean isValidAge(int age) {
        return age >= 18 && age <= 60;
    }

    public boolean isValidPhoneNumber(String phone) {
        return phone != null &&
                phone.length() == 10 &&
                phone.matches("\\d+");
    }

    public boolean doPasswordsMatch(String password, String confirmPassword) {
        return password != null &&
                password.equals(confirmPassword);
    }
}
