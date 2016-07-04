package com.candyspace.androidtest.api;


import retrofit.Callback;
import retrofit.http.GET;

interface MostPopularService {

	@GET ("/svc/mostpopular/v2/mostviewed/all-sections/1.json?api-key=102f3f64bc5638cb6e3b566f87bd8db7:19:73578649")
	void mostPopular(Callback<Response> callback);

}
