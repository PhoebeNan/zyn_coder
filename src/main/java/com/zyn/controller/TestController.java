package com.zyn.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Api(tags = {"zyn的功能接口"})
@RestController
public class TestController {



    @GetMapping("/seata")
    public String seata()  {

        System.out.println("=======");
       return "success";
    }






    //D:\txtDir
    @ApiOperation(value = "将一个目录下所有文件名称中的空格和()去除掉", notes = "注意问题点，例如：D:\\txtDir")
    @GetMapping("/liuManRenameFile")
    public String liuManRenameFile(@ApiParam(name = "dir", value = "文件路径", required = true)
                                   @RequestParam("dir") String dir) {

        //初始化 找到文件夹
        File file = new File(dir);
        //返回文件夹里面的内容
        File[] listFiles = file.listFiles();
        //遍历出来
        for (File file2 : listFiles) {


            String name = file2.getName().trim();
            String regEx = "[()]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(name);
            String name2 = m.replaceAll("");

            //找到文件
            //打印看一下

            //初始化需要的文件
            File file1 = new File(dir, file2.getName());
            //初始化我要修改的文件名字
            File file3 = new File(dir, name2);
            //修改
            file1.renameTo(file3);
        }


        return "success";
    }

    @Resource
    private ThreadPoolTaskExecutor executor;

    @GetMapping("/zyn")
    @ApiOperation(value = "测试我的云服务器接口", notes = "注意问题点")
    public String zyn() throws ExecutionException, InterruptedException {

        List<Future<Integer>> list = new ArrayList<>();


        for (int i = 0; i < 2; i++) {

            int finalI = i;
            Future<Integer> submit = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {

                    System.out.println("******111");
                    System.out.println(Thread.currentThread().getName());

                    System.out.println("******2");

                    if (finalI == 0) {
                        return 0;

                    } else {
                        return 1;
                    }

                }
            });

            if (submit.get()==null){
                System.out.println("zyn");
            }
            list.add(submit);

            System.out.println("******");

        }

        for (Future<Integer> future : list) {
            Integer integer = future.get();

            System.out.println(integer+"=======");

        }


        return "success";
    }


    Boolean flag = true;

    @GetMapping("/batch")
    @ApiOperation(value = "测试停止接口", notes = "注意问题点")
    public Map<String, Object> batch() {


        flag = !flag;

        long currentTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
        Date date = new Date(currentTime);
        String format = formatter.format(date);
        Map<String, Object> map = new HashMap<>();
        map.put("result:", "赵亚楠的云服务器");
        map.put("当前时间为:", format);

        return map;
    }


}
