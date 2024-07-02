package org.czareg.codewars.invite.more.woman


import org.junit.jupiter.api.Test

class InviterTest {

    def random = new Random()

    @Test
    void "Fixed Tests"() {
        assert Inviter.inviteMoreWomen([1, -1, 1]) == true
        assert Inviter.inviteMoreWomen([-1, -1, -1]) == false
        assert Inviter.inviteMoreWomen([1, -1]) == false
        assert Inviter.inviteMoreWomen([1, 1, 1]) == true
    }

    @Test
    void "Random Tests"() {
        def ri
        (1..100).each {
            ri = (0..random.nextInt(35)).collect { _ -> random.nextInt(100) % 2 == 0 ? 1 : -1 }
            def exp = solution(ri)
            assert Inviter.inviteMoreWomen(ri) == exp
        }
    }

    private static def solution(arr) {
        arr.inject(0, { x, y -> x + y }) > 0
    }
}