package pokemon;


public abstract class Pokemon {
	
	String nombre;
	String tipo;
	String ataque1;
	String ataque2;
	String ataque3;
	String ataque4;

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getAtaque1() {
		return ataque1;
	}
	
	public void setAtaque1(String ataque1) {
		this.ataque1 = ataque1;
	}
	
	public String getAtaque2() {
		return ataque2;
	}
	
	public void setAtaque2(String ataque2) {
		this.ataque2 = ataque2;
	}
	
	public String getAtaque3() {
		return ataque3;
	}
	
	public void setAtaque3(String ataque3) {
		this.ataque3 = ataque3;
	}
	
	public String getAtaque4() {
		return ataque4;
	}
	
	public void setAtaque4(String ataque4) {
		this.ataque4 = ataque4;
	}

	
    public boolean tieneAtaque(String ataque) {
        return ataque.equals(this.ataque1) || ataque.equals(this.ataque2) || ataque.equals(this.ataque3) || ataque.equals(this.ataque4);
    }
	 
}




