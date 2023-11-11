package com.capstone.capstone.enums;

public enum Breed {
    CHIHUAHUA("Chihuahua", "Small"),
    LABRADOR("Labrador", "Large"),
    BULLDOG("Bulldog", "Medium"),
    GOLDENRETRIEVER("Golden Retriever", "Large"),
    POMERANIAN("Pomeranian", "Small"),
    GERMANSHEPHERD("German Shepherd", "Large"),
    DACHSHUND("Dachshund", "Small"),
    BEAGLE("Beagle", "Small"),
    POODLE("Poodle", "Medium"),
    ROTTWEILER("Rottweiler", "Large"),
    SHIHTZU("Shih Tzu", "Small"),
    BOXER("Boxer", "Large"),
    YORKSHIRETERRIER("Yorkshire Terrier", "Small"),
    GREATDANE("Great Dane", "Giant"),
    PUG("Pug", "Small"),
    BOSTONTERRIER("Boston Terrier", "Small"),
    AUSTRALIANSHEPHERD("Australian Shepherd", "Medium"),
    SIBERIANHUSKY("Siberian Husky", "Large"),
    SHIBAINU("Shiba Inu", "Medium"),
    PAPILLON("Papillon", "Small"),
    MALTESE("Maltese", "Small"),
    DOBERMAN("Doberman", "Large");

    private String breed;
    private String size;

    Breed(String breed, String size) {
        this.breed = breed;
        this.size = size;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
