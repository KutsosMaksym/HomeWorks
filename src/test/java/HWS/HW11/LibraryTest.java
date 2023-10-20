package HWS.HW11;

import org.testng.annotations.Test;

public class LibraryTest {
    Library library = new Library();

    @Test(priority = 1)
    public void addMaterialsToLibrary() {
        Book book1 = new Book("The Hound of the Baskervilles", "Sherlock Holmes", "Arthur Conan Doyle", Genre.Detective);
        Book book2 = new Book("The Little Prince", "Sherlock Holmes", "Antoine de Saint-Exupéry", Genre.Novella);
        Book book3 = new Book("Thinking in Java", "Java for beginners", "Bruce Eckel", Genre.Science);
        library.addBookToStorage(book1);
        library.addBookToStorage(book2);
        library.addBookToStorage(book3);
        Magazine magazine1 = new Magazine("The Economist", "Focuses on current affairs", 250000);
        Magazine magazine2 = new Magazine("Man's World", "Men's luxury lifestyle", 200000);
        Magazine magazine3 = new Magazine("Time", "American news magazine", 100000);
        library.addMagazineToStorage(magazine1);
        library.addMagazineToStorage(magazine2);
        library.addMagazineToStorage(magazine3);
        Audiobook audiobook1 = new Audiobook("The Game of Logic", "The fundamentals of logic", 360);
        Audiobook audiobook2 = new Audiobook("The Life of James Clerk Maxwell", "The Man Who Changed Everything", 200);
        library.addAudiobookToStorage(audiobook1);
        library.addAudiobookToStorage(audiobook2);
    }

    @Test(dependsOnMethods = "addMaterialsToLibrary", priority = 2)
    public void borrowALibraryMaterial() {
        library.borrowAMagazine("The Economist");
        library.borrowAMagazine("Time");
        library.borrowAMagazine("Title which doesn't exist");
        library.displayListOfAvailableMagazines();
        library.displayListOfBorrowedMagazines();
    }

    @Test(dependsOnMethods = "addMaterialsToLibrary", priority = 2)
    public void returnALibraryMaterial() {
        library.borrowABook("Thinking in Java");
        library.borrowABook("The Little Prince");
        library.returnABook("Thinking in Java");
        library.displayListOfAvailableBooks();
        library.displayListOfBorrowedBooks();
    }

    @Test (dependsOnMethods = "addMaterialsToLibrary", priority = 3)
    public void findALibraryMaterialByKeyword() {
        library.findAvailableMaterialByKeyword("Man");
        library.borrowAnAudioBook("The Life of James Clerk Maxwell");
        library.findAvailableMaterialByKeyword("Man");
        library.borrowAMagazine("Man's World");
        library.findAvailableMaterialByKeyword("Man");
    }
}
