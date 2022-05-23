package Stru;

public class MyStringTest {

    public static void main(String[] args) {
        char[] s1 = new char[]{'M','y','S','t','r','i','n','g','.'};
        char[] s2 = new char[]{'S','t','r','i','n','g'};
        MyString string1 = new MyString(s1);
        MyString string2 = new MyString(s2);

        System.out.println(string1.print());
        System.out.println("长度为："+string1.getLength()+" 是否为空串"+string1.isEmpty());
        System.out.println(string1.CharAt(2));
        System.out.println("比较两个字符串是否相等"+string1.equals(string2)+"  "+string1.equals(string2));
        System.out.println("截取字符串：");
        System.out.println((string1.substring(0, 3)).print());
        string2 = string1.concat(string2);
        System.out.println("拼接字符串:");
        System.out.println(string2.print());
        System.out.println("字符S在字符串中第一次出现的位置："+string1.indexOf('S',2));
        System.out.println("替换字符串中的字符: ");
        System.out.println((string2.replace('i','3')).print());

    }
}
