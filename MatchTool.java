package org.example.awt;

public class MatchTool {
    public StringBuffer repStr;
    public int strFind(String s1, String s2, int pos){
        int i=0,j=0,k=0;
        while (i < s1.length() && j < s2.length()){
            if (s1.charAt(i) == s2.charAt(j)){
                ++j;
                if(j == s2.length()){
                    k = k+1;
                    i = i-j+1;
                    j = 0;
                }else{
                    i = i-j+1;
                    j = 0;
                }
            }
            ++i;
        }
        return k;
    }

    public int strReplace(String s1, String s2, String s3, int pos){
        int i=0, j=0, k=0;
        repStr = new StringBuffer(s1);
        while (i < repStr.length() && j < s2.length()){
            if(repStr.charAt(i) == s2.charAt(j)){
                ++i;
                ++j;
                if (j == s2.length()){
                    k = k+1;
                    repStr.replace(i-j, i, s3);
                    j = 0;
                }
            }else{
                i = i-j+1;
                j = 0;
            }
        }
        return k;
    }
}
