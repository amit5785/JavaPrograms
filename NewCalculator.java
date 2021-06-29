import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.*;
public class NewCalculator
{
    public static void main(String Args [])
    {
       new CalculatorJFrame("Calculator");
    }
}
class CalculatorJFrame extends JFrame implements ActionListener
{
    JTextArea tA;
    JLabel l;
    JButton b[];
    Font f;
    Stack comand,actualAnswer;

    String mainString="",previousCom;
    int ans=0,actualAns=0;
    int previousLen=0,presentLen=0;

    public CalculatorJFrame(String heading)
    {
        super(heading);
        setVisible(true);
        setDefaultCloseOperation(3);
        setSize(450,500);
        setLayout(null);
        f=new Font(Font.DIALOG,Font.BOLD,24);

        comand=new Stack();
        comand.push("+");
        actualAnswer=new Stack();
        actualAnswer.push(0);

        l=new JLabel("CALCULATOR");
        l.setFont(f);
        l.setBackground(Color.BLUE);
        l.setBounds(100,5,200,40);
        tA=new JTextArea(2,30);
        tA.setFont(f);
        tA.setLineWrap(true);
        tA.setWrapStyleWord(true);
        tA.setBounds(5,60,400,80);
        b=new JButton[20];
        b[0]=new JButton("C");
        b[0].setFont(f);
        b[0].setBounds(20,160,80,40);
        b[1]=new JButton("%");
        b[1].setFont(f);
        b[1].setBounds(120,160,80,40);
        b[1].addActionListener(new ArithematicKey());
        b[2]=new JButton("D");
        b[2].setFont(f);
        b[2].setBounds(220,160,80,40);
        b[3]=new JButton("÷");
        b[3].setFont(f);
        b[3].setBounds(320,160,80,40);
        b[3].addActionListener(new ArithematicKey());
        b[4]=new JButton("7");
        b[4].setFont(f);
        b[4].setBounds(20,220,80,40);
        b[4].addActionListener(this);
        b[5]=new JButton("8");
        b[5].setFont(f);
        b[5].setBounds(120,220,80,40);
        b[5].addActionListener(this);
        b[6]=new JButton("9");
        b[6].setFont(f);
        b[6].setBounds(220,220,80,40);
        b[6].addActionListener(this);
        b[7]=new JButton("X");
        b[7].setFont(f);
        b[7].setBounds(320,220,80,40);
        b[7].addActionListener(new ArithematicKey());
        b[8]=new JButton("4");
        b[8].setFont(f);
        b[8].setBounds(20,280,80,40);
        b[8].addActionListener(this);
        b[9]=new JButton("5");
        b[9].setFont(f);
        b[9].setBounds(120,280,80,40);
        b[9].addActionListener(this);
        b[10]=new JButton("6");
        b[10].setFont(f);
        b[10].setBounds(220,280,80,40);
        b[10].addActionListener(this);
        b[11]=new JButton("-");
        b[11].setFont(f);
        b[11].setBounds(320,280,80,40);
        b[11].addActionListener(new ArithematicKey());
        b[12]=new JButton("1");
        b[12].setFont(f);
        b[12].setBounds(20,340,80,40);
        b[12].addActionListener(this);
        b[13]=new JButton("2");
        b[13].setFont(f);
        b[13].setBounds(120,340,80,40);
        b[13].addActionListener(this);
        b[14]=new JButton("3");
        b[14].setFont(f);
        b[14].setBounds(220,340,80,40);
        b[14].addActionListener(this);
        b[15]=new JButton("+");
        b[15].setFont(f);
        b[15].setBounds(320,340,80,40);
        b[15].addActionListener(new ArithematicKey());
        b[16]=new JButton("00");
        b[16].setFont(f);
        b[16].setBounds(20,400,80,40);
        b[16].addActionListener(this);
        b[17]=new JButton("0");
        b[17].setFont(f);
        b[17].setBounds(120,400,80,40);
        b[17].addActionListener(this);
        b[18]=new JButton(".");
        b[18].setFont(f);
        b[18].setBounds(220,400,80,40);
        b[18].addActionListener(this);
        b[19]=new JButton("=");
        b[19].setFont(f);
        b[19].setBounds(320,400,80,40);

        add(l);
        add(tA);
        int i=0;
        for(i=0;i<b.length;i++)
        {
            add(b[i]);
        }

        b[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainString="";
                tA.setText(mainString);
                //previousCom="+";
                ans=0;
                actualAns=0;
                actualAnswer.clear();
                actualAnswer.push(0);
                comand.clear();
                comand.push("+");
                previousLen=0;
                presentLen=0;
            }
        });

        b[19].addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                tA.setText(""+ans);
                mainString=""+ans;
            }
        });

        b[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String com=mainString.substring(mainString.length()-1);
                if(com.equals("+")|| com.equals("-") || com.equals("X") || com.equals("%") || com.equals("÷"))
                {
                    comand.pop();
                    actualAnswer.pop();
                    if(com.equals("%"))
                    {
                        //comand.pop();
                        //actualAnswer.pop();
                        int i=mainString.lastIndexOf(comand.peek().toString());
                        String num=mainString.substring(i+1,mainString.length()-1);
                        ans=(int)actualAnswer.peek();
                        if(previousCom=="+")
                        {
                            ans=ans+Integer.parseInt(num);
                            //ans=actualAns+Integer.parseInt(num);
                        }
                        else if(previousCom=="-")
                        {
                            ans=ans-Integer.parseInt(num);
                        }
                        else if(previousCom=="X")
                        {
                            ans=ans*Integer.parseInt(num);
                        }
                        else if(previousCom=="÷")
                        {
                            ans=ans/Integer.parseInt(num);
                        }
                        else
                        {
                            String tCom=(String)comand.pop();
                            int tActualAns=(int)actualAnswer.pop();
                            String tPreviousCom=comand.peek().toString();
                            int tAns=(int)actualAnswer.peek();
                            int j=mainString.lastIndexOf(comand.peek().toString());
                            String tSubString=mainString.substring(j+1,mainString.length());
                            String tNum[]=tSubString.split("%");
                            ans=tAns;
                            previousCom=tPreviousCom;
                            if(previousCom=="+")
                            {
                                ans=ans+((Integer.parseInt(tNum[0])*Integer.parseInt(tNum[1]))/100);
                                //ans=actualAns+Integer.parseInt(num);
                            }
                            else if(previousCom=="-")
                            {
                                ans=ans-((Integer.parseInt(tNum[0])*Integer.parseInt(tNum[1]))/100);
                            }
                            else if(previousCom=="X")
                            {
                                ans=ans*((Integer.parseInt(tNum[0])*Integer.parseInt(tNum[1]))/100);
                            }
                            else if(previousCom=="÷")
                            {
                                ans=ans/((Integer.parseInt(tNum[0])*Integer.parseInt(tNum[1]))/100);
                            }
                            actualAnswer.push(tActualAns);
                            comand.push(tCom);
                        }
                    }
                }
                else
                {
                    int i=mainString.lastIndexOf(comand.peek().toString());
                    System.out.println(i);
                    String num=mainString.substring(i+1,mainString.length()-1);
                    System.out.println(num);
                    if(num.equals(""))
                    {
                        ans=(int)actualAnswer.peek();
                    }
                    else
                    {
                        ans=(int)actualAnswer.peek();
                        if(previousCom=="+")
                        {
                            ans=ans+Integer.parseInt(num);
                            //ans=actualAns+Integer.parseInt(num);
                        }
                        else if(previousCom=="-")
                        {
                            ans=ans-Integer.parseInt(num);
                        }
                        else if(previousCom=="X")
                        {
                            ans=ans*Integer.parseInt(num);
                        }
                        else if(previousCom=="÷")
                        {
                            ans=ans/Integer.parseInt(num);
                        }
                        else
                        {
                            String tCom=(String)comand.pop();
                            int tActualAns=(int)actualAnswer.pop();
                            String tPreviousCom=comand.peek().toString();
                            int tAns=(int)actualAnswer.peek();
                            int j=mainString.lastIndexOf(comand.peek().toString());
                            String tSubString=mainString.substring(j+1,mainString.length());
                            String tNum[]=tSubString.split("%");
                            ans=tAns;
                            previousCom=tPreviousCom;
                            if(previousCom=="+")
                            {
                                ans=ans+((Integer.parseInt(tNum[0])*Integer.parseInt(tNum[1]))/100);
                                //ans=actualAns+Integer.parseInt(num);
                            }
                            else if(previousCom=="-")
                            {
                                ans=ans-((Integer.parseInt(tNum[0])*Integer.parseInt(tNum[1]))/100);
                            }
                            else if(previousCom=="X")
                            {
                                ans=ans*((Integer.parseInt(tNum[0])*Integer.parseInt(tNum[1]))/100);
                            }
                            else if(previousCom=="÷")
                            {
                                ans=ans/((Integer.parseInt(tNum[0])*Integer.parseInt(tNum[1]))/100);
                            }
                            actualAnswer.push(tActualAns);
                            comand.push(tCom);
                        }
                    }
                }
                mainString=mainString.substring(0,mainString.length()-1);
                tA.setText(mainString+"\n"+ans);
                previousLen=mainString.length();
                //actualAnswer.pop();
               // actualAnswer.push(ans);
            }
        });

    }

    public void actionPerformed(ActionEvent e)
    {
        mainString+=e.getActionCommand();
        presentLen=mainString.length();
        previousCom=comand.peek().toString();
        //ans=actualAns;
        ans=(int)actualAnswer.peek();
        int i=mainString.lastIndexOf(comand.peek().toString());
        String num=mainString.substring(i+1,mainString.length());
        if(previousCom=="+")
        {
            ans=ans+Integer.parseInt(num);
            //ans=actualAns+Integer.parseInt(num);
        }
        else if(previousCom=="-")
        {
            ans=ans-Integer.parseInt(num);
        }
        else if(previousCom=="X")
        {
            ans=ans*Integer.parseInt(num);
        }
        else if(previousCom=="÷")
        {
            ans=ans/Integer.parseInt(num);
        }
        else
        {
            String tCom=(String)comand.pop();
            int tActualAns=(int)actualAnswer.pop();
            String tPreviousCom=comand.peek().toString();
            int tAns=(int)actualAnswer.peek();
            int j=mainString.lastIndexOf(comand.peek().toString());
            String tSubString=mainString.substring(j+1,mainString.length());
            String tNum[]=tSubString.split("%");
            ans=tAns;
            previousCom=tPreviousCom;
            if(previousCom=="+")
            {
                ans=ans+((Integer.parseInt(tNum[0])*Integer.parseInt(tNum[1]))/100);
                //ans=actualAns+Integer.parseInt(num);
            }
            else if(previousCom=="-")
            {
                ans=ans-((Integer.parseInt(tNum[0])*Integer.parseInt(tNum[1]))/100);
            }
            else if(previousCom=="X")
            {
                ans=ans*((Integer.parseInt(tNum[0])*Integer.parseInt(tNum[1]))/100);
            }
            else if(previousCom=="÷")
            {
                ans=ans/((Integer.parseInt(tNum[0])*Integer.parseInt(tNum[1]))/100);
            }
            actualAnswer.push(tActualAns);
            comand.push(tCom);
        }
        tA.setText(mainString+"\n"+ans);
    }

    class ArithematicKey implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equals("%"))
            {
                previousCom=comand.peek().toString();
                //ans=actualAns;
                ans=(int)actualAnswer.peek();
                int i=mainString.lastIndexOf(comand.peek().toString());
                String num=mainString.substring(i+1,mainString.length());
                if(previousCom=="+")
                {
                    ans=ans+(ans*Integer.parseInt(num)/100);
                    //ans=actualAns+Integer.parseInt(num);
                }
                else if(previousCom=="-")
                {
                    ans=ans-(ans*Integer.parseInt(num)/100);
                }
                else if(previousCom=="X")
                {
                    ans=ans*(ans*Integer.parseInt(num)/100);
                }
                else if(previousCom=="÷")
                {
                    ans=ans/(ans*Integer.parseInt(num)/100);
                }
            }
            mainString+=e.getActionCommand();
            comand.push(e.getActionCommand());
            //previousCom=comand.peek().toString();
            previousLen=mainString.length();
            tA.setText(mainString+"\n"+ans);
            //actualAns=ans;
            actualAnswer.push(ans);
        }
    }

}
