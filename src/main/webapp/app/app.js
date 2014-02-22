if (window.MARVEL_APP === undefined) {
	angular.module("marvelApp.controllers", []);
	angular.module("marvelApp.filters", []);
	angular.module("marvelApp.services", [ "ngResource" ]);
	MARVEL_APP = angular.module("marvelApp", [ "marvelApp.controllers", "marvelApp.services", "marvelApp.filters" ]);
	angular.element(document).ready(function() {
		// Bootstrapping AngularJS, could be replaced by ng-app attribute if using a theme
		angular.bootstrap("body", [ "marvelApp" ]);
		
		// Loads additional styles, could be moved to <head> if using a theme
		angular.element('head')
			.append('<link rel="stylesheet" href="/wps/PA_Marvel/libs/semantic-ui/build/packaged/css/semantic.min.css" />')
			.append('<link rel="stylesheet" href="/wps/PA_Marvel/assets/css/style.css" />');
	});
	// Fixes moment.js trying to be loaded through AMD if found
	if (define !== undefined && define.amd !== undefined) {
		window.moment = require("moment");
	}
}