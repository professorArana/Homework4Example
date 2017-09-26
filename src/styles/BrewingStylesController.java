package styles;

import common.IBreweryApiDao;

public class BrewingStylesController {
	IBreweryApiDao brewDao;

	public BrewingStylesController(IBreweryApiDao brewDao) {
		this.brewDao = brewDao;
	}

	public String obtainBrewingStyles() {
		// call beerDb API
		String url = "http://api.brewerydb.com/v2/styles?key=a6a536de870a1b8f3408c92eae7971a6";
		String json = brewDao.getJson(url, 0);
		// format API output
		return json;
	}
}
