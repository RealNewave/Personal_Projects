package themaopdracht.domein.exceptions;

public class ExistingInstanceException extends Exception{
	/**
	 * @author Rogier Pijpers
	 * 
	 * ExistingInstanceException is bedoeld om een exception te geven
	 * op het moment dat een object toegevoegd wordt dat al bestaat.
	 * In de controller kan deze afgevangen worden en een melding geven.
	 */
	
	public ExistingInstanceException(){
		super("object bestaat al");
	}
	
	public ExistingInstanceException(String s){
		super(s);
	}
}
