package com.jony.sys.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jony.sys.domain.Menu;
import com.jony.sys.mapper.MenuMapper;

/**
 * ��ʼ���˵�����
 * @author LJH
 *
 */
public class InitMenuData {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		MenuMapper menuMapper = context.getBean(MenuMapper.class);
		menuMapper.insert(new Menu(1, 0, "ͼ�����ϵͳ", null, 1, null, "&#xe68e;", 1));
		menuMapper.insert(new Menu(2, 1, "��������", null, 1, null, "&#xe653;", 1));
		menuMapper.insert(new Menu(3, 1, "ҵ�����", null, 0, null, "&#xe663;", 1));
		menuMapper.insert(new Menu(4, 1, "ϵͳ����", null, 0, null, "&#xe716;", 1));
		menuMapper.insert(new Menu(5, 1, "ͳ�Ʒ���", null, 0, null, "&#xe629;", 1));
		
		
		menuMapper.insert(new Menu(6, 2, "�ͻ�����", null, 0, null, "&#xe770;", 1));
		menuMapper.insert(new Menu(7, 2, "ͼ�����", null, 0, null, "&#xe657;", 1));
		
		
		menuMapper.insert(new Menu(8, 3, "ͼ�����", null, 0, null, "&#xe65b;", 1));
		menuMapper.insert(new Menu(9, 3, "���ⵥ����", null, 0, null, "&#xe6b2;", 1));
		menuMapper.insert(new Menu(10, 3, "ͼ�����", null, 0, null, "&#xe65a;", 1));
		menuMapper.insert(new Menu(11, 3, "��鵥����", null, 0, null, "&#xe705;", 1));
		
		
		menuMapper.insert(new Menu(12, 4, "�˵�����", null, 0, null, "&#xe60f;", 1));
		menuMapper.insert(new Menu(13, 4, "��ɫ����", null, 0, null, "&#xe66f;", 1));
		menuMapper.insert(new Menu(14, 4, "�û�����", null, 0, null, "&#xe770;", 1));
		menuMapper.insert(new Menu(15, 4, "��־����", null, 0, null, "&#xe655;", 1));
		menuMapper.insert(new Menu(16, 4, "�������", null, 0, null, "&#xe645;", 1));
		menuMapper.insert(new Menu(17, 4, "����Դ���", null, 0, null, "&#xe857;", 1));
		
		
		menuMapper.insert(new Menu(18, 5, "�ͻ�����ͳ��", null, 0, null, "&#xe63c;", 1));
		menuMapper.insert(new Menu(19, 5, "��˾����·����۶�", null, 0, null, "&#xe62c;", 1));
		menuMapper.insert(new Menu(20, 5, "ҵ��Ա������۶�", null, 0, null, "&#xe62d;", 1));
		
		System.out.println("��ʼ�����");
		
		
		
	}
}
