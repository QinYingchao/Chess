package FiveChess;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class ChessListener extends MouseAdapter implements ActionListener,Goconfig{
	private Qipan qp;
	private Graphics2D g;
	private boolean flag=true;
	private String type="���˶�ս";
	private JComboBox cbItem;
	private ArrayList<Chess> list = new ArrayList<Chess>();
	public ChessListener(Qipan qp,JComboBox cbItem) {
		this.qp=qp;
		this.cbItem=cbItem;
	}
	
	public void mouseClicked(MouseEvent e) {
		if(g==null) {
			 g = (Graphics2D) qp.getGraphics();
			 g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
		 }
		 int x=e.getX();
		 int y=e.getY();
		 if(x<30 || y<30 || x>520 || y>520) 
			 System.out.println("���������ڵ��");
		 else {
			 int cx=x-X-((x-X)/square_size)*square_size;int cy=y-Y-((y-Y)/square_size)*square_size;
			 if(cx>17) 
				 x=X+((x-X)/square_size+1)*square_size;
			 else
				 x=X+((x-X)/square_size)*square_size;
			 if(cy>17) 
				 y=Y+((y-Y)/square_size+1)*square_size;
			 else
				 y=Y+((y-Y)/square_size)*square_size;
			 int zx=(x-X)/square_size;
			 int zy=(y-Y)/square_size;
			 Chess tmpchess=new Chess(zx,zy);
			 if(go[zx][zy].color==0) {
				 draw(tmpchess);
				 if(type.equals("�˻���ս")) {  
					 Piece.weightReset();
					 tmpchess=Piece.weight();
					 draw(tmpchess);  //�������ӣ����ж���Ӯ��
				 } 
			 }
			else
				 System.out.println("��λ�ò�������");
		 }
	}
	
	
	public void draw(Chess tmpchess) {
		int zx=tmpchess.x;int zy=tmpchess.y;
		int x=zx*35+30;int y=zy*35+30;
		if(flag) {
			 g.setColor(Color.black);
		 }
		 else {
			 g.setColor(Color.WHITE);
		 }
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
		 Color col=g.getColor();
		 if(col==Color.black)
			 go[zx][zy].color=1;
		 else if(col==Color.WHITE)
			 go[zx][zy].color=2;
		 if(go[zx][zy].judge(zx, zy)!=0) {
			 qp.removeMouseListener(this);
			 JOptionPane.showMessageDialog(qp, "��Ϸ����");
		 }
		 flag=!flag;
		 list.add(tmpchess);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("��ʼ��Ϸ")) {
			for(int i=0;i<row;i++) {
				for(int j=0;j<column;j++) {
					go[i][j].color=0;
				}
			}
			Piece.weightReset();           //��ʼǰ�������̵�Ȩ��
			flag=true;                     //��һ�����ӱ���Ϊ��ɫ
			cbItem.setEnabled(false);      
			qp.repaint();               
			qp.removeMouseListener(this);  //�����ʼ���ܽ�����Ϸ
			qp.addMouseListener(this); 			
		}else if(e.getActionCommand().equals("����")){
			if(list.size()>=1) {
				Chess chess=list.remove(list.size()-1);
				go[chess.x][chess.y].color=0;
				flag=!flag;
				qp.repaint();
			}
		}else if(e.getActionCommand().equals("����")) {
			if (flag) {
				JOptionPane.showMessageDialog(qp, "�������䣬����ʤ����");
			} else {
				JOptionPane.showMessageDialog(qp, "�������䣬����ʤ����");
			}
			qp.removeMouseListener(this);   // �Ƴ���������ϵ���궯�������������¼����������
			cbItem.setEnabled(true);        //���ÿ��Բ���
		}else if(e.getSource() instanceof JComboBox){
			JComboBox<String> cbItem = (JComboBox<String>) e.getSource();// ��ȡ�¼�Դ����
			type = cbItem.getSelectedItem().toString();      // ��ȡѡ��Ķ�սģʽ
		}
	}
}
