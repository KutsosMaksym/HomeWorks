package HWS.HW11;

public sealed abstract class LibraryMaterial permits Book, Audiobook, Magazine {
    protected String title;
    protected String shortDescription;

    public LibraryMaterial(String title, String shortDescription) {
        this.title = title;
        this.shortDescription = shortDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
