package dep;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��ʾһ��ѭ��������ѭ�����������½�
 * @author ylt
 *
 */
public class LoopBounds{
	public LoopBounds(){
		list=new ArrayList<LoopBound>();
	}
	public LoopBounds(List<LoopBound> list){
		this.list=list;
	}
	public LoopBounds(List<LoopBound> list,List<String> names){
		this.list=list;
		setNames(names);
	}
	/**
	 * ����ѭ�����������½���б������ѭ���������ڲ�ѭ��������
	 */
	private List<LoopBound> list;
	/**
	 * ѭ������x�����֡�ע�����Ƶ�˳���ɾ���A�������������listѭ��һ����ͬ��
	 */
	private List<String> names;
	
	public void add(LoopBound b){
		list.add(b);
		b.setBounds(this);
	}
	
	public List<LoopBound> getList() {
		return list;
	}
	public void setList(List<LoopBound> list) {
		this.list = list;
	}
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		assert list.size()==names.size();
		this.names = names;
	}
	
	public LoopBounds setNames(String[] ss){
		setNames(Arrays.asList(ss));
		return this;
	}
	
	/**
	 * �õ�ѭ���е�i������������
	 */
	public String getName(int i){
		if(names==null) return "x"+i;
		return names.get(i);
	}
	
	public void prettyPrint(PrintStream out){
		for(int i=0;i<list.size();i++){
			for(int j=0;j<i;j++) out.print(" ");
			list.get(i).prettyPrint(out);
		}
	}
}