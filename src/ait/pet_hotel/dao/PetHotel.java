package ait.pet_hotel.dao;

import ait.pet_hotel.model.Pet;

public interface PetHotel {
    boolean addPet(Pet pet);

    Pet removePet(int id);

    Pet findPet(int id);

    Pet updatePet(Pet pet);

    Pet[] findByBreed(String breed);

    double calculateTotalPriceProNight();
}
