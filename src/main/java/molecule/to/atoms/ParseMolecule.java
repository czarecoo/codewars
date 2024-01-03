package molecule.to.atoms;

import lombok.experimental.UtilityClass;

import java.util.*;

/*
For a given chemical formula represented by a string, count the number of atoms of each element contained in the molecule and return an object (associative array in PHP, Dictionary<string, int> in C#, Map<String,Integer> in Java).

For example:

String water = "H2O";
parseMolecule.getAtoms(water); // return [H: 2, O: 1]

String magnesiumHydroxide = "Mg(OH)2";
parseMolecule.getAtoms(magnesiumHydroxide); // return ["Mg": 1, "O": 2, "H": 2]

String fremySalt = "K4[ON(SO3)2]2";
parseMolecule.getAtoms(fremySalt); // return ["K": 4, "O": 14, "N": 2, "S": 4]

parseMolecule.getAtoms("pie"); // throw an IllegalArgumentException
As you can see, some formulas have brackets in them. The index outside the brackets tells you that you have to multiply count of each atom inside the bracket on this index. For example, in Fe(NO3)2 you have one iron atom, two nitrogen atoms and six oxygen atoms.

Note that brackets may be round, square or curly and can also be nested. Index after the braces is optional.
 */
@UtilityClass
class ParseMolecule {

    private static final List<String> SYMBOLS = Arrays.asList(
            "H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne",
            "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca",
            "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn",
            "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr",
            "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn",
            "Sb", "Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd",
            "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb",
            "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg",
            "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th",
            "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm",
            "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds",
            "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og");

    public static Map<String, Integer> getAtoms(String formula) {
        Map<String, Integer> hashMap = new HashMap<>();

        FormulaIterator formulaIterator = new FormulaIterator(formula);
        while (formulaIterator.hasNext()) {
            String token = formulaIterator.next();
            if (isMulecule(token)) {
                Map.Entry<String, Integer> elementWithCount = splitMolecule(token);
                String elementName = elementWithCount.getKey();
                Integer elementCount = elementWithCount.getValue();
                Integer old = hashMap.getOrDefault(elementName, 0);
                hashMap.put(elementName, old + elementCount);
            } else {
                //bracket
                Map.Entry<String, Integer> formulaWithCount = splitFormula(token);
                String innerFormula = formulaWithCount.getKey();
                int multiplier = formulaWithCount.getValue();

                Map<String, Integer> innerHashMap = getAtoms(innerFormula);
                innerHashMap.replaceAll((s, i) -> i *= multiplier);

                for (Map.Entry<String, Integer> innerMapEntry : innerHashMap.entrySet()) {
                    String innerKey = innerMapEntry.getKey();
                    Integer innerValue = innerMapEntry.getValue();
                    Integer old = hashMap.getOrDefault(innerKey, 0);
                    hashMap.put(innerKey, old + innerValue);
                }
            }
        }

        return hashMap;
    }

    private static Map.Entry<String, Integer> splitMolecule(String token) {
        //use SYMBOLS
        //count should be 1 if its not there
        return Map.entry("Mg", 3);
    }

    private static Map.Entry<String, Integer> splitFormula(String token) {
        //return inner formula without brackets, count should be 1 if its not there
        return Map.entry("ON(SO3)2", 2);
    }

    private static boolean isMulecule(String token) {
        //use SYMBOLS
        return false;
    }

    private static class FormulaIterator implements Iterator<String> {

        private final String tempFormula;
        private int currentIndex;

        public FormulaIterator(String formula) {
            tempFormula = formula;
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < tempFormula.length();
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the formula");
            }

            StringBuilder tokenBuilder = new StringBuilder();
            char currentChar = tempFormula.charAt(currentIndex);

            // Handling molecule with count
            if (Character.isUpperCase(currentChar)) {
                tokenBuilder.append(currentChar);
                currentIndex++;

                // Collect the entire molecule, including any lowercase characters
                while (currentIndex < tempFormula.length() &&
                        (Character.isLowerCase(tempFormula.charAt(currentIndex)) || Character.isDigit(tempFormula.charAt(currentIndex)))) {
                    tokenBuilder.append(tempFormula.charAt(currentIndex));
                    currentIndex++;
                }
            }
            // Handling inner formula with count
            else if (isOpeningBracket(currentChar)) {
                int openBracketIndex = currentIndex;
                int closingBracketIndex = findClosingBracket(tempFormula, openBracketIndex);
                tokenBuilder.append(tempFormula, openBracketIndex, closingBracketIndex + 1);
                currentIndex = closingBracketIndex + 1;
                // Collect the entire molecule, including any lowercase characters
                while (currentIndex < tempFormula.length() && Character.isDigit(tempFormula.charAt(currentIndex))) {
                    tokenBuilder.append(tempFormula.charAt(currentIndex));
                    currentIndex++;
                }
            } else {
                throw new IllegalStateException("Invalid character encountered in formula");
            }

            return tokenBuilder.toString();
        }

        private boolean isOpeningBracket(char c) {
            return c == '(' || c == '[' || c == '{';
        }

        private boolean isClosingBracket(char c) {
            return c == ')' || c == ']' || c == '}';
        }

        // Helper method to find the index of the closing bracket for a given opening bracket
        private int findClosingBracket(String formula, int openBracketIndex) {
            int openBracketCount = 1;
            int closingBracketIndex = openBracketIndex + 1;

            while (closingBracketIndex < formula.length() && openBracketCount > 0) {
                char current = formula.charAt(closingBracketIndex);
                if (isOpeningBracket(current)) {
                    openBracketCount++;
                } else if (isClosingBracket(current)) {
                    openBracketCount--;
                }
                closingBracketIndex++;
            }
            if (openBracketCount != 0) {
                throw new IllegalStateException("Invalid inner formula encountered in formula");
            }
            return closingBracketIndex - 1;
        }
    }
}
