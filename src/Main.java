import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		TresEnRaya juego = new TresEnRaya();

		while (true) {

			juego.iniciar();

			boolean esRobot = true;

			System.out.println("Con quien quieres jugar (Robot - r, Otra persona - p)?");
			if (Character.compare(entrada.nextLine().toLowerCase().charAt(0), 'p') == 0) {
				esRobot = false;
			}

			while (juego.ganaJugador() == 0) {
				juego.dibujarTablero();
				if (juego.esTurnoJugador1()) {
					System.out.println("Turno Jugador 1: ");
					juego.mueveJugador1(entrada.nextInt());
				} else {
					System.out.println("Turno Jugador 2: ");
					if (esRobot) {
						juego.mueveJugador2();
					} else {
						juego.mueveJugador2(entrada.nextInt());
					}
				}
			}

			juego.dibujarTablero();

			switch (juego.ganaJugador()) {
			case 1:
				System.out.println("Gratz Jugador 1");
				break;

			case 2:
				System.out.println("Gratz Jugador 2");
				break;

			default:
				System.out.println("No hay ganador :( (empate)");
				break;
			}

			entrada.nextLine();
			System.out.println("Nueva partida? (y/n)");
			if (Character.compare(entrada.nextLine().toLowerCase().charAt(0), 'n') == 0) {
				break;
			}
		}

		entrada.close();
	}

}
