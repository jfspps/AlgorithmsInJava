package com.algo_data.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllUniqueCharsTest {

    AllUniqueChars areUnique;
    AllUniqueChars areNotUnique;

    @BeforeEach
    void setUp() {
        areUnique = new AllUniqueChars("abcdefg");
        areNotUnique = new AllUniqueChars("aaabbbccc");
    }

    @Test
    void areAllUniqueChars() {
        assertTrue(areUnique.areAllUniqueChars_withADT());
        assertFalse(areNotUnique.areAllUniqueChars_withADT());
    }

    @Test
    void areAllUniqueChars_withoutADT() {
        assertTrue(areUnique.areAllUniqueChars_withoutADT());
        assertFalse(areNotUnique.areAllUniqueChars_withoutADT());
    }
}