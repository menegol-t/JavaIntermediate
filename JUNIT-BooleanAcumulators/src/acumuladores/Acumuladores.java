package acumuladores;

public class Acumuladores {
//1	
	public boolean todosMultiplosDe(int [] vec, int num) {
		
		boolean todosMultiplos = true;
				
		for(int i = 0; i<vec.length; i++) {
			todosMultiplos = todosMultiplos && vec[i] % num == 0;
		}
		
		return todosMultiplos;
	}
	
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
		
		boolean matrizVaciaONumNegativo = mat.length == 0 || num <= 0;
		
		if(matrizVaciaONumNegativo) return false;
		
		boolean existeFilaDondeTodosMultiplos = false;
		
		for(int i=0; i < mat.length; i++) {
			
			existeFilaDondeTodosMultiplos = todosMultiplosDe(mat[i], num) || existeFilaDondeTodosMultiplos;
		}
		
		return existeFilaDondeTodosMultiplos;
		
	}

//2
	public boolean algunRepetido(int[]vec1, int[]vec2) {
		
		boolean algunaInterseccion = false;
			
//Si bien la consigna no lo dice, se asume que las matrices dadas tienen la misma cantidad de COLUMNAS 			
		
		for(int i = 0; i < vec1.length; i++) { 

			for(int j = 0; j < vec2.length; j++) {

				algunaInterseccion = vec1[i] == vec2[j] || algunaInterseccion;
			}
		}
		
		return algunaInterseccion;
	}
	
	public boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) {

//Si bien la consigna no lo dice, se asume que las matrices dadas tienen la misma cantidad de COLUMNAS
		
		boolean matricesDistintasOVacias = mat1.length == 0 || mat2.length == 0|| mat1.length != mat2.length;
		
		if(matricesDistintasOVacias) return false;

		boolean unaInterseccionEnCadaFila = true;
		
		for(int i = 0; i < mat1.length; i++) {
			unaInterseccionEnCadaFila = algunRepetido(mat1[i], mat2[i]) && unaInterseccionEnCadaFila;
		}
		
		return unaInterseccionEnCadaFila;
	}
	
//3
	public int sumarColumna(int [][]mat, int nColum) {
		int suma = 0;
		
		for(int i = 0; i < mat.length;i++) {
			suma += mat[i][nColum];
		}
		
		return suma;
	}
	
	public int sumarFila(int[] vec) {
		int suma = 0;
		
		for(int i = 0; i < vec.length;i++) {
			suma += vec[i];
		}
		
		return suma;
	}
	
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) {
		
		boolean matrizVaciaOIndiceInvalido =  mat.length == 0 || nColum >= mat[0].length || nColum < 0;
		
		if(matrizVaciaOIndiceInvalido) return false;
		
		int sumaColumna = sumarColumna(mat, nColum);
		
		boolean existeFilaConMayorSumaQueColumna = false;
		
		for(int i = 0; i < mat.length; i++) {
			existeFilaConMayorSumaQueColumna = sumarFila(mat[i]) > sumaColumna || existeFilaConMayorSumaQueColumna;
		}
		
		return existeFilaConMayorSumaQueColumna;
	}
	
//4
	public boolean numeroExisteEnColumna(int numeroDeColumna, int numeroQuePodriaSerInterseccion, int [][]mat) {
		boolean interseccion = false;
		
		for(int i = 0; i < mat.length; i++) {
			interseccion = mat[i][numeroDeColumna] == numeroQuePodriaSerInterseccion || interseccion;
		}
		
		return interseccion;
	}
	
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) {
		
//Se asume que el largo de todas las columnas dentro de una misma matriz es el mismo		
		
		boolean matricesVaciasODeDistintasColumnas = mat1.length == 0 || mat2.length == 0 || mat1[0].length != mat2[0].length;
		
		if(matricesVaciasODeDistintasColumnas) return false;
		
		boolean todasColumnasInterseccion = true;

		for(int i = 0; i < mat1[0].length; i++) {
			
			boolean interseccionNumeroColumna = false;
			
			for(int j = 0; j < mat1.length; j++) { //Recorre las columnas de la primer matriz elemento a elemento
				interseccionNumeroColumna = numeroExisteEnColumna(i, mat1[j][i], mat2) || interseccionNumeroColumna;
			}
			
			todasColumnasInterseccion = interseccionNumeroColumna && todasColumnasInterseccion;
		}
		
		return todasColumnasInterseccion;
	}
}