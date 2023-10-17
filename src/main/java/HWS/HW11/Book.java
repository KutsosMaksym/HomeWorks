package HWS.HW11;

import java.util.Objects;

public class Book extends LibraryMaterial {
    String publishingHouse;
    String bookBinding;
    int amountOfStrings;


    public Book(String title, int ageVersion, String publishingHouse, String bookBinding, int amountOfStrings) {
        super(title, ageVersion);
        this.publishingHouse = publishingHouse;
        this.bookBinding = bookBinding;
        this.amountOfStrings = amountOfStrings;
    }

    @Override
    public String toString() {
        return "Book{" +
                "publishingHouse='" + publishingHouse + '\'' +
                ", bookBinding='" + bookBinding + '\'' +
                ", amountOfStrings=" + amountOfStrings +
                ", title='" + title + '\'' +
                ", ageVersion=" + ageVersion +
                '}';
    }
}
