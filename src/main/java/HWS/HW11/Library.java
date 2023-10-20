package HWS.HW11;

import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryService {
    private Storage storage = new Storage();

    void addBookToStorage(Book book) {
        storage.createLibraryMaterial(book);
    }

    void addAudiobookToStorage(Audiobook audiobook) {
        storage.createLibraryMaterial(audiobook);
    }

    void addMagazineToStorage(Magazine magazine) {
        storage.createLibraryMaterial(magazine);
    }

    public Book borrowABook(String title) {
        Book book = storage.getBookByTitle(title);
        if (book != null) {
            storage.changeBookStatus(book, storage.books, storage.borrowedBooks);
        }
        return book;
    }

    public Audiobook borrowAnAudioBook(String title) {
        Audiobook audiobook = storage.getAudioBookByTitle(title);
        if (audiobook != null) {
            storage.changeAudioBookStatus(audiobook, storage.audiobooks, storage.borrowedAudiobooks);
        }
        return audiobook;
    }

    public Magazine borrowAMagazine(String title) {
        Magazine magazine = storage.getMagazineByTitle(title);
        if (magazine != null) {
            storage.changeMagazineStatus(magazine, storage.magazines, storage.borrowedMagazines);
        }
        return magazine;
    }

    public void returnABook(String title) {
        Book book = storage.getBookByTitle(title);
        if (book != null) {
            storage.changeBookStatus(book, storage.borrowedBooks, storage.books);
        }
    }

    public void returnAnAudiobook(String title) {
        Audiobook audiobook = storage.getAudioBookByTitle(title);
        if (audiobook != null) {
            storage.changeAudioBookStatus(audiobook, storage.borrowedAudiobooks, storage.audiobooks);
        }
    }

    public void returnMagazine(String title) {
        Magazine magazine = storage.getMagazineByTitle(title);
        if (magazine != null) {
            storage.changeMagazineStatus(magazine, storage.borrowedMagazines, storage.magazines);
        }
    }

    public void findAvailableMaterialByKeyword(String keyword) {
        if (storage.findLibraryMaterialByKeyword(keyword) != null)
            System.out.println(storage.findLibraryMaterialByKeyword(keyword));
    }

    public void displayListOfAvailableBooks() {
        if (storage.books.isEmpty()){
            System.out.println("There no available books");
            return;
        }
        System.out.println("List of available books: ");
        for (LibraryMaterial material : storage.books) {
            System.out.println(material);
        }
    }

    public void displayListOfAvailableAudiobooks() {
        if (storage.audiobooks.isEmpty()){
            System.out.println("There no available audiobooks");
            return;
        }
        System.out.println("List of available audiobooks: ");
        for (LibraryMaterial material : storage.audiobooks) {
            System.out.println(material);
        }
    }

    public void displayListOfAvailableMagazines() {
        if (storage.magazines.isEmpty()){
            System.out.println("There no available magazines");
            return;
        }
        System.out.println("List of available magazines: ");
        for (LibraryMaterial material : storage.magazines) {
            System.out.println(material);
        }
    }
    public void displayListOfBorrowedBooks() {
        if (storage.borrowedBooks.isEmpty()){
            System.out.println("There are no borrowed books");
            return;
        }
        System.out.println("List of borrowed books(Temporarily  not available): ");
        for (LibraryMaterial material : storage.borrowedBooks) {
            System.out.println(material);
        }
    }
    public void displayListOfBorrowedAudiobooks() {
        if (storage.audiobooks.isEmpty()){
            System.out.println("There are no borrowed audiobooks");
            return;
        }
        System.out.println("List of borrowed books(Temporarily  not available): ");
        for (LibraryMaterial material : storage.borrowedAudiobooks) {
            System.out.println(material);
        }
    }
    public void displayListOfBorrowedMagazines() {
        if (storage.borrowedMagazines.isEmpty()){
            System.out.println("There are no borrowed magazines");
            return;
        }
        System.out.println("List of borrowed books(Temporarily  not available): ");
        for (LibraryMaterial material : storage.borrowedMagazines) {
            System.out.println(material);
        }
    }

    private class Storage {
        List<Book> books = new ArrayList<>();
        List<Book> borrowedBooks = new ArrayList<>();
        List<Audiobook> audiobooks = new ArrayList<>();
        List<Audiobook> borrowedAudiobooks = new ArrayList<>();
        List<Magazine> magazines = new ArrayList<>();
        List<Magazine> borrowedMagazines = new ArrayList<>();

        void changeBookStatus(Book book, List<Book> from, List<Book> to) {
            to.add(book);
            from.remove(book);
        }

        void changeAudioBookStatus(Audiobook audioBook, List<Audiobook> from, List<Audiobook> to) {
            to.add(audioBook);
            from.remove(audioBook);
        }

        void changeMagazineStatus(Magazine magazine, List<Magazine> from, List<Magazine> to) {
            to.add(magazine);
            from.remove(magazine);
        }

        void createLibraryMaterial(LibraryMaterial libraryMaterial) {
            if (libraryMaterial instanceof Book) {
                storage.books.add((Book) libraryMaterial);
            } else if (libraryMaterial instanceof Audiobook) {
                storage.audiobooks.add((Audiobook) libraryMaterial);
            } else if (libraryMaterial instanceof Magazine) {
                storage.magazines.add((Magazine) libraryMaterial);
            }
        }

        Book getBookByTitle(String title) {
            for (Book book : storage.books) {
                if (book.title.equals(title)) {
                    return book;
                }
            }
            for (Book book : storage.borrowedBooks) {
                if (book.title.equals(title)) {
                    return book;
                }
            }
            System.out.println("There are no such book with title: " + title);
            return null;
        }

        Audiobook getAudioBookByTitle(String title) {
            for (Audiobook audioBook : storage.audiobooks) {
                if (audioBook.title.equals(title)) {
                    return audioBook;
                }
            }
            for (Audiobook audiobook : storage.borrowedAudiobooks) {
                if (audiobook.title.equals(title)) {
                    return audiobook;
                }
            }
            System.out.println("There are no such Audiobook with title: " + title);
            return null;
        }

        Magazine getMagazineByTitle(String title) {
            for (Magazine magazine : storage.magazines) {
                if (magazine.title.equals(title)) {
                    return magazine;
                }
            }
            for (Magazine magazine : storage.borrowedMagazines) {
                if (magazine.title.equals(title)) {
                    return magazine;
                }
            }
            System.out.println("There are no such magazine with title: " + title);
            return null;
        }

        LibraryMaterial findLibraryMaterialByKeyword(String keyword) {
            for (Book book : books) {
                if (isLibraryMaterialContainsKeyword(keyword, book))
                    return book;
            }
            for (Audiobook audiobook : audiobooks) {
                if (isLibraryMaterialContainsKeyword(keyword, audiobook))
                    return audiobook;
            }
            for (Magazine magazine : magazines) {
                if (isLibraryMaterialContainsKeyword(keyword, magazine))
                    return magazine;
            }
            System.out.println("There are no such material with keyword: " + keyword);
            return null;
        }

        boolean isLibraryMaterialContainsKeyword(String keyword, LibraryMaterial libraryMaterial) {
            return libraryMaterial.getTitle().contains(keyword) || libraryMaterial.getShortDescription().contains(keyword);
        }
    }
}