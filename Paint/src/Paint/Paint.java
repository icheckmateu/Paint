package Paint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paint extends JPanel{
	//����һ���ܴ�����飬�������ͼ��Ԫ��
	private Shape[] ShArr = new Shape[10000];
	public static void main(String[] args) {
		Paint p = new Paint();
	}

	JFrame jf = new JFrame();
	//JPanel jp = new JPanel();
	int len = 0;
	//ʵ����һ��ButtonListener����ʵ���˶��ֽӿ�
	ButtonListener btl = new ButtonListener();
	public Paint() {
		//ʵ��һ������
		jf.setTitle("��ͼ��");
		jf.setLocation(450, 100);
		jf.setSize(700, 600);
		this.setPreferredSize(new Dimension(600, 500));
		//�����������飬��������ָ��
		String[] command = { "��ʼ", "���", "ֱ��", "����", "�����", "����","��Բ" };
		Color[] color = { Color.BLACK, Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN };
		//���ò���Ϊ��ʽ����
		jf.setLayout(new FlowLayout());
		
		/*�����������ѭ���н����ְ�ť��ӽ��붯���������У�����addActionListener����Ϊbtl��
		 btl��һ��Buttonlistener�Ķ���
		 */
		for (int i = 0; i < command.length; i++) {
			JButton jb = new JButton(command[i]);
			jb.addActionListener(btl);
			jf.add(jb);
		}
		for (int i = color.length - 1; i >= 0; i--) {
			JButton jb = new JButton();
			jb.setBackground(color[i]);//���ñ�����ɫ
			Dimension dm = new Dimension(20, 20);//���ô�С
			jb.setPreferredSize(dm);
			jb.addActionListener(btl);
			jf.add(jb);
		}
		//��JPanel������ӽ���jf��������У�������Ч
		jf.add(this);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);	//���ÿɼ�
		Graphics gf = this.getGraphics();	//��ȡ���ʣ����ǵ�this����ǰ��Ķ���������һ��JPanel�Ķ���
		this.addMouseListener(btl);		//����������������ڻ�ͼ
		this.addMouseMotionListener(btl);	//������ģʽ�����������ڻ滭����
		btl.set_gr(gf);		//��������һ����Ļ���
		btl.set_jp(this);	//��������һ�����JPanel����
		btl.set_ShArr(ShArr);	//��������һ���������
	}
	public void paint(Graphics g) {
		super.paint(g);		//���ø����paint������������������
		len = btl.get_len();	//��ȡ����ĳ���
		//�ػ����ǵ�ͼ��
		for(int i=0;i<len;i++) {
			if(ShArr[i]!=null) {
				//û���ػ�ͼ����ֻ�ػ���ͼ�Σ�
				ShArr[i].repaint(g);
			}
			else {
				break;
			}
		}
	}
}
