import javax.swing.border.Border;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;  
import javax.swing.JOptionPane;
import java.awt.*;  
import javax.swing.*;  
import javax.swing.JButton; 
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
public class RPSGameGUI extends JFrame
{
    private JFrame f; //setting our JFrame variable
    private JOptionPane pane = new JOptionPane();//creating a new pane
    //Private vars 
    private String uchoice = null;
    private String cpuchoice = null;
    private int iuchoice = 0;
    private int icpuchoice = 0;
    private int gamenum = 0;
    private int uWins = 0;
    private int uLosses = 0;
    private int cpuWins = 0;
    private int cpuLosses = 0;
    private int draws = 0;
    private boolean cont = true;
    private String cpuresult = null;
    private String uresult = null;
    public RPSGameGUI()
    { 
        f = new JFrame();

        //Starter message informing the user of the general rules
        JOptionPane.showMessageDialog(pane,"Before you start, here are the basic rules of the game:\n \n Scissors cuts paper" +
            "\n Paper covers rock \n Rock breaks scissors \n \n Goal: beat the computer by getting the most wins. \n The game can either " +
            "end in a draw (both parties have the same amount of wins), a win, or a loss \n \n Goodluck!");

        Border blackline = BorderFactory.createLineBorder(Color.black); //creates borders around the panels

        //Fonts used throughout the project
        Font font = new Font("Helvetica", Font.BOLD, 30);
        Font font2 = new Font("Helvetica", Font.BOLD, 30);
        Font font3 = new Font("Helvetica", Font.BOLD, 25);
        Font font4 = new Font("Helvetica", Font.BOLD, 60);
        Font font5 = new Font("Helvetica", Font.BOLD, 60);
        Font font6 = new Font("Helvetica", Font.BOLD, 20);
        Font font7 = new Font("Helvetica", Font.BOLD, 35);
        Font font8 = new Font("Helvetica", Font.BOLD, 15);
        Font font9 = new Font("Helvetica", Font.BOLD, 45);
        //

        //panels at the top of the page 
        //(x, y, width, height) x & y refer to the coordinates of the upper left corner of the component relative to the frame corner
        //with 0,0 being the actual corner of the frame / window     

        //Panel for the no button that's not visible as first but then becomes visible when a game is finished 
        JPanel nobut2 = new JPanel();
        nobut2.setLayout(new BorderLayout());
        nobut2.setBounds(45,25,90,50); 
        nobut2.setBorder(blackline);
        nobut2.setBackground(Color.WHITE);
        f.add(nobut2);
        JButton Nobut = new JButton("No");
        Nobut.setVisible(false);
        nobut2.add(Nobut); 

        //outside panel that encases the no button for aesthetic purposes
        JPanel nobut1 = new JPanel();
        nobut1.setLayout(new BorderLayout());
        nobut1.setBounds(0,0,180,100); 
        nobut1.setBorder(blackline);
        nobut1.setBackground(Color.BLACK);
        f.add(nobut1);  

        //Yes button inside panel
        JPanel yesbut2 = new JPanel();
        yesbut2.setLayout(new BorderLayout());
        yesbut2.setBounds(665,25,90,50); 
        yesbut2.setBorder(blackline);
        yesbut2.setBackground(Color.WHITE);
        f.add(yesbut2); 
        JButton Yesbut = new JButton("Yes");
        Yesbut.setVisible(false);
        yesbut2.add(Yesbut); 

        //Yes button outside padding panel
        JPanel yesbut1 = new JPanel();
        yesbut1.setLayout(new BorderLayout());
        yesbut1.setBounds(620,0,180,100);          
        yesbut1.setBorder(blackline);
        yesbut1.setBackground(Color.BLACK);
        f.add(yesbut1);  

        //The middle panel that encases the text area at the top of the page, the text area changes after each game, becoming hidden 
        JPanel midtop = new JPanel();
        midtop.setLayout(new BorderLayout());
        midtop.setBounds(180,0,440,100);              
        midtop.setBackground(Color.WHITE);
        midtop.setBorder(blackline);
        JTextArea Play_again = new JTextArea(440,100);
        Play_again.setText("          Welcome to Rock Paper Scissors \n Please choose from the three options below \n              App design by jcook03266");
        Play_again.setFont(font6);
        Play_again.setEditable(false);
        midtop.add(Play_again);
        f.add(midtop);  
        //end of the top of the page

        //middle of the page
        //CPU
        //The event log header panel
        JPanel CPU_eventlogHeader = new JPanel();
        CPU_eventlogHeader.setLayout(new BorderLayout());
        CPU_eventlogHeader.setBounds(0,100,180,50); 
        CPU_eventlogHeader.setBorder(blackline);
        CPU_eventlogHeader.setBackground(Color.WHITE);
        JTextArea CPU_Elog = new JTextArea(440,100);
        CPU_Elog.setText(" Event Log:");
        CPU_Elog.setFont(font2);
        CPU_Elog.setEditable(false);
        CPU_eventlogHeader.add(CPU_Elog);
        f.add(CPU_eventlogHeader);  

        //event log body that holds a scrollable text area for displaying information about the cpu's run
        JPanel CPU_eventlogbody = new JPanel();
        CPU_eventlogbody.setLayout(new BorderLayout());
        CPU_eventlogbody.setBounds(0,150,180,450); 
        CPU_eventlogbody.setBorder(blackline);
        CPU_eventlogbody.setBackground(Color.WHITE);
        JTextArea CPU_TA = new JTextArea(180,500);
        CPU_TA.setFont(font8);
        CPU_TA.setText("");
        CPU_TA.setEditable(false);
        CPU_TA.setLineWrap(true);
        JScrollPane CPU_RO = new JScrollPane(CPU_TA);
        CPU_RO.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        CPU_RO.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        CPU_eventlogbody.add(CPU_RO);
        f.add(CPU_eventlogbody);  

        //The win/loss panel for the cpu near the bottom of the page 
        JPanel CPU_WL = new JPanel();//CPU wins
        CPU_WL.setLayout(new BorderLayout());
        CPU_WL.setBounds(110,600,70,35); 
        CPU_WL.setBorder(blackline);
        CPU_WL.setBackground(Color.WHITE);
        JTextArea CPU_WLcount = new JTextArea(180,500);
        CPU_WLcount.setFont(font8);
        CPU_WLcount.setEditable(false);
        CPU_WLcount.setText("       " + "0");
        CPU_WL.add(CPU_WLcount);
        f.add(CPU_WL);

        JPanel CPU_WL2 = new JPanel();//CPU losses
        CPU_WL2.setLayout(new BorderLayout());
        CPU_WL2.setBounds(110,635,70,35); 
        CPU_WL2.setBorder(blackline);
        CPU_WL2.setBackground(Color.WHITE);
        JTextArea CPU_WL2count = new JTextArea(180,500);
        CPU_WL2count.setFont(font8);
        CPU_WL2count.setEditable(false);
        CPU_WL2count.setText("       " + "0");
        CPU_WL2.add(CPU_WL2count);
        f.add(CPU_WL2);

        JPanel CPU_WL3 = new JPanel();
        CPU_WL3.setLayout(new BorderLayout());
        CPU_WL3.setBounds(0,600,180,70); 
        CPU_WL3.setBorder(blackline);
        CPU_WL3.setBackground(Color.WHITE);
        JTextArea CPU_WLLabels = new JTextArea(440,100);
        CPU_WLLabels.setText("     Wins: \n Losses:");
        CPU_WLLabels.setFont(font3);
        CPU_WLLabels.setEditable(false);
        CPU_WL3.add(CPU_WLLabels);
        f.add(CPU_WL3);
        //end of cpu win/loss panel 

        //Displays the choice of the cpu, whether rock paper or scissors
        JPanel CPU_Header = new JPanel();//panel used for positioning the choice of the cpu in the appropriate location
        CPU_Header.setLayout(new BorderLayout());
        CPU_Header.setBounds(180,100,220,100); 
        CPU_Header.setBorder(blackline);
        CPU_Header.setBackground(Color.WHITE);
        JTextArea CPU_HeaderLabel = new JTextArea(440,100);
        CPU_HeaderLabel.setText("   CPU");
        CPU_HeaderLabel.setFont(font4);
        CPU_HeaderLabel.setEditable(false);
        CPU_Header.add(CPU_HeaderLabel);
        f.add(CPU_Header);

        JPanel CPU_body = new JPanel();//interior panel
        CPU_body.setLayout(new BorderLayout());
        CPU_body.setBounds(190,320,200,200); 
        CPU_body.setBackground(Color.WHITE);
        JTextArea CPU_bodyLabel = new JTextArea(440,100);
        CPU_bodyLabel.setFont(font9);
        CPU_bodyLabel.setEditable(false);
        CPU_body.add(CPU_bodyLabel);
        f.add(CPU_body);

        JPanel CPU_body1 = new JPanel();//exterior panel 
        CPU_body1.setLayout(new BorderLayout());
        CPU_body1.setBounds(180,200,220,400); 
        CPU_body1.setBorder(blackline);
        CPU_body1.setBackground(Color.WHITE);
        f.add(CPU_body1);
        //end 

        //Displays the final results of the game when the user chooses to not continue 
        JPanel CPU_bodyfinal1 = new JPanel();
        CPU_bodyfinal1.setLayout(new BorderLayout());
        CPU_bodyfinal1.setBounds(180,600,90,70); 
        CPU_bodyfinal1.setBorder(blackline);
        CPU_bodyfinal1.setBackground(Color.WHITE);
        JTextArea CPU_bodyfinal1Label = new JTextArea(110,70);
        CPU_bodyfinal1Label.setText("   Final \n Results: ");
        CPU_bodyfinal1Label.setFont(font6);
        CPU_bodyfinal1Label.setEditable(false);
        CPU_bodyfinal1.add(CPU_bodyfinal1Label);
        f.add(CPU_bodyfinal1);

        JPanel CPU_bodyfinal2 = new JPanel();
        CPU_bodyfinal2.setLayout(new BorderLayout());
        CPU_bodyfinal2.setBounds(270,600,130,70); 
        CPU_bodyfinal2.setBorder(blackline);
        CPU_bodyfinal2.setBackground(Color.WHITE);
        JTextArea CPU_bodyfinal2Label = new JTextArea(110,70);
        CPU_bodyfinal2Label.setFont(font7);
        CPU_bodyfinal2Label.setEditable(false);
        CPU_bodyfinal2.add(CPU_bodyfinal2Label);
        f.add(CPU_bodyfinal2);
        //end
        //end of CPU styling 

        //USER styling, basically a mirror of what is above, both in function and in style
        JPanel U_eventlogHeader = new JPanel();
        U_eventlogHeader.setLayout(new BorderLayout());
        U_eventlogHeader.setBounds(620,100,180,50); 
        U_eventlogHeader.setBorder(blackline);
        U_eventlogHeader.setBackground(Color.WHITE);
        JTextArea U_Elog = new JTextArea(440,100);
        U_Elog.setText(" Event Log:");
        U_Elog.setFont(font2);
        U_Elog.setEditable(false);
        U_eventlogHeader.add(U_Elog);
        f.add(U_eventlogHeader);  

        JPanel U_eventlogbody = new JPanel();
        U_eventlogbody.setLayout(new BorderLayout());
        U_eventlogbody.setBounds(620,150,180,450); 
        U_eventlogbody.setBorder(blackline);
        U_eventlogbody.setBackground(Color.WHITE);
        JTextArea U_TA = new JTextArea(180,500);
        U_TA.setFont(font8);
        U_TA.setText("");
        U_TA.setEditable(false);
        U_TA.setLineWrap(true);
        JScrollPane U_RO = new JScrollPane(U_TA);
        U_RO.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        U_RO.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        U_eventlogbody.add(U_RO);
        f.add(U_eventlogbody);  

        JPanel U_WL = new JPanel(); //User wins
        U_WL.setLayout(new BorderLayout());
        U_WL.setBounds(730,600,70,35); 
        U_WL.setBorder(blackline);
        U_WL.setBackground(Color.WHITE);
        JTextArea U_WLcount = new JTextArea(180,500);
        U_WLcount.setFont(font8);
        U_WLcount.setEditable(false);
        U_WLcount.setText("       " + "0");
        U_WL.add(U_WLcount);
        f.add(U_WL);

        JPanel U_WL2 = new JPanel(); //User loses
        U_WL2.setLayout(new BorderLayout());
        U_WL2.setBounds(730,635,70,35); 
        U_WL2.setBorder(blackline);
        U_WL2.setBackground(Color.WHITE);
        JTextArea U_WL2count = new JTextArea(180,500);
        U_WL2count.setFont(font8);
        U_WL2count.setEditable(false);
        U_WL2count.setText("       " + "0");
        U_WL2.add(U_WL2count);
        f.add(U_WL2);

        JPanel U_WL3 = new JPanel();
        U_WL3.setLayout(new BorderLayout());
        U_WL3.setBounds(620,600,180,70); 
        U_WL3.setBorder(blackline);
        U_WL3.setBackground(Color.WHITE);
        JTextArea U_WLLabels = new JTextArea(440,100);
        U_WLLabels.setText("     Wins: \n Losses:");
        U_WLLabels.setFont(font3);
        U_WLLabels.setEditable(false);
        U_WL3.add(U_WLLabels);
        f.add(U_WL3);

        JPanel User_Header = new JPanel();
        User_Header.setLayout(new BorderLayout());
        User_Header.setBounds(400,100,220,100); 
        User_Header.setBorder(blackline);
        User_Header.setBackground(Color.WHITE);
        JTextArea User_HeaderLabel = new JTextArea(440,100);
        User_HeaderLabel.setText("   You");
        User_HeaderLabel.setFont(font4);
        User_HeaderLabel.setEditable(false);
        User_Header.add(User_HeaderLabel);
        f.add(User_Header);

        JPanel User_body = new JPanel();
        User_body.setLayout(new BorderLayout());
        User_body.setBounds(410,320,200,200); 
        User_body.setBackground(Color.WHITE);
        JTextArea User_bodyLabel = new JTextArea(440,100);
        User_bodyLabel.setFont(font9);
        User_bodyLabel.setEditable(false);
        User_body.add(User_bodyLabel);
        f.add(User_body);

        JPanel User_body1 = new JPanel();
        User_body1.setLayout(new BorderLayout());
        User_body1.setBounds(400,200,220,400); 
        User_body1.setBorder(blackline);
        User_body1.setBackground(Color.WHITE);
        f.add(User_body1);

        JPanel User_bodyfinal1 = new JPanel();
        User_bodyfinal1.setLayout(new BorderLayout());
        User_bodyfinal1.setBounds(400,600,90,70); 
        User_bodyfinal1.setBorder(blackline);
        User_bodyfinal1.setBackground(Color.WHITE);
        JTextArea User_bodyfinal1Label = new JTextArea(110,70);
        User_bodyfinal1Label.setText("   Final \n Results: ");
        User_bodyfinal1Label.setFont(font6);
        User_bodyfinal1Label.setEditable(false);
        User_bodyfinal1.add(User_bodyfinal1Label);
        f.add(User_bodyfinal1);

        JPanel User_bodyfinal2 = new JPanel();
        User_bodyfinal2.setLayout(new BorderLayout());
        User_bodyfinal2.setBounds(490,600,130,70); 
        User_bodyfinal2.setBorder(blackline);
        User_bodyfinal2.setBackground(Color.WHITE);
        JTextArea User_bodyfinal2Label = new JTextArea(110,70);
        User_bodyfinal2Label.setFont(font7);
        User_bodyfinal2Label.setEditable(false);
        User_bodyfinal2.add(User_bodyfinal2Label);
        f.add(User_bodyfinal2);
        //END OF USER

        //Bottom of the page, holds the buttons that determine the user's choice
        JPanel Bottom_headerbutton = new JPanel();//panel 1 aka the Rock button aka option 0
        Bottom_headerbutton.setLayout(new BorderLayout());
        Bottom_headerbutton.setBounds(100,680,200,60); 
        Bottom_headerbutton.setBorder(blackline);
        Bottom_headerbutton.setBackground(Color.WHITE);
        JButton Rock = new JButton("Rock");
        Bottom_headerbutton.add(Rock); 
        f.add(Bottom_headerbutton);

        JPanel Bottom_headerbutton2 = new JPanel();//panel 2 aka the Paper button aka option 1 
        Bottom_headerbutton2.setLayout(new BorderLayout());
        Bottom_headerbutton2.setBounds(300,680,200,60); 
        Bottom_headerbutton2.setBorder(blackline);
        Bottom_headerbutton2.setBackground(Color.WHITE);
        JButton Paper = new JButton("Paper");
        Bottom_headerbutton2.add(Paper); 
        f.add(Bottom_headerbutton2);

        JPanel Bottom_headerbutton3 = new JPanel(); //panel 3 aka the Scissors button aka option 2
        Bottom_headerbutton3.setLayout(new BorderLayout());
        Bottom_headerbutton3.setBounds(500,680,200,60); 
        Bottom_headerbutton3.setBorder(blackline);
        Bottom_headerbutton3.setBackground(Color.WHITE);
        JButton Scissors = new JButton("Scissors");
        Bottom_headerbutton3.add(Scissors); 
        f.add(Bottom_headerbutton3);

        JPanel Bottom_header = new JPanel(); //the exterior padding panel
        Bottom_header.setLayout(new BorderLayout());
        Bottom_header.setBounds(0,670,815,110); 
        Bottom_header.setBorder(blackline);
        Bottom_header.setBackground(Color.BLACK);
        f.add(Bottom_header);  
        //End of page bottom

        f.setSize(815,800);//sets the size of the frame to 815 pixels by 800 pixels L*H
        f.setLayout(null);//layout set to null
        f.setVisible(true);//frame is visible    

        //Action listener for the Rock button, allows for the manipulation of most instance variables enumerated at the top
        //the entire listener is encased in boolean to prevent the user from continuing to press buttons unless they answer the prompt
        //following each game.he message at the top of the screen is changed, and the readout of the game's details are printed to the 
        //event logs of each side of the spectrum via toString methods.
        Rock.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(cont == true){
                        gamenum += 1;
                        iuchoice = 0;
                        icpuchoice = (int)(Math.random()*10);
                        icpuchoice %= 3;
                        if (iuchoice == icpuchoice){
                            cpuresult = "Draw"; uresult = "Draw!"; draws += 1;
                        }

                        if(iuchoice == 0 && icpuchoice == 2 || iuchoice == 2 && icpuchoice == 1 || iuchoice == 1 && icpuchoice == 0){
                            cpuresult = "CPU loses!"; uresult = "You win!"; uWins += 1; cpuLosses += 1;
                        }

                        if(iuchoice == 2 && icpuchoice == 0 || iuchoice == 1 && icpuchoice == 2 || iuchoice == 0 && icpuchoice == 1){
                            cpuresult = "CPU wins!"; uresult = "You lose!"; uLosses += 1; cpuWins += 1; 
                        }

                        if(iuchoice == 0)
                            uchoice = "Rock";
                        if(iuchoice == 1)
                            uchoice = "Paper";    
                        if(iuchoice == 2)
                            uchoice = "Scissors";

                        if(icpuchoice == 0)
                            cpuchoice = "Rock";
                        if(icpuchoice == 1)
                            cpuchoice = "Paper";    
                        if(icpuchoice == 2)
                            cpuchoice = "Scissors";

                        U_WLcount.setText("       " +Integer.toString(uWins));
                        U_WL2count.setText("       " + Integer.toString(uLosses));
                        CPU_WLcount.setText("       " + Integer.toString(cpuWins));
                        CPU_WL2count.setText("       " + Integer.toString(cpuLosses));

                        User_bodyLabel.setText(uchoice);
                        CPU_bodyLabel.setText(cpuchoice);

                        CPU_TA.append(CPUtoString());
                        U_TA.append(UtoString());

                        Play_again.setFont(font);
                        Play_again.setText("        Would you like to play \n             another game?"); 
                        Nobut.setVisible(true);
                        Yesbut.setVisible(true);
                        Play_again.setVisible(true);
                        cont = false;
                    }
                }
            });
        //paper action listener basically the same as the others
        Paper.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(cont == true){
                        gamenum += 1;
                        iuchoice = 1;
                        icpuchoice = (int)(Math.random()*10);
                        icpuchoice %= 3;
                        if (iuchoice == icpuchoice){
                            cpuresult = "Draw"; uresult = "Draw!"; draws += 1;
                        }

                        if(iuchoice == 0 && icpuchoice == 2 || iuchoice == 2 && icpuchoice == 1 || iuchoice == 1 && icpuchoice == 0){
                            cpuresult = "CPU loses!"; uresult = "You win!"; uWins += 1; cpuLosses += 1;
                        }

                        if(iuchoice == 2 && icpuchoice == 0 || iuchoice == 1 && icpuchoice == 2 || iuchoice == 0 && icpuchoice == 1){
                            cpuresult = "CPU wins!"; uresult = "You lose!"; uLosses += 1; cpuWins += 1;
                        }

                        if(iuchoice == 0)
                            uchoice = "Rock";
                        if(iuchoice == 1)
                            uchoice = "Paper";    
                        if(iuchoice == 2)
                            uchoice = "Scissors";

                        if(icpuchoice == 0)
                            cpuchoice = "Rock";
                        if(icpuchoice == 1)
                            cpuchoice = "Paper";    
                        if(icpuchoice == 2)
                            cpuchoice = "Scissors";

                        U_WLcount.setText("       " +Integer.toString(uWins));
                        U_WL2count.setText("       " + Integer.toString(uLosses));
                        CPU_WLcount.setText("       " + Integer.toString(cpuWins));
                        CPU_WL2count.setText("       " + Integer.toString(cpuLosses));

                        User_bodyLabel.setText(uchoice);
                        CPU_bodyLabel.setText(cpuchoice);

                        CPU_TA.append(CPUtoString());
                        U_TA.append(UtoString());

                        Play_again.setFont(font);
                        Play_again.setText("        Would you like to play \n             another game?"); 
                        Nobut.setVisible(true);
                        Yesbut.setVisible(true);
                        Play_again.setVisible(true);
                        cont = false;
                    }
                }
            });

        Scissors.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(cont == true){
                        gamenum += 1;
                        iuchoice = 2;
                        icpuchoice = (int)(Math.random()*10);
                        icpuchoice %= 3;
                        if (iuchoice == icpuchoice){
                            cpuresult = "Draw"; uresult = "Draw!"; draws += 1;
                        }

                        if(iuchoice == 0 && icpuchoice == 2 || iuchoice == 2 && icpuchoice == 1 || iuchoice == 1 && icpuchoice == 0){
                            cpuresult = "CPU loses!"; uresult = "You win!"; uWins += 1; cpuLosses += 1;
                        }

                        if(iuchoice == 2 && icpuchoice == 0 || iuchoice == 1 && icpuchoice == 2 || iuchoice == 0 && icpuchoice == 1){
                            cpuresult = "CPU wins!"; uresult = "You lose!"; uLosses += 1; cpuWins += 1;
                        }

                        if(iuchoice == 0)
                            uchoice = "Rock";
                        if(iuchoice == 1)
                            uchoice = "Paper";    
                        if(iuchoice == 2)
                            uchoice = "Scissors";

                        if(icpuchoice == 0)
                            cpuchoice = "Rock";
                        if(icpuchoice == 1)
                            cpuchoice = "Paper";    
                        if(icpuchoice == 2)
                            cpuchoice = "Scissors";

                        U_WLcount.setText("       " +Integer.toString(uWins));
                        U_WL2count.setText("       " + Integer.toString(uLosses));
                        CPU_WLcount.setText("       " + Integer.toString(cpuWins));
                        CPU_WL2count.setText("       " + Integer.toString(cpuLosses));

                        User_bodyLabel.setText(uchoice);
                        CPU_bodyLabel.setText(cpuchoice);

                        CPU_TA.append(CPUtoString());
                        U_TA.append(UtoString());

                        Play_again.setFont(font);
                        Play_again.setText("        Would you like to play \n             another game?"); 
                        Nobut.setVisible(true);
                        Yesbut.setVisible(true);
                        Play_again.setVisible(true);
                        cont = false;
                    }
                }
            });

        //Yes button action listener that enables the user to press buttons again and continue on with more games,
        //sets all of the top components to invisible for aesthetic purposes 
        Yesbut.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cont = true;
                    Nobut.setVisible(false);
                    Yesbut.setVisible(false);
                    Play_again.setVisible(false);
                }
            });

        //No buttton locks the user out for good, and prompts them to quit by displaying the final stats of the game
        Nobut.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(cpuWins < uWins){
                        CPU_bodyfinal2Label.setText(" Loser");
                        User_bodyfinal2Label.setText("Winner");

                    }
                    if(cpuWins > uWins){
                        CPU_bodyfinal2Label.setText("Winner");
                        User_bodyfinal2Label.setText(" Loser");
                    }
                    if(uWins == cpuWins){
                        CPU_bodyfinal2Label.setText("  Draw");
                        User_bodyfinal2Label.setText("  Draw");
                    } 
                    Nobut.setVisible(false);
                    Yesbut.setVisible(false);
                    Play_again.setText("\n                  Goodbye!");
                }
            });
    }

    //To string method for the cpu, utilizes the loaded variables previously discussed to print a readout to the 
    //CPU log on the left side of the program
    public String CPUtoString(){
        String output = "";
        output += "Game " + gamenum + ": \n";
        output += "CPU chose: \n";
        output += cpuchoice + "\n";
        output += cpuresult;
        output += "\n";
        output += "Number of draws: " + draws + "\n";
        output += "\n";
        return output;
    }

    //To string method for the user prints a readout for the user to the right side of the program
    public String UtoString(){
        String output = "";
        output += "Game " + gamenum + ": \n";
        output += "You chose: \n";
        output += uchoice + "\n";
        output += uresult;
        output += "\n";
        output += "Number of draws: " + draws + "\n";
        output += "\n";
        return output;
    }

    public static void main(){
        new RPSGameGUI();//creates new object
    }
}
