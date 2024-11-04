
public class Note {
	float note;
	String commentaire;
	Matiere matiere;
	
	public Note(float note, String commentaire, Matiere matiere) {
		if(matiere == null) throw new IllegalArgumentException("L'argument paramètre ne peut pas etre null");
		
		this.note = note;
		this.commentaire = commentaire;
		this.matiere = matiere;
	}
	
	public Note(float note, Matiere matiere) {
		this(note, "", matiere);
	}
	
	public double getNote() {
		return note;
	}
	
	public void setNote(float note) {
		this.note = note;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public Matiere getMatiere() {
		return matiere;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}
