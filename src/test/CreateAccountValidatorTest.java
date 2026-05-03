import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CreateAccountValidatorTest {

    private CreateAccountValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CreateAccountValidator();
        System.out.println("Test started");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test finished");
    }

    // EMAIL TESTS

    @Test
    void validEmailTest() {
        assertTrue(validator.isValidEmail("test@gmail.com"));
    }

    @Test
    void invalidEmailWithoutAtTest() {
        assertFalse(validator.isValidEmail("testgmail.com"));
    }

    @Test
    void invalidEmailWithoutDotTest() {
        assertFalse(validator.isValidEmail("test@gmailcom"));
    }

    // PASSWORD TESTS (BVA)

    @Test
    void validPasswordBoundaryTest() {
        assertTrue(validator.isValidPassword("12345678"));
    }

    @Test
    void invalidPasswordBelowBoundaryTest() {
        assertFalse(validator.isValidPassword("1234567"));
    }

    // AGE TESTS (EP + BVA)

    @Test
    void validMinimumAgeTest() {
        assertTrue(validator.isValidAge(18));
    }

    @Test
    void invalidBelowMinimumAgeTest() {
        assertFalse(validator.isValidAge(17));
    }

    @Test
    void validMaximumAgeTest() {
        assertTrue(validator.isValidAge(60));
    }

    @Test
    void invalidAboveMaximumAgeTest() {
        assertFalse(validator.isValidAge(61));
    }

    // PHONE TESTS

    @Test
    void validPhoneNumberTest() {
        assertTrue(validator.isValidPhoneNumber("5551234567"));
    }

    @Test
    void invalidShortPhoneNumberTest() {
        assertFalse(validator.isValidPhoneNumber("555123"));
    }

    @Test
    void invalidPhoneWithLettersTest() {
        assertFalse(validator.isValidPhoneNumber("55512abc67"));
    }

    // PASSWORD MATCH TESTS

    @Test
    void matchingPasswordsTest() {
        assertTrue(validator.doPasswordsMatch("password123", "password123"));
    }

    @Test
    void nonMatchingPasswordsTest() {
        assertFalse(validator.doPasswordsMatch("password123", "password321"));
    }

    // NULL TESTS

    @Test
    void nullEmailTest() {
        assertFalse(validator.isValidEmail(null));
    }

    @Test
    void nullPasswordTest() {
        assertFalse(validator.isValidPassword(null));
    }
}