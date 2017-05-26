package nl.kadaster.oca1.wk27.familie;

public class Kind extends Mens {
	private Mens ouders[];
	Kind(String voorNaam, String achterNaam, Mens ouders[]) {
		super(voorNaam, achterNaam); 
		this.ouders = ouders;
	}
}
