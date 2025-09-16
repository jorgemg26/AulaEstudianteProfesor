package pj.proyecto1;

import clases.Estudiante;
import clases.Profesor;
import clases.Aula;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class AulaEstudiantesProfesor {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int NumeroEstudiantes;
        
        System.out.println("Cuantos estudiantes hay?");
        NumeroEstudiantes=scan.nextInt();       //Para decidir cuantos estudiantes hay (la longitud del array)
        scan.nextLine();        //Consumir salto de linea
        
        Estudiante [] Estudiantes = new Estudiante [NumeroEstudiantes];     //Guardar todos los estudiantes para poder cargarlos con un bucle a la clase o poder acceder a ellos direcamente
        Profesor [] Profesores = new Profesor [3];      //Guardar los profesores para cargarlos con un bucle a la clase o poder acceder a ellos directamente
        Aula [] Aulas = new Aula [3];       //Guardar las aulas para cargarlas con un bucle a la clase o poder acceder a ellas directamente
        
        ArrayList <Integer> NumeroAula = new ArrayList <> ();        //Para que el numero de aula se guarde en un ArrayList, y cuando de forma aleatoria salga un valor, luego se pueda borrar
        
        String NombreEstudiante, NombreProfesor, NombreAula, SexoEstudiante, SexoProfesor, materia, FraseRepetir, asiste, AulaAlumno;
        
        int EdadEstudiante, EdadProfesor, calificacion, NumeroMateria, MaxEstudiantesAula = 0, IdentificadorAula, NumeroAulaAlumno, NumeroAulaProfesor, MinEstudiantes, AulaProfesor=0,
        IndiceAulaProfesor;
        
        double NovillosDecimal, DisponibleDecimal;
        
        boolean novillos, disponible, repetir, sexo;
        
        int AlumnosMatematicas=0;   int AlumnosFilosofia=0; int AlumnosFisica=0;        //Para contar el numero de alumnos que va a cada asignatura
        
        int AprobadosMatematicas=0; int AprobadosFilosofia=0;    int AprobadosFisica=0;      //Para contar el numero de aprobados por asignatura
        
        Random rand = new Random();
        
        for (int ContadorAula1=0; ContadorAula1<3; ContadorAula1++){        //Cargamos el ArrayList del Numero de Aula para los profesores con numeros del 0 al 2
                NumeroAula.add(ContadorAula1);
        }
        
        
        do{ 
            
            for (int contador1=0; contador1<NumeroEstudiantes; contador1++){        //Para registrar todos los estudiantes con un bucle
                System.out.println("Nombre del estudiante:");
                NombreEstudiante=scan.nextLine();       //El nombre de los estudiantes lo pone el usuario

                System.out.println("Edad del estudiante:");
                EdadEstudiante=scan.nextInt();      //La edad del estudiante la decide el usuario
                scan.nextLine();        //Consumir salto de linea

                do{     //Se repite el bucle hasta que ponga "masculino" o "femenino"
                    System.out.println("Sexo del estudiante (debe ser 'masculino' o 'femenino'):");
                    SexoEstudiante=scan.nextLine();     //El sexo del estudiante lo pone el usuario
                    if (SexoEstudiante.equalsIgnoreCase("masculino") || SexoEstudiante.equalsIgnoreCase("femenino")){
                        sexo=true;
                    }
                    else {
                        sexo=false;
                    }
                }
                while (sexo==false);

                calificacion=rand.nextInt(11);      //La calificacion del estudiante es aleatoria
                
                NovillosDecimal=rand.nextDouble();      //Esto nos devuelve un numero aleatorio entre 0 y 1
                if (NovillosDecimal>0.5){       //Si es mayor de 0.5 hace novillos
                    novillos=true;
                }
                else{
                    novillos=false;     //Si es menor no hace novillos
                }
                if (novillos==false){
                    asiste="asiste";
                }
                else{
                    asiste="no asiste";
                }
                
                NumeroAulaAlumno=rand.nextInt(3);       //Para que el aula en la que debe estar el alumno sea aleatoria
                if (NumeroAulaAlumno==0){       //Se asigna y se suma 1 a la cantidad de alumnos de la asignatura que le ha tocado
                    AulaAlumno="matematicas"; 
                    AlumnosMatematicas=AlumnosMatematicas+1;
                    if (calificacion>=5){
                        AprobadosMatematicas=AprobadosMatematicas+1;
                    }
                }
                else if (NumeroAulaAlumno==1){
                    AulaAlumno="filosofia";
                    AlumnosFilosofia=AlumnosFilosofia+1;
                    if (calificacion>=5){
                        AprobadosFilosofia=AprobadosFilosofia+1;
                    }
                }
                else{
                    AulaAlumno="fisica";
                    AlumnosFisica=AlumnosFisica+1;
                    if (calificacion>=5){
                        AprobadosFisica=AprobadosFisica+1;
                    }
                }

                Estudiantes[contador1] = new Estudiante (NombreEstudiante, EdadEstudiante, SexoEstudiante, calificacion, novillos);     //Cargamos la clase con los datos
                
                System.out.println();
                System.out.println("Estudiante " + (contador1+1) + ":");
                Estudiantes[contador1].MostrarEstudiante();     //Mostrar los datos del estudiante 
                
                System.out.print(" " + asiste);
                System.out.println();
                System.out.println();
            }
            
            for (int contador2=0; contador2<Profesores.length; contador2++){        //Para registrar los profesores de las 3 asignaturas
                System.out.println("Nombre del profesor:");
                NombreProfesor=scan.nextLine();     //El nombre del profesor lo pone el usuario
                
                EdadProfesor=rand.nextInt(64)+16;       //Edad del profesor aleatoria (entre 16 y 80 años)
                
                do{      //Se repite el bucle hasta que ponga "masculino" o "femenino"
                    System.out.println("Sexo del profesor (debe ser 'masculino' o 'femenino'):");
                    SexoProfesor=scan.nextLine();     //El sexo del profesor lo pone el usuario
                    if (SexoProfesor.equalsIgnoreCase("masculino") || SexoProfesor.equalsIgnoreCase("femenino")){
                        sexo=true;
                    }
                    else{
                        sexo=false;
                    }
                }
                while (sexo==false);
                
                System.out.println();
                NumeroMateria=contador2;        //Segun en que vuelta del bucle estemmos el profesor es de una asignatura
                if(NumeroMateria==0){       //Si esta en la primera es de matematicas
                    materia="matematicas";
                }
                else if (NumeroMateria==1){     //Si esta en la segunda es de filosofia
                    materia="filosofia";
                }
                else{       //Si esta en la tercera (la ultima) es de fisica
                    materia="fisica";
                }
                
                DisponibleDecimal=rand.nextDouble();        //Esto nos devuelve un numero aleatorio entre 0 y 1
                if (DisponibleDecimal>=0.2){     //Si es mayor de 0.2 esta disponible
                    disponible=true;
                    asiste="asiste";
                }
                else{       //Si es menor no esta dispoible
                    disponible=false;
                    asiste="no asiste";
                }
                
                IndiceAulaProfesor=rand.nextInt(NumeroAula.size());     //Para que el aula en que debe estar el profesor sea aleatoria se saca el indice (enttre 0 y 2) del ArrayList
                NumeroAulaProfesor=NumeroAula.get(IndiceAulaProfesor);     //Sacamos la posicion que ha tocado, y se guarda en la variable NumeroAulaProfesor 
                AulaProfesor=NumeroAulaProfesor;        //La posicionn la guardamos en otra variable que se va a usar posteriormente
                NumeroAula.remove(IndiceAulaProfesor);      //Borramos el numero del aula para que no se vuelva a repetir
                
                Profesores[contador2] = new Profesor (NombreProfesor, EdadProfesor, SexoProfesor, materia, disponible);
                
                System.out.println();
                System.out.println("Profesor de " + materia + ":");
                Profesores[contador2].MostrarProfesor();
                
                System.out.print(" " + asiste);
                System.out.println();
                System.out.println();
            }
            
            for (int contador3=0; contador3<3; contador3++){     //Para registrar las 3 aulas
                IdentificadorAula=contador3;
                
                MaxEstudiantesAula=NumeroEstudiantes;      //El maximo de estudiantes por aula total de estudiantes
                
                if (contador3==0){      //Si esta en la primera vuelta el aula es de matematicas
                    NombreAula="matematicas";
                }
                else if (contador3==1){     //Si esta en la segunda vuelta el aula es de filosofia
                    NombreAula="filosofia";
                }
                else{       //Si esta en la tercera vuelya (la ultima) el aula es de fisica
                    NombreAula="fisica";
                }
                
                Aulas[contador3] = new Aula (IdentificadorAula, MaxEstudiantesAula, NombreAula);        //Cargamos la clase aula con los datos
                
                System.out.println();
                System.out.println("Aula:");
                Aulas[contador3].MostrarAula();
                System.out.println();
                System.out.println();
            }
            
            MinEstudiantes = (int) Math.floor(MaxEstudiantesAula/2);     //Calcular el minimo de alumnos para dar clase (la mitad entre dos, redondeado abajo por si son impares)
            
            System.out.println("Clase de matematicas:");        //Vamos a comprobar si se puede dar clase de matematicas
            
            if (Profesores[0].GetDisponible()==true){       
                System.out.println("El profesor esta disponible");
                if (AulaProfesor==0){
                    System.out.println("El profesor de matematicas esta en la clase de matematicas");
                    if(AlumnosMatematicas>=MinEstudiantes){
                        System.out.println("Hay los alumnos necesarios, asi que se puede dar clase de matematicas");
                        System.out.println("El numero de aprobados en matematicas es: " + AprobadosMatematicas);
                    }
                    else {
                        System.out.println("No hay los alumnos necesarios, asi que no se puede dar clase de matematicas");
                    }
                }
                else {
                    System.out.println("El profesor de matematicas no esta en la clase de matematicas");
                }
            }
            else{
                System.out.println("El profesor no esta disponible");
            }
            
            System.out.println();
            System.out.println("Clase de filosofia:");      //Vamos a comprobar si se puede dar clase de filosofia
            
            if (AulaProfesor==1){       
                System.out.println("El profesor de filosofia esta disponible");
                if (Profesores[1].GetMateria().equalsIgnoreCase("filosofia")){
                    System.out.println("El profesor de filosofia esta en la clase de filosofia");
                    if(AlumnosFilosofia>=MinEstudiantes){
                        System.out.println("Hay los alumnos necesarios, asi que se puede dar clase de filosofia");
                        System.out.println("El numero de aprobados en filosofia es: " + AprobadosFilosofia);
                    }
                    else {
                        System.out.println("No hay los alumnos necesarios, asi que no se puede dar clase de filosofia");
                    }
                }
                else {
                    System.out.println("El profesor de filosofia no esta en la clase de filosofia");
                }
            }
            else{
                System.out.println("El profesor no esta disponible");
            }
            
            System.out.println();
            System.out.println("Clase de fisica");      //Vamos a comprobar si se puede dar clase de fisica
             
            if (AulaProfesor==2){       
                System.out.println("El profesor de fisica esta disponible");
                if (Profesores[2].GetMateria().equalsIgnoreCase("fisica")){
                    System.out.println("El profesor de fisca esta en la clase de fisica");
                    
                    if(AlumnosFisica>=MinEstudiantes){
                        System.out.println("Hay los alumnos necesarios, asi que se puede dar clase de fisca");
                        System.out.println("El numero de aprobados en fisica es: " + AprobadosFisica);
                    }
                    else {
                        System.out.println("No hay los alumnos necesarios, asi que no se puede dar clase de fisica");
                    }
                }
                else {
                    System.out.println("El profesor de fisica no esta en la clase de fisica");
                }
            }
            else{
                System.out.println("El profesor no esta disponible");
            }
            
            System.out.println();
            System.out.println("Desea repetir la simulacion?");     //Para repetir si lo desea, e intentar que la clase este dispoible
            FraseRepetir=scan.nextLine();
            if(FraseRepetir.equalsIgnoreCase("si")){        //Si dice "si" se repite todo
                repetir=true;
            }
            else{       //Si dice algo diferente a "si" se sale del programa
                repetir=false;
            }
            
        }
        while(repetir==true);
    }
}
