app.controller('HomeCtrl',function($rootScope,BlogPostService,$location)
		{
			BlogPostService.getNotificationNotViewed().then(function(response){
				$rootScope.notifications=response.data
				$rootScope.notificationCount=$rootScope.notifications.length
			},function(response)
				{
				if (response.status==401)
					$location.path('/login')
				})
			
		})