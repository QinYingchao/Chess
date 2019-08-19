package FiveChess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Qipan extends JPanel implements Goconfig{
	static {
		//���� ������λ��ֹͣ��
		//��һ��
		map.put("010",40);
		map.put("020",40);
		//�����
		map.put("0110",400);
		map.put("0220",400);
		//������
		map.put("01110", 3000);
		map.put("02220", 3000);
		//������
		map.put("011110", 10000);
		map.put("022220", 10000);
		//��һ��
		map.put("012",20);
		map.put("021",20);
		//�߶���
		map.put("0112",200);
		map.put("0221",200);
		//������
		map.put("01112",500);
		map.put("02221",500);
		//������  ֻ�������������ӵ�����²��м�ֵ
		map.put("022221", 3000);
		map.put("011112", 3000); 
	}
	
	//ά��һ��15*15�ı�����¼ÿ��������������
	private void PieceInit() {
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				go[i][j]=new Piece(0);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Qipan qp=new Qipan();
		qp.Init();
		qp.PieceInit();
	}
	
	public void Init() {
		/*
		 * jf������˳�����֣���λ�ã��ɵ��ڴ�С����С���رշ�ʽ�����ַ�ʽ���Ƿ�ɼ���
		 * Dimension��������ͳһ����Ĵ�С��
		 */
		JFrame jf=new JFrame();
		jf.setTitle("������");
		jf.setSize(650, 580);        //�����С���������;
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(3);
		jf.setLayout(new BorderLayout());
		jf.add(this);
		JPanel eastp=new JPanel();
		eastp.setPreferredSize(new Dimension(100,0));
		JButton buttonStart=new JButton("��ʼ��Ϸ");
		JButton buttonregret=new JButton("����");
		JButton buttonlose=new JButton("����");
		String[] itemArray = { "���˶�ս", "�˻���ս" };
		JComboBox<String> cbItem = new JComboBox<String>(itemArray);
		buttonStart.setPreferredSize(new Dimension(90,40));
		buttonregret.setPreferredSize(new Dimension(90,40));
		buttonlose.setPreferredSize(new Dimension(90,40));
		cbItem.setPreferredSize(new Dimension(90,40));
		eastp.add(buttonStart);
		eastp.add(buttonregret);
		eastp.add(buttonlose);
		eastp.add(cbItem);
		jf.add(eastp,BorderLayout.EAST);
		jf.setVisible(true);
		ChessListener cl=new ChessListener(this,cbItem);
		buttonStart.addActionListener(cl);
		buttonregret.addActionListener(cl);
		buttonlose.addActionListener(cl);
		cbItem.addActionListener(cl);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < 15; i++) {
			g.drawLine(30, 30 + i * 35, 30 + 35 * 14, 30 + i * 35);// ����
			g.drawLine(30 + i * 35, 30, 30 + i * 35, 30 + 35 * 14);// ����
		}
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(go[i][j].color!=0) {
					int x=30+i*35;
					int y=30+j*35;
					if(go[i][j].color==1)
						g.setColor(Color.black);
					else 
						g.setColor(Color.WHITE);
					g.fillOval(x-12, y-12, 24, 24);
				}
			}
		}
	}
}
