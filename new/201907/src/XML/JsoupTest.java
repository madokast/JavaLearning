package XML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * jSoup对象
 *  Jsoup——解析器
 *      Jsoup.parse 解析
 *  document——对象内存的中的DOM树
 *      获得element
 *  elements——element对象集合
 *  element——元素对象 标签
 *      获取子元素对象
 *  node——上述对象的爹
 */

public class JsoupTest {
    public static void main(String[] args) throws Exception{
        //document 对象
        final Document parse = Jsoup.parse(
                new File(JsoupTest.class.getClassLoader().getResource("user.xml").getPath()),
                "UTF-8");

        final Elements name = parse.getElementsByTag("name");
        System.out.println("name.size() = " + name.size());

        for (Element e:name

             ) {
            System.out.println("e = " + e);
        }

    }
}
