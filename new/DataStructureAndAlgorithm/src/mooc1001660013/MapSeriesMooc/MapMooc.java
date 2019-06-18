package mooc1001660013.MapSeriesMooc;

import com.sun.source.tree.CompilationUnitTree;
import mooc1001660013.ListSeriesMooc.LinkedListMooc;
import mooc1001660013.ListSeriesMooc.ListMooc;

import java.lang.ref.SoftReference;
import java.util.*;

/**
 * 散列表
 */
public class MapMooc {
    private EntryLink[] arr;
    private int volume;

    private MapMooc() {
    }

    public MapMooc(int volume) {
        this.volume = volume;
        this.arr = new EntryLink[volume];
    }

    public boolean insert(String key,int value){
        Entry entry = new Entry(key,value);
        EntryLink entryLink = new EntryLink(entry,null);
        //找到应该插入的位置
        int local = key.hashCode()%volume;

        //获取这个位置
        EntryLink old = arr[local];
        //如果为空，直接插入
        if(old==null){
            arr[local]=entryLink;
            System.out.println("插入成功");
            return true;
        }

        //以下说明不为空

        //存储前值，已备用
        EntryLink former = null;
        while (old!=null){
            //旧值跟新
            if(old.entry.key.equals(key)){
                old.entry.value=value;
                System.out.println("旧值跟新");
                return true;
            }

            former = old;
            old=old.next;
        }

        //以下不是旧值跟新，出现冲突
        System.out.println("出现冲突，链上");
        former.next=entryLink;
        return true;
    }

    public int size(){
        int size = 0;
        for (int i = 0; i < volume; i++) {
            EntryLink entryLink = arr[i];
            while (entryLink!=null){
                size++;
                entryLink=entryLink.next;
            }
        }

        return size;
    }

    public Set<Entry> entries(){
        Set<Entry> set = new HashSet<>(size());
        for (int i = 0; i < volume; i++) {
            EntryLink entryLink = arr[i];
            while (entryLink!=null){
                set.add(entryLink.entry);
                entryLink=entryLink.next;
            }
        }

        return set;
    }

    public boolean delete(String key){
        EntryLink entryLink;
        EntryLink former;
        for (int i = 0; i < volume; i++) {
            entryLink = arr[i];
            former = null;
            while (entryLink!=null){
                if(entryLink.entry.key.equals(key)){
                    if(former==null){
                        if(entryLink.next==null){
                            System.out.println("没有链，直接删除");
                            arr[i]=null;
                            return true;
                        }
                        else{
                            System.out.println("存在链，删除--2");
                            arr[i]=entryLink.next;
                            return true;
                        }
                    }
                    else {
                        System.out.println("存在链，删除--1");
                        former.next=entryLink.next;
                        return true;
                    }
                }
                former = entryLink;
                entryLink=entryLink.next;
            }
        }

        System.out.println("集合中没有对应的key，删除失败");
        return false;
    }

    @Override
    public String toString(){
        List<String> list = new LinkedList<>();
        for (int i = 0; i < volume; i++) {
            EntryLink entryLink = arr[i];
            while (entryLink!=null){
                list.add("("+"\""+entryLink.entry.key+"\""+"->"+entryLink.entry.value+")");
                entryLink=entryLink.next;
            }
        }

        return list.toString();
    }

    public void print(){
        System.out.println(toString());
    }

    public void printMap(){
        StringBuilder stringBuilder = new StringBuilder();
        EntryLink entryLink;
        for (int i = 0; i < volume; i++) {
            stringBuilder.delete(0,stringBuilder.length());
            entryLink = arr[i];
            stringBuilder.append("arr["+i+"]");
            if(entryLink==null){
                stringBuilder.append("->null");
            }
            while (entryLink!=null){
                stringBuilder.append("->"+entryLink.entry);
                entryLink = entryLink.next;
            }

            System.out.println(stringBuilder);
        }
    }


    public class Entry {
        public Entry() {
            this.key = "出错";
            this.value = Integer.MAX_VALUE;
        }

        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "("+"\""+key+"\""+"->"+value+")";
        }

        public String key;
        public int value;
    }

    private class EntryLink{
        public EntryLink(Entry entry, EntryLink next) {
            this.entry = entry;
            this.next = next;
        }

        Entry entry;
        EntryLink next;
    }
}
