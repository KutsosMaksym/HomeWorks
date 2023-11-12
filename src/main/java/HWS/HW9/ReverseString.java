package HWS.HW9;

public class ReverseString {

    public String reverse(StringBuilder initialString) {
        try {
            if (initialString.length() == 0)
                return "";
        } catch (NullPointerException e) {
            return "";
        }
        return (initialString.charAt(initialString.length() - 1)) + reverse(initialString.deleteCharAt(initialString.length() - 1));
    }


}
