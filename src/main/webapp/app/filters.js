angular.module("marvelApp.filters").filter("Thumbnail", function() {
	return function(thumbnail) {
		return thumbnail.path + "." + thumbnail.extension;
	};
})
.filter("Timeago", function() {
	return function(date) {
		return moment(date).fromNow();
	};
});