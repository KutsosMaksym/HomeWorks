package HWS.HW11;

import java.util.ArrayList;

public class Library implements LibraryService {
    private Storage storage = new Storage();

    void addMaterialToStorage(Material material) {
        if (material != null)
            storage.materials.add(material);
    }

    public void borrowMaterial(String title) {
        Material material = storage.getMaterialByTitle(title);
        if (material != null) {
            storage.borrowedMaterials.add(material);
            storage.materials.remove(material);
        }
    }

    public void returnMaterial(String title) {
        Material material = storage.getMaterialByTitle(title);
        if (storage.borrowedMaterials.contains(material)) {
            storage.materials.add(material);
            storage.borrowedMaterials.remove(material);
        }
    }

    public void findAvailableMaterialByKeyword(String keyword) {
        if (storage.findMaterialByKeyword(keyword) != null)
            System.out.println("The result of search by keyword '" + keyword + "': " + storage.findMaterialByKeyword(keyword));
    }

    public void displayListOfAllMaterials() {
        displayListOfAvailableMaterials();
        displayListOfBorrowedMaterials();
    }

    public void displayListOfAvailableMaterials() {
        if (storage.materials.isEmpty()) {
            System.out.println("There no available materials");
            return;
        }
        System.out.println("List of available materials: ");
        for (Material material : storage.materials) {
            System.out.println(material);
        }
    }

    public void displayListOfBorrowedMaterials() {
        if (storage.borrowedMaterials.isEmpty()) {
            System.out.println("There are no borrowed materials");
            return;
        }
        System.out.println("List of borrowed materials(Temporarily not available): ");
        for (Material material : storage.borrowedMaterials) {
            System.out.println(material);
        }
    }

    private class Storage {
        public ArrayList<Material> materials = new ArrayList<>();
        public ArrayList<Material> borrowedMaterials = new ArrayList<>();

        Material getMaterialByTitle(String title) {
            for (Material material : storage.materials) {
                if (material.title.equals(title)) {
                    return material;
                }
            }
            for (Material material : storage.borrowedMaterials) {
                if (material.title.equals(title)) {
                    return material;
                }
            }
            System.out.println("There are no such material with title: " + title);
            return null;
        }

        Material findMaterialByKeyword(String keyword) {
            for (Material material : materials) {
                if (isMaterialContainsKeyword(keyword, material))
                    return material;
            }
            System.out.println("There are no such material with keyword: " + keyword);
            return null;
        }

        boolean isMaterialContainsKeyword(String keyword, Material material) {
            return material.getTitle().contains(keyword) || material.getShortDescription().contains(keyword);
        }
    }
}