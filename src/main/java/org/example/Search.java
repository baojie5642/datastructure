package org.example;

public class Search {

    private Search() {

    }

    public static final Search create() {
        return new Search();
    }

    // 写的很粗糙，如果想好一点，可以使用string的charAt方法
    // 这里多了一次字符复制
    public final int local4Char(String source, String sub) {
        if (null == source) {
            return -1;
        }
        if (null == sub) {
            return -1;
        }
        int subl = sub.length();
        int soul = source.length();
        if (subl == 0) {
            return -1;
        }
        if (soul == 0) {
            return -1;
        }
        if (subl > soul) {
            return -1;
        }
        return local4Char(str2char(source), str2char(sub));
    }

    private final int local4Char(char[] sou, char[] emp) {
        int begin = 0;
        boolean find = false;
        // 如果剩余元素少于子串并且仍然未找到，则可知已经不存在这样的子串了
        for (; begin < sou.length - emp.length + 1; ) {
            char temp = sou[begin];
            if (temp != emp[0]) {
                begin++;
            } else {
                // 匹配到子串的第一个元素，那么在去比较子串的最后一个元素
                // 在主串中跳过子串长度，去比较在主串中对应位置是否与子串末尾字符一致
                if (sou[begin + emp.length - 1] == emp[emp.length - 1]) {
                    // 如果子串长度1，则找到
                    if (emp.length == 1) {
                        find = true;
                    } else if (emp.length == 2) {
                        // 如果子串长为2，前后都已经匹配到，那么找到
                        find = true;
                    } else {
                        find = innerSearch(sou, emp, begin + 1);
                    }
                    if (find) {
                        break;
                    } else {
                        begin++;
                    }
                } else {
                    begin++;
                }
            }
        }
        if (find) {
            return begin;
        } else {
            return -1;
        }
    }

    private final boolean innerSearch(char[] sou, char[] emp, int copy) {
        boolean find = false;
        // 去掉前后已经比较过的元素
        // 并且子串从第二个元素开始比较
        for (int k = 1; k <= emp.length - 2; k++) {
            if (emp[k] == sou[copy]) {
                find = true;
            } else {
                find = false;
                break;
            }
            copy++;
        }
        return find;
    }

    private final char[] str2char(String str) {
        return str.toCharArray();
    }

    public static final void main(String args[]) {
        Search search = Search.create();
        String source = "C:\\home\\jdk-130164\\bin\\java.exe \"-javaagent:C:" +
                "\\home\\idea\\IntelliJ IDEA Community Edition 2019.3\\lib\\" +
                "idea_rt.jar=56095:C:\\home\\idea\\IntelliJ IDEA Community Edition 2019.3\\" +
                "bin\" -Dfile.encoding=UTF-8 -classpath C:\\home\\workspace\\idea" +
                "\\datastructure\\target\\classes org.example.Search\n";
        String source1 = "q";
        String source2 = "qw";
        String source3 = "qwe";
        String sub = "classpath";
        int find = search.local4Char(source, sub);
        System.out.println(find);
        if (find >= 0) {
            System.out.println(source.charAt(find));
        }

    }

}
