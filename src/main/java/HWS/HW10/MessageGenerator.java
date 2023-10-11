package HWS.HW10;

public class MessageGenerator {

    public static void main(String[] args) {
        String info = MessageGenerator.infoMessage("Запуск додатку", "Версія 1.0");
        System.out.println(info);
        String error = MessageGenerator.errorMessage("Файл не знайдено", 404);
        System.out.println(error);
        String loginToComfy  = MessageGenerator.successLogin("Comfy");
        System.out.println(loginToComfy);
    }

    private static String successLogin(String website) {
        return String.format("User logged in into %s successfully", website);
    }

    private static String errorMessage(String message, int i) {
        return message + " : " + i;
    }

    private static String infoMessage(String... messages) {
        String message = "";
        for (String m : messages) {
            message += m;
        }
        return message;
    }
}
