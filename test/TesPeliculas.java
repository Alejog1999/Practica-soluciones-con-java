package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Modelo.Generos;
import Modelo.Peliculas;


public class TesPeliculas {
    @Test
    public void testIngresarPelicula(){

        Peliculas pelicula = new Peliculas("Rapido y furioso2", 3, 2003, "www.wikipedia.org/Rapido_y_furioso2", Generos.ACCION, 0);
        
        assertEquals("Rapido y furioso2", pelicula.Get_Titulo());
        assertEquals(3, pelicula.Get_Id_director());
        assertEquals(2003, pelicula.Get_Year());
        assertEquals("www.wikipedia.org/Rapido_y_furioso2", pelicula.Get_Url_caratula());
        assertEquals(Generos.ACCION, pelicula.Get_Id_genero());
        assertEquals(0, pelicula.Get_Es_animacion());
    }
}
