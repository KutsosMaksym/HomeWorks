package HWS.HW11;

public final class Book extends Material {
    private String author;
    private Genre genre;

    public Book(String title, String shortDescription, String author, Genre genre) {
        super(title, shortDescription);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book - "  + '\'' + title + '\'' +
                ". " + shortDescription +
                ". Genre - " + genre +
                ". Written by: '" + author + '\'' + ".";
    }
}
