package org.czareg.codewars.boredom.score;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TheOfficeTest {

    @Test
    void basic1() {
        assertEquals("kill me now", TheOffice.boredom(new Person[]{
                new Person("tim", "change"),
                new Person("jim", "accounts"),
                new Person("randy", "canteen"),
                new Person("sandy", "change"),
                new Person("andy", "change"),
                new Person("katie", "IS"),
                new Person("laura", "change"),
                new Person("saajid", "IS"),
                new Person("alex", "trading"),
                new Person("john", "accounts"),
                new Person("mr", "finance")
        }));
    }

    @Test
    void basic2() {
        assertEquals("i can handle this", TheOffice.boredom(new Person[]{
                new Person("tim", "IS"),
                new Person("jim", "finance"),
                new Person("randy", "pissing about"),
                new Person("sandy", "cleaning"),
                new Person("andy", "cleaning"),
                new Person("katie", "cleaning"),
                new Person("laura", "pissing about"),
                new Person("saajid", "regulation"),
                new Person("alex", "regulation"),
                new Person("john", "accounts"),
                new Person("mr", "canteen")
        }));
    }

    @Test
    void basic3() {
        assertEquals("party time!!", TheOffice.boredom(new Person[]{
                new Person("tim", "accounts"),
                new Person("jim", "accounts"),
                new Person("randy", "pissing about"),
                new Person("sandy", "finance"),
                new Person("andy", "change"),
                new Person("katie", "IS"),
                new Person("laura", "IS"),
                new Person("saajid", "canteen"),
                new Person("alex", "pissing about"),
                new Person("john", "retail"),
                new Person("mr", "pissing about")
        }));
    }
}