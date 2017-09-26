package main;

import beers.BeersController;
import beers.BeersFilterValidator;
import breweries.BreweryController;
import breweries.BreweryFilterValidator;
import common.BreweryApiDao;
import styles.BrewingStylesController;

public class Main {
	public static void main(String args[]) {
		// System.out.println("My main arg is: " + args[0] + " " + args[1]);

		if ("brewery".equals(args[0])) {
			runBrewController(args[1]);
		}
		if ("style".equals(args[0])) {
			runStyleController();
		}
		if ("beers".equals(args[0])) {
			runBeersController(args[1]);
		}
	}

	private static void runBrewController(String filter) {
		BreweryController bc = new BreweryController(new BreweryApiDao(), new BreweryFilterValidator());
		String result = bc.obtainBrewerInfoByFilter(filter);
		System.out.println(result);
	}

	private static void runStyleController() {
		BrewingStylesController bsc = new BrewingStylesController(new BreweryApiDao());
		String result = bsc.obtainBrewingStyles();
		System.out.println(result);
	}

	private static void runBeersController(String filter) {
		BeersController bc = new BeersController(new BreweryApiDao(), new BeersFilterValidator());
		String result = bc.obtainBeersByFilter(filter);
		System.out.println(result);
	}
}
