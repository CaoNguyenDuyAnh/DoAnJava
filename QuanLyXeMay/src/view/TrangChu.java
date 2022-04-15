package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.DanhMucBean;
import controller.ChuyenManHinhController;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.Button;
import javax.swing.BoxLayout;
import java.awt.Color;


public class TrangChu extends JFrame {
	
	

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrangChu() {
		setFont(new Font("Dialog", Font.BOLD, 17));
		setTitle("Qu\u1EA3n l\u00FD xe m\u00E1y");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1143, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel jpnMenu = new JPanel();
		jpnMenu.setBackground(Color.WHITE);
		
		JPanel jpnView = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(jpnMenu, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jpnView, GroupLayout.PREFERRED_SIZE, 975, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(jpnView, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
						.addComponent(jpnMenu, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		jpnMenu.setLayout(null);
		
		JPanel jpnXe = new JPanel();
		jpnXe.setBackground(Color.ORANGE);
		jpnXe.setBounds(10, 10, 150, 72);
		jpnMenu.add(jpnXe);
		jpnXe.setLayout(null);
		
		JLabel jlbXe = new JLabel("XE MÁY");
		jlbXe.setForeground(Color.WHITE);
		jlbXe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jlbXe.setHorizontalAlignment(SwingConstants.CENTER);
		jlbXe.setBounds(10, 10, 130, 52);
		jpnXe.add(jlbXe);
		
		JPanel jpnKH = new JPanel();
		jpnKH.setBackground(Color.ORANGE);
		jpnKH.setLayout(null);
		jpnKH.setBounds(10, 92, 150, 72);
		jpnMenu.add(jpnKH);
		
		JLabel jlbKH = new JLabel("KHÁCH HÀNG");
		jlbKH.setForeground(Color.WHITE);
		jlbKH.setHorizontalAlignment(SwingConstants.CENTER);
		jlbKH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jlbKH.setBounds(10, 10, 130, 52);
		jpnKH.add(jlbKH);
		
		JPanel jpnNCC = new JPanel();
		jpnNCC.setBackground(Color.ORANGE);
		jpnNCC.setLayout(null);
		jpnNCC.setBounds(10, 174, 150, 72);
		jpnMenu.add(jpnNCC);
		
		JLabel jlbNCC = new JLabel("NHÀ CUNG CẤP");
		jlbNCC.setForeground(Color.WHITE);
		jlbNCC.setHorizontalAlignment(SwingConstants.CENTER);
		jlbNCC.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jlbNCC.setBounds(10, 10, 130, 52);
		jpnNCC.add(jlbNCC);
		
		JPanel jpnNV = new JPanel();
		jpnNV.setBackground(Color.ORANGE);
		jpnNV.setLayout(null);
		jpnNV.setBounds(10, 256, 150, 72);
		jpnMenu.add(jpnNV);
		
		JLabel jlbNV = new JLabel("NHÂN VIÊN");
		jlbNV.setForeground(Color.WHITE);
		jlbNV.setHorizontalAlignment(SwingConstants.CENTER);
		jlbNV.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jlbNV.setBounds(10, 10, 130, 52);
		jpnNV.add(jlbNV);
		
		JPanel jpnBan = new JPanel();
		jpnBan.setBackground(Color.ORANGE);
		jpnBan.setLayout(null);
		jpnBan.setBounds(10, 338, 150, 72);
		jpnMenu.add(jpnBan);
		
		JLabel jlbBan = new JLabel("BÁN HÀNG");
		jlbBan.setForeground(Color.WHITE);
		jlbBan.setHorizontalAlignment(SwingConstants.CENTER);
		jlbBan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jlbBan.setBounds(10, 10, 130, 52);
		jpnBan.add(jlbBan);
		
		JPanel jpnThongKe = new JPanel();
		jpnThongKe.setBackground(Color.ORANGE);
		jpnThongKe.setLayout(null);
		jpnThongKe.setBounds(10, 420, 150, 72);
		jpnMenu.add(jpnThongKe);
		
		JLabel jlbThongKe = new JLabel("THỐNG KÊ");
		jlbThongKe.setForeground(Color.WHITE);
		jlbThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		jlbThongKe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jlbThongKe.setBounds(10, 10, 130, 52);
		jpnThongKe.add(jlbThongKe);
		contentPane.setLayout(gl_contentPane);
		
		ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
		controller.setView(jpnThongKe, jlbThongKe);
		
		List<DanhMucBean> listItem = new ArrayList<>();
		listItem.add(new DanhMucBean("ThongKe", jpnThongKe,jlbThongKe));
		listItem.add(new DanhMucBean("KHACHHANG", jpnKH,jlbKH));
		listItem.add(new DanhMucBean("NHANVIEN", jpnNV,jlbNV));
		listItem.add(new DanhMucBean("NCC", jpnNCC,jlbNCC));
		listItem.add(new DanhMucBean("XEMAY", jpnXe,jlbXe));
		listItem.add(new DanhMucBean("BANHANG", jpnBan,jlbBan));
		controller.setEvent(listItem);
	}
}
