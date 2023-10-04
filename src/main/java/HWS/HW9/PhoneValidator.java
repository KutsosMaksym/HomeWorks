package HWS.HW9;

public class PhoneValidator {
    static String regex = "\\+[3][8]+[(]+[0]+\\d{2}+[)]+\\d{7}";

    public static boolean isPhoneValid(String phone) {
        return phone.matches(regex);
    }
}
