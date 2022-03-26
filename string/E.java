package com.aojia.practice.string;

/**
 * @author QiTian
 * @date 2022/3/26
 * @Description 151. 颠倒字符串中的单词
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 思路：1.去掉首位空格和 字符串内的多余空格
 *       2.将trim后的字符串整体反转
 *       3.将每个单词反转
 */
public class E {
    public static String reverseWords(String s) {
        StringBuffer sb = trimSpace(s);//先去掉多余空格
        reverse(sb,0,sb.length()-1);//字符串整体反转
        sb=reverseWord(sb);//最后处理单个字符
        return sb.toString();
    }
    public static StringBuffer trimSpace(String s) {
        int left=0,right=s.length()-1;
        while (left<right&&s.charAt(left)==' ')left++;//去掉首部空格
        while (left<right&&s.charAt(right)==' ')right--;//去掉尾部空格
        StringBuffer sb=new StringBuffer();
        //接下来处理字符串中的多余空格
        while (left<=right){//带=号 要取到最后一个索引的元素 将其存入sb
            char c =s.charAt(left);//将left索引所指向的字符存入c
            if (c!=' '){ //该字符不是空格则存入sb
                sb.append(c);
            }else if (sb.charAt(sb.length()-1)!=' '){//不走if 则代表当前字符为空格
                // 所以判断前一个字符 前一个字符不是空格 则可以将当前空格存入sb
                sb.append(c);
            }
            ++left;//移动指针
        }
        return sb;//返回去空格后的字符串
    }
    public static void reverse(StringBuffer sb,int left,int right) {
        while (left<right){
            //首位元素交换  达到反转的效果
            char tmp=sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,tmp);
        }
    }
    public static StringBuffer reverseWord(StringBuffer sb) {
            //拆分单个单词 进行反转
        int start=0,end=0;//使用双指针记录单词位置
        // nd也可以理解为空格的索引  end-1为单词结束索引
        int n=sb.length();//n代表sb的长度
        while (start<n){//外层while 遍历到最后一个元素
            while (end<n&&sb.charAt(end)!=' '){
                ++end;//内层end记录每个单词元素个数
            }
            reverse(sb,start,end-1);//进行逐个单词反转
            start=end+1;//更改下次循环的start位置 开始遍历下一个单词
            ++end;//end 和start 一同初始化到下个单词的起始位置
        }
        return  sb;
    }

    public static void main(String[] args) {
        String s="the sky is blue";
        System.out.println(reverseWords(s));
    }
}
