package web;
import java.util.Scanner;

public class BootStrap {

    public static void main(String[] args) {
        ServerManager serverManager=new ServerManager();
        boolean isRun=true;
        @SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
        System.out.println("Input your choice:");
        while(isRun){
            String input=scanner.next();
            switch (input) {
	            case "start":
	                serverManager.Start(81);
	                break;
	            case "stop":
	                serverManager.Stop();
	                isRun=false;
	                break;
	            case "initDataBase":
	            	//初始化数据库
	                break;
	            default:
	                break;
            }
        }
    }

}