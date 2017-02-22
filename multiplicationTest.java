/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplication;

import java.util.Arrays;
import junit.framework.TestCase;
import static multiplication.multiplication.equal;

/**
 *
 * @author boss
 */
public class multiplicationTest extends TestCase {
    
    public multiplicationTest(String testName) {
        super(testName);
    }

    /**
     * Test of iterative method, of class multiplication.
     */
    public void testIterative() {
        System.out.println("iterative");
        //mxp matrix
        //pxq matrix
        int p = 2;
        int q = 3;
        int m = 3;
        //first array
        int[][] first = {{1,1},{2,1},{1,2}};
       //second array
        int[][] second = {{1,1,1},{1,1,0}};

        multiplication instance = new multiplication();
        
        //iterative method
        int[][] result = instance.iterative(p, q, m, first, second);
        //strassens method
        int[][] result1 = instance.Strassens(first, second);
 
        //check the results are equal
        Arrays.equals(instance.iterative(p, q, m, first, second),instance.Strassens(first, second));
       // assertTrue(multiplication.equal(p, q, result,result1));
       
    }

    
}
