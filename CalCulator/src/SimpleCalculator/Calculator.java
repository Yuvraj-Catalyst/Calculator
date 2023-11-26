package SimpleCalculator;
//Program to make an Calculator
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
class Calculator extends JFrame implements ActionListener{
    JButton btn[] = new JButton[17];
    JTextField dis;
    int count=-1;
    String solve = "";
    // ArrayList<String> number = new ArrayList<>();
    // String operator="";
    StringBuilder infix= new StringBuilder("");
    Calculator(){
        Container con;
        setTitle("---------Calculator---------");
        setLocationRelativeTo(null);
        setSize(450,300);
        con = getContentPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        con.setBackground(Color.black);
    }
    public void setComponent(){
        setLayout(null);
        dis = new JTextField();
        dis.setBounds(130,10,310,40);
        dis.setFont(new Font("Arial",Font.BOLD,22));
        add(dis);
        btn[0] = new JButton("0");
        btn[0].setBounds(0,60,112,50);
        btn[0].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[0]);
        btn[1] = new JButton("1");
        btn[1].setBounds(0,110,112,50);
        btn[1].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[1]);
        btn[2] = new JButton("2");
        btn[2].setBounds(0,160,112,50);
        btn[2].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[2]);
        btn[3] = new JButton("3");
        btn[3].setBounds(0,210,112,50);
        btn[3].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[3]);
        btn[4] = new JButton("4");
        btn[4].setBounds(112,60,112,50);
        btn[4].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[4]);
        btn[5] = new JButton("5");
        btn[5].setBounds(112,110,112,50);
        btn[5].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[5]);
        btn[6] = new JButton("6");
        btn[6].setBounds(112,160,112,50);
        btn[6].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[6]);
        btn[7] = new JButton("7");
        btn[7].setBounds(112,210,112,50);
        btn[7].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[7]);
        btn[8] = new JButton("8");
        btn[8].setBounds(224,60,112,50);
        btn[8].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[8]);
        btn[9] = new JButton("9");
        btn[9].setBounds(224,110,112,50);
        btn[9].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[9]);
        btn[10] = new JButton("+");
        btn[10].setBounds(224,160,112,50);
        btn[10].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[10]);
        btn[11] = new JButton("-");
        btn[11].setBounds(224,210,112,50);
        btn[11].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[11]);
        btn[12] = new JButton("AC");
        btn[12].setBounds(336,60,112,50);
        btn[12].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[12]);
        btn[13] = new JButton("*");
        btn[13].setBounds(336,110,112,50);
        btn[13].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[13]);
        btn[14] = new JButton("/");
        btn[14].setBounds(336,160,112,50);
        btn[14].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[14]);
        btn[15] = new JButton("=");
        btn[15].setBounds(336,210,112,50);
        btn[15].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[15]);
        btn[16] = new JButton("Back");
        btn[16].setBounds(0,10,112,50);
        btn[16].setFont(new Font("Arial",Font.BOLD,20));
        add(btn[16]);
        for(int k = 0;k<btn.length;k++){
            btn[k].addActionListener(this);
        }
        dis.setEditable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        int i = 0;
        String st = dis.getText();
        while(i!=st.length()){
            if(st.charAt(i) == '='){
                dis.setText(solve);
                break;
            }
            i++;
        }
        count ++;
        if(e.getSource() == btn[0]){
            dis.setText(dis.getText()+"0");
        }
        if(e.getSource() == btn[1]){
            dis.setText(dis.getText()+"1");
        }
        if(e.getSource() == btn[2]){
            dis.setText(dis.getText()+"2");
        }
        if(e.getSource() == btn[3]){
            dis.setText(dis.getText()+"3");
        }
        if(e.getSource() == btn[4]){
            dis.setText(dis.getText()+"4");
        }
        if(e.getSource() == btn[5]){
            dis.setText(dis.getText()+"5");
        }
        if(e.getSource() == btn[6]){
            dis.setText(dis.getText()+"6");
        }
        if(e.getSource() == btn[7]){
            dis.setText(dis.getText()+"7");
        }
        if(e.getSource() == btn[8]){
            dis.setText(dis.getText()+"8");
        }
        if(e.getSource() == btn[9]){
            dis.setText(dis.getText()+"9");
        }
        if(e.getSource() == btn[10]){
            String str = dis.getText();
            if(str.length() == 0){
                return;
            }
            if(isOperator(str.charAt(count-1))){
                str = str.substring(0,--count);
            }
            dis.setText(str+"+");
        }
        if(e.getSource() == btn[11]){
            String str = dis.getText();
            if(str.length() == 0){
                return;
            }
            if(isOperator(str.charAt(count-1))){
                str = str.substring(0,--count);
            }
            dis.setText(str+"-");
        }
        if(e.getSource() == btn[12]){
            dis.setText("");
            count = -1;
            infix = new StringBuilder("");
        }
        if(e.getSource() == btn[13]){
            String str = dis.getText();
            if(str.length() == 0){
                return;
            }
            if(isOperator(str.charAt(count-1))){
                str = str.substring(0,--count);
            }
            dis.setText(str+"*");
        }
        if(e.getSource() == btn[14]){
            String str = dis.getText();
            if(str.length() == 0){
                return;
            }
            if(isOperator(str.charAt(count-1))){
                str = str.substring(0,--count);
            }
            dis.setText(str+"/");
        }
        if(e.getSource() == btn[15]){
            String str = dis.getText();
            if(isOperator(str.charAt(count-1))){
                str = str.substring(0,--count);
            }
            dis.setText(str);
            infix.append(dis.getText());
            String postfix = infixToPostfix(infix.toString());
            solve = solvePostfix(postfix);
            dis.setText(dis.getText()+" = "+solve);
            count = solve.length()-1;
            infix = new StringBuilder("");
        }
        if(e.getSource() == btn[16]){
            count--;
            String str = dis.getText();
            if(str.length() == 0){
                return;
            }
            dis.setText(str.substring(0,count--));
        }

    }
    public String solvePostfix(String postfix){
        Stack<String> s = new Stack<>();
        float result = 0;
        int i;
        String str = "";
        for(i=0;i<postfix.length();i++){
            str = "";
            while(i != postfix.length() && postfix.charAt(i)!=','){
                str = str+postfix.charAt(i);
                i++;
            }
            if(!isOperator(str)){
                s.push(str);
            }
            else{
                String data2 = s.pop();
                String data1 = s.pop();
                // result = (float)(Integer.parseInt(data1))+(float)(Integer.parseInt(data2));
                if(str.equals("+")){
                    result = (Float.parseFloat(data1))+(Float.parseFloat(data2));
                    // result = Integer.parseInt(data1)+Integer.parseInt(data2);

                }
                else if(str.equals("-")){
                    result = (Float.parseFloat(data1))-(Float.parseFloat(data2));
                    // result = Integer.parseInt(data1)-Integer.parseInt(data2);
                }
                else if(str.equals("*")){
                    result = (Float.parseFloat(data1))*(Float.parseFloat(data2));
                    // result = Integer.parseInt(data1)*Integer.parseInt(data2);
                }
                else if(str.equals("/")){
                    result = (Float.parseFloat(data1))/(Float.parseFloat(data2));
                    // result = Integer.parseInt(data1)/Integer.parseInt(data2);
                }
                // else if(str == ""){
                //     result = (float)(Integer.parseInt(data1))-(float)(Integer.parseInt(data2));
                // }

                String st = Float.toString(result);
                st = String.format("%.3f",result);
                s.push(st);
            }
        }
        // while(s.isEmpty()){
        //     System.out.println(s.pop());
        // }
        return s.peek();
    }
    private boolean isOperator(char c){
        if(c == '+' || c=='-' || c=='*' || c=='/'){
            return true;
        }
        return false;
    }
    private boolean isOperator(String c){
        if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
            return true;
        }
        return false;
    }
    private int precedence(char c){
        if(c == '+' || c=='-'){
            return 1;
        }
        else if(c == '*' || c == '/'){
            return 2;
        }
        else if(c == '^'){
            return 3;
        }
        return -1;
    }
    public String infixToPostfix(String infix){
        Stack<Character> s = new Stack<>();
        String postfix="";
        int i =0;
        boolean operand = false;
        while(i<infix.length()){
            char ch = infix.charAt(i);
            if(!isOperator(ch)){
                postfix = postfix+ch;
                operand = true;
                i++;
            }
            else{
                if(operand){
                    postfix = postfix+",";
                    operand = false;
                }
                if(s.isEmpty() || precedence(ch)>precedence(s.peek())){
                    s.push(ch);
                    i++;
                }
                else{
                    postfix = postfix+s.pop()+",";
                }
            }
        }
        if(operand){
            // postfix =postfix+",";
        }
        postfix = postfix+",";
        while(!s.isEmpty()){
            postfix = postfix+s.pop()+",";
        }
        return postfix;
        // s.add(infix.charAt(i));
    }
 
}
