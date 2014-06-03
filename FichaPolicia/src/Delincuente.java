
public class Delincuente {
	//Falta por crear
	//Atributos para guardar
	//Tienen que ser los atributos de la pantalla
	private String nombre;
	private int edad;
	private String crimen;
	private int altura;
	private int iD;
	public Delincuente() {
		nombre="";
		edad=0;
		crimen="";
		altura=0;
		iD=0;
	}
	public Delincuente(String NombreYapellidos, int Edad, int Altura, String Crimen, int ID) {
		nombre=NombreYapellidos;
		edad=Edad;
		crimen=Crimen;
		altura=Altura;
		iD=ID;
	}
	//Falta por crear
	//Los métodos de guardado y recuperación
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
	public void setId(int id) {
		iD=id;
	}
	public int getId() {
		return iD;
	}
	//Falta por crear
	//El método toString para que aparezca en el comboBox
	public String toString(){
		return nombre+" "+ "("+iD+")";
	}

}
