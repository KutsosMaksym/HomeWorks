package HWS.HW11;

import org.testng.annotations.Test;

public class LibraryTest {

    @Test
    public void addMaterialsToLibrary() {
        Library library = new Library();
        Book book1 = new Book("The Hound of the Baskervilles", "Sherlock Holmes", "Arthur Conan Doyle", Genre.DETECTIVE);
        library.addMaterialToStorage(book1);
        Magazine magazine1 = new Magazine("The Economist", "Focuses on current affairs", 250000);
        library.addMaterialToStorage(magazine1);
        Audiobook audiobook1 = new Audiobook("The Game of Logic", "The fundamentals of logic", 360);
        library.addMaterialToStorage(audiobook1);
        library.borrowMaterial("The Hound of the Baskervilles");
        library.borrowMaterial("The Game of Logic");
        library.returnMaterial("The Hound of the Baskervilles");
        library.findAvailableMaterialByKeyword("affairs");
        library.displayListOfAllMaterials();
    }
}
