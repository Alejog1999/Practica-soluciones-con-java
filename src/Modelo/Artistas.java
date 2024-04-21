package Modelo;

public class Artistas {
    private int Id;
    private String Nombre;
    private String Url_foto;
    private String Url_web;

    public Artistas(int Id, String Nombre, String Url_foto, String Url_web) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Url_foto = Url_foto;
        this.Url_web = Url_web;
    }

    public int Get_Id(){
        return Id;
    }

    public String Get_Nombre(){
        return Nombre;
    }

    public String Get_Url_foto(){
        return Url_foto;
    }

    public String Get_Url_web(){
        return Url_web;
    }

    public void Set_Id(int Id){
        this.Id = Id;
    }

    public void Set_Nombre(String Nombre){
        this.Nombre = Nombre;
    }

    public void Set_Url_foto(String Url_foto){
        this.Url_foto = Url_foto;
    }

    public void Set_Url_web(String Url_web){
        this.Url_web = Url_web;
    }
}
