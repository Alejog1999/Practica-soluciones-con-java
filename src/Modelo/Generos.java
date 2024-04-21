package Modelo;

public enum Generos {

    FICCION(1),
    SUSPENSO(2),	
    COMEDIA(3),
    ACCION(4),
    INFANTIL(5);
    private int Id;

    private Generos(int Id){
        this.Id = Id;
    }
    
    public int Get_Id(){
        return Id;
    }
}
