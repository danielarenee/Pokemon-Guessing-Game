package pokemon;

class Agua extends Pokemon {

	@Override
    public boolean tieneAtaque(String ataque) {
        String[] ataques = {getAtaque1(), getAtaque2(), getAtaque3(), getAtaque4()};
        for (String a : ataques) {
            if (a.equals(ataque)) {
                return true;
            }
        }
        return false;
    }
	
	
}
