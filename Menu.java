package pokemon;

import java.util.Scanner;
import java.util.Random;

public class Menu {
    private Scanner scanner;
    
    public boolean partidaGanada = false;
	private int numeroPartida = 1;
	
    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void jugarAdivinaQuien(Pokemon[] pokemones) {
        Random random = new Random();
        Pokemon pokemonObjetivo = pokemones[random.nextInt(pokemones.length)];
        String ataque = "";

        System.out.println("");
        System.out.println("¡Bienvenido a Adivina Quien Version Pokemon!");
        
        Usuario usuario = new Usuario();
        usuario.logIn();

       
        int numPreguntas = 0;

        while (numPreguntas < 4) {
            System.out.println("");
            System.out.println("Elige una categoría para preguntar:");
            System.out.println("1) Tipo");
            System.out.println("2) Ataque");

            int preguntaSeleccionada = scanner.nextInt();

            switch (preguntaSeleccionada) {
                case 1:
                    System.out.println("1) ¿Es tipo Agua?");
                    System.out.println("2) ¿Es tipo Fuego?");
                    System.out.println("3) ¿Es tipo Planta?");
                    int respuestaTipo = scanner.nextInt();

                    switch (respuestaTipo) {
                        case 1:
                            if (pokemonObjetivo instanceof Agua) {
                                eliminarMissmatch(pokemones, "Agua");
                                System.out.println("");
                                System.out.println("Sí, es de tipo Agua.");
                                System.out.println("");
                            } else {
                                eliminarMatch(pokemones, "Agua");
                                System.out.println("No, no es de tipo Agua.");
                                System.out.println("");
                            }
                            break;

                        case 2:
                            if (pokemonObjetivo instanceof Fuego) {
                                eliminarMissmatch(pokemones, "Fuego");
                                System.out.println("");
                                System.out.println("Sí, es de tipo Fuego.");
                                System.out.println("");
                            } else {
                                eliminarMatch(pokemones, "Fuego");
                                System.out.println("");
                                System.out.println("No, no es de tipo Fuego.");
                                System.out.println("");
                            }
                            break;

                        case 3:
                            if (pokemonObjetivo instanceof Planta) {
                                eliminarMissmatch(pokemones, "Planta");
                                System.out.println("");
                                System.out.println("Sí, es de tipo Planta.");
                                System.out.println("");
                            } else {
                                eliminarMatch(pokemones, "Planta");
                                System.out.println("");
                                System.out.println("No, no es de tipo Planta.");
                                System.out.println("");
                            }
                            break;

                        default:
                            System.out.println("Opción no válida");
                            continue;
                    }
                    break;

                case 2:
                    System.out.println("¿Tiene el ataque... : ");
                    scanner.nextLine();
                    String cadena = scanner.nextLine();
                    ataque = cadena.replace(" ", "");

                    if (ataque.equals("PetalDance")) {
                        ataque = "Petal Dance";
                    } else if (ataque.equals("HydroPump")) {
                        ataque = "Hydro Pump";
                    } else if (ataque.equals("SolarBeam")) {
                        ataque = "Solar Beam";
                    } else if (ataque.equals("AquaJet")) {
                        ataque = "Aqua Jet";
                    }

                    if (pokemonObjetivo.tieneAtaque(ataque)) {
                        System.out.println("");
                        System.out.println("Sí, tiene el ataque " + ataque);
                        eliminarSinAtaque(pokemones, ataque);
                        System.out.println("");
                    } else {
                        System.out.println("");
                        System.out.println("No, no tiene el ataque " + ataque);
                        eliminarConAtaque(pokemones, ataque);
                        System.out.println("");
                    }
                    break;

                default:
                    System.out.println("Opción no válida");
                    continue;
            }

            System.out.println(" Pokemones disponibles:");
            System.out.println("");
            for (Pokemon pokemon : pokemones) {
                if (pokemon != null) {
                    imprimirCaracteristicas(pokemon);
                }
            }

            numPreguntas++;
        }

        System.out.println("");
        System.out.println("Adivina un pokemon: ");
        String guess = scanner.next();

        if (pokemonObjetivo.getNombre().equals(guess)) {
            System.out.println("");
            System.out.println("   ¡Felicidades! Has adivinado correctamente. ¡Has ganado el juego!");
            System.out.println("");
            partidaGanada = true;
            usuario.actualizarArchivo(partidaGanada);
            numeroPartida++;
        } else {
            System.out.println("");
            System.out.println("   Lo siento, esa no es la respuesta correcta. El pokemon era " + pokemonObjetivo.nombre + ". ¡Has perdido el juego!");
            System.out.println("");
           
            usuario.actualizarArchivo( partidaGanada);
            numeroPartida++;
        }
        usuario.mostrarScore();
    }

    private void imprimirCaracteristicas(Pokemon pokemon) {
        System.out.println(pokemon.getNombre() + "    (" + pokemon.getTipo() + ")    [ " + pokemon.getAtaque1() + ",  " + pokemon.getAtaque2() + ",  " + pokemon.getAtaque3() + ",  " + pokemon.getAtaque4() + " ]");
    }

    private void eliminarMissmatch(Pokemon[] pokemones, String tipoObjetivo) {
        for (int i = 0; i < pokemones.length; i++) {
            if (pokemones[i] != null && !pokemones[i].getTipo().equals(tipoObjetivo)) {
                pokemones[i] = null;
            }
        }
    }

    private void eliminarMatch(Pokemon[] pokemones, String tipoObjetivo) {
        for (int i = 0; i < pokemones.length; i++) {
            if (pokemones[i] != null && pokemones[i].getTipo().equals(tipoObjetivo)) {
                pokemones[i] = null;
            }
        }
    }

    private void eliminarSinAtaque(Pokemon[] pokemones, String ataqueObjetivo) {
        for (int i = 0; i < pokemones.length; i++) {
            if (pokemones[i] != null && !pokemones[i].tieneAtaque(ataqueObjetivo)) {
                pokemones[i] = null;
            }
        }
    }

    private void eliminarConAtaque(Pokemon[] pokemones, String ataqueObjetivo) {
        for (int i = 0; i < pokemones.length; i++) {
            if (pokemones[i] != null && pokemones[i].tieneAtaque(ataqueObjetivo)) {
                pokemones[i] = null;
            }
        }
    }
}
