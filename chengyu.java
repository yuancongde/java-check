package check_image;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class chengyu{
	@SuppressWarnings("resource")
	public List<String> input_chengyu(){
		List<String> list = new ArrayList<String>();
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("D://trian_data//chengyu.txt"),"UTF-8"));
			String s = null;
			while((s=br.readLine()) != null){
				list.add(s);
			}
			return list;
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
}
