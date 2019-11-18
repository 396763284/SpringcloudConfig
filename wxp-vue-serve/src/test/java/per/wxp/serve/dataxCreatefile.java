package per.wxp.serve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dataxCreatefile {

    public static void main(String[] args) throws IOException, InterruptedException {

        String name= "E:/code/mysql_csv.json";

        String cmd="python E:/code/datax/bin/datax.py "+name;
        Process pr = Runtime.getRuntime().exec(cmd);
        BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
        pr.waitFor();
        String a="\"\\";
    }




}
