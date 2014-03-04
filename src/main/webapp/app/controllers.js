angular.module("marvelApp.controllers")

.controller("CharactersCtrl", function($scope, $rootScope, MarvelService) {	
	$scope.model = {
		page: 0,
		data: MarvelService.getCharacters({
			page: 0
		}, function(succ) {
			$scope.failed = false;
		}, function(err) {
			$scope.failed = true;
		})
	};
	
	$scope.failed = false;
	
	$scope.setPage = function(/** Integer */ page) {
		$scope.model.page = page;
		$scope.model.data = MarvelService.getCharacters({
			'page': page
		});
	};
	
	$scope.isNotLastPage = function() {
		return $scope.model.data.data !== undefined && $scope.model.page * $scope.model.data.data.count < $scope.model.data.data.total;
	};
	
	$scope.isNotFirstPage = function() {
		return $scope.model.page !== 0;
	};
	
	$scope.setActive = function(/** Character */ character) {
		$rootScope.$broadcast('be.optis.portal.marvel.active', character);
	};
})
.controller("CharacterCtrl", function($scope) {
	$scope.character = null;
	
	$scope.$on('be.optis.portal.marvel.active', function(evt, character) {
		$scope.character = character;
	});
})
.controller("DetailListCtrl", function($scope) {
	$scope.model = {
		character: null,
		listItem: 0
	};
	
	$scope.$on('be.optis.portal.marvel.active', function(evt, character) {
		$scope.model.character = character;
		$scope.model.listItem = 0;
	});
});