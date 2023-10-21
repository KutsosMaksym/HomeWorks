package HWS.HW11;

public final class Magazine extends Material {
    private int circulation;

    public Magazine(String title, String shortDescription, int circulation) {
        super(title, shortDescription);
        this.circulation = circulation;
    }

    @Override
    public String toString() {
        return "Magazine - " + '\'' + title + '\'' +
                ". " + shortDescription +
                ". Circulation: " + circulation +
                " pieces.";
    }

    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }
}
