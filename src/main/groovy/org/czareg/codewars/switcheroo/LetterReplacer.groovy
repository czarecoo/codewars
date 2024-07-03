package org.czareg.codewars.switcheroo

/*
Given a string made up of letters a, b, and/or c, switch the position of letters a and b (change a to b and vice versa). Leave any incidence of c untouched.

Example:

'acb' --> 'bca'
'aabacbaa' --> 'bbabcabb'
 */

class LetterReplacer {

    static def switcheroo(String string) {
        string.replaceAll(/[ab]/) { it[0] == 'a' ? 'b' : 'a' }
    }
}
