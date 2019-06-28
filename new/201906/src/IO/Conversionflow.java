package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.http.WebSocketHandshakeException;
import java.nio.charset.Charset;

/**
 * 转换流 382.flv
 * 字符编码&解码
 *      encoding decode
 * 字符集
 *  ascii  /  iso-8859-1
 *  gbk / gb2313 gbk gb18030
 *  unicode  -8  -16  -32
 */
public class Conversionflow {
    public static void main(String[] args) throws Exception{
        File file = new File("./text.txt");
        System.out.println(file.exists());
        FileReader fileReader = new FileReader(file);//super(new FileInputStream(file));
        int a;
        while ((a=fileReader.read())!=-1) {
            System.out.print((int)a+"->"+(char) a+"->"+Integer.toBinaryString(a)+"   ");//���
        }
        System.out.println();
        fileReader.close();

        fileReader = new FileReader(file, Charset.forName("GBK"));
        while ((a=fileReader.read())!=-1) {
            System.out.print((int)a+"->"+(char) a+"->"+Integer.toBinaryString(a)+"   ");//你好
        }
        System.out.println();
        fileReader.close();
        //底层是StreamDecoder在读
        //所以知道每次读几个

        FileInputStream fileInputStream = new FileInputStream(file);
        int b;
        while((b=fileInputStream.read())!=-1){
            System.out.print((byte)b+"->"+Integer.toBinaryString(b)+"   ");
        }


        //----------------------GBK---------------------------------
        //65533->�->1111111111111101   65533->�->1111111111111101   65533->�->1111111111111101
        //解码失败的表示？

        //20320->你->100111101100000   22909->好->101100101111101
        //已经解码了？
        //所以和下面的对不上

        //-60->11000100   -29->11100011   -70->10111010   -61->11000011
        //这才是最原始的存储方式？

        //--------------------UTF-8----------------------------------
        //20320->你->100111101100000   22909->好->101100101111101
        //28003->浣->110110101100011   29362->犲->111001010110010   12477->ソ->11000010111101
        //-28->11100100   -67->10111101   -96->10100000   -27->11100101   -91->10100101   -67->10111101
    }
}
