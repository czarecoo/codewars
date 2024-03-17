package org.czareg.codewars.follow.that.spy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoutesTest {

    @Test
    void spyRoutes() {
        Routes routes = new Routes();
        assertEquals("MNL, TAG, CEB, TAC, BOR",
                routes.findRoutes(new String[][]{{"MNL", "TAG"}, {"CEB", "TAC"}, {"TAG", "CEB"}, {"TAC", "BOR"}}));
        assertEquals("UK, GER, BEL, CAN",
                routes.findRoutes(new String[][]{{"UK", "GER"}, {"GER", "BEL"}, {"BEL", "CAN"}}));
        assertEquals("Halifax, Montreal, Toronto, Chicago, Winnipeg, Seattle",
                routes.findRoutes(new String[][]{{"Chicago", "Winnipeg"}, {"Halifax", "Montreal"}, {"Montreal", "Toronto"}, {"Toronto", "Chicago"}, {"Winnipeg", "Seattle"}}));
        assertEquals("Seoul, Ljubljana, Wroclaw, Nashville, Amsterdam, Hull, Vancouver, Agra, Tokyo, Manila",
                routes.findRoutes(new String[][]{{"Agra", "Tokyo"}, {"Seoul", "Ljubljana"}, {"Ljubljana", "Wroclaw"}, {"Wroclaw", "Nashville"}, {"Nashville", "Amsterdam"}, {"Amsterdam", "Hull"}, {"Hull", "Vancouver"}, {"Vancouver", "Agra"}, {"Tokyo", "Manila"}}));
        assertEquals("Spokane, Toronto, Calgary, Fargo, Winnipeg, Montreal",
                routes.findRoutes(new String[][]{{"Calgary", "Fargo"}, {"Spokane", "Toronto"}, {"Winnipeg", "Montreal"}, {"Toronto", "Calgary"}, {"Fargo", "Winnipeg"}}));
        assertEquals("USA, BRA, KSA, UAE, JPN, PHL",
                routes.findRoutes(new String[][]{{"BRA", "KSA"}, {"USA", "BRA"}, {"JPN", "PHL"}, {"KSA", "UAE"}, {"UAE", "JPN"}}));
        assertEquals("HQ, SH",
                routes.findRoutes(new String[][]{{"HQ", "SH"}}));
        assertEquals("Jipapad, Maslog, Arteche, San Policarpo, Oras, Dolores, Can-avid, Taft, Sulat, San Julian, Borongan, Maydolong, Balangkayan, Llorente, Hernani, General MacArthur, Giporlos, Balangiga, Lawaan, Salcedo, Mercedes, Guiuan",
                routes.findRoutes(new String[][]{{"San Policarpo", "Oras"}, {"Balangiga", "Lawaan"}, {"Borongan", "Maydolong"}, {"Jipapad", "Maslog"}, {"Balangkayan", "Llorente"}, {"Mercedes", "Guiuan"}, {"Taft", "Sulat"}, {"Sulat", "San Julian"}, {"Arteche", "San Policarpo"}, {"Oras", "Dolores"}, {"Dolores", "Can-avid"}, {"Can-avid", "Taft"}, {"San Julian", "Borongan"}, {"Maydolong", "Balangkayan"}, {"Llorente", "Hernani"}, {"Hernani", "General MacArthur"}, {"General MacArthur", "Giporlos"}, {"Giporlos", "Balangiga"}, {"Lawaan", "Salcedo"}, {"Salcedo", "Mercedes"}, {"Maslog", "Arteche"}}));
    }
}