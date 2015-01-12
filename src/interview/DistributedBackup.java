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
			List<Set<Integer>> inputsets = null;//���������������
			Set<Integer> inputdata = null;//���������������
			Map<Integer, Integer> reversedIndex = null;//��ÿ����������Ӧ���������ĵ�����

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			inputdata = new HashSet<Integer>();
			reversedIndex = new HashMap<Integer, Integer>();
	        
			//��ȡ��һ�����֣�������������
			String line = br.readLine();
			int num = Integer.parseInt(line);
			inputsets = new ArrayList<Set<Integer>>(num);
			for (int i = 0; i < num; i++) {
				String[] data = br.readLine().split(" ");//ͨ���ո��������
				HashSet<Integer> hs = new HashSet<Integer>(data.length);
				inputsets.add(hs);
				if (data.length == 1) {
					continue;
				}
				//��ȡ�����������
				int size = Integer.parseInt(data[0]);
				for (int j = 1; j < size+1; j++) {
					int tmp = Integer.parseInt(data[j]);
					hs.add(tmp);
					inputdata.add(tmp);//�õ����е�����
					if (!reversedIndex.containsKey(tmp)) {
						//���������ݶ�Ӧ�İ��������ݵ�һ���������ĵ�����������
						reversedIndex.put(tmp, i + 1);
					}
				}
			}

			//���αȽ�ÿ���������ĺ�������֮��Ĳ�������ȱ���ݾ�ִ�п������ݲ��貢��ӡ����
			for (int i = 0; i < inputsets.size(); i++) {
				Set<Integer> s = inputsets.get(i);
				for (Integer j : inputdata) {
					if (!s.contains(j)) {
						System.out.println(j + " " + reversedIndex.get(j) + " "
								+ (i + 1));
					}
				}
			}
			//���ݱ��ݽ���
			System.out.println("done");
		}
	
}
