package br.com.fiap.twoespwx.libunclepresser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    // Testes de compressao
    public void testcompressao(){
        // Teste 1
        assertEquals("A4C3T2G1", App.comprimir("AAAACCCTTG"));

        // Teste 2
        assertEquals("G2A2C2T2C2", App.comprimir("GGAACCTTCC"));
        
        // Teste 3
        assertEquals("G10", App.comprimir("GGGGGGGGGG"));
        
        // Teste 4
        assertEquals("T1G8C1", App.comprimir("TGGGGGGGGC"));
        
        // Teste 5
        assertEquals("G8C2", App.comprimir("GGGGGGGGCC"));
        
        // Teste 6
        assertEquals("G7C3", App.comprimir("GGGGGGGCCC"));
    }

}
