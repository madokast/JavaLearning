package XML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;

public class MyJsoupTest {
    public static void main(String[] args) throws Exception{
        final Document parse = Jsoup.parse(new File("D:/Desktop/workflowy-export.opml"), "utf-8");
        System.out.println("parse = " + parse);

        final Elements outline = parse.getElementsByTag("outline");
        System.out.println("outline.size() = " + outline.size());

        final Elements note = parse.getElementsByAttribute("_note");
        System.out.println("note.size() = " + note.size());
    }
}
