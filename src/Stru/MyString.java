package Stru;

import java.util.ArrayList;

public class MyString {
    private final char[] value;

    //空构造函数
    public MyString(){
        this.value = null;
    }
    //通过MyString构造
    public MyString(MyString s){
        this.value = s.value;
    }
    //通过char数组构造
    public MyString(char[] value) {
        this.value = value;
    }

    //输出字符串
    public char[] print(){
        return value;
    }

    //获取字符串长度
    public int getLength(){
        return value.length;
    }

    //判断字符串是否为空串
    public boolean isEmpty(){
        if(value.length == 0) return true;
        return false;
    }

    //获取字符串的第i个字符
    public char CharAt(int index){
        if(index<0 || index>value.length) throw new StringIndexOutOfBoundsException(index);
        else return value[index-1];
    }

    //比较两个字符串是否相等
    public boolean equals(MyString myString) {
        if(myString == this)
            return true;
        int n = myString.getLength();
        if(n == value.length){
            for(int i = 1;i<=n;i++){
                char c = myString.CharAt(i);
                if(c != value[i-1])
                    return false;
            }
            return true;
        }
        return false;
    }
    //从指定的起始位置开始，对字符串进行截取。
    public MyString substring(int beginIndex) {
        if(beginIndex<0 || beginIndex>value.length) throw new StringIndexOutOfBoundsException(beginIndex);
        int n = value.length-beginIndex;
        int j = 0;
        char[] result = new char[n];
        for(int i = n;i<value.length;i++){
            result[j] = value[i];
            j++;
        }

        return new MyString(result);
    }
    //从指定的起始位置开始，对字符串进行截取。
    public MyString substring(int beginIndex,int endIndex) {
        if(beginIndex<0 ) throw new StringIndexOutOfBoundsException(beginIndex);
        if(endIndex>value.length) throw new StringIndexOutOfBoundsException(beginIndex);
        int n = endIndex-beginIndex+1;
        int j = 0;
        char[] result = new char[n];
        for(int i = beginIndex;i<endIndex;i++){
            result[j] = value[i];
            j++;
        }
        return new MyString(result);
    }

    //将两个字符串进行拼接
    public MyString concat(MyString str) {
        if(str.getLength() == 0) return this;
        int length = value.length+str.getLength();
        char[] result = new char[length];
        int i =0;
        for(;i<value.length;i++){
            result[i] = value[i];
        }
        System.out.println(i);
        for(int j =1;j<=str.getLength();j++){
            char c = str.CharAt(j);
            result[i] = c;
            i++;
        }

        return new MyString(result);
    }
    //返回ch字符第一次在字符串中出现的位置
    public int indexOf(char ch) {

        int index=-1;
        for(int i = 0;i<value.length;i++){
            char c = CharAt(i+1);
            if(c == ch)
                return index=i+1;
        }
        return index;
    }

    //返回ch字符第一次在字符串中出现的位置
    public int indexOf(char ch, int fromIndex) {
        if(fromIndex<0 || fromIndex>value.length) throw new StringIndexOutOfBoundsException(fromIndex);
        int index=-1;
        for(int i = fromIndex;i<value.length;i++){
            char c = CharAt(i+1);
            if(c == ch)
                return index=i+1;
        }
        return index;
    }

    //替换，将字符串中的oldChar字符全部替换成newChar
    public MyString replace(char oldChar, char newChar) {
        if(oldChar != newChar){
            int n = value.length;
            char[] newValue = new char[n];
            for(int i = 0;i<value.length;i++){
                if(value[i] == oldChar)
                    newValue[i] = newChar;
                else newValue[i] = value[i];
            }

            return new MyString(newValue);
        }
        return this;
    }
    //根据切割符号切割字符串
    public MyString[] split(MyString regex, int limit) {
        char ch = 0;
        char[] s=new char[]{'.','$','|','(',')','\'','[','{','^','?','*','+','\\'};
        MyString exclude=new MyString(s);
        if(((regex.getLength() == 1 &&
            exclude.indexOf(ch = regex.CharAt(0)) == -1) ||
            (regex.getLength()== 2 &&
            regex.CharAt(0) == '\\' &&
            (((ch = regex.CharAt(1))-'0')|('9'-ch)) < 0 &&
            ((ch-'a')|('z'-ch)) < 0 &&
            ((ch-'A')|('Z'-ch)) < 0)) &&
            (ch < Character.MIN_HIGH_SURROGATE ||
                        ch > Character.MAX_LOW_SURROGATE)){
            int start = 0;
            int next = 0;
            boolean limited = limit > 0;
            ArrayList<MyString> list = new ArrayList<>();
            while((next = indexOf(ch,start)) != -1){
                if (!limited || list.size() < limit - 1) {
                    list.add(substring(start, next));
                    start = next + 1;
                } else {
                    list.add(substring(start, value.length));
                    start = value.length;
                    break;
                }
            }
            if(start == 0) return new MyString[]{this};

            if (!limited || list.size() < limit)
                list.add(substring(start, value.length));

            int reSize = list.size();
            if(limit==0){
                while (reSize > 0 && list.get(reSize - 1).getLength() == 0) {
                    reSize--;
                }
            }
            MyString[] result = new MyString[reSize];
            return list.subList(0, reSize).toArray(result);

        }
        //返回null，切割符格式错误
        return null;

    }

}
