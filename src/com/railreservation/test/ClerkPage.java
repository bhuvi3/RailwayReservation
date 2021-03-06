package com.railreservation.test;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import com.railreservation.auxiliary.MyDate;
import com.railreservation.domain.Admin;
import com.railreservation.domain.Clerk;
import com.railreservation.domain.Passenger;
import com.railreservation.domain.Train;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Madhavi S
 */
public class ClerkPage extends javax.swing.JFrame {

    /**
     * Creates new form ClerkPage
     */
    public ClerkPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        pasField = new javax.swing.JTextField();
        
        jScrollPane3 = new javax.swing.JScrollPane();
        tdArea = new javax.swing.JTextArea();
        btnCheckAvail = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField5.setText("availability status");
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clerk Page", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Source:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Destination:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Date Of Journey :");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tdArea.setColumns(20);
        tdArea.setRows(5);
        jScrollPane3.setViewportView(tdArea);

        btnCheckAvail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCheckAvail.setText("CHECK AVAILABILITY");
        btnCheckAvail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/railreservation/test/train.jpg"))); // NOI18N
        jButton4.setText("RESERVE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Passenger Name:");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        //jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/railreservation/test/EXIT.PNG"))); // NOI18N
        jButton2.setText("CANCEL TICKET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        JLabel lblTicketInformation = new JLabel("TICKET INFORMATION:");
        lblTicketInformation.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel lblTrainInfo = new JLabel("Train Info:");
        lblTrainInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        ticketArea = new JTextArea();
        ticketArea.setText("ticket info to be printed here...");
        
        scrollPane = new JScrollPane();
        
        JLabel lblValidTrainnos = new JLabel("Valid TrainNos:");
        lblValidTrainnos.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JButton btnAllTrains = new JButton("ALL TRAINS");
        btnAllTrains.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Clerk temp=new Clerk();
        		ArrayList<Train> trains=temp.showAllTrains();
        		String tnos="";
            	for( Train t: trains){
            		tnos=tnos.concat(t.getNum()+"\n");
            		//i++;
            	}
            	System.out.println(tnos);
            	tnArea.setText(tnos);
        	}
        });
        
        btnTrainInfo = new JButton("Train Info");
        btnTrainInfo.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        	}
        });
        btnTrainInfo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String stn=tnArea.getSelectedText();
        		int tn=Integer.parseInt(stn);
        		Clerk temp=new Clerk();
        		ArrayList<Train>trains=temp.showAllTrains();
        		for(Train t:trains){
        			if(tn==t.getNum()){
        				String td=t.printTrainDetails();
        				tdArea.setText(td);
        				break;
        			}
        		}
        	}
        });
        
        btnNewButton = new JButton("Done");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Admin a=new Admin();
        		a.saveMasterRecord();
        		dispose();
        	}
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(jTextField1)
        								.addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        							.addGap(186)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(btnAllTrains)
        								.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(pasField, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
        						.addComponent(lblTicketInformation, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGap(14)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblValidTrainnos))
        							.addGap(49)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addComponent(lblTrainInfo)
        									.addGap(15)
        									.addComponent(btnTrainInfo))
        								.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jTextField5, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        							.addComponent(btnCheckAvail, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(jButton4, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(292)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jButton1)
        						.addComponent(jLabel3))
        					.addPreferredGap(ComponentPlacement.RELATED, 401, Short.MAX_VALUE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap(683, Short.MAX_VALUE)
        					.addComponent(jButton2)))
        			.addGap(39))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(ticketArea, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(391, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jButton1))
        				.addComponent(btnAllTrains))
        			.addGap(41)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(btnCheckAvail)
        						.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
        						.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addGap(24))
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addGap(18)
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(lblTrainInfo)
        							.addComponent(lblValidTrainnos)
        							.addComponent(btnTrainInfo))
        						.addGap(18, 27, Short.MAX_VALUE)
        						.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(pasField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addComponent(jButton4)))
        					.addGap(13))
        				.addComponent(lblTicketInformation, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(ticketArea, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(41)
        					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
        			.addGap(13))
        );
        
        tnArea = new JTextArea();
        tnArea.setText("trainNo to be printed...");
        scrollPane.setViewportView(tnArea);
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	String pname=pasField.getText();
    	Passenger pass= new Passenger(pname);
    	String date=jTextField3.getText();
    	String tokens[]=date.split("/");
    	int dd=Integer.parseInt(tokens[0]);
    	int mm=Integer.parseInt(tokens[1]);
    	int yyyy=Integer.parseInt(tokens[2]);
    	MyDate doj=new MyDate(yyyy,mm,dd);
    	int tnum=Integer.parseInt(tnArea.getSelectedText());
    	Clerk temp=new Clerk();
    	String tstatus=temp.reserveTicket(doj, tnum, pass);
    	ticketArea.setText(tstatus);
    	Admin a= new Admin();
    	a.saveMasterRecord();
    	/*jList1.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent lse) {
        		if(!lse.getValueIsAdjusting()){
        			//String sel=(String) jList1.getSelectedValue();
        			//int trainNo=Integer.parseInt(sel);
        			int trainNo=jList1.getSelectedValue();
        			String trainDetails;
        			Clerk temp=new Clerk();
        	    	ArrayList<Train> aux=temp.showAllTrains();//showTrains
        	    	String date=jTextField3.getText();
        	    	String pname=jTextField4.getText();
        	    	String tokens[]=date.split("/");
        	    	int dd=Integer.parseInt(tokens[0]);
        	    	int mm=Integer.parseInt(tokens[1]);
        	    	int yyyy=Integer.parseInt(tokens[2]);
        	    	MyDate doj=new MyDate(dd,mm,yyyy);
        	    	Passenger pass=new Passenger(pname);
        			for( Train t: aux){
        	    		if(trainNo==t.getNum()){
        	    			String res=temp.reserveTicket(doj, trainNo, pass);
        	    			jTextArea2.setText(res);
        	    			break;
        	    		}
        	    	}
        			
        		}
        	}
        });*/
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	//submit button action performed
    	tnArea.setText("");
    	tdArea.setText("");
    	jTextField5.setText("availability...");
    	pasField.setText("");
    	ticketArea.setText("");
    	String s=jTextField1.getText();
    	String d=jTextField2.getText();
    	String date=jTextField3.getText();
    	String tokens[]=date.split("/");
    	int dd=Integer.parseInt(tokens[0]);
    	int mm=Integer.parseInt(tokens[1]);
    	int yyyy=Integer.parseInt(tokens[2]);
    	MyDate doj=new MyDate(yyyy,mm,dd);
    	Clerk temp=new Clerk();
    	ArrayList<Train> aux=temp.showTrains(s, d, doj);//showTrains
    	int n=aux.size();
    	System.out.println("VALID TRAINS: "+n);
    	//Integer[] tn=new Integer[n];
    	//int i=0;
    	String tnos="";
    	for( Train t: aux){
    		tnos=tnos.concat(t.getNum()+"\n");
    		System.out.println(tnos);
    		//i++;
    	}
    	
    	tnArea.setText(tnos);
    	/*jList1.setListData(tn);
    	jList1.setVisibleRowCount(4);
    	jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	jList1.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent lse) {
        		if(!lse.getValueIsAdjusting()){
        			//String sel=(String) jList1.getSelectedValue();
        			//int trainNo=Integer.parseInt(sel);
        			int trainNo=jList1.getSelectedValue();
        			String trainDetails;
        			Clerk temp=new Clerk();
        	    	ArrayList<Train> aux=temp.showAllTrains();//showTrains
        			for( Train t: aux){
        	    		if(trainNo==t.getNum()){
        	    			trainDetails=t.printTrainDetails();
        	    			jTextArea1.setText(trainDetails);
        	    			break;
        	    		}
        	    	}
        			
        		}
        	}
        });*/
    } 
    

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        CancelSeat c = new CancelSeat();
        c.setVisible(true);
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	//String s=jTextField1.getText();
    	//String d=jTextField2.getText();
    	String date=jTextField3.getText();
    	String tokens[]=date.split("/");
    	int dd=Integer.parseInt(tokens[0]);
    	int mm=Integer.parseInt(tokens[1]);
    	int yyyy=Integer.parseInt(tokens[2]);
    	MyDate doj=new MyDate(yyyy,mm,dd);
    	Clerk temp=new Clerk();
    	String tnum=tnArea.getSelectedText();
    	int tn=Integer.parseInt(tnum);
    	String status=temp.checkAvail(doj, tn);
    	jTextField5.setText(status);
    	//ArrayList<Train> aux=temp.showAllTrains();//showTrains
    	/*int n=aux.size();
    	Integer[] tn=new Integer[n];
    	int i=0;
    	for( Train t: aux){
    		tn[i]=t.getNum();
    		i++;
    	}
    	jList1.setListData(tn);
    	jList1.setVisibleRowCount(4);
    	jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);*/
    	/*jList1.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent lse) {
        		if(!lse.getValueIsAdjusting()){
        			//String sel=(String) jList1.getSelectedValue();
        			//int trainNo=Integer.parseInt(sel);
        			int trainNo=jList1.getSelectedValue();
        			String trainDetails;
        			Clerk temp=new Clerk();
        	    	ArrayList<Train> aux=temp.showAllTrains();//showTrains
        	    	String date=jTextField3.getText();
        	    	String tokens[]=date.split("/");
        	    	int dd=Integer.parseInt(tokens[0]);
        	    	int mm=Integer.parseInt(tokens[1]);
        	    	int yyyy=Integer.parseInt(tokens[2]);
        	    	MyDate doj=new MyDate(dd,mm,yyyy);
        			for( Train t: aux){
        	    		if(trainNo==t.getNum()){
        	    			String avail=temp.checkAvail(doj, trainNo);
        	    			jTextField5.setText(avail);
        	    			break;
        	    		}
        	    	}
        			
        		}
        	}
        });*/
    }                                        

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClerkPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClerkPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClerkPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClerkPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClerkPage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton btnCheckAvail;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea tdArea;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField pasField;
    private javax.swing.JTextField jTextField5;
    private JTextArea ticketArea;
    private JScrollPane scrollPane;
    private JTextArea tnArea;
    private JButton btnTrainInfo;
    private JButton btnNewButton;
}
