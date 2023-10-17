package HWS.HW11;

import java.util.ArrayList;
import java.util.List;

public class Library {
    Storage storage = new Storage();

    void addBookToStorage(Book book) {
        storage.createLibraryMaterial(book);
    }

    void addAudiobookToStorage(Audiobook audiobook) {
        storage.createLibraryMaterial(audiobook);
    }

    void addMagazineToStorage(Magazine magazine) {
        storage.createLibraryMaterial(magazine);
    }

    Book borrowABook(String title) {
        Book book = storage.getBookByTitle(title);
        List <Book> books = new ArrayList<>();

        storage.changeMaterialStatus(book, storage.books, storage.borrowedBooks);
        return book;
    }

    Audiobook borrowAnAudioBook(String title) { //TODO
        storage.borrowedAudiobooks.add(storage.getAudioBookByTitle(title));
        return storage.getAudioBookByTitle(title);
    }

    Magazine borrowAMagazine(String title) { //TODO
        storage.borrowedMagazines.add(storage.getMagazineByTitle(title));
        return storage.getMagazineByTitle(title);
    }

    Book returnABook(String title) {
        Book book = storage.getBookByTitle(title);

        storage.borrowedBooks.add(book);
        storage.removeBookFromStockByTitle(title);
        return book;
    }


    class Storage {
        List<Book> books = new ArrayList<>();
        List<Book> borrowedBooks = new ArrayList<>();
        List<Audiobook> audiobooks = new ArrayList<>();
        List<Audiobook> borrowedAudiobooks = new ArrayList<>();
        List<Magazine> magazines = new ArrayList<>();
        List<Magazine> borrowedMagazines = new ArrayList<>();

        void changeMaterialStatus(LibraryMaterial libraryMaterial, List<LibraryMaterial> from, List<LibraryMaterial> to){
            if (libraryMaterial instanceof Book) {
                to.add((Book) libraryMaterial);
                from.remove(libraryMaterial);
            } else if (libraryMaterial instanceof Audiobook) {
                //TODO
            } else if (libraryMaterial instanceof Magazine) {
                //TODO
            }
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
            return null;
        }

        Audiobook getAudioBookByTitle(String title) {
            for (Audiobook audiobook : storage.audiobooks) {
                if (audiobook.title.equals(title)) {
                    return audiobook;
                }
            }
            return null;
        }

        Magazine getMagazineByTitle(String title) {
            for (Magazine magazine : storage.magazines) {
                if (magazine.title.equals(title)) {
                    return magazine;
                }
            }
            return null;
        }


        void removeBookFromStockByTitle(String title) {
            for (Book book : storage.books) {
                if (book.title.equals(title)) {
                    storage.books.remove(book);
                    break;
                }
            }
        }

        void removeAudioBookFromStockByTitle(String title) { //TODO

        }

            void removeMagazineFromStockByTitle(String title) { //TODO
    }
//        void returnBookToStockByTitle(String title) {
//                  for (Book book : storage.books) {
//                if (book.title.equals(title)) {
//                    storage.books.remove(book);
//                    break;
//                }
//            }
        //     }

    }
}