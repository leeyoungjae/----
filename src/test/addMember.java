package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

class can extends JFrame{
	public can(){
		setTitle("가능");
		
		
		JLabel jl = new JLabel("사용 가능합니다!");
		
		setLayout(new GridLayout(1,0));
		add(jl);
		
		setSize(300,200);
		setVisible(true);
		
	}
	
}
class cant extends JFrame{
	public cant(){
		setTitle("불가능");
		
		
		JLabel jl = new JLabel("이미 존재합니다!");
		
		setLayout(new GridLayout(1,0));
		add(jl);
		
		setSize(300,200);
		setVisible(true);
		
	}
	
}

class  addMember extends JFrame{
	// GUI까지만 구현된 것
	
	FileInputStream fin = null;
	ObjectInputStream ois = null;
	
	FileOutputStream fout = null;
    ObjectOutputStream oos = null;
	
	HashMap <String,String> map = new HashMap<String, String>();
	
	
	addMember(){
		load();
		setTitle("final exam!");
		
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
		
		
		JTextField input_id=new JTextField();
		JTextField passwordinput=new JTextField();
		
		JLabel formlabel= new JLabel("회원가입",JLabel.CENTER);
		
		JButton resulton=new JButton("완료");
		
		overjpan.setPreferredSize(new Dimension(250,35)); // preferredSize , Dimension !?
		westjpan.setPreferredSize(new Dimension(10,235));
		eastjpan.setPreferredSize(new Dimension(10,235));
		southjpan.setPreferredSize(new Dimension(250,10));
		
		
		overjpan.add(formlabel);
		
		
		add(BorderLayout.NORTH,overjpan);
		add(BorderLayout.WEST,westjpan);
		add(BorderLayout.EAST,eastjpan);
		add(BorderLayout.SOUTH,southjpan);
		
		
		JLabel label_id= new JLabel("아이디");
		JLabel label_pw=new JLabel("비밀번호");
		
		
		
		
		JLabel empty=new JLabel();
		JLabel empty1=new JLabel();
		JLabel empty2=new JLabel();
		
		
		
		GridLayout gl=new GridLayout(3,3);
		
		
		gl.setHgap(5);
		gl.setVgap(5);
		
		
		jp.setLayout(gl);
		
		JButton conform=new JButton("중복확인");
		
		jp.add(label_id);
		jp.add(input_id);
		jp.add(conform);
		jp.add(label_pw);
		jp.add(passwordinput);
		jp.add(empty);
		jp.add(empty1);
		jp.add(empty2);
		jp.add(resulton);
		
		
		
		
		
		conform.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//여기에 버튼눌렀을때의 반응을 추가하면됨
				try{
					if(map.containsKey(input_id.getText()) == false){
						can can = new can();
					}
					else if(map.containsKey(input_id.getText())){
						cant cant = new cant();
					}
				}
				catch (Exception e1){
					System.out.print("오류코드 : ");
					System.out.println(e1);
				}
			}
		});
		
		
		resulton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//여기에 버튼눌렀을때의 반응을 추가하면됨
				try{
					if(map.containsKey(input_id.getText())==false){

						map.put(input_id.getText(),passwordinput.getText());

						save();
						dispose();
					}
					else if(map.containsKey(input_id.getText())){
						cant cant = new cant();
					}
					
					
				}
				catch (Exception e1){
					System.out.print("오류코드 : ");
					System.out.println(e1);
				}
				
			}
		});
		
		
		
		
		
		
		add(BorderLayout.CENTER,jp);
		setBounds(new Rectangle(350,235));
		setVisible(true);
	}
	

	public void save(){
		try{
			dat_print();
			FileOutputStream fos = new FileOutputStream("Member.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(map);
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
			
			map = (HashMap<String, String>)ois.readObject();
			
			dat_print();
			
			ois.close();
			fis.close();
			save();
		}
		catch(Exception ex){
			
		}
	}
	
	public void dat_print(){
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()){
			String temp = (String)it.next();
			System.out.println(temp);
		}
	}
	
}