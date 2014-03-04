angular.module("marvelApp.filters").filter("Thumbnail", function() {
	return function(thumbnail) {
		return thumbnail.path + "." + thumbnail.extension;
	};
})
.filter("Timeago", function() {
	return function(date) {
		return moment(date).fromNow();
	};
})
.filter('StartFrom', function() {
    return function(input, start) {
        return input.slice(parseInt(start));
    };
});