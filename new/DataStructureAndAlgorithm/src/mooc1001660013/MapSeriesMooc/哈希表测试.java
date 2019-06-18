package mooc1001660013.MapSeriesMooc;

import java.util.Random;
import java.util.stream.Stream;

public class 哈希表测试 {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static String randomString() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        Stream.generate(()->(char)('A'+random.nextInt('z'-'A'))).limit(3).forEach(e->stringBuilder.append(e));
        return stringBuilder.toString();
    }

    private static void test2() {
        MapMooc mapMooc = new MapMooc(8);
        Stream.generate(哈希表测试::randomString).limit(50).forEach(e->mapMooc.insert(e,e.hashCode()%1000));
        System.out.println("-------------打印map-------------");
        mapMooc.printMap();

        System.out.println();
        String key = mapMooc.entries().iterator().next().key;
        System.out.println("删除："+key);
        mapMooc.delete(key);
        System.out.println("-------------打印map-------------");
        mapMooc.printMap();

        //-------------打印map-------------
        //arr[0]->("fXB"->816)->("Q`g"->920)->("toc"->16)
        //arr[1]->("QLd"->297)->("WqK"->185)->("WRD"->217)->("tfK"->713)->("WY["->457)->("AIq"->841)->("d[X"->9)
        //arr[2]->("HNh"->714)->("sgF"->778)->("GFq"->514)
        //arr[3]->("_oS"->819)->("UMk"->179)->("nZG"->571)->("mtZ"->435)->("U`F"->731)->("EAO"->403)->("\]D"->363)
        //arr[4]->("DpP"->900)->("Bn`"->932)->("bPZ"->748)->("bWI"->948)->("[ib"->804)
        //arr[5]->("ijF"->261)->("EWG"->77)->("dbk"->245)->("[\n"->413)->("fRy"->685)->("AEa"->701)->("Zor"->45)->("tZk"->373)
        //arr[6]->("VwG"->406)->("^Qa"->942)->("vBR"->526)->("yyf"->134)->("UKl"->118)->("jOc"->414)->("XSy"->262)->("DfH"->582)->("Dm_"->822)
        //arr[7]->("d\G"->23)->("pwn"->431)->("Kos"->631)->("xkb"->735)->("ft]"->711)->("Dna"->855)->("dSN"->751)->("B_\"->463)
        //
        //删除：Bn`
        //存在链，删除--1
        //-------------打印map-------------
        //arr[0]->("fXB"->816)->("Q`g"->920)->("toc"->16)
        //arr[1]->("QLd"->297)->("WqK"->185)->("WRD"->217)->("tfK"->713)->("WY["->457)->("AIq"->841)->("d[X"->9)
        //arr[2]->("HNh"->714)->("sgF"->778)->("GFq"->514)
        //arr[3]->("_oS"->819)->("UMk"->179)->("nZG"->571)->("mtZ"->435)->("U`F"->731)->("EAO"->403)->("\]D"->363)
        //arr[4]->("DpP"->900)->("bPZ"->748)->("bWI"->948)->("[ib"->804)
        //arr[5]->("ijF"->261)->("EWG"->77)->("dbk"->245)->("[\n"->413)->("fRy"->685)->("AEa"->701)->("Zor"->45)->("tZk"->373)
        //arr[6]->("VwG"->406)->("^Qa"->942)->("vBR"->526)->("yyf"->134)->("UKl"->118)->("jOc"->414)->("XSy"->262)->("DfH"->582)->("Dm_"->822)
        //arr[7]->("d\G"->23)->("pwn"->431)->("Kos"->631)->("xkb"->735)->("ft]"->711)->("Dna"->855)->("dSN"->751)->("B_\"->463)
    }

    private static void test1() {
        MapMooc mapMooc = new MapMooc(8);
        mapMooc.insert("ABC",123);
        mapMooc.insert("ABC",321);
        mapMooc.print();
        //插入成功
        //旧值跟新
        //[("ABC"->321)]

        mapMooc.insert("Aa",5);
        mapMooc.insert("BB",-5);
        mapMooc.print();
        //插入成功
        //出现冲突，链上
        //[("Aa"->5), ("BB"->-5), ("ABC"->321)]

        System.out.println(mapMooc.size());//3
        System.out.println("-----------------");

        mapMooc.delete("A");
        //集合中没有对应的key，删除失败

        mapMooc.delete("ABC");
        mapMooc.print();
        //没有链，直接删除
        //[("Aa"->5), ("BB"->-5)]

        mapMooc.delete("BB");
        mapMooc.print();
        //存在链，删除
        //[("Aa"->5)]

        mapMooc.insert("Aa",233);
        mapMooc.insert("BB",233456);
        //旧值跟新
        //出现冲突，链上
        mapMooc.print();
        //[("Aa"->233), ("BB"->233456)]

        System.out.println("---------------------");
        mapMooc.delete("Aa");
        mapMooc.print();

        System.out.println("---------------------");
        mapMooc.insert("Aa",233);
        mapMooc.insert("Aa",233);
        mapMooc.insert("Aa",233);
        mapMooc.insert("BB",233);
        mapMooc.insert("BB",233);
        mapMooc.insert("CCC",345);
        mapMooc.insert("CCC",345);
        mapMooc.print();
        //[("BB"->233), ("Aa"->233), ("CCC"->345)]

        System.out.println("-----------------");
        mapMooc.printMap();
    }
}
