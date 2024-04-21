package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;

import Modelo.Directores;
import Modelo.DirectoresDAO;
import Modelo.Generos;
import Modelo.Peliculas;
import Modelo.PeliculasDAO;
import Modelo.Utilidades;



public class TestDAO {
    @Test
    public void testJDBCConecta() {

        boolean laClaseJDBCExiste = false;
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Todo ha ido bien");
            laClaseJDBCExiste = true;
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC no encontrado");
            e.printStackTrace();
        }
        
        assertTrue(laClaseJDBCExiste);
    }

    @Test
    public void testCrearConexion() {
        Utilidades utils = new Utilidades();

        Connection conn = utils.getConnection("./data/Base_datos_test.sqlite");
        assertNotNull(conn);

        conn = utils.getConnection("./lolailoylere/Base_datos_test.sqlite");
        assertNull(conn);
    }

    @Test
    public void testDameTodosDirectoresDAO() throws SQLException{
        DirectoresDAO dao = new DirectoresDAO("./data/Base_datos_test.sqlite");
        ArrayList<Directores> listaDirectores = dao.dameTodos();

        assertEquals(4, listaDirectores.size());
    }

    @Test
    public void testBuscaPorIdDirectoresDAO() throws SQLException{
        DirectoresDAO dao = new DirectoresDAO("./data/Base_datos_test.sqlite");
        Directores Director = dao.BuscarPorId(3);

        assertEquals("Charles Chaplin", Director.Get_Nombre());
    }

    @Test
    public void testBuscaPorNombreDirectoresDAO() throws SQLException{
        DirectoresDAO dao = new DirectoresDAO("./data/Base_datos_test.sqlite");
        Directores Director = dao.BuscarPorNombre("Jaume Collet-Serra");

        assertEquals("Jaume Collet-Serra", Director.Get_Nombre());
    }

    @Test
    public void testEliminarDirectoresDAO() throws SQLException{
        DirectoresDAO dao = new DirectoresDAO("./data/Base_datos_test.sqlite");
        dao.Eliminar_director(5);
        Directores director = dao.BuscarPorId(5);
        assertNull(director);
    }

    @Test
    public void testModificarDirectoresDAO() throws SQLException{
        DirectoresDAO dao = new DirectoresDAO("./data/Base_datos_test.sqlite");
        Directores director = dao.BuscarPorId(3);
        director.Set_Nombre("Pepe Perez");
        director.Set_Url_foto("aaaa");
        director.Set_Url_web("bbbbb");
        
        Directores dire = dao.Modificar_Director(director);
        assertEquals("Pepe Perez", dire.Get_Nombre());
    }

    @Test
    public void testDameTodasPeliculasDAO() throws SQLException{
        PeliculasDAO dao = new PeliculasDAO("./data/Base_datos_test.sqlite");
        ArrayList<Peliculas> listaPeliculas = dao.dameTodos();

        assertEquals(5, listaPeliculas.size());
    }

    @Test
    public void testBuscaPorIdPeliculasDAO() throws SQLException{
        PeliculasDAO dao = new PeliculasDAO("./data/Base_datos_test.sqlite");
        Peliculas pelicula = dao.BuscarPorId(4);

        assertEquals("Black adam", pelicula.Get_Titulo());
    }

    @Test
    public void testBuscaPorTituloPeliculasDAO() throws SQLException{
        PeliculasDAO dao = new PeliculasDAO("./data/Base_datos_test.sqlite");
        Peliculas pelicula = dao.BuscarPorTitulo("SONIC");

        assertEquals("SONIC", pelicula.Get_Titulo());
    }

    @Test
    public void testEliminarPeliculasDAO() throws SQLException{
        PeliculasDAO dao = new PeliculasDAO("./data/Base_datos_test.sqlite");
        dao.Eliminar_Pelicula(5);
        Peliculas pelicula = dao.BuscarPorId(5);
        assertNull(pelicula);
    }

    @Test
    public void testModificarPeliculasDAO() throws SQLException{
        PeliculasDAO dao = new PeliculasDAO("./data/Base_datos_test.sqlite");
        Peliculas pelicula = dao.BuscarPorId(3);
        pelicula.Set_Titulo("aaaa");
        pelicula.Set_Id_director(4);
        pelicula.Set_Year(1212);
        pelicula.Set_Url_caratula("mmmm");
        pelicula.Set_Id_genero(Generos.INFANTIL);
        pelicula.Set_Es_animacion(1);
        
        Peliculas peli = dao.Modificar_Pelicula(pelicula);
        assertEquals("aaaa", peli.Get_Titulo());
    }
}