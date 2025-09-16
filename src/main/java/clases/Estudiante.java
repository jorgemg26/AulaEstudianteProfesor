package clases;

public class Estudiante {
    
    String nombre;
    int edad;
    String sexo;
    int calificacion;
    boolean novillos;
    
    public Estudiante (String nombre, int edad, String sexo, int calificacion, boolean novillos){
        
        this.nombre=nombre;
        this.edad=edad;
        this.sexo=sexo;
        this.calificacion=calificacion;
        this.novillos=false;
        
        System.out.println("Estudiante creado");
    }
    
    public String GetNombre (){
        return nombre;
    }
    public int GetEdad (){
        return edad;
    }
    public String GetSexo (){
        return sexo;
    }
    public int GetCalificacion(){
        return calificacion;
    }
    public void MostrarEstudiante (){
        System.out.print(nombre + " " + edad + " " + sexo + " " + calificacion);
    }
}
