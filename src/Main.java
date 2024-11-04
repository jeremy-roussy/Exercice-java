public class Main {

	public static void main(String[] args) {
		Ecole ecole = new Ecole("St-Paul");
		
		Eleve jeremy = new Eleve("Jeremy");
		jeremy.addNote(10, "Math", 2);
		jeremy.addNote(20, "Anglais");
		jeremy.addNote(19, "Anglais");
		jeremy.addNote(5, "Anglais");
		jeremy.addNote(5, "Math");
		jeremy.addNote(10, "Math");
		jeremy.addNote(30, "Math");
		
		ecole.addEleve(jeremy);
		
		ecole.displayNewsletter();
	}

}
