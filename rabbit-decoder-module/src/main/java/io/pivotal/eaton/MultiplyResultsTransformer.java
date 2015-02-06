package io.pivotal.eaton;

import org.springframework.integration.annotation.Transformer;

/**
 * Transformer to multiply the results in a 
 * message.
 * @author Brian Jimerson
 *
 */
public class MultiplyResultsTransformer {
	
	private String amplifyFactor;
	
	/**
	 * Multiplies the results by some factor set.
	 * 
	 * @param results The results to multiply.
	 * @return A new payload containing the multiplied results.
	 */
	@Transformer
	public Object multiplyResults(String results) {
		return results;
	}

	/**
	 * Gets the factor to amplify by.
	 * @return The factor to amplify by.
	 */
	public String getAmplifyFactor() {
		return amplifyFactor;
	}

	/**
	 * Sets the factor to amplify by.
	 * @param amplifyFactor The factor to amplify by.
	 */
	public void setAmplifyFactor(String amplifyFactor) {
		this.amplifyFactor = amplifyFactor;
	}

}
