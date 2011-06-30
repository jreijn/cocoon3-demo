<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output indent="yes"/>

  <xsl:template match="rss">
    <info>
      <xsl:copy-of select="channel/title"/>
      <xsl:copy-of select="channel/lastBuildDate"/>
    </info>
  </xsl:template>

  <xsl:template match="@*|node()|text()|comment()|processing-instruction()" priority="-1">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()|text()|comment()|processing-instruction()" />
    </xsl:copy>
  </xsl:template>

</xsl:stylesheet>