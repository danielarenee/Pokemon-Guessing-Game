package pokemon;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class Usuario {
	private Scanner scanner;
	public String nombreUsuario;
	
	public Usuario() {
        scanner = new Scanner(System.in);
    	 
    }
    
	public void logIn() {
        System.out.println("Ingresa tu nombre: ");
        nombreUsuario = scanner.nextLine().toLowerCase();
        File nombreUsuarioFile = new File(nombreUsuario + ".txt");
        
        if (nombreUsuarioFile.exists()) {
        	System.out.println("");
            System.out.println("Bienvenid@ de vuelta, " + nombreUsuario + "!");
            System.out.println("");
        
        } else {
            try {
                nombreUsuarioFile.createNewFile();
                System.out.println("");
                System.out.println("Bienvenid@, " + nombreUsuario + "! Ahora podrás guardar tus victorias");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo para el usuario.");
                e.printStackTrace();
            }
        }
    }
	
	
	
	public void mostrarScore() {
        try {
            File archivoPartidas = new File(nombreUsuario + ".txt");
            Scanner lector = new Scanner(archivoPartidas);
            
            System.out.println("Archivo de partidas de " + nombreUsuario + ":");
            System.out.println("");
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                System.out.println(linea);
            }

            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de partidas.");
            e.printStackTrace();
        }
    }
	
	public void actualizarArchivo( boolean partidaGanada) {
	    try {
	        int numeroPartida = 0;
	        
	        File archivoPartidas = new File(nombreUsuario + ".txt");
	        if (archivoPartidas.exists()) {
	        	
	            Scanner lector = new Scanner(archivoPartidas);
	            while (lector.hasNextLine()) {
	                lector.nextLine(); 
	                numeroPartida++;
	            }
	            lector.close();
	        }

	        numeroPartida++;

	        if (partidaGanada)
        	{
        		 FileWriter escritor = new FileWriter(nombreUsuario + ".txt", true);
                 escritor.write(" Partida " + numeroPartida + ": Ganada  \n");  

                 escritor.close();
        	}
        	else {
        		FileWriter escritor = new FileWriter(nombreUsuario + ".txt", true);
                escritor.write(" Partida " + numeroPartida + ": Perdida  \n");  
             
                escritor.close();
        	}
	        
	    } catch (IOException e) {
	        System.out.println("Error al actualizar el archivo de partidas.");
	        e.printStackTrace();
	    }
	}
}