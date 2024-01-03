package molecule.to.atoms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParseMoleculeTest {

    private static Stream<Arguments> generateRandomTestCases() {
        return Stream.of(
                Arguments.of("H2O", Map.of("H", 2, "O", 1)),
                Arguments.of("Mg(OH)2", Map.of("Mg", 1, "H", 2, "O", 2)),
                Arguments.of("K4[ON(SO3)2]2", Map.of("K", 4, "O", 14, "N", 2, "S", 4))
        );
    }


    @ParameterizedTest(name = "Should return {1} for \"{0}\"")
    @MethodSource("generateRandomTestCases")
    void testMolecule(String formula, Map<String, Integer> expected) {
        assertEquals(expected, ParseMolecule.getAtoms(formula));
    }
}
