package com.jeroenreijn;

/**
 * RSS Feed info generator
 * @author Jeroen Reijn
 */
public class RSSFeedInfoGenerator {

    private static final String DEFAULT_RSS_URL = "http://blog.jeroenreijn.com/feeds/posts/default?alt=rss";

    public static void main(String[] args) {
        RSSParser parser = new RSSParser();
        if(args!=null && args.length > 0) {
            parser.setFeedURL(args[0]);
        } else {
            parser.setFeedURL(DEFAULT_RSS_URL);
        }
        parser.parse();

    }
}
