package org.czareg.codewars.hungarian.vowel.harmony

import org.junit.jupiter.api.Test

class SuffixAdderTest {

    @Test
    void "Fixed Tests"() {
        assert SuffixAdder.dative("ablak") == "ablaknak"
        assert SuffixAdder.dative("tükör") == "tükörnek"
        assert SuffixAdder.dative("keret") == "keretnek"
        assert SuffixAdder.dative("otthon") == "otthonnak"
        assert SuffixAdder.dative("virág") == "virágnak"
        assert SuffixAdder.dative("tett") == "tettnek"
        assert SuffixAdder.dative("rokkant") == "rokkantnak"
        assert SuffixAdder.dative("rossz") == "rossznak"
        assert SuffixAdder.dative("gonosz") == "gonosznak"
        assert SuffixAdder.dative("rög") == "rögnek"
        assert SuffixAdder.dative("király") == "királynak"
    }

    @Test
    void "Random Tests"() {
        def allWords = (randomWords + front + back) as List<String>
        allWords.each { word ->
            Collections.shuffle(allWords)
            SuffixAdder.dative(word) == solution(word)
        }
    }

    private def randomWords = "kalap,ház,tűz,víz,méz,kéz,ember,rák,máz,üveg,pohár,húr,gödör,csűr,lakás,rokon".split(",")
    private def front = "terv,kérvény,vény,kép,hit,tök,őr,füst,űr".split(",")
    private def back = "rag,tár,kár,zár,gondnok,mór,mókus,úr".split(",")

    static def solution(String word) {
        for (def i = word.size() - 1; i >= 0; i--) {
            def c = word[i]
            if ("eéiíöőüű".contains(c)) {
                return "${word}nek"
            } else if ("aáoóuú".contains(c)) {
                return "${word}nak"
            }
        }
    }
}