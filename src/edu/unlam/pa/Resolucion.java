package edu.unlam.pa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Resolucion extends EjercicioOIA{

	private File entrada;
	private File salida;
	public Resolucion(File entrada, File salida) {
		super(entrada, salida);
		this.entrada = entrada;
		this.salida = salida;
	}


	@Override
	
	// CC = O(n^2)
	// O(n + n + n^2) = O(2n + n^2)
	// Por Regla de la suma: O(2n + n^2) -> O(n^2) 
	public void resolver() {
		
		boolean[][] tablero;
		int[] columnas;
		
		try {
			Scanner entrada = new Scanner(this.entrada);
			
			int tam = entrada.nextInt();
			tablero = new boolean[tam][tam];
			columnas = new int [tam];
			
			// O(n)
			for (int i = 0; i < columnas.length; i++) {
				columnas[i] = entrada.nextInt();
			}
			entrada.close();
			
			// O(n)
			for (int i = 0; i < columnas.length; i++) {
				tablero[columnas[i] - 1][i] = true;
			}
			
			for (int i = 0; i < columnas.length; i++) {
				for (int j = 0; j < columnas.length; j++) {
					System.out.print((tablero[i][j]?1:0) + " ");
				}
				System.out.println();
			}
			
			@SuppressWarnings("resource")
			PrintWriter salida = new PrintWriter(this.salida);
			boolean no = false;
			
			// O(n^2)
			// Por Regla del Producto
			// dos ciclos for anidados
			for (int i = 0; i < columnas.length; i++) {
				for (int j = 1; j < columnas.length - 1; j++) {
					if((columnas[i]-1) - j >= 0 && (i + j) < tam && tablero[(columnas[i]-1) - j][i + j]) {
						if(!no) {
							System.out.println("NO");
							salida.println("NO");
							no = true; 
						}
						System.out.println("(" + (i+1)  + "," + (i+j+1) + ")");
						salida.println("(" + (i+1)  + "," + (i+j+1) + ")");
						break;
					}
					if((columnas[i]-1) + j < tam && (i + j) < tam && tablero[(columnas[i]-1) + j][i + j]) {
						if(!no) {
							System.out.println("NO");
							salida.println("NO");
							no = true; 
						}
						System.out.println("(" + (i+1) + "," + (i+j+1) + ")");
						salida.println("(" + (i+1) + "," + (i+j+1) + ")");
						break;
					}
				}
			}
			if(!no) {
				System.out.println("SI");
				salida.println("SI");
			}
			salida.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		
		String dirIn = "Estructura de Carpetas\\Preparacion de la Prueba\\Lote de Prueba\\Entrada\\";
		String dirOut = "Estructura de Carpetas\\Ejecucion de Prueba\\Salida Obtenida\\";
		
		File[] v_files = new File(dirIn).listFiles();
		
		for (File fileIn : v_files) {
			System.out.println("Ejecutando: " + fileIn.getName());
			long ini = System.currentTimeMillis();
			
			File fileOut = new File(dirOut + (fileIn.getName()).replace(".in", ".out") );
			EjercicioOIA ejer = new Resolucion(fileIn,fileOut);
			ejer.resolver();
			
			long fin = System.currentTimeMillis();
			System.out.println("Finalizado. Tiempo de ejecución: " + (fin - ini)+ " miliseg.");
		}
		
		
	}
}
