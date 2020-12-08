package space.worldhu.util;

import java.util.Arrays;

/**
 * 下划线字段转驼峰式
 * @author hushicheng
 * @date 2020/12/3
 */
public class FieldUnderScoreToHump {

    public static void main(String[] args) {
        excute("account_id,account_name,agent_name,login_name,pass_word,lock_flag,agent_agreement_no,supplement_agreement_no,"
                + "employee_code,city_code,city_name,insured_code,insured_name,system_code,employee_name,sale_group_code,"
                + "channel_source_code,channel_source_detail_code,channel_type,com_code,com_code_des,make_com,make_com_des,"
                + "monopoly_code,monopoly_name,tax_com_code,tax_com_name");
    }

    public static void excute(String source) {
        String printStr = "GPIC_MAP.put(";
        String[] arr = source.split(",");
        Arrays.stream(arr).forEach(field -> {
            String[] words = field.split("_");
            if (words.length < 2) {
                return;
            }
            StringBuilder hump = new StringBuilder();
            hump.append(words[0].substring(0, 1).toLowerCase())
                    .append(words[0].substring(1));
            for (int i = 1; i < words.length; i++) {
                hump.append(words[i].substring(0, 1).toUpperCase())
                        .append(words[i].substring(1));
            }
            StringBuilder ss = new StringBuilder();
            ss.append("GPIC_").append(field.toUpperCase()).append(", Arrays.asList(\"\", FIELD_STR, \"\", \"\", \"true\", \"true\"));");
            System.out.println(ss.insert(0, printStr).toString());
        });
    }
}
