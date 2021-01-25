package com.algo_data.stacksAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogsAndCatsTest {

    String bernie = "Bernie";
    String sammy = "Sammy";
    String cushions = "Cushions";
    String bone = "Bone";
    DogsAndCats dogsAndCats;
    public static final String DOG = "dog";
    public static final String CAT = "cat";

    @BeforeEach
    void setUp() {
        dogsAndCats = new DogsAndCats();
    }

    @Test
    void enqueue() {
        assertTrue(dogsAndCats.noneAtShelter(DOG));
        dogsAndCats.enqueue(bernie, DOG);
        assertFalse(dogsAndCats.noneAtShelter(DOG));
    }

    @Test
    void peek() {
        dogsAndCats.enqueue(bernie, DOG);
        assertEquals(bernie, dogsAndCats.peek(DOG));
    }

    @Test
    void enqueueAndPeekSeveral(){
        dogsAndCats.enqueue(bernie, DOG);
        dogsAndCats.enqueue(sammy, CAT);
        dogsAndCats.enqueue(cushions, CAT);
        dogsAndCats.enqueue(bone, DOG);

        assertEquals(bernie, dogsAndCats.peek(DOG));
        assertEquals(sammy, dogsAndCats.peek(CAT));

        assertNull(dogsAndCats.peek("pigeon"));
    }

    @Test
    void dequeueDog() {
        dogsAndCats.enqueue(bernie, DOG);
        dogsAndCats.enqueue(sammy, CAT);
        dogsAndCats.enqueue(cushions, CAT);
        dogsAndCats.enqueue(bone, DOG);

        assertEquals(bernie, dogsAndCats.dequeueDog());
    }

    @Test
    void dequeueCat() {
        dogsAndCats.enqueue(bernie, DOG);
        dogsAndCats.enqueue(sammy, CAT);
        dogsAndCats.enqueue(cushions, CAT);
        dogsAndCats.enqueue(bone, DOG);

        assertEquals(sammy, dogsAndCats.dequeueCat());

        // cat released when there are equal numbers of dogs and cats
        assertEquals(cushions, dogsAndCats.dequeueCat());
    }

    @Test
    void dequeueAny() {
        dogsAndCats.enqueue(bernie, DOG);
        dogsAndCats.enqueue(sammy, CAT);
        dogsAndCats.enqueue(cushions, CAT);
        dogsAndCats.enqueue(bone, DOG);

        assertEquals(bernie, dogsAndCats.dequeueDog());
        assertEquals(sammy, dogsAndCats.dequeueCat());

        // cat released when there are equal numbers of dogs and cats
        assertEquals(cushions, dogsAndCats.dequeueAny());
    }

    @Test
    void isEmpty() {
        dogsAndCats.enqueue(bernie, DOG);
        dogsAndCats.enqueue(sammy, CAT);
        dogsAndCats.enqueue(cushions, CAT);
        dogsAndCats.enqueue(bone, DOG);

        dogsAndCats.dequeueCat();
        dogsAndCats.dequeueCat();
        assertTrue(dogsAndCats.noneAtShelter(CAT));
        assertFalse(dogsAndCats.noneAtShelter(DOG));
    }
}