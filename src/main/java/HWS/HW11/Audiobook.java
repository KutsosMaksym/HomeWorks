package HWS.HW11;

public final class Audiobook extends LibraryMaterial {
    private int minutesDuration;

    public Audiobook(String title, String shortDescription, int minutesDuration) {
        super(title, shortDescription);
        this.minutesDuration = minutesDuration;
    }

    @Override
    public String toString() {
        return "Audiobook - " + '\'' + title + '\'' +
                ". " + shortDescription +
                ". Duration: " + minutesDuration + " minutes.";
    }

    public int getMinutesDuration() {
        return minutesDuration;
    }

    public void setMinutesDuration(int minutesDuration) {
        this.minutesDuration = minutesDuration;
    }
}
