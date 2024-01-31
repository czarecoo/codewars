package org.czareg.codewars.bagels;

import org.junit.jupiter.api.Test;

class BagelSolverTest {

    @Test
    void testBagel() {
        Bagel bagel = BagelSolver.getBagel();
        org.junit.Assert.assertEquals(
                bagel.getValue() == 4,
                java.lang.Boolean.TRUE
        );
    }
}