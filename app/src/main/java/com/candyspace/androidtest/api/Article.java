package com.candyspace.androidtest.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
Sample article in JSON:

{
  "url": "http:\/\/www.nytimes.com\/2015\/11\/25\/world\/europe\/turkey-syria-russia-military-plane.html",
  "adx_keywords": "Airlines and Airplanes;North Atlantic Treaty Organization;Syria",
  "column": "",
  "section": "World",
  "byline": "By CEYLAN YEGINSU and NEIL MacFARQUHAR",
  "type": "Article",
  "title": "Turkey Shoots Down Russian Warplane Near Syrian Border",
  "abstract": "President Vladimir V. Putin of Russia confirmed that an F-16 Turkish fighter jet brought down a Russian aircraft that he said had remained in Syrian airspace.",
  "published_date": "2015-11-25",
  "source": "The New York Times",
  "id": 1.0000000405547e+14,
  "asset_id": 1.0000000405547e+14,
  "views": 1,
  "des_facet": [
	"AIRLINES AND AIRPLANES"
  ],
  "org_facet": [
	"NORTH ATLANTIC TREATY ORGANIZATION"
  ],
  "per_facet": "",
  "geo_facet": [
	"SYRIA"
  ],
  "media": [
	{
	  "type": "image",
	  "subtype": "photo",
	  "caption": "A military plane in flames after being shot down by Turkish fighter jets near to the Syrian border on Tuesday.",
	  "copyright": "Fatih Akta\/Anadolu Agency, via Getty Images",
	  "media-metadata": [
		{
		  "url": "http:\/\/static01.nyt.com\/images\/2015\/11\/25\/world\/25Turkey-web\/25Turkey-web-square320.jpg",
		  "format": "square320",
		  "height": 320,
		  "width": 320
		},
		{
		  "url": "http:\/\/static01.nyt.com\/images\/2015\/11\/25\/world\/25Turkey-web\/25Turkey-web-thumbStandard.jpg",
		  "format": "Standard Thumbnail",
		  "height": 75,
		  "width": 75
		},
		{
		  "url": "http:\/\/static01.nyt.com\/images\/2015\/11\/25\/world\/25Turkey-web\/25Turkey-web-articleInline-v2.jpg",
		  "format": "Normal",
		  "height": 127,
		  "width": 190
		},
		{
		  "url": "http:\/\/static01.nyt.com\/images\/2015\/11\/25\/world\/25Turkey-web\/25Turkey-web-sfSpan-v2.jpg",
		  "format": "Large",
		  "height": 263,
		  "width": 395
		},
		{
		  "url": "http:\/\/static01.nyt.com\/images\/2015\/11\/25\/world\/25Turkey-web\/25Turkey-web-jumbo-v2.jpg",
		  "format": "Jumbo",
		  "height": 682,
		  "width": 1024
		},
		{
		  "url": "http:\/\/static01.nyt.com\/images\/2015\/11\/25\/world\/25Turkey-web\/25Turkey-web-superJumbo-v2.jpg",
		  "format": "superJumbo",
		  "height": 714,
		  "width": 1072
		},
		{
		  "url": "http:\/\/static01.nyt.com\/images\/2015\/11\/25\/world\/25Turkey-web\/25Turkey-web-thumbLarge.jpg",
		  "format": "Large Thumbnail",
		  "height": 150,
		  "width": 150
		},
		{
		  "url": "http:\/\/static01.nyt.com\/images\/2015\/11\/25\/world\/25Turkey-web\/25Turkey-web-mediumThreeByTwo210-v2.jpg",
		  "format": "mediumThreeByTwo210",
		  "height": 140,
		  "width": 210
		},
		{
		  "url": "http:\/\/static01.nyt.com\/images\/2015\/11\/25\/world\/25Turkey-web\/25Turkey-web-mediumThreeByTwo440-v2.jpg",
		  "format": "mediumThreeByTwo440",
		  "height": 293,
		  "width": 440
		}
	  ]
	}
  ]
}
 */

public class Article {

	@SerializedName("url")
	private String url;
	@SerializedName("title")
	private String title;
	@SerializedName("abstract")
	private String body;

	@SerializedName("media")
	private List<Media> mediaList;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Media> getMediaList() {
		return mediaList;
	}

	public void setMediaList(List<Media> media) {
		this.mediaList = media;
	}

	public static class Media {

		@SerializedName("type")
		private String type;

		@SerializedName("media-metadata")
		private List<MediaMetadata> mediaMetadataList;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public List<MediaMetadata> getMediaMetadataList() {
			return mediaMetadataList;
		}

		public void setMediaMetadataList(List<MediaMetadata> mediaMetadataList) {
			this.mediaMetadataList = mediaMetadataList;
		}

		public static class MediaMetadata {

			@SerializedName("url")
			private String url;
			@SerializedName("format")
			private String format;

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public String getFormat() {
				return format;
			}

			public void setFormat(String format) {
				this.format = format;
			}

		}

	}

}
