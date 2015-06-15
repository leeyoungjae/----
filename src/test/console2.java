package test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class console2 extends JFrame {
	
	ArrayList<Ticket> list = new ArrayList<Ticket>();

	String id;
	int index;

	console2(String id) {
		this.id = id;
		load();
		JMenuBar mb = new JMenuBar();
		JMenu m = new JMenu("Option");
		JMenuItem mi = new JMenuItem("Exit");
		mb.add(m);
		m.add(mi);
		setJMenuBar(mb);

		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		JPanel jp = new JPanel(new GridLayout(4, 1));

		DefaultTableModel model = new DefaultTableModel(){
			public boolean isCellEditAble(int row, int column){
				return false;
			}
		};
		
		model.addColumn("출발역");
		model.addColumn("도착역");
		model.addColumn("년도");
		model.addColumn("월");
		model.addColumn("일");
		model.addColumn("시간");
		model.addColumn("인원");

		for (int i = 0; i < list.size(); i++) {
			Ticket temp_ticket = list.get(i);
			String temp_id = temp_ticket.getUserId();
			if (temp_id.equals(id)) {
				String temp_d_station = temp_ticket.getD_station();
				String temp_a_station = temp_ticket.getA_station();
				String temp_year = temp_ticket.getYear();
				String temp_month = temp_ticket.getMonth();
				String temp_day = temp_ticket.getDay();
				String temp_time = temp_ticket.getTime();
				String temp_person = temp_ticket.getPerson(); //

				model.addRow(new String[] { temp_d_station, temp_a_station,
						temp_year, temp_month, temp_day, temp_time, temp_person });
			}
		}

		JButton jb1 = new JButton("티켓 재구매[변경]");
		JButton jb2 = new JButton("환불 [제거]");
		JButton jb3 = new JButton("좌석 선택");

		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);

		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(center);
		}
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				index = table.getSelectedRow();
				
				
				//if(e.getClickCount() == 2){
					
				//}
			}
		});

		add(jp, BorderLayout.EAST);
		add(scroll, BorderLayout.CENTER);

		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 여기에 버튼눌렀을때의 반응을 추가하면됨
				try {

					/*
					 * System.out.println("출발역과 도착역이 포함되는 티켓을 검색합니다.");
					 * System.out.println("정류장의 이름을 입력해주세요."); String station =
					 * a.next();
					 * 
					 * for(int i=0;i>list.size();i++){
					 * if(list.get(i).getD_station() == station ||
					 * list.get(i).getA_station() == station){
					 * System.out.println(list.get(i).toString()); }
					 * 
					 * }
					 */

				} catch (Exception e1) {
					System.out.print("오류코드 : ");
					System.out.println(e1);
				}

			}
		});
		
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 여기에 버튼눌렀을때의 반응을 추가하면됨
				try {
					model.removeRow(index);
					//list.remove(index); // list 에서 인덱스가아님..
					
					save();
					load();
					
					/*
					 * System.out.println("환불 할 티켓을 선택 하여 주십시오.");
					 * System.out.println("       출발역--도착역--년--월--일--출발시간--인원");
					 * for(int i=0; i<list.size();i++){ System.out.print("[");
					 * System.out.print(i+1); System.out.print("] ");
					 * System.out.println(list.get(i).toString()); } int select
					 * = a.nextInt();
					 * 
					 * list.remove(select-1);
					 * System.out.println("환불 완료 되었습니다.");
					 */

				} catch (Exception e1) {
					System.out.print("오류코드 : ");
					System.out.println(e1);
				}

			}
		});
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 여기에 버튼눌렀을때의 반응을 추가하면됨
				try {

					/*
					 * load(); System.out.println("변경 할 티켓을 선택합니다.");
					 * System.out.println("       출발역--도착역--년--월--일--출발시간--인원");
					 * for(int i=0; i<list.size();i++){ System.out.print("[");
					 * System.out.print(i+1); System.out.print("] ");
					 * System.out.println(list.get(i).toString()); } int select
					 * = a.nextInt();
					 * 
					 * list.remove(select-1); save();
					 * System.out.println("변경 할 티켓의 정보를 다시 입력해주세요."); TicketGUI
					 * g = new TicketGUI();
					 */

				} catch (Exception e1) {
					System.out.print("오류코드 : ");
					System.out.println(e1);
				}

			}
		});

		setSize(800, 400);
		setVisible(true);

	}

	public void save() {
		try {

			FileOutputStream fos = new FileOutputStream("Ticket.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(list);
			oos.flush(); // ?

			oos.close();
			fos.close();
		} catch (Exception ex) {

		}
	}

	public void load() {
		try {
			FileInputStream fis = new FileInputStream("Ticket.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			list = (ArrayList) ois.readObject(); // (ArrayList) 형 변환 어레이리스트로
													// (다읽어서 어레이스트로 바꾼다)
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}

			ois.close();
			fis.close();
			save();
		} catch (Exception ex) {

		}
	}

}
