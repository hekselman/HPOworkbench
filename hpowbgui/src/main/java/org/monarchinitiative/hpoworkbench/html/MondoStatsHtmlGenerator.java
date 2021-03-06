package org.monarchinitiative.hpoworkbench.html;


import org.monarchinitiative.hpoworkbench.analysis.MondoStats;

public class MondoStatsHtmlGenerator {

    private static final String HTML_TEMPLATE = "<!DOCTYPE html>" +
            "<html lang=\"en\"><head>" +
            "<style>%s</style>\n" +
            "<meta charset=\"UTF-8\"><title>Mondo: descriptive statistics</title></head>" +
            "<body>" +
            "%s \n" + // the Mondo , summary, and the annotation HTML code go here
            "</body></html>";

    public static String getHTML(MondoStats stats) {

        return String.format(HTML_TEMPLATE,Css.getCSS(),getCounts(stats));
    }

    private static String getCounts(MondoStats stats) {
        StringBuilder sb = new StringBuilder();

        sb.append("<h1>MONDO Statistics</h1>");
        sb.append("<ol>");
        sb.append("<li>Number of terms: ").append(stats.getN_termCount()).append("</li>");
           sb.append("<li>Number of terms with a textual definition: ").append(stats.getN_definition()).append("</li>");
        sb.append("<li>Number of synonyms: ").append(stats.getN_synonyms()).append("</li>");

        sb.append("<li>Number of  relations: ").append(stats.getN_relations()).append("</li>");
        sb.append("<li>Number of  obsolete terms: ").append(stats.getN_obsoleteTermCount()).append("</li>");
        sb.append("<li>Number of  non-obsolete terms: ").append(stats.getN_nonObsoleteTermCount()).append("</li>");
        for (String key : stats.getMetaInfo().keySet()) {
            sb.append("<li>").append(key).append(": ").append(stats.getMetaInfo().get(key)).append("</li>");
        }
        sb.append("</ol>");
        return sb.toString();
    }
}
