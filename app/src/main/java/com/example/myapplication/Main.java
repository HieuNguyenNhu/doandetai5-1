package com.example.myapplication;

public class Main {
    private static String input;
    private static String[] units= {
            "" ,
            "Một",
            "Hai",
            "Ba" ,
            "Bốn",
            "Năm",
            "Sáu" ,
            "Bảy",
            "Tám",
            "Chín"
    };
    private static String[] teen= {
            "Mười" ,
            "Mười Một",
            "Mười Hai",
            "Mười Ba" ,
            "Mười Bốn",
            "Mười Lăm",
            "Mười Sáu" ,
            "Mười Bảy",
            "Mười Tám",
            "Mười Chín"
    };
    private static String[] tens= {
            "Hai Mươi" ,
            "Ba Mươi",
            "Bốn Mươi",
            "Năm Mươi",
            "Sáu Mươi" ,
            "Bảy Mươi",
            "Tám Mươi",
            "Chín Mươi"
    };
    private static String[] maxs= {
            "Nghin" ,
            "Chuc Nghin",
            "Tram Nghin"
    };

    private String digits(String temp){
        String converted = "";
        for (int i=temp.length()-1;i>=0;i--){
            int ch= temp.charAt(i)-48;
            if(i==0&&ch>1&&temp.length()>1)
                converted=tens[ch-2]+converted;
            else if(i==0&&ch>1 && temp.length()==2){
                int sum=0;
                for(int j=0;j<2;j++)
                    sum=(sum*10)+(temp.charAt(j)-48);
                return teen[sum-10];
            }
            else{
                if(ch>0)
                    converted=units[ch]+converted;
            }
        }
        return converted;
    }
    public String convertNumberToWords(int n){
        input = numToString(n);
        String converted="";
        int pos=1;
        boolean hun=false;
        while( input.length()> 0) {
            if(pos==1) // TENS AND UNIT POSITION
            {
                if (input.length() >= 2) // TWO DIGIT NUMBERS
                {
                    String temp = input.substring(input.length() - 2, input.length());
                    input = input.substring(0, input.length() - 2);
                    converted += digits(temp);
                    //converted = converted.concat(digits(temp));
                } else if (input.length() == 1) // 1 DIGIT NUMBER
                {
                    converted += digits(input);
                    input = "";
                }
                pos++;
            }
            else if(pos==2) // HUNDRED POSITION
                {
                    String temp=input.substring(input.length()-1,input.length());
                    input=input.substring(0, input.length()-1);
                    if(converted.length() > 0 && digits(temp) != "")
                    {
                        converted=(digits(temp)+maxs[pos]+" and" ) + converted;
                        hun=true;
                    }
                    else {
                        if
                        (digits(temp)=="");
                        else
                            converted=(digits(temp) + maxs[pos])+ converted;hun=true;
                        }
                        pos++;
                    } else if (pos > 2)
                    {
                        if(input.length()>=2)
                        {
                            String temp=input.substring(input.length()-2,input.length());
                            input=input.substring(0,input.length()-2);
                            if (!hun&&converted.length()>0)
                                converted=digits(temp)+maxs[pos]+" and"+converted;
                            else{
                                if(digits(temp)=="");
                                else
                                    converted=digits(temp)+maxs[pos]+converted;
                            }

                                }
                        else if(input.length()==1){
                            if(!hun&&converted.length()>0)
                                converted=digits(input)+maxs[pos]+" and"+converted;
                            else{
                                if(digits(input)=="");
                                else
                                    converted=digits(input)+maxs[pos]+converted;
                                input="";
                            }
                        }
                        pos++;
                }

        }
        return converted;
    }
    private String numToString(long x){
        String num ="";
        while (x!=0){
            num = ((char)(x%10) + 48) +num;
            x/=10;
        }
        return num;
    }
}
