package com.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotePad extends JFrame implements ActionListener {
    JTextArea jta=null;
    JMenuBar jmb=null;
    JMenu jm=null;
    JMenuItem itemOpen=null;
    JMenuItem itemSave=null;
    public static void main(String [] args){
        NotePad np=new NotePad();
    }
    public NotePad(){
        jmb=new JMenuBar();
        jmb.setVisible(true);
        jm=new JMenu("文件");
        //设置快捷键为 Alt+F
        jm.setMnemonic('F');
        //创建打开按钮
        itemOpen=new JMenuItem("打开(O)");
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("open");
        jm.add(itemOpen);
        //创建保存按钮
        itemSave=new JMenuItem("保存(S)");
        itemSave.addActionListener(this);
        itemSave.setActionCommand("save");
        jm.add(itemSave);
        jmb.add(jm);

        this.setJMenuBar(jmb);
        jta=new JTextArea();
        this.add(jta);
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("open")){
            JFileChooser jfc=new JFileChooser();
            jfc.showOpenDialog(null);
            //jfc.setVisible(true);
            jfc.setDialogTitle("请选择文件");
            String filename= jfc.getSelectedFile().getAbsolutePath();
            FileReader fr=null;
            BufferedReader br=null;
            try{
                fr=new FileReader(filename);
                br=new BufferedReader(fr);
                String str="";
                String allCon="";
                while((str=br.readLine())!=null){
                    allCon=allCon+str+"\r\n";
                }
                jta.setText(allCon);
            }catch (IOException exc){
                exc.printStackTrace();
            }finally{
                try{
                    br.close();
                    fr.close();

                }catch (IOException exc){
                    exc.printStackTrace();
                }
            }

        }else if(e.getActionCommand().equals("save")){
            JFileChooser jfc=new JFileChooser();
            jfc.showSaveDialog(null);
            //jfc.setVisible(true);
            jfc.setDialogTitle("保存为");
            String filename=jfc.getSelectedFile().getAbsolutePath();
            FileWriter fw=null;
            BufferedWriter bw=null;
            try{
                fw=new FileWriter(filename);
                bw=new BufferedWriter(fw);
                String s=jta.getText();
                bw.write(s);
            }catch (IOException exc){
                exc.printStackTrace();
            }finally{
                try{
                    bw.close();
                    fw.close();

                }catch (IOException exc){
                    exc.printStackTrace();
                }
            }
        }
    }
}
