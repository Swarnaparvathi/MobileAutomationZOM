package Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Swarnaparvathi
 * Created On 15/05/23
 */

public class OTPExtractor {

    private static String extractOTPFromSMS(String sms) {
        Pattern pattern = Pattern.compile("\\b(\\d{6})\\b");
        Matcher matcher = pattern.matcher(sms);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String returnOtp(String sms) {
        return extractOTPFromSMS(sms);
    }
    public static void main(String[] args) {
        String sms = "792328 is the OTP to login to your Zomato account. DO NOT disclose it to anyone. AlOe4TVDpqm";
        String otp = extractOTPFromSMS(sms);
        System.out.println("OTP: " + otp);

    }
}
