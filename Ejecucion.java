package examen2;

import java.util.Random;

public class Ejecucion {
    public void iniciarPrograma() {
        Random random = new Random();

        Pokemon[] pokemones = new Pokemon[15];

        int countAgua = 0;
        int countPlanta = 0;
        int countFuego = 0;

        String[] nombresAgua = {"Squirtle", "Totodile", "Mudkip", "Froakie", "Quaxly"};
        String[] nombresFuego = {"Charmander", "Cyndaquil", "Torchic", "Litten", "Fuecoco"};
        String[] nombresPlanta = {"Bulbasaur", "Chikorita", "Treecko", "Rowlet", "Sprigatito"};
      

        mezclarArray(nombresAgua, random);
        mezclarArray(nombresFuego, random);
        mezclarArray(nombresPlanta, random);

        for (int i = 0; i < 15; i++) {
            int randomSubclase;
            do {
                randomSubclase = random.nextInt(3);
            } while ((randomSubclase == 0 && countFuego >= 5) ||
                    (randomSubclase == 1 && countPlanta >= 5) ||
                    (randomSubclase == 2 && countAgua >= 5));

            switch (randomSubclase) {
                case 0:
                    pokemones[i] = new Fuego();
                    pokemones[i].setNombre(nombresFuego[countFuego]);
                    countFuego++;
                    break;
                case 1:
                    pokemones[i] = new Planta();
                    pokemones[i].setNombre(nombresPlanta[countPlanta]);
                    countPlanta++;
                    break;
                case 2:
                    pokemones[i] = new Agua();
                    pokemones[i].setNombre(nombresAgua[countAgua]);
                    countAgua++;
                    break;
            }
            asignarAtaques(pokemones[i], random);
        }

        for (Pokemon pokemon : pokemones) {
            if (pokemon != null) {
                if (pokemon.getAtaque1().equals("PetalDance")) {
                    pokemon.setAtaque1("Petal Dance");
                } else if (pokemon.getAtaque1().equals("HydroPump")) {
                    pokemon.setAtaque1("Hydro Pump");
                } else if (pokemon.getAtaque1().equals("SolarBeam")) {
                    pokemon.setAtaque1("Solar Beam");
                } else if (pokemon.getAtaque1().equals("AquaJet")) {
                    pokemon.setAtaque1("Aqua Jet");
                }

                if (pokemon.getAtaque2().equals("PetalDance")) {
                    pokemon.setAtaque2("Petal Dance");
                } else if (pokemon.getAtaque2().equals("HydroPump")) {
                    pokemon.setAtaque2("Hydro Pump");
                } else if (pokemon.getAtaque2().equals("SolarBeam")) {
                    pokemon.setAtaque2("Solar Beam");
                } else if (pokemon.getAtaque2().equals("AquaJet")) {
                    pokemon.setAtaque2("Aqua Jet");
                }

                if (pokemon.getAtaque3().equals("PetalDance")) {
                    pokemon.setAtaque3("Petal Dance");
                } else if (pokemon.getAtaque3().equals("HydroPump")) {
                    pokemon.setAtaque3("Hydro Pump");
                } else if (pokemon.getAtaque3().equals("SolarBeam")) {
                    pokemon.setAtaque3("Solar Beam");
                } else if (pokemon.getAtaque3().equals("AquaJet")) {
                    pokemon.setAtaque3("Aqua Jet");
                }

                if (pokemon.getAtaque4().equals("PetalDance")) {
                    pokemon.setAtaque4("Petal Dance");
                } else if (pokemon.getAtaque4().equals("HydroPump")) {
                    pokemon.setAtaque4("Hydro Pump");
                } else if (pokemon.getAtaque4().equals("SolarBeam")) {
                    pokemon.setAtaque4("Solar Beam");
                } else if (pokemon.getAtaque4().equals("AquaJet")) {
                    pokemon.setAtaque4("Aqua Jet");
                }
            }
        }
        
        

        for (Pokemon pokemon : pokemones) {
            if (pokemon instanceof Agua) {
                pokemon.setTipo("Agua");
            } else if (pokemon instanceof Fuego) {
            	pokemon.setTipo("Fuego");
            } else if (pokemon instanceof Planta) {
            	pokemon.setTipo("Planta");
            }
        }
        
        System.out.println(" Pokemones: ");
    	System.out.println("");
    	
        for (Pokemon pokemon : pokemones) {
            imprimirCaracteristicas(pokemon);
        }
        
        Menu menu = new Menu();
        menu.jugarAdivinaQuien(pokemones);
    }
    
    
    private void imprimirCaracteristicas(Pokemon pokemon) {
        System.out.println(pokemon.nombre + "    (" + pokemon.tipo + ")    [ " + pokemon.getAtaque1() + ",  " + pokemon.getAtaque2() + ",  " + pokemon.getAtaque3()+ ",  " + pokemon.getAtaque4() + " ]" );
    }
    

    private void mezclarArray(String[] array, Random random) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            String temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    private void asignarAtaques(Pokemon pokemon, Random random) {
        String[] tiposAtaqueSpaceless = {"HydroPump", "SolarBeam", "Eruption", "Flamethrower", "AquaJet", "Whirlpool", "Synthesis", "PetalDance"};
        String[] ataques = new String[4];

        for (int i = 0; i < 4; i++) {
            String ataque;
            boolean ataqueRepetido;
            do {
                ataque = tiposAtaqueSpaceless[random.nextInt(tiposAtaqueSpaceless.length)];

                ataqueRepetido = false;
                for (int j = 0; j < i; j++) {
                    if (ataque.equals(ataques[j])) {
                        ataqueRepetido = true;
                        break;
                    }
                }
            } while (ataqueRepetido);


            ataques[i] = ataque;
        }

        pokemon.setAtaque1(ataques[0]);
        pokemon.setAtaque2(ataques[1]);
        pokemon.setAtaque3(ataques[2]);
        pokemon.setAtaque4(ataques[3]);
    }
}
