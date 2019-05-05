package us.ktmc.main;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.plugin.java.JavaPlugin;
import us.ktmc.file.OldConfUpdata;
import us.ktmc.player.PlayerEventHandler;
import us.ktmc.util.Var;
import us.ktmc.util_interface.FastUtil;

public class FastLogin extends JavaPlugin {
	
	CommandHandler Command=new CommandHandler();
	
	public void onEnable(){
		
		System.out.println("[FastLogin]�汾:"+FastUtil.FastLoginVersion);
		System.out.println("[FastLogin]�����������");	
						
		
		/**���¾�������**/
		new OldConfUpdata().AutoUpdataOldConf();

		/**���ó�ʼ��**/
		Var.conf.ConfigCheck();
		Var.conf.ReaderConfig(); 	
		Var.conf.IPtablesCheck();
	
		/**�����ļ���ʼ��**/
		Var.conf.LanguageCheck();
								
		try{
			
			Var.conf.ReaderLanuage();
			
		}catch(NullPointerException ec){
			System.out.println("[����]����ȡ�����ļ�ʱ���ִ���,��ʹ��Ԥ������");
		}
		
		/**��ʼ�����!**/
				
		Var.MainClass=this;
		
		Bukkit.getPluginManager().registerEvents(new PlayerEventHandler(),this);
		
		
	}
	
	//���������
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){							
		return Command.onCommand(sender, cmd, label, args);
	}
	
	
}