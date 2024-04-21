package Modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PeliculasDAO {
    private String path;

    public PeliculasDAO(String path){
        this.path = path;
    }

    public ArrayList<Peliculas> dameTodos() throws SQLException{
        String sql = "SELECT P.Titulo, P.Id_director, P.Year, P.Url_caratula, P.Id_genero, P.Es_animacion, G.Descripcion AS Genero " +  
                     "FROM Peliculas P " + 
                     "JOIN Generos G ON P.Id_genero = G.Id " + 
                     "ORDER BY Genero, Year DESC, Titulo;";
        Connection conn = new Utilidades().getConnection(path);
        Statement sentenciaSQL = conn.createStatement();
        ResultSet rs = sentenciaSQL.executeQuery(sql);
    
        ArrayList<Peliculas> listaPeliculas = new ArrayList<>();
    
        Peliculas peli = null;
        while (rs.next()) {
            int Id_genero = rs.getInt("Id_genero");
            Generos generos = null;
            for (Generos genero : Generos.values()) {
                if (genero.Get_Id() == Id_genero) {
                    generos = genero;
                    break;
                }
            }
            peli = new Peliculas(rs.getString("Titulo"),
                                  rs.getInt("Id_director"),
                                  rs.getInt("Year"),
                                  rs.getString("Url_caratula"),
                                  generos,
                                  rs.getInt("Es_animacion"));
        
            listaPeliculas.add(peli);
        }  
        conn.close();
        return listaPeliculas;
    }
    

    public Peliculas BuscarPorId(int Buscar_Id) throws SQLException{
        String sql = "SELECT * FROM Peliculas where Id = ?;";
        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement((sql));
        sentenciaSQL.setInt(1, Buscar_Id);
        ResultSet rs = sentenciaSQL.executeQuery();
        
        Peliculas peli = null;
        if(rs.next()){
            int Id_genero = rs.getInt("Id_genero");
            Generos generos = null;
            for (Generos genero : Generos.values()) {
                if (genero.Get_Id() == Id_genero) {
                    generos = genero;
                    break;
                }
            }
            peli = new Peliculas(rs.getString("Titulo"),
                                  rs.getInt("Id_director"),
                                  rs.getInt("Year"),
                                  rs.getString("Url_caratula"),
                                  generos,
                                  rs.getInt("Es_animacion"));
        }conn.close();
        return peli;            
    }

    public Peliculas BuscarPorTitulo(String Buscar_Titulo) throws SQLException{
        String sql = "SELECT * FROM Peliculas where Titulo = ?;";
        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement((sql));
        sentenciaSQL.setString(1, Buscar_Titulo);
        ResultSet rs = sentenciaSQL.executeQuery();
        
        Peliculas peli = null;
        if(rs.next()){
            int Id_genero = rs.getInt("Id_genero");
            Generos generos = null;
            for (Generos genero : Generos.values()) {
                if (genero.Get_Id() == Id_genero) {
                    generos = genero;
                    break;
                }
            }
            peli = new Peliculas(rs.getString("Titulo"),
                                  rs.getInt("Id_director"),
                                  rs.getInt("Year"),
                                  rs.getString("Url_caratula"),
                                  generos,
                                  rs.getInt("Es_animacion"));
        }conn.close();
        return peli;            
    }

    public void Eliminar_Pelicula(int Buscar_Id)throws SQLException{
        String sql = "DELETE FROM Peliculas WHERE Id = ?;";
        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement((sql));
        sentenciaSQL.setInt(1, Buscar_Id);
        sentenciaSQL.executeUpdate(); 
        
        conn.close();    
    }

    public Peliculas Modificar_Pelicula(Peliculas pelicula)throws SQLException{
        String sql = "UPDATE Peliculas SET Titulo =?, Id_director=?, Year =?, Url_caratula =?, Id_genero =?, Es_animacion =?"
            + "Where Id = ?;";
        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement((sql));
        sentenciaSQL.setString(1, pelicula.Get_Titulo());
        sentenciaSQL.setInt(2, pelicula.Get_Id_director());
        sentenciaSQL.setInt(3, pelicula.Get_Year());
        sentenciaSQL.setString(4, pelicula.Get_Url_caratula());
        sentenciaSQL.setInt(5, pelicula.Get_Id_genero().Get_Id());
        sentenciaSQL.setInt(6, pelicula.Get_Es_animacion());
        sentenciaSQL.setInt(6, pelicula.Get_Id());

        sentenciaSQL.executeUpdate();
        conn.close();    
        return pelicula; 
    }

}
