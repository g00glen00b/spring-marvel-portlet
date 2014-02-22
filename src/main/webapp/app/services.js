angular.module("marvelApp.services").service("MarvelService", function($resource) {
	var transformQuery = function(data) {
		var output = null;
		if (data !== null && data !== undefined) {
			output = $.param(data);
		}
		return output;
	};
	
	return $resource(MARVEL_SERVICE_URL.CHARACTERS, {
		page: '@page',
		id: '@id'
	}, {
		getCharacters: {
			method: "GET",
			url: MARVEL_SERVICE_URL.CHARACTERS,
			transformRequest: transformQuery
		}
	});
});