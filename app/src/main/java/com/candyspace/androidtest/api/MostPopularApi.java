package com.candyspace.androidtest.api;

import java.util.List;

public interface MostPopularApi {

	interface Callback {

		/**
		 * Called when articles retrieved successfully
		 * @param articles list of {@link Article}
		 */
		void onSuccess(List<Article> articles);

		/**
		 * Called when article retrieval fails
		 * @param error error message
		 */
		void onFailure(String error);

	}

	/**
	 * Request a list of {@link Article} from the Most Popular API
	 */
	void fetchArticles(Callback callback);

}
