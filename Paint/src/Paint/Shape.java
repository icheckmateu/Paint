package Paint;

import java.awt.Graphics;

import javax.swing.JPanel;
//����һ��ͼ�����࣬����Զ���ͼ������ʵ�ֺ͹���
public class Shape{
	//Shape����name���������������
	private int x1,x2,y1,y2;
	private String name;
	public Shape(int x1,int y1,int x2,int y2,String name){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.name = name;
	}
	//���ݲ�ͬ��ͼ�����֣���չ��ͬ���ػ����
	public void repaint(Graphics g) {
		switch(name) {
		case "ֱ��":
			g.drawLine(x1, y1, x2, y2);
			break;
		case "����":
			g.drawRect(Math.min(x1, x2), Math.min(y1 ,y2), Math.abs(x1-x2), Math.abs(y1-y2));
			break;
		case "Բ��":
			g.drawOval(Math.min(x1, x2), Math.min(y1 ,y2), Math.abs(x1-x2), Math.abs(y1-y2));
			break;
		case "����":
			g.drawLine(x1, y1, x2, y2);
			break;
		case "�����":
			g.drawLine(x1, y1, x2, y2);
			break;
		}
	}
}
