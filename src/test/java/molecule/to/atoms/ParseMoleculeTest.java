package molecule.to.atoms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParseMoleculeTest {

    @ParameterizedTest(name = "Should return {1} for \"{0}\"")
    @MethodSource("generateTestCases")
    void testMolecule(String formula, Map<String, Integer> expected) {
        assertEquals(expected, ParseMolecule.getAtoms(formula));
    }

    @ParameterizedTest(name = "Should throw IllegalArgumentException for \"{0}\"")
    @MethodSource("generateMoreTestCases")
    void testExceptions(String formula) {
        assertThrows(IllegalArgumentException.class, () -> ParseMolecule.getAtoms(formula));
    }

    private static Stream<Arguments> generateTestCases() {
        return Stream.of(
                Arguments.of("H2O", Map.of("H", 2, "O", 1)),
                Arguments.of("Mg(OH)2", Map.of("Mg", 1, "H", 2, "O", 2)),
                Arguments.of("K4[ON(SO3)2]2", Map.of("K", 4, "O", 14, "N", 2, "S", 4)),
                Arguments.of("K(N)", Map.of("K", 1, "N", 1)),
                Arguments.of("C6H12O6", Map.of("C", 6, "H", 12, "O", 6)),
                Arguments.of("{[Co(NH3)4(OH)2]3Co}(SO4)3", Map.of("Co", 4, "N", 12, "H", 42, "O", 18, "S", 3)),
                Arguments.of("Pd[P(C6H5)3]4", Map.of("Pd", 1, "C", 72, "H", 60, "P", 4))
        );
    }

    private static Stream<Arguments> generateMoreTestCases() {
        return Stream.of(
                Arguments.of("pie"),
                Arguments.of("Mg(OH"),
                Arguments.of("MgOH)2"),
                Arguments.of("Mg(OH]2")
        );
    }
}
