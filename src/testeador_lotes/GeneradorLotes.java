package testeador_lotes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GeneradorLotes {
	
	public static void main(String[] args) throws FileNotFoundException {
		String dirIn = "Estructura de Carpetas\\Preparacion de la Prueba\\Lote de Prueba\\Entrada\\";
		String fileIn = "05_Fatiga_misma_diagonal_principal.in";
		
		PrintWriter salida = new PrintWriter(new File(dirIn + fileIn));
		
		int n_reinas = 100;
		
		System.out.println(n_reinas);
		salida.println(n_reinas);
		
		for (int i = 1; i < n_reinas ; i++) {
			System.out.print( i + " ");
			salida.print( i + " ");
		}
		System.out.println(n_reinas);
		salida.println(n_reinas);
		
		salida.close();
	}

}
