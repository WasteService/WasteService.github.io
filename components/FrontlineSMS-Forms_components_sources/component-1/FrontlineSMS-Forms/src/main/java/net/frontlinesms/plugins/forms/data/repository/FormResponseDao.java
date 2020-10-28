/**
 * 
 */
package net.frontlinesms.plugins.forms.data.repository;

import java.util.List;

import net.frontlinesms.plugins.forms.data.domain.Form;
import net.frontlinesms.plugins.forms.data.domain.FormResponse;

/**
 * Data Access Object for {@link FormResponse}.
 * @author Alex
 */
public interface FormResponseDao {
	/**
	 * Gets a list of responses submitted for a form.
	 * @param form form whose responses we are fetching
	 * @param startIndex 
	 * @param limit 
	 * @return list of responses submitted
	 */
	public List<FormResponse> getFormResponses(Form form, int startIndex, int limit);

	/**
	 * Get all form responses
	 * @return list of responses submitted
	 */
	public List<FormResponse> getAllFormResponses();
	
	/**
	 * Gets the number of responses submitted for a form.
	 * @param form 
	 * @return number of responses submitted
	 */
	public int getFormResponseCount(Form form);

	/**
	 * Save a form response
	 * @param formResponse the response to save
	 */
	public void saveResponse(FormResponse formResponse);

	public void delete(FormResponse responseOne);
	
	public FormResponse getFormResponse(long id);
}
