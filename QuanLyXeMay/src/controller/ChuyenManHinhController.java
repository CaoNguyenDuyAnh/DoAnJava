package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.Node;

import bean.DanhMucBean;
import view.BANHANG;
import view.KHACHHANG;
import view.NCC;
import view.NHANVIEN1;
import view.THONGKE1;
import view.XEMAY;

public class ChuyenManHinhController {
	private JPanel root;
	private String kindSelected ="";
	
	private List<DanhMucBean> listItem = null;
	
	
	public ChuyenManHinhController(JPanel jpnRoot) {
		this.root = jpnRoot; 
	}
	
	
	public void setView(JPanel jpnItem, JLabel jlbItem) {
		kindSelected = "ThongKe";
		
		jpnItem.setBackground(new Color(96, 100, 191));
		jlbItem.setBackground(new Color(96, 100, 191));
		
		
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new THONGKE1());
		root.validate();
		root.repaint();
	}
	
	public void setEvent(List<DanhMucBean> listItem) {
		this.listItem = listItem;
		
		
		for (DanhMucBean item : listItem) {
			item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
		}
	}
	
	class LabelEvent implements MouseListener{
		private JPanel node;
		private String kind;
		
		private JPanel jpnItem;
		private JLabel jlbItem;

		
		public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
			super();
			this.kind = kind;
			this.jpnItem = jpnItem;
			this.jlbItem = jlbItem;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			switch(kind) {
				case "THONGKE":
					node = new THONGKE1();
					break;
				case "XEMAY":
					node = new XEMAY();
					break;
				case "NCC":
					node = new NCC(); 
					break;
				case "KHACHHANG":
					node = new KHACHHANG();
					break;
				case "BANHANG":
					node = new BANHANG();
					break;
				case "NHANVIEN":
					node = new NHANVIEN1();
					break;
				default:
					node = new THONGKE1();
					break;
			}
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(node);
			root.validate();
			root.repaint();
			setChangeBackground(kind);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			kindSelected = kind;
			jpnItem.setBackground(new Color(96,100,191));
			jlbItem.setBackground(new Color(96,100,191));
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jpnItem.setBackground(new Color(96,100,191));
			jlbItem.setBackground(new Color(96,100,191));
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(!kindSelected.equalsIgnoreCase(kind)) {
				jpnItem.setBackground(new Color(76,175,80));
				jlbItem.setBackground(new Color(76,175,80));
			}
			
		}
		
		private void setChangeBackground(String kind) {
			for (DanhMucBean item : listItem) {
				if(item.getKind().equalsIgnoreCase(kind)) {
					item.getJlb().setBackground(new Color(96,100,191));
					item.getJpn().setBackground(new Color(96,100,191));
				}else {
					item.getJlb().setBackground(new Color(76,175,80));
					item.getJpn().setBackground(new Color(76,175,80));
				}
			}
				
		}
		
	}
}
