package beers;

import common.IBreweryApiDao;

public class BeersController {
	IBreweryApiDao brewDao;
	IBeersFilterValidator beersFilter;

	public BeersController(IBreweryApiDao brewDao, IBeersFilterValidator beersFilter) {
		this.brewDao = brewDao;
		this.beersFilter = beersFilter;
	}

	public String obtainBeersByFilter(String filter) {
		if (!beersFilter.isValid(filter)) {
			return "invalid beer filters";
		}
		// call beerDb API
		String url = "http://api.brewerydb.com/v2/beers?" + filter + "&key=a6a536de870a1b8f3408c92eae7971a6";
		String json = brewDao.getJson(url, 0);
		// format API output
		return json;
	}

}
