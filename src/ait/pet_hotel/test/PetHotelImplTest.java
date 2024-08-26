package ait.pet_hotel.test;

import ait.pet_hotel.dao.PetHotel;
import ait.pet_hotel.dao.PetHotelImpl;
import ait.pet_hotel.model.Cat;
import ait.pet_hotel.model.Dog;
import ait.pet_hotel.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class PetHotelImplTest {
    PetHotel petHotel;
    Pet[] pets;

    @BeforeEach
    void setUp() {
        petHotel = new PetHotelImpl(6);
        pets = new Pet[5];
        pets[0] = new Dog(24687, "dog", 5, "Bobik", "spitz", 50.5, 7);
        pets[1] = new Dog(85512, "dog", 3, "Sharik", "husky", 102, 20.5);
        pets[2] = new Cat(15230, "cat", 2, "Murzik", "spitz", 20, 3);
        pets[3] = new Cat(14670, "cat", 1, "Barsik", "persian", 21, 3.5);
        pets[4] = new Cat(52153, "cat", 4, "Mashka", "british shorthair", 18, 2.9);

        for (int i = 0; i < pets.length; i++) {
            petHotel.addPet(pets[i]);
        }

    }

    @Test
    void testAddPet() {
        assertFalse(petHotel.addPet(pets[1]));
        assertFalse(petHotel.addPet(null));
        Pet pet = new Dog(1234, "dog", 2, "Hoppes", "Mops", 0.5, 6);
        assertTrue(petHotel.addPet(pet));
        pet = new Cat(254568, "cat", 2, "Kitty", "No Breed", 0.3, 2);
        assertFalse(petHotel.addPet(pet));
    }

    @Test
    void testRemovePet() {
        Pet pet = petHotel.removePet(14670);
        assertEquals(pets[3], pet);
        assertNull(petHotel.removePet(0000));
    }

    @Test
    void testFindPet() {
        assertEquals(pets[3], petHotel.findPet(14670));
        assertNull(petHotel.findPet(00000));
    }

    @Test
    void testUpdatePet() {
        Pet myPet = new Dog(85512, "dog", 5, "Sharik", "husky", 102, 20.5);
        assertEquals(petHotel.updatePet(myPet), pets[1]);
        assertEquals(5, petHotel.updatePet(myPet).getAge());
        myPet = new Dog(00000, "dog", 5, "Sharik", "husky", 102, 20.5);
        assertNull(petHotel.updatePet(myPet));
    }

    @Test
    void testFindByBreed() {
        Pet[] expected = {pets[0], pets[2]};
        Pet[] actual = petHotel.findByBreed("spitz");
        assertArrayEquals(expected, actual);
        assertNull(petHotel.findByBreed("mops"));
    }


    @Test
    void TestCalculateTotalPrice() {
        assertEquals(119.949,0.001, petHotel.calculateTotalPriceProNight());
    }
}