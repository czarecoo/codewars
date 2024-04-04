package org.czareg.codewars.ordering.beers.in.poland;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TranslatorTest {

    @Test
    void shouldReturnExceptionNegativeNumber() {
        assertThrows(RuntimeException.class, () -> Translator.orderingBeers(-1));
    }

    @Test
    void shouldReturnWodaWhenOrdering0Beer() {
        assertEquals("Woda mineralna poprosze", Translator.orderingBeers(0));
    }

    @Test
    void shouldReturnJednoPiwoWhenOrdering1Beer() {
        assertEquals("Jedno piwo poprosze", Translator.orderingBeers(1));
    }

    @Test
    void shouldReturnDwaPiwaWhenOrdering2Beers() {
        assertEquals("Dwa piwa poprosze", Translator.orderingBeers(2));
    }

    @Test
    void shouldReturnTrzyPiwaWhenOrdering3Beers() {
        assertEquals("Trzy piwa poprosze", Translator.orderingBeers(3));
    }

    @Test
    void shouldReturnCzteryPiwaWhenOrdering4Beers() {
        assertEquals("Cztery piwa poprosze", Translator.orderingBeers(4));
    }

    @Test
    void shouldReturnPiecPiwWhenOrdering5Beers() {
        assertEquals("Piec piw poprosze", Translator.orderingBeers(5));
    }

    @Test
    void shouldReturnOsiemPiwWhenOrdering8Beers() {
        assertEquals("Osiem piw poprosze", Translator.orderingBeers(8));
    }

    @Test
    void shouldReturnDziesiecPiwWhenOrdering10Beers() {
        assertEquals("Dziesiec piw poprosze", Translator.orderingBeers(10));
    }

    @Test
    void shouldReturnJedenasciePiwWhenOrdering11Beers() {
        assertEquals("Jedenascie piw poprosze", Translator.orderingBeers(11));
    }

    @Test
    void shouldReturnDwanasciePiwWhenOrdering12Beers() {
        assertEquals("Dwanascie piw poprosze", Translator.orderingBeers(12));
    }

    @Test
    void shouldReturnTrzynasciePiwWhenOrdering13Beers() {
        assertEquals("Trzynascie piw poprosze", Translator.orderingBeers(13));
    }

    @Test
    void shouldReturnCzternasciePiwWhenOrdering14Beers() {
        assertEquals("Czternascie piw poprosze", Translator.orderingBeers(14));
    }

    @Test
    void shouldReturnPietnasciePiwWhenOrdering15Beers() {
        assertEquals("Pietnascie piw poprosze", Translator.orderingBeers(15));
    }

    @Test
    void shouldReturnSzesnasciePiwWhenOrdering16Beers() {
        assertEquals("Szesnascie piw poprosze", Translator.orderingBeers(16));
    }

    @Test
    void shouldReturndwadziesciaPiwWhenOrdering20Beers() {
        assertEquals("Dwadziescia piw poprosze", Translator.orderingBeers(20));
    }

    @Test
    void shouldReturndwadziesciaJedenPiwWhenOrdering21Beers() {
        assertEquals("Dwadziescia jeden piw poprosze", Translator.orderingBeers(21));
    }

    @Test
    void shouldReturndwadziesciaDwaPiwaWhenOrdering22Beers() {
        assertEquals("Dwadziescia dwa piwa poprosze", Translator.orderingBeers(22));
    }

    @Test
    void shouldReturndwadziesciaOsiemPiwWhenOrdering28Beers() {
        assertEquals("Dwadziescia osiem piw poprosze", Translator.orderingBeers(28));
    }

    @Test
    void shouldReturnTrzydziesciTrzyPiwaWhenOrdering33Beers() {
        assertEquals("Trzydziesci trzy piwa poprosze", Translator.orderingBeers(33));
    }

    @Test
    void shouldReturnCzterdziesciCzteryPiwaWhenOrdering44Beers() {
        assertEquals("Czterdziesci cztery piwa poprosze", Translator.orderingBeers(44));
    }

    @Test
    void shouldReturnPiecdziesiatPiecPiwaWhenOrdering55Beers() {
        assertEquals("Piecdziesiat piec piw poprosze", Translator.orderingBeers(55));
    }

    @Test
    void shouldReturnDziewiecdziesiatOsiemPiwWhenOrdering98Beers() {
        assertEquals("Dziewiecdziesiat osiem piw poprosze", Translator.orderingBeers(98));
    }

    @Test
    void shouldReturnDziewiecdziesiatDziewiecPiwWhenOrdering99Beers() {
        assertEquals("Dziewiecdziesiat dziewiec piw poprosze", Translator.orderingBeers(99));
    }

    @Test
    void shouldshouldThrowRuntimeExceptionWhenMoreThanOneHundredBeers() {
        assertThrows(RuntimeException.class, () -> Translator.orderingBeers(100));
    }
}