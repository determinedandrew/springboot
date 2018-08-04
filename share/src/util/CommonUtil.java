package util;
/**
 * for branch1
 */
import java.util.Map;

public class CommonUtil {
	
	public static boolean StringIsEmpty(String string){
		if(string==null||"".equals(string)){
			return true;
		}else{
			return false;
		}
	}
	public static boolean StringIsNotEmpty(String string){
		if(string!=null&&!"".equals(string)){
			return true;
		}else{
			return false;
		}
	}
	public static boolean MapIsEmpty(@SuppressWarnings("rawtypes") Map map){
		if(map==null||map.size()==0){
			return true;
		}else{
			return false;
		}
	}
	public static boolean MapIsNotEmpty(@SuppressWarnings("rawtypes") Map map){
		if(map!=null&&map.size()!=0){
			return true;
		}else{
			return false;
		}
	}
	
}
