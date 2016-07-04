package com.candyspace.androidtest.model;

import android.support.annotation.Nullable;

import com.candyspace.androidtest.api.Article;

import java.util.List;

public class ArticleWrapper {

	private final Article article;

	public ArticleWrapper(Article article) {
		this.article = article;
	}

	/**
	 * Returns the url for an image thumbnail, used in R.layout.grid_item
	 * @return thumbnail image url
	 */
	@Nullable
	public String getThumbImageUrl(){
		List<Article.Media.MediaMetadata> mediaMetadataList = getImageMetadata();
		if(getImageMetadata() != null) {
			return getImageOfType("Large Thumbnail", mediaMetadataList);
		} else {
			return null;
		}
	}

	/**
	 * Returns the url for a hero image, used in R.layout.hero_item
	 * @return hero image url
	 */
	@Nullable
	public String getHeroImageUrl(){
		List<Article.Media.MediaMetadata> mediaMetadataList = getImageMetadata();
		if(getImageMetadata() != null) {
			return getImageOfType("square640", mediaMetadataList);
		} else {
			return null;
		}
	}

	private String getImageOfType(String type, List<Article.Media.MediaMetadata> mediaMetadataList) {
		for(Article.Media.MediaMetadata item : mediaMetadataList) {
			if (item.getFormat().equalsIgnoreCase(type)) {
				return item.getUrl();
			}
		}
		return null;
	}

	private List<Article.Media.MediaMetadata> getImageMetadata() {
		for(Article.Media media : article.getMediaList()) {
			if(media.getType().equalsIgnoreCase("image")) {
				return media.getMediaMetadataList();
			}
		}
		return null;
	}

}
