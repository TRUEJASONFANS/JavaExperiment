package org.zhxie.java.string.operation;

import static org.junit.Assert.*;

/**
 * Created by zhxie on 6/4/2018.
 */
public class FilterStarInStringTest {

    @org.junit.Test
    public void testFilterStar() throws Exception {
        assertEquals("**", FilterStarInString.filterStar("***"));
        assertEquals("*qq*", FilterStarInString.filterStar("*q*q*"));
        assertEquals("**", FilterStarInString.filterStar("***"));
        assertEquals("**", FilterStarInString.filterStar("****"));
    }

    @org.junit.Test
    public void testFilterStar2() throws Exception {
        assertEquals("**", FilterStarInString.filterStar2("***"));
        assertEquals("*qq*", FilterStarInString.filterStar2("*q*q*"));
        assertEquals("**", FilterStarInString.filterStar2("***"));
        assertEquals("**", FilterStarInString.filterStar2("****"));
    }

}