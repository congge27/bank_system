package com.bank.demo.controller;

import com.bank.demo.model.Account;
import com.bank.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DataTest {

    @Autowired
    private AccountsumRepository accountsumRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private SummaryRepository summaryRepository;

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @GetMapping(value = "/datainit")
    public int DataInit()
    {


        return 0;
    }

    public void addAccount()
    {
        for(int i=0;i<=5;i++){
            Account account=new Account();
            //account.setAcconut_Id();
        }
    }

    public Date formatOfDate(String date) throws ParseException {
        return new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").parse(date).getTime());
    }

    public static String makeAccountid(Integer siteid)
    {
        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
        //获取时间戳
        String time=dateFormat.format(now);
        String info=now+"";
        //获取三位随机数
        int ran=(int) ((Math.random()*9+1)*100);
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        return time+info.substring(2, info.length())+ran+siteid;
    }

    public static String makeSummaryid()
    {
        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
        //获取时间戳
        String time=dateFormat.format(now);
        String info=now+"";
        //获取三位随机数
        int ran=(int) ((Math.random()*9+1)*100);
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        return time+info+ran;
    }

    public static String makeStaffid(Integer siteid)
    {
        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
        //获取时间戳
        String time=dateFormat.format(now);
        String info=now+"";
        //获取三位随机数
        int ran=(int) ((Math.random()*9+1)*100);
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        return time+info+ran+siteid;
    }

    public static Integer getSiteId(String accountid)
    {
        String s=accountid.substring(accountid.length()-1,accountid.length());
        Integer i=Integer.parseInt(s);
        return i;
    }

    public static String getMD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}
