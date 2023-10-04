package HWS.HW9;

public class RemoveExtraSymbols {
    public String remove(String initialString, String... symbolsToRemove) {
        for (int i = 0; i < symbolsToRemove.length; i++) {
            initialString = initialString.replace(symbolsToRemove[i], "");
        }
        return initialString;
    }
}
