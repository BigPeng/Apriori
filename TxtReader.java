package aprori;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//本程序用于读取矩阵型的记录数据，并转换为List<List<String>>格式数据
public class TxtReader {

	public List<List<String>> getRecord() {
		List<List<String>> record = new ArrayList<List<String>>();
		try {
			String encoding = "GBK"; // 字符编码(可解决中文乱码问题 )
			File file = new File("simple.txt");
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTXT = null;
				while ((lineTXT = bufferedReader.readLine()) != null) {//读一行文件
					String[] lineString = lineTXT.split("	");
					List<String> lineList = new ArrayList<String>();
					for (int i = 0; i < lineString.length; i++) {//处理矩阵中的T、F、YES、NO
						if (lineString[i].endsWith("T")
								|| lineString[i].endsWith("YES"))
							lineList.add(record.get(0).get(i));
						else if (lineString[i].endsWith("F")
								|| lineString[i].endsWith("NO"))
							;// F，NO记录不保存
						else
							lineList.add(lineString[i]);
					}
					record.add(lineList);
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件！");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容操作出错");
			e.printStackTrace();
		}
		return record;
	}
}
