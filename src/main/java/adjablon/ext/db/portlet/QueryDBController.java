package adjablon.ext.db.portlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;


/**
 * 
 * @author Adam Jabłoński
 */
@RequestMapping(value = "VIEW")
public class QueryDBController {

	private static final Log LOG = LogFactory.getLog(QueryDBController.class);
	
	private PersonDao personDao;
	
	@RenderMapping
	public String showForm(){
		LOG.info("Show query form");
		return "queryForm";
	}
	
	@ResourceMapping("countPersons")
	public void getPersonsInfo(ResourceRequest request, ResourceResponse response) throws IOException {
		String surname = request.getParameter("surname");
		LOG.info("query for :" + surname);
		OutputStream outStream = response.getPortletOutputStream();
		Long personsCount = personDao.countPersons(surname);
		LOG.info(personsCount + " persons was found");
		StringBuffer buffer = new StringBuffer();
		buffer.append("<span class='results'>");
		buffer.append("found ");
		buffer.append(personsCount);
		buffer.append(" person(s) with the last name ");
		buffer.append(surname);
		buffer.append("</span>");
		outStream.write(buffer.toString().getBytes());
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

}
