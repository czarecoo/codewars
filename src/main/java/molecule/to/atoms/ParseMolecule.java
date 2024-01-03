package molecule.to.atoms;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/*
For a given chemical formula represented by a string, count the number of atoms of each element contained in the molecule and return an object (associative array in PHP, Dictionary<string, int> in C#, Map<String,Integer> in Java).

For example:
parseMolecule.getAtoms("H2O"); // return [H: 2, O: 1]
parseMolecule.getAtoms("Mg(OH)2"); // return ["Mg": 1, "O": 2, "H": 2]
parseMolecule.getAtoms("K4[ON(SO3)2]2"); // return ["K": 4, "O": 14, "N": 2, "S": 4]
parseMolecule.getAtoms("pie"); // throw an IllegalArgumentException
As you can see, some formulas have brackets in them. The index outside the brackets tells you that you have to multiply count of each atom inside the bracket on this index. For example, in Fe(NO3)2 you have one iron atom, two nitrogen atoms and six oxygen atoms.

Note that brackets may be round, square or curly and can also be nested. Index after the braces is optional.
 */
@UtilityClass
class ParseMolecule {

    private static final char OPENING_ROUND_BRACKET = '(';
    private static final char OPENING_SQUARE_BRACKET = '[';
    private static final char OPENING_CURLY_BRACKET = '{';
    private static final char CLOSING_ROUND_BRACKET = ')';
    private static final char CLOSING_SQUARE_BRACKET = ']';
    private static final char CLOSING_CURLY_BRACKET = '}';

    public static Map<String, Integer> getAtoms(String formula) {
        Map<String, Integer> hashMap = new HashMap<>();
        FormulaIterator formulaIterator = new FormulaIterator(formula);
        while (formulaIterator.hasNext()) {
            String token = formulaIterator.next();
            if (containsInnerFormula(token)) {
                Map.Entry<String, Integer> formulaWithCount = stripAndSplitFormulaFromItsCount(token);
                String innerFormula = formulaWithCount.getKey();
                int multiplier = formulaWithCount.getValue();
                Map<String, Integer> innerHashMap = getAtoms(innerFormula);
                for (Map.Entry<String, Integer> innerMapEntry : innerHashMap.entrySet()) {
                    String innerKey = innerMapEntry.getKey();
                    Integer innerValue = innerMapEntry.getValue();
                    Integer old = hashMap.getOrDefault(innerKey, 0);
                    hashMap.put(innerKey, old + innerValue * multiplier);
                }
            } else {
                Map.Entry<String, Integer> elementWithCount = splitElementAndItsCount(token);
                String elementName = elementWithCount.getKey();
                Integer elementCount = elementWithCount.getValue();
                Integer old = hashMap.getOrDefault(elementName, 0);
                hashMap.put(elementName, old + elementCount);
            }
        }
        return hashMap;
    }

    private static Map.Entry<String, Integer> splitElementAndItsCount(String token) {
        int indexForSplit = -1;
        for (int i = 0; i < token.length(); i++) {
            char c = token.charAt(i);
            if (Character.isDigit(c)) {
                indexForSplit = i;
                break;
            }
        }
        if (indexForSplit == -1) {
            return Map.entry(token, 1);
        }
        String name = token.substring(0, indexForSplit);
        String count = token.substring(indexForSplit);
        int elementCount = Integer.parseInt(count);
        return Map.entry(name, elementCount);
    }

    private static Map.Entry<String, Integer> stripAndSplitFormulaFromItsCount(String token) {
        Map.Entry<Character, Integer> mostOuterBracket = Stream.of(
                        Map.entry(OPENING_ROUND_BRACKET, token.indexOf(OPENING_ROUND_BRACKET)),
                        Map.entry(OPENING_SQUARE_BRACKET, token.indexOf(OPENING_SQUARE_BRACKET)),
                        Map.entry(OPENING_CURLY_BRACKET, token.indexOf(OPENING_CURLY_BRACKET))
                )
                .filter(entry -> entry.getValue() != -1)
                .min(Map.Entry.comparingByValue(Integer::compare))
                .orElseThrow(() -> new IllegalArgumentException("Failed to find opening bracket in inner formula"));
        int indexOfClosingBracket = token.lastIndexOf(getClosingBracket(mostOuterBracket.getKey()));
        if (indexOfClosingBracket == -1) {
            throw new IllegalArgumentException("Could not find closing bracket for inner formula");
        }
        String innerFormula = token.substring(1, indexOfClosingBracket);
        String countString = token.substring(indexOfClosingBracket + 1);
        int count = 1;
        if (!countString.isEmpty()) {
            count = Integer.parseInt(countString);
        }
        return Map.entry(innerFormula, count);
    }

    private static char getClosingBracket(char openingBracket) {
        return switch (openingBracket) {
            case OPENING_ROUND_BRACKET -> CLOSING_ROUND_BRACKET;
            case OPENING_SQUARE_BRACKET -> CLOSING_SQUARE_BRACKET;
            case OPENING_CURLY_BRACKET -> CLOSING_CURLY_BRACKET;
            default -> throw new IllegalArgumentException("Wrong bracket");
        };
    }

    private static boolean containsInnerFormula(String token) {
        return token.contains(String.valueOf(OPENING_ROUND_BRACKET))
                || token.contains(String.valueOf(OPENING_SQUARE_BRACKET))
                || token.contains(String.valueOf(OPENING_CURLY_BRACKET));
    }

    private static class FormulaIterator implements Iterator<String> {

        private final String formula;
        private int currentIndex;

        public FormulaIterator(String formula) {
            this.formula = formula;
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < formula.length();
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the formula");
            }
            StringBuilder tokenBuilder = new StringBuilder();
            char currentChar = formula.charAt(currentIndex);
            if (Character.isUpperCase(currentChar)) {
                tokenBuilder.append(currentChar);
                currentIndex++;
                while (currentIndex < formula.length() &&
                        (Character.isLowerCase(formula.charAt(currentIndex)) || Character.isDigit(formula.charAt(currentIndex)))) {
                    tokenBuilder.append(formula.charAt(currentIndex));
                    currentIndex++;
                }
            } else if (isOpeningBracket(currentChar)) {
                int openBracketIndex = currentIndex;
                int closingBracketIndex = findClosingBracket(formula, openBracketIndex);
                tokenBuilder.append(formula, openBracketIndex, closingBracketIndex + 1);
                currentIndex = closingBracketIndex + 1;
                while (currentIndex < formula.length() && Character.isDigit(formula.charAt(currentIndex))) {
                    tokenBuilder.append(formula.charAt(currentIndex));
                    currentIndex++;
                }
            } else {
                throw new IllegalArgumentException("Invalid character encountered in formula");
            }

            return tokenBuilder.toString();
        }

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
                throw new IllegalArgumentException("Invalid inner formula encountered in formula");
            }
            return closingBracketIndex - 1;
        }

        private boolean isOpeningBracket(char c) {
            return c == OPENING_ROUND_BRACKET || c == OPENING_SQUARE_BRACKET || c == OPENING_CURLY_BRACKET;
        }

        private boolean isClosingBracket(char c) {
            return c == CLOSING_ROUND_BRACKET || c == CLOSING_SQUARE_BRACKET || c == CLOSING_CURLY_BRACKET;
        }
    }
}
