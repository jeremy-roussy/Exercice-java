import java.util.ArrayList;

public class Eleve {
	private String nom;
	private ArrayList<Note> listeNotes = new ArrayList<Note>();
	
	public Eleve(String nom) {
		this.nom = nom;
	}
	
	public Eleve(String nom, ArrayList<Note> notes) {
		this.nom = nom;
		this.listeNotes = notes;
	}
	
	public String getNom() {
		return this.nom;
	}

	public ArrayList<Note> getListeNotes() {
		return listeNotes;
	}

	public void addNote(float note, Matiere matiere) {
		if(note > 20) {
			this.listeNotes.add(new Note(20, matiere));
			return;
		}
		
		if(note < 0) {
			this.listeNotes.add(new Note(0, matiere));
			return;
		}
		
		this.listeNotes.add(new Note(note, matiere));
	}
	
	public void addNote(float note, String nomMatiere) {
		if(note > 20) {
			this.listeNotes.add(new Note(20, new Matiere(nomMatiere)));
			return;
		}
		
		if(note < 0) {
			this.listeNotes.add(new Note(0, new Matiere(nomMatiere)));
			return;
		}
		
		this.listeNotes.add(new Note(note, new Matiere(nomMatiere)));
	}
	
	public void addNote(float note, String nomMatiere, int coefficient) {
		if(note > 20) {
			this.listeNotes.add(new Note(20, new Matiere(nomMatiere, coefficient)));
			return;
		}
		
		if(note < 0) {
			this.listeNotes.add(new Note(0, new Matiere(nomMatiere, coefficient)));
			return;
		}
		
		this.listeNotes.add(new Note(note, new Matiere(nomMatiere, coefficient)));
	}
	
	public float average() throws AucuneNoteException {
		if(this.listeNotes.isEmpty()) throw new AucuneNoteException("L'élève n'a aucune note");
		
		float average = 0;
		int nbNote = 0;
		
		for(Note note : listeNotes) {
			average += note.getNote() * note.getMatiere().getCoefficient();
			nbNote += note.getMatiere().getCoefficient();
		}
		
		return average / nbNote;
	}
	
}
