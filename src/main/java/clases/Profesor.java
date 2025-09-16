package clases;

public class Profesor {
    
    String nombre;
    int edad;
    String sexo;
    String materia;
    boolean disponible;
    
    public Profesor (String nombre, int edad, String sexo, String materia, boolean disponible){
        
        this.nombre=nombre;
        this.edad= edad;
        this.sexo=sexo;
        this.materia=materia;
        this.disponible=disponible;
        
        System.out.println("Profesor creado");
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
    
    public String GetMateria (){
        return materia;
    }
    
    public boolean GetDisponible (){
        return disponible;
    }
    
    public void MostrarProfesor(){
        System.out.print(nombre + " " + edad + " " + sexo + " " + materia);
    }
}
