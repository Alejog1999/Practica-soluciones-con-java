package Modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DirectoresDAO {
    private String path;

    public DirectoresDAO(String path){
        this.path = path;
    }

    public ArrayList<Directores> dameTodos() throws SQLException{
        String sql = "SELECT * FROM Directores ORDER BY Nombre DESC";
        Connection conn = new Utilidades().getConnection(path);
        Statement sentenciaSQL = conn.createStatement();
        ResultSet rs = sentenciaSQL.executeQuery(sql);

        ArrayList<Directores> listaDirectores = new ArrayList<>();
        Directores dire=null;
        while (rs.next()) {
            dire = new Directores(rs.getString("Nombre"),
                                             rs.getString("Url_foto"), 
                                             rs.getString("Url_web"));
            listaDirectores.add(dire);
        }conn.close();
        return listaDirectores;
    }

    public Directores BuscarPorId(int Buscar_Id) throws SQLException{
        String sql = "SELECT * FROM Directores where Id = ?;";
        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement((sql));
        sentenciaSQL.setInt(1, Buscar_Id);
        ResultSet rs = sentenciaSQL.executeQuery();

        Directores dire = null;
        if(rs.next()){
            dire = new Directores(rs.getString("Nombre"),
                                  rs.getString("Url_foto"),
                                  rs.getString("Url_web"));
        }conn.close();
        return dire;            
    }

    public Directores BuscarPorNombre(String Buscar_Nombre) throws SQLException{
        String sql = "SELECT * FROM Directores where Nombre = ?;";
        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement((sql));
        sentenciaSQL.setString(1, Buscar_Nombre);
        ResultSet rs = sentenciaSQL.executeQuery();

        Directores dire = null;
        if(rs.next()){
            dire = new Directores(rs.getString("Nombre"),
                                  rs.getString("Url_foto"),
                                  rs.getString("Url_web"));
        }conn.close();
        return dire;            
    }

    public void Eliminar_director(int Buscar_Id)throws SQLException{
        String sql = "DELETE FROM Directores WHERE Id = ?;";
        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement((sql));
        sentenciaSQL.setInt(1, Buscar_Id);
        sentenciaSQL.executeUpdate(); 
        
        conn.close();    
    }

    public Directores Modificar_Director(Directores director)throws SQLException{
        String sql = "UPDATE Directores SET Nombre =?, Url_foto=?, Url_web =? Where Id = ?;";
        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement((sql));
        sentenciaSQL.setString(1, director.Get_Nombre());
        sentenciaSQL.setString(2, director.Get_Url_foto());
        sentenciaSQL.setString(3, director.Get_Url_web());
        sentenciaSQL.setInt(4, director.Get_Id());

        sentenciaSQL.executeUpdate();
        conn.close();    
        return director;  
    }

}
