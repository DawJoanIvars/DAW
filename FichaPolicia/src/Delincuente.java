
public class Delincuente {
	//Falta por crear
	//Atributos para guardar
	//Tienen que ser los atributos de la pantalla
	private String nombre;
	private int edad;
	private String crimen;
	private int altura;
	
	public Delincuente() {
		nombre="";
		edad=0;
		crimen="";
		altura=0;
	}
	//Falta por crear
	//Los m�todos de guardado y recuperaci�n
	public void setNombre(String CojeNombre) {
		nombre=CojeNombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setEdad(int CojeEdad) {
		edad=CojeEdad;
	}
	public int getEdad() {
		return edad;
	}
	public void setCrimen(String CojeCrimen) {
		crimen=CojeCrimen;
	}
	public String getCrimen() {
		return crimen;
	}
	public void setAltura(int CojeAltura) {
		altura=CojeAltura;
	}
	public int getAltura() {
		return altura;
	}
	//Falta por crear
	//El m�todo toString para que aparezca en el comboBox
	public String toString(){
		return nombre;
	}

}
