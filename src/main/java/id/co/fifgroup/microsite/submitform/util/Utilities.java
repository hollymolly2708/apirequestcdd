package id.co.fifgroup.microsite.submitform.util;

import java.security.SecureRandom;

public class Utilities {
    private static final SecureRandom random = new SecureRandom();
    private static final int OTP_LENGTH = 6;

    private Utilities() {
        // Private constructor to prevent instantiation
    }
    public static String generateOtp() {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
}
