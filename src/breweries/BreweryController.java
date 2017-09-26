package breweries;

import common.IBreweryApiDao;

public class BreweryController {
	IBreweryApiDao brewDao;
	IBreweryFilterValidator brewFilterValidator;

	public BreweryController(IBreweryApiDao brewDao, IBreweryFilterValidator brewFilterValidator) {
		this.brewDao = brewDao;
		this.brewFilterValidator = brewFilterValidator;
	}
	
	public String obtainBrewerInfoByFilter(String filterString) {
		// validate filter string
		if(!brewFilterValidator.isValid(filterString)) {
			return "Filter string is not valid.";
		}
		// call beerDb API
		String url = "http://api.brewerydb.com/v2/breweries?" + filterString + "&key=a6a536de870a1b8f3408c92eae7971a6";
		String json = brewDao.getJson(url, 0);
		// format API output
		return json;
	}
}
