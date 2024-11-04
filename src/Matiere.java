
public class Matiere {
	String nom;
	int coefficient;
	
	public Matiere(String nom, int coefficient) {
		this.nom = nom;
		this.coefficient = coefficient;
	}
	
	public Matiere(String nom) {
		this(nom, 1);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
}
