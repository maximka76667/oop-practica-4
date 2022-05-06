
public class TresEnRaya {
	private int[] tablero;
	// Variable que contenga si es el turno de jugador 1
	private boolean esTurnoJugador1;
	private int[][] lineasGanadoras = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
			{ 0, 4, 8 }, { 2, 4, 6 } };

	// Constructor
	public TresEnRaya() {
		this.tablero = new int[9];
		for (int celda : tablero) {
			celda = 0;
		}
		this.esTurnoJugador1 = true;
	}

	public void mueveJugador(int pos, int numJugador) {
		if (esMovimientoValido(pos)) {
			this.tablero[pos] = numJugador;
			cambiarTurno();
		}
	}

	// Metodos jugador
	public void mueveJugador1(int pos) {
		mueveJugador(pos, 1);
	}

	public void mueveJugador2(int pos) {
		mueveJugador(pos, 2);
	}

	public boolean esMovimientoValido(int pos) {
		return tablero[pos] == 0;
	}
	
	public int generarNumeroAleatorio() {
		return (int) Math.floor(Math.random() * 9);
	}

	public void mueveJugador1() {
		mueveJugador1(generarNumeroAleatorio());
	}

	public void mueveJugador2() {
		mueveJugador2(generarNumeroAleatorio());
	}

	public boolean quedanMovimientos() {
		for (int celda : tablero) {
			if (celda == 0) {
				return true;
			}
		}
		return false;
	}

	public void cambiarTurno() {
		this.esTurnoJugador1 = !esTurnoJugador1;
	}

	public void iniciar() {
		System.out.println("Un nuevo juego");
		for (int i = 0; i < tablero.length; i++) {
			tablero[i] = 0;
		}
		this.esTurnoJugador1 = true;
	}

	public void dibujarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			String simbol = tablero[i] == 1 ? "X" : tablero[i] == 0 ? "-" : "O";
			System.out.print(simbol + " ");
			// Dividir las rayas
			if ((i + 1) % 3 == 0) {
				System.out.println("");
			}
		}
	}

	// Metodos ganador
	public int ganaJugador() {
		// Comprueba si existe ganador
		// Si existe devuelve 1 o 2 (depende del ganador)
		for (int i = 0; i < lineasGanadoras.length; i++) {
			int[] lineaGanadora = lineasGanadoras[i];
			if (tablero[lineaGanadora[0]] != 0 && tablero[lineaGanadora[1]] == tablero[lineaGanadora[0]]
					&& tablero[lineaGanadora[2]] == tablero[lineaGanadora[0]]) {
				return tablero[lineaGanadora[0]];
			}
		}

		// Si no quedan más movimientos devuelve -1 y no hay ganador (empate)
		if (!quedanMovimientos()) {
			return -1;
		}

		// Si no hay ganador y quedan más movimientos devuelve 0 (continuamos el juego)
		return 0;
	}

	public boolean ganaJugador1() {
		return ganaJugador() == 1;
	}

	public boolean ganaJugador2() {
		return ganaJugador() == 2;
	}

	public boolean esTurnoJugador1() {
		return esTurnoJugador1;
	}

}
