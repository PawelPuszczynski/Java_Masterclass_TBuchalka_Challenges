
package com.company;

public class Main {

    public static void main(String[] args) {
	Utilities utilities = new Utilities();
	utilities.removePairs("AABCDDEEF");
    }
}


package com.company;

import javax.crypto.spec.PSource;

import static org.junit.Assert.*;

public class UtilitiesTest {
private Utilities utilities;



    @org.junit.Before
    public void setup() {
        utilities = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() throws Exception{
        char [] input = {'h','e', 'l', 'l', 'o' };
        char [] output = {'e','l'};
//        Utilities utilities = new Utilities();
        assertArrayEquals(output,utilities.everyNthChar(input, 2));
        assertArrayEquals(new char[]{'h','e', 'l', 'l', 'o' }, utilities.everyNthChar(input, 200));
    }

    @org.junit.Test
    public void removePairs_input1() throws Exception{
        String source = "AABCDDEFF";
//        Utilities utilities = new Utilities();

        assertEquals("ABCDEF", utilities.removePairs(source) );


    }

    @org.junit.Test
    public void removePairs_input2() throws  Exception {
        String source = "ABCCABCEEF";
//        Utilities utilities = new Utilities();

        assertEquals("ABCABCEF", utilities.removePairs("ABCCABCEEF"));
    }

    @org.junit.Test
    public void removePairs_shortString() throws Exception{
        String source = "A";
//        Utilities utilities = new Utilities();

        assertEquals("A", utilities.removePairs("A"));
    }

    @org.junit.Test
    public void removePairs_emptyString() throws Exception {
        String source = "";
//        Utilities utilities = new Utilities();

        assertEquals("", utilities.removePairs(""));
    }
    @org.junit.Test
    public void removePairs_null () throws Exception{
//        Utilities utilities = new Utilities();
       assertNull("Did not get null returned when argument passed was null", utilities.removePairs(null));
       assertEquals("A", utilities.removePairs("A"));
    }

    @org.junit.Test
    public void converter() throws Exception{
//       Utilities utilities = new Utilities();
       assertEquals(300, utilities.converter(10, 5));
    }
    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_byZero () throws Exception{
//        Utilities utilities = new Utilities();
        utilities.converter(10, 0);
        fail("should have thrown ArithmeticException (divide by 0)");

    }

    @org.junit.Test
    public void nullIfOddLength() throws Exception{
//       Utilities utilities = new Utilities();
       String oddString = "babab";
       String evenString = "ba";
       assertEquals(evenString, utilities.nullIfOddLength(evenString));
       assertNotNull(utilities.nullIfOddLength(evenString));
       assertNull("was not null", utilities.nullIfOddLength(oddString));
    }
}


package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class UtilitiesTestParametrized {

   String input;
   String expected;

    public UtilitiesTestParametrized(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {"ABCDEFF","ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"112233445566", "123456"},
                {"ZYZQQB", "ZYZQB"},
                {"A", "A"}
        });
    }
    @org.junit.Test
    public void removePairs () throws Exception {
        Utilities utilities = new Utilities();
        assertEquals(expected, utilities.removePairs(input));


    }
}


package com.company;

public class Utilities {


    //Returns a char array containing every nth char. When
    // sourceArray.length < n , returns sourceArray
    public char [] everyNthChar (char [] sourceArray, int n) {

        if (sourceArray == null || sourceArray.length < n){
            return sourceArray;
        }
        int returnedLength = sourceArray.length / n;
        char [] result = new char [returnedLength];
        int index = 0;

        for (int i = n-1; i<sourceArray.length; i+=n) {
            result [index++] = sourceArray[i];
        }
        return result;

    }
    //Removes pairs of the same character that are next to each other
    // , by removing one occurrence of the character.
    // "ABBCDEEF" -> "ABCDF"
    // " ABCBDEEF" -> " ABCBDEF" (the two B's aren't next to each other, so they
    // aren't removed.

    public String removePairs (String source) {
        // if length is less than 2, there won't be any pairs
        if (source == null || source.length()<2) {
            return source;
        }
        StringBuilder sb = new StringBuilder();
        char [] string = source.toCharArray();

        for (int  i =0; i < string.length-1; i++) {
            System.out.println(string[i]);
            if ( string [i] !=string [i+1]) {
                sb.append(string[i]);
                System.out.println(sb.toString());

            }
        }
        System.out.println(string[string.length-1]);
        sb.append(string[string.length-1]);
        return sb.toString();
    }
    //perform a conversion based on ssome internal business rule.
    public int converter (int a , int b) {
        return (a/b) + (a * 30) -2 ;

    }
    public String nullIfOddLength (String source) {
        if (source.length() % 2 ==0) {
            return source;
        }
        return null;
    }
}

































