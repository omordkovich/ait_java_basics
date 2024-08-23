package ait.pet_hotel.dao;

import ait.pet_hotel.model.Cat;
import ait.pet_hotel.model.Dog;
import ait.pet_hotel.model.Pet;

import java.util.Arrays;

public class PetHotelImpl implements PetHotel {
    private Pet[] pets;
    int size;

    public PetHotelImpl(int capacity) {
        this.pets = new Pet[capacity];
    }

    @Override
    public boolean addPet(Pet pet) {
        if (pet == null || pets.length == size || findPet(pet.getId()) != null) {
            return false;
        }
        pets[size++] = pet;
        return true;
    }

    @Override
    public Pet removePet(int id) {
        for (int i = 0; i < size; i++) {
            if (pets[i].getId() == id) {
                Pet victim = pets[i];
                System.arraycopy(pets, i + 1, pets, i, size - i - 1);
                pets[--size] = null;
                return victim;
            }
        }
        return null;
    }


    @Override
    public Pet findPet(int id) {
        for (int i = 0; i < size; i++) {
            if (pets[i].getId() == id) {
                return pets[i];
            }
        }
        return null;
    }


    @Override
    public Pet updatePet(Pet pet) {
        for (int i = 0; i < size; i++) {
            if (pets[i].getId() == pet.getId()) {
                pets[i] = pet;
                return pet;
            }
        }
        return null;
    }

    @Override
    public Pet[] findByBreed(String breed) {
        Pet[] myPets = new Pet[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (pets[i] instanceof Cat cat) {
                if (cat.getBreed().equals(breed)) {
                    myPets[count++] = pets[i];
                }
            }
            if (pets[i] instanceof Dog dog) {
                if (dog.getBreed().equals(breed)) {
                    myPets[count++] = pets[i];
                }
            }
        }
        if (count>0) {
            return Arrays.copyOf(myPets, count);
        }else {
            return null;
        }
    }


    @Override
    public double calculateTotalPriceProNight() {
        double res = 0;
        double price = 0;
        for (int i = 0; i < size; i++) {
            if (pets[i] instanceof Cat) {
                price = pets[i].getCATPRICE();
            } else {
                price = pets[i].getDOGPIRCE();
            }
            res += price;
        }
        return res;
    }

}
