/**
 * AEM Sightly Workshop Components Controller package.
 */
package cr.prodigious.aem.sightlyworkshop.components.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.adobe.cq.sightly.WCMUse;
import com.day.cq.wcm.api.Page;

import cr.prodigious.aem.sightlyworkshop.components.model.Link;

/**
 * Class to use as a Breadcrumb Controller by extending WCMUse.
 * 
 * @author Rodolfo Oviedo
 */
public class BreadcrumbController extends WCMUse {
	
	@Override
	public void activate() throws Exception {
		
	}
	
	/**
	 * Method to get the breadcrumb links.
	 * 
	 * @param page
	 *            Actual page
	 * 
	 * @return List of links
	 */
	public List<Link> getBreadcrumbLinks() {
		List<Link> links = new ArrayList<Link>();
		Page actualPage = getCurrentPage();

		// Get the path of the links for the current page
		while (actualPage != null) {
			links.add(getBreadcrumbLinkFromPage(actualPage));
			actualPage = actualPage.getParent();
		}

		// Reverse the list of links
		Collections.reverse(links);

		return links;
	}

	/**
	 * Method to adapt a page into a BreadcrumbLink object.
	 * 
	 * @param page
	 *            Actual Page
	 * 
	 * @return BreadcrumbLink object
	 */
	private Link getBreadcrumbLinkFromPage(Page page) {
		Link newBreadcrumbLink = new Link();

		newBreadcrumbLink.setLink(page.getPath());
		newBreadcrumbLink.setTitle(page.getTitle());

		return newBreadcrumbLink;
	}

}
