This is a small demo project for using Apache Cocoon 3 as a standalone application.

More information about this demo project can be found at:

- http://blog.jeroenreijn.com/2011/03/simple-xml-processing-with-apache.html
- http://cocoon.apache.org/3.0/

## Running this demo

- $ git clone git://github.com/jreijn/cocoon3-demo.git
- $ cd cocoon3-demo
- $ mvn compile
- $ mvn exec:java -Dexec.mainClass="com.jeroenreijn.RSSFeedInfoGenerator" -Dexec.args="http://blog.jeroenreijn.com/feeds/posts/default?alt=rss"
