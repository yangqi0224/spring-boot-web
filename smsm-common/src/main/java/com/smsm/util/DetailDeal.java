package com.smsm.util;

import com.smsm.model.Recruitment;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetailDeal {

    public static List<String> deal(String text){
        List<String> list = new ArrayList<String>();
        if (text!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(text);
            text = m.replaceAll("");
        }
        StringBuilder sb = new StringBuilder(text.trim());
        int start,end;
        start = end = 0;
        int length = sb.length();
        for (;end<length;end++){
            if(sb.charAt(end) == ';' ||sb.charAt(end) == '；'||end == length-1){
                if(end==start){
                    start++;
                    continue;
                }
                list.add(sb.substring(start,end+1));
                start = end+1;
            }

        }
        return list;
    }

    public static void salaryDeal(Recruitment recruitment){

        if (recruitment.getJobName()!=null)
            if (recruitment.getJobName().equals(""))
                recruitment.setJobName(null);
        if (recruitment.getJobCity()!=null)
            if (recruitment.getJobCity().equals("") || recruitment.getJobCity().equals("全国"))
                recruitment.setJobCity(null);
        if (recruitment.getJobSalary()!=null)
            if (recruitment.getJobSalary().equals(""))
                recruitment.setJobSalary(null);
        if (recruitment.getJobPro()!=null)
            if (recruitment.getJobPro().equals(""))
                recruitment.setJobPro(null);
        if (recruitment.getExceptionEducation()!=null)
            if (recruitment.getExceptionEducation().equals(""))
                recruitment.setExceptionEducation(null);
        if (recruitment.getJobYear()!=null)
            if (recruitment.getJobYear().equals(""))
                recruitment.setJobYear(null);



        String salary;
        if ((salary = recruitment.getJobSalary())!=null && !salary.equals("")){
            String max = "";
            String min = "";

            if (salary.equals("50k以上")){
                recruitment.setSalaryMax(9999);
                recruitment.setSalaryMin(50);
                return;
            }

            for (int i = 0;i<salary.length();i++){
                if (i<3){
                    if (salary.charAt(i)!='k' && salary.charAt(i)!='-')
                        min+=salary.charAt(i);
                }else {
                    if (salary.charAt(i)!='-' && salary.charAt(i)!='k')
                        max+=salary.charAt(i);
                }
            }
            recruitment.setSalaryMin(Integer.parseInt(min));
            recruitment.setSalaryMax(Integer.parseInt(max));
        }
    }
    /**
     * 测试
     */
    /*public static void main(String[] args) {
        String vi = "写字楼里写字间，写字间里程序员；\n" +
                "程序人员写程序，又拿程序换酒钱。;\n" +
                "酒醒只在网上坐，酒醉还来网下眠；\n" +
                "酒醉酒醒日复日，网上网下年复年。;\n" +
                "但愿老死电脑间，不愿鞠躬老板前；;\n" +
                "奔驰宝马贵者趣，公交自行程序员。;\n" +
                "别人笑我忒疯癫，我笑自己命太贱；\n" +
                "不见满街漂亮妹，哪个归得程序员？;";
        System.out.println(vi.trim());
        List<String> list = deal(vi);

        int n = 1;
        for (String i:list){
            System.out.println(n+"、"+i);
            n++;
        }
    }*/
}
