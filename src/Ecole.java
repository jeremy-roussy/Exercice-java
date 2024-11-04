import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ecole {
	String nom;
	ArrayList<Eleve> listeEleves;
	
	public Ecole(String nom) {
		this.nom = nom;
		this.listeEleves = new ArrayList<Eleve>();
	}
	
	public Ecole(String nom, ArrayList<Eleve> eleves) {
		this.nom = nom;
		this.listeEleves = eleves;
	}
	
	public String getNom() {
		return this.nom;
	}

	public ArrayList<Eleve> getListeEleves() {
		return listeEleves;
	}

	public void addEleve(Eleve eleve) {
			this.listeEleves.add(eleve);
	}
	
	public void addEleveWithNotes(String nomEleve, ArrayList<Note> notes) {
		this.listeEleves.add(new Eleve(nomEleve, notes));
	}
	
	public void addEleve(String nomEleve, ArrayList<Note> notes) {
		this.listeEleves.add(new Eleve(nomEleve, notes));
	}
	
	public float average() {
		float average = 0;
		
		for(Eleve eleve : listeEleves) {
			try {
				average += eleve.average();
			} catch (AucuneNoteException e) {
				e.printStackTrace();
			}
		}
		
		return average / listeEleves.size();
	}
	
	public Eleve findBestStudent() throws AucuneNoteException {
		Eleve best = listeEleves.get(0);
		
		for(Eleve eleve : listeEleves)
			if(eleve.average() > best.average()) best = eleve;
		
		return best;
	}
	
	public void displayNewsletter() {
		for(Eleve eleve : listeEleves) {
			Map<String, List<Note>> map = new HashMap<>();
			
			for(Note note : eleve.getListeNotes()) {
				if(map.containsKey(note.getMatiere().getNom()))
					map.get(note.getMatiere().getNom()).add(note);
				else
					map.put(note.getMatiere().getNom(), new ArrayList<Note>(Arrays.asList(note)));
			}
			
			System.out.println(eleve.getNom());
			
			for (Map.Entry<String, List<Note>> entry : map.entrySet()) {
			    System.out.println(entry.getKey() + " : ");
			    for(Note note : entry.getValue()) {
			    	System.out.println(note.getNote());
			    }
			}
			
			try {
				System.out.println("moyenne général : " + eleve.average());
			} catch (AucuneNoteException e) {
				e.printStackTrace();
			}
		}
	}
}
