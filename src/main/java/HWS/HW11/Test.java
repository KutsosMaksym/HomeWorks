package HWS.HW11;

public class Test {
    public static void main(String[] args) {
        Library library = new Library();
        Book book = new Book("Sherlock", 1990, "RoyalBook", "Hard", 300);
        Magazine magazine = new Magazine("APL Football", 2000);
        Audiobook audiobook = new Audiobook("Sherlock Holms", 2018);
        //     library.addLibraryMaterialToStorage(book);
        library.addBookToStorage(book);
        System.out.println(library.storage.getBookByTitle("Sherlock"));
        library.borrowABook("Sherlock");
        System.out.println(library.storage.getBookByTitle("Sherlock"));
        // System.out.println(library.getMagazine());
        //   System.out.println(library.getAudioBook());
    }
}
