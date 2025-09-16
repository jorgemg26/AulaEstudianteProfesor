package clases;

public class Aula {
    
    int idAula;
    int MaxEstudiantes;
    String nombre;
    
    public Aula (int idAula, int MaxEstudiantes, String nombre){
        
        this.idAula=idAula;
        this.MaxEstudiantes=MaxEstudiantes;
        this.nombre=nombre;
        
        System.out.println("Aula creada");
    }
    
    public int GetidAula(){
        return idAula;
    }
    public String GetNombre (){
        return nombre;
    }
    public void MostrarAula(){
        System.out.print(idAula + " " + MaxEstudiantes + " " + nombre);
    }
}
