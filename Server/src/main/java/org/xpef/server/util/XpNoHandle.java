package org.xpef.server.util;

public class XpNoHandle {

    public static String buildXpNo(Integer id){
        StringBuilder xpNo=new StringBuilder("XP-");
        StringBuilder s= new StringBuilder();

        while (s.length()<5-String.valueOf(id).length()){
            s.append("0");
        }
        xpNo.append(s).append(String.valueOf(id));
        return xpNo.toString();
    }

    public static Integer removePredix(String xpNo){
        return Integer.parseInt(xpNo.substring(xpNo.indexOf("-")+1));
    }

    public static void main(String[] args) {
        System.out.println(buildXpNo(21));
        System.out.println(removePredix(buildXpNo(21)));
    }
}
