package HWS.HW11;

public interface LibraryService {
    void borrowMaterial (String title);
    void returnMaterial(String title);
    void findAvailableMaterialByKeyword(String keyword);
}
