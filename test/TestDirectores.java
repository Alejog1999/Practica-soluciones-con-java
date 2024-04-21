package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Modelo.Directores;

public class TestDirectores {
    @Test
    public void testIngresarDirector(){

        Directores director = new Directores("Quentin Tarantino","www.wikipedia.org/Foto/Quentin_Tarantino",  "www.wikipedia.org/Quentin_Tarantino");

        assertEquals("Quentin Tarantino", director.Get_Nombre());
        assertEquals("www.wikipedia.org/Foto/Quentin_Tarantino", director.Get_Url_foto());
        assertEquals("www.wikipedia.org/Quentin_Tarantino", director.Get_Url_web());
    } 
}
