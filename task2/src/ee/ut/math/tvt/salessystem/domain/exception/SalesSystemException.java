package ee.ut.math.tvt.salessystem.domain.exception;
public class SalesSystemException extends Exception {

	// the lines below added
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs new <code>SalesSystemException</code>.
	 */
	public SalesSystemException() {
		super();
	}
	
	/**
	 * Constructs new <code>SalesSystemException</code> with  with the specified detail message.
	 * @param message the detail message.
	 */
	public SalesSystemException(final String message) {
		super(message);
	}
	
}