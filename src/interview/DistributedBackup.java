package interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DistributedBackup {
		public static void main(String args[]) throws Exception {
			List<Set<Integer>> inputsets = null;//存输入的数据中心
			Set<Integer> inputdata = null;//存所有输入的数据
			Map<Integer, Integer> reversedIndex = null;//存每个数组所对应的数据中心的索引

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			inputdata = new HashSet<Integer>();
			reversedIndex = new HashMap<Integer, Integer>();
	        
			//获取第一行数字：数据中心数量
			String line = br.readLine();
			int num = Integer.parseInt(line);
			inputsets = new ArrayList<Set<Integer>>(num);
			for (int i = 0; i < num; i++) {
				String[] data = br.readLine().split(" ");//通过空格解析数据
				HashSet<Integer> hs = new HashSet<Integer>(data.length);
				inputsets.add(hs);
				if (data.length == 1) {
					continue;
				}
				//读取数据组的数量
				int size = Integer.parseInt(data[0]);
				for (int j = 1; j < size+1; j++) {
					int tmp = Integer.parseInt(data[j]);
					hs.add(tmp);
					inputdata.add(tmp);//得到所有的数据
					if (!reversedIndex.containsKey(tmp)) {
						//将所有数据对应的包含该数据的一个数据中心的索引存起来
						reversedIndex.put(tmp, i + 1);
					}
				}
			}

			//依次比较每个数据中心和总数据之间的差别，如果有缺数据就执行拷贝数据步骤并打印出来
			for (int i = 0; i < inputsets.size(); i++) {
				Set<Integer> s = inputsets.get(i);
				for (Integer j : inputdata) {
					if (!s.contains(j)) {
						System.out.println(j + " " + reversedIndex.get(j) + " "
								+ (i + 1));
					}
				}
			}
			//数据备份结束
			System.out.println("done");
		}
	
}
