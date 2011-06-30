package com.jeroenreijn;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.cocoon.pipeline.NonCachingPipeline;
import org.apache.cocoon.pipeline.Pipeline;
import org.apache.cocoon.sax.SAXPipelineComponent;
import org.apache.cocoon.sax.component.CleaningTransformer;
import org.apache.cocoon.sax.component.XMLGenerator;
import org.apache.cocoon.sax.component.XMLSerializer;
import org.apache.cocoon.sax.component.XSLTTransformer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Rss parser that uses Cocoon 3 for generating and transforming the RSS feed to a simple XML response.
 */
public class RSSParser {

    private static final Log LOG = LogFactory.getLog(RSSParser.class);
    private String feedURL;

    /**
     * Parse the provided feed URL and generate the Feed INFO.
     */
    public void parse() {
        try {
            Pipeline<SAXPipelineComponent> pipeline = new NonCachingPipeline<SAXPipelineComponent>();
            XSLTTransformer xsltTransformer = new XSLTTransformer(this.getClass().getClassLoader().getResource("simplify-rss.xsl"));

            pipeline.addComponent(new XMLGenerator(new URL(getFeedURL())));
            pipeline.addComponent(new CleaningTransformer());
            pipeline.addComponent(xsltTransformer);
            pipeline.addComponent(new XMLSerializer().setIndent(true));
            pipeline.setup(System.out);
            pipeline.execute();

        } catch (MalformedURLException e) {
            LOG.error("An exception occurred while parsing the RSS URL: " + e.getMessage());
        } catch (FileNotFoundException e) {
            LOG.error("An exception occurred while parsing the RSS URL: " + e.getMessage());
        } catch (Exception e) {
            LOG.error("An exception occurred trying to parse the RSS feed: " + e.getMessage());
        }
    }

    public String getFeedURL() {
        return feedURL;
    }

    public void setFeedURL(final String feedURL) {
        this.feedURL = feedURL;
    }
}
