package org.xpef.server.util;

public class XpNoHandle {

    public static String buildXpNo(Integer id,Integer grade,String region){
        StringBuilder xpNo=new StringBuilder();
        if (region.contains("贵州"))
            xpNo.append("GZ");
        if (region.contains("四川"))
            xpNo.append("SC");
        xpNo.append(grade%100).append("-");
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
        System.out.println(buildXpNo(21,2018,"贵州省贵阳市"));
        System.out.println(removePredix(buildXpNo(21,2018,"贵州省贵阳市")));
    }
}
