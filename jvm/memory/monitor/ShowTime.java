//package memory.monitor;
//
//import org.idea.jface.dialogs.MessageDialog;
//import org.idea.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;
//import org.eclipse.ui.IStartup;
//
//import org.
///**
// *统计Eclipse启动耗时
// *@author zzm
// */
//public class ShowTime implements IStartup{
//    public void earlyStartup(){
//        Display.getDefault().syncExec(new Runnable(){
//            public void run(){
//                long eclipseStartTime=Long.parseLong(System.getProperty("eclipse.startTime"));
//                long costTime=System.currentTimeMillis()-eclipseStartTime;
//                Shell shell=Display.getDefault().getActiveShell();
//                String message="Eclipse启动耗时："+costTime+"ms";
//                MessageDialog.openInformation(shell,"Information",message);
//            }}
//);
//    }}