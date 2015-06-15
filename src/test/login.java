package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


class notfind extends JFrame{
	public notfind(){
		setTitle("X");
		
		
		JLabel jl = new JLabel("���̵� �߸� �Է��ϼ̽��ϴ�.");
		
		setLayout(new GridLayout(1,0));
		add(jl);
		
		setSize(300,200);
		setVisible(true);
		
	}
	
}

class donfind extends JFrame{
	public donfind(){
		setTitle("X");
		
		
		JLabel jl = new JLabel("���̵�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		
		setLayout(new GridLayout(1,0));
		add(jl);
		
		setSize(300,200);
		setVisible(true);
	}
}


public class login extends JFrame{
	
	// GUI ������ ��������
	
	HashMap<String, String> map2 = new HashMap<String,String>();
	
	login(){
		
		load();
		setTitle("�α���");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar mb = new JMenuBar();
		JMenu m = new JMenu("Option"); 
		JMenuItem mi = new JMenuItem("Exit");
		mb.add(m);
		m.add(mi);
		setJMenuBar(mb);
		
		mi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
				
			}
		});
		
		
		
		JPanel overjpan=new JPanel();		 // JPaner ?!
		JPanel westjpan=new JPanel();
		JPanel eastjpan=new JPanel();
		JPanel southjpan=new JPanel();   
		JPanel jp=new JPanel();
		
		
		
		JTextField input_id = new JTextField();
		JPasswordField password = new JPasswordField();
		
		
		
		
		JLabel formlabel= new JLabel("�α��� ȭ��",JLabel.CENTER);
		
		
		JButton jb1 = new JButton("�α���");
		JButton jb2 = new JButton("ȸ������");
		
		overjpan.setPreferredSize(new Dimension(250,35)); // preferredSize , Dimension !?
		westjpan.setPreferredSize(new Dimension(10,235));
		eastjpan.setPreferredSize(new Dimension(10,235));
		southjpan.setPreferredSize(new Dimension(250,10));
		
		
		overjpan.add(formlabel);
		
		add(BorderLayout.NORTH,overjpan);
		add(BorderLayout.WEST,westjpan);
		add(BorderLayout.EAST,eastjpan);
		add(BorderLayout.SOUTH,southjpan);
		
		JLabel label_id = new JLabel("���̵�");
		JLabel label_pw = new JLabel("��й�ȣ");
		
		
		JLabel empty=new JLabel();
		JLabel empty1=new JLabel();
		JLabel empty2=new JLabel();
		
		
		GridLayout g1=new GridLayout(3,3);
		
		
		g1.setHgap(5);
		g1.setVgap(5);
		
		
		jp.setLayout(g1);
		
		
		jp.add(label_id);
		jp.add(input_id);
		jp.add(empty);
		jp.add(label_pw);
		jp.add(password);
		jp.add(empty1);
		jp.add(empty2);
		jp.add(jb1);
		jp.add(jb2);
		

		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				try{
					
					load();
					Iterator <String> iterator = map2.keySet().iterator();
					
					if(map2.containsKey(input_id.getText()) == false){  
						notfind notfind = new notfind();  // ���̵��Է��Ѱ� Ű�� ���� ���
					}
					else if(map2.containsKey(input_id.getText()) && (password.getText().equals(map2.get(input_id.getText())))){
						Choice Choice = new Choice(input_id.getText());     // ���̵� �ְ� value ������ ��ġ�� ���
						dispose();
						
					}
					else if(password.getText() != map2.get(input_id.getText())){   // ��й�ȣ�� value ���� ����ġ �� ���
						donfind donfind = new donfind();
					}
					
					
				}catch(Exception ex){
				}
			}
				
		});
		
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addMember IM = new addMember();
				
			}
		});
		
		
		
		
		add(BorderLayout.CENTER,jp);
		setBounds(new Rectangle(350,235));
		setVisible(true);
		
	}
	
	public void save(){
		try{
			
			FileOutputStream fos = new FileOutputStream("Member.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(map2);
			oos.flush();
			
			oos.close();
			fos.close();
			
		}
		catch(Exception ex){
			
		}
	}
	public void load(){
		try{
			FileInputStream fis = new FileInputStream("Member.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			map2 = (HashMap<String, String>)ois.readObject();
			
			
			
			
			ois.close();
			fis.close();
			save();
		}
		catch(Exception ex){
			
		}
	}
	
	public void dat_print(){  // ���
		Iterator it = map2.keySet().iterator();
		while(it.hasNext()){
			String temp = (String)it.next();
			System.out.println(temp);             
		}
	}
	
	
	
	//ȸ���������� load ���� ������ �̸����� �����
	
	
	public static void main(String[] args) {
		login lo = new login();
	}

}
