package Modelo;

public class Peliculas {
    private int Id;
    private String Titulo;
    private int Id_director;
    private int Year;
    private String Url_caratula;
    private Generos Id_genero; 
    private int Es_animacion;

    public Peliculas(String Titulo, int Id_director, int Year, String Url_caratula, Generos Id_genero, int Es_animacion){
        this.Titulo = Titulo;
        this.Id_director = Id_director;
        this.Year = Year;
        this.Url_caratula = Url_caratula;
        this.Id_genero = Id_genero;
        this.Es_animacion = Es_animacion;
    }

    public int Get_Id(){
        return Id;
    }

    public String Get_Titulo(){
        return Titulo;
    }

    public int Get_Id_director(){
        return Id_director;
    }

    public int Get_Year(){
        return Year;
    }

    public String Get_Url_caratula(){
        return Url_caratula;
    }

    public Generos Get_Id_genero(){
        return Id_genero;
    }

    public int Get_Es_animacion(){
        return Es_animacion;
    }

    public void Set_Titulo(String Titulo){
        this.Titulo = Titulo;
    }

    public void Set_Id_director(int Id_director){
        this.Id_director = Id_director;
    }

    public void Set_Year(int Year){
        this.Year = Year;
    }

    public void Set_Url_caratula(String Url_caratula){
        this.Url_caratula = Url_caratula;
    }

    public void Set_Id_genero(Generos Id_genero){
        this.Id_genero = Id_genero;
    }

    public void Set_Es_animacion(int Es_animacion){
        this.Es_animacion = Es_animacion;
    }
}
