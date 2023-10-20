package HWS.HW11;

public interface LibraryService {

    Book borrowABook(String title);
    Audiobook borrowAnAudioBook(String title);
    Magazine borrowAMagazine(String title);
    void returnABook(String title);
    void returnAnAudiobook(String title);
    void returnMagazine(String title);
    void findAvailableMaterialByKeyword(String keyword);
}
