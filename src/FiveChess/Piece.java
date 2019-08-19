package FiveChess;

class  Piece implements Goconfig{
	public Piece(int color){
		this.color=0;
	}
	public int color=0;   //������ɫ
	//Ȩֵ����
	public static void weightReset() {
		for(int i=0;i<weightarr.length;i++) {
			for(int j=0;j<weightarr[i].length;j++) {
				weightarr[i][j]=0;
			}
		}
	}
	public static Chess weight() {  
		int maxWeight=0;int x=0,y=0;
		for(int i=0;i<go.length;i++) {
			for(int j=0;j<go[i].length;j++) {
				if(go[i][j].color==0) {
					String key1="0";String key2="0";
					int ux=i,uy=j,dx=i,dy=j;
					//��б�����ж�
					int first1=0,first2=0;
					while((ux-1)>=0&&(uy-1)>=0) {
						int first=go[i-1][j-1].color;
						first1=first;
						if(first==0) break;
						else {
							--ux;--uy;
							if(go[ux][uy].color==first) {
								key1+=go[ux][uy].color;
							}
							else {
								key1+=go[ux][uy].color;
								break;
							}
						}
					}
					while((dx+1)<=14&&(dy+1)<=14) {
						int first=go[i+1][j+1].color;
						first2=first;
						if(first==0) break;
						else {
							++dx;++dy;
							if(go[dx][dy].color==first) {
								key2+=go[dx][dy].color;
							}
							else {
								key2+=go[dx][dy].color;
								break;
							}
						}
					}
					Integer res1=map.get(key1);
					Integer res2=map.get(key2);
					int value1=0,value2=0;
					if(res1!=null) value1 = res1.intValue();
					if(res2!=null) value2 = res2.intValue();
					int value=value1+value2;
					if((first1==first2)&&first1!=0) value*=2;	
					//�ڶ�Ӧ��λ�ۼ�Ȩֵ
					
					key1="0";key2="0";
					ux=i;uy=j;dx=i;dy=j;
					//��ֱ�����ж�
					first1=0;first2=0;
					while((uy-1)>=0) {
						int first=go[i][j-1].color;
						first1=first;
						if(first==0) break;
						else {
							--uy;
							if(go[ux][uy].color==first) {
								key1+=go[ux][uy].color;
							}
							else {
								key1+=go[ux][uy].color;
								break;
							}
						}
					}
					while((dy+1)<=14) {
						int first=go[i][j+1].color;
						first2=first;
						if(first==0) break;
						else {
							++dy;
							if(go[dx][dy].color==first) {
								key2+=go[dx][dy].color;
							}
							else {
								key2+=go[dx][dy].color;
								break;
							}
						}
					}
					res1=map.get(key1);
					res2=map.get(key2);
					value1=0;value2=0;
					if(res1!=null) value1 = res1.intValue();
					if(res2!=null) value2 = res2.intValue();
					value+=value1+value2;
					if((first1==first2)&&first1!=0) value*=2;	
//					value+=value;//�ڶ�Ӧ��λ�ۼ�Ȩֵ
					
					//ˮƽ����
					key1="0";key2="0";
					ux=i;uy=j;dx=i;dy=j;
					first1=0;first2=0;
					while((ux-1)>=0) {
						int first=go[i-1][j].color;
						first1=first;
						if(first==0) break;
						else {
							--ux;
							if(go[ux][uy].color==first) {
								key1+=go[ux][uy].color;
							}
							else {
								key1+=go[ux][uy].color;
								break;
							}
						}
					}
					while((dx+1)<=14) {
						int first=go[i+1][j].color;
						first2=first;
						if(first==0) break;
						else {
							++dx;
							if(go[dx][dy].color==first) {
								key2+=go[dx][dy].color;
							}
							else {
								key2+=go[dx][dy].color;
								break;
							}
						}
					}
					res1=map.get(key1);
					res2=map.get(key2);
					value1=0;value2=0;
					if(res1!=null) value1 = res1.intValue();
					if(res2!=null) value2 = res2.intValue();
					value+=value1+value2;
					if((first1==first2)&&first1!=0) value*=2;	
//					value+=value;//�ڶ�Ӧ��λ�ۼ�Ȩֵ
					
					//��б����
					key1="0";key2="0";
					ux=i;uy=j;dx=i;dy=j;
					//��б�����ж�
					first1=0;first2=0;
					while((ux+1)<=14&&(uy-1)>=0) {
						int first=go[i+1][j-1].color;
						first1=first;
						if(first==0) break;
						else {
							++ux;--uy;
							if(go[ux][uy].color==first) {
								key1+=go[ux][uy].color;
							}
							else {
								key1+=go[ux][uy].color;
								break;
							}
						}
					}
					while((dx-1)>=0&&(dy+1)<=14) {
						int first=go[i-1][j+1].color;
						first2=first;
						if(first==0) break;
						else {
							--dx;++dy;
							if(go[dx][dy].color==first) {
								key2+=go[dx][dy].color;
							}
							else {
								key2+=go[dx][dy].color;
								break;
							}
						}
					}
					res1=map.get(key1);
					res2=map.get(key2);
					value1=0;value2=0;
					if(res1!=null) value1 = res1.intValue();
					if(res2!=null) value2 = res2.intValue();
					value+=value1+value2;
					if((first1==first2)&&first1!=0) value*=2;	
					weightarr[i][j]+=value;//�ڶ�Ӧ��λ�ۼ�Ȩֵ
					if(weightarr[i][j]>=maxWeight) {
						maxWeight=weightarr[i][j];
						x=i;y=j;
					}
				}
			}
		}
		return new Chess(x,y);
	}
	public int judge(int x,int y) {   //ÿ��һö�ӣ����ĸ������ϵ����Ӹ��������жϣ�
		for(int i=0;i<4;i++) {
			int ux=x,uy=y,dx=x,dy=y;
			int count=1;
			/*
			 * 1���ȿ����Ƿ������ڵ����ӣ������
			 * 2������ɫ�Ƿ���ͬ�������ͬ��������+1��
			 * 3: ����ﵽ��=5����˵����Ϸ������
			 */
			if(i==0) {    
				while((ux-1)>=0&&(uy-1)>=0) {
					if(go[--ux][--uy].color==this.color) count++;
					else break;
				}
				while((dx+1)<=14&&(dy+1)<=14) {
					if(go[++dx][++dy].color==this.color) count++;
					else break;
				}
				if(count>=5) {
					System.out.print(this.color+"ʤ��");
					return this.color;
				}
			}
			else if(i==1) {
				while((uy-1)>=0) {
					if(go[ux][--uy].color==this.color) count++;
					else break;
				}
				while((dy+1)<=14) {
					if(go[dx][++dy].color==this.color) count++;
					else break;
				}
				if(count>=5) {
					System.out.print(this.color+"ʤ��");
					return this.color;
				}
			}
			else if(i==2) {
				while((ux+1)<=14&&(uy-1)>=0) {
					if(go[++ux][--uy].color==this.color) count++;
					else break;
				}
				while((dx-1)>=0&&(dy+1)<=14) {
					if(go[--dx][++dy].color==this.color) count++;
					else break;
				}
				if(count>=5) {
					System.out.print(this.color+"ʤ��");
					return this.color;
				}
			}
			else if(i==3) {
				while((dx-1)>=0) {
					if(go[--dx][dy].color==this.color) count++;
					else break;
				}
				while((ux+1)<=14) {
					if(go[++ux][uy].color==this.color) count++;
					else break;
				}
				if(count>=5) {
					System.out.print(this.color+"ʤ��");
					return this.color;
				}
			}
		}
		return 0;
	}

}
