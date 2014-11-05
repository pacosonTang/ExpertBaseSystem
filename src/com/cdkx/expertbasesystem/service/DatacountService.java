package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.dto.BiPropertyDTO;
import com.cdkx.expertbasesystem.dto.TriPropertyDTO;

/**
 * ��ѧ�ƶԲ�ʿ����Ա����Ŀ�����Ҽ���Ŀ��ʡ����Ŀ�� �м���Ŀ�� ר�������ģ�������һ�Ƚ������Ƚ������Ƚ�����ͳ��
 * @author pacoson
 */
public interface DatacountService {
	
	/**����kwyword ���� ͳ�ƻ�Ա����Ŀ��ר�����ɹ��� ���ĵ� �ٷֱȡ�(int����)
	 * @return 
	 */
	public List<BiPropertyDTO> member_ratio(String keyword);
	 
	/**
	 * ͨ�� ��ѯ������Ŀ subname �Ļ�Ա��¼��Ŀ����
	 * @param һ����Ŀ���ƣ� ��Ŀ�����ͣ�itemType ���Ա����Ŀ�� ������ ���ģ�ר����
	 * @return ��Ŀ������
	 */
	public int findItemSum(String subname,String itemType);
	
	/**
	 * ͨ�� ��ѯ������Ŀ subname �Ļ�Ա��¼��Ŀ���� ����ҳ��ѯ��
	 * @param һ����Ŀ���ƣ� ��Ŀ�����ͣ�itemType ���Ա����Ŀ�� ������ ���ģ�ר����
	 * @return ��Ŀ������
	 */
	
}
