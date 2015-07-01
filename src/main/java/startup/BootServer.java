package startup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 * @author andros
 *
 *         2015年7月1日上午11:28:42
 */
public class BootServer {
	private static final Log log = LogFactory.getLog(BootServer.class);
	private static FileSystemXmlApplicationContext context;

	private static final String[] predefinedCommands = new String[] { "start","stop" };

	private BootServer() {

	}

	static class Inner {
		static BootServer BootServer = new BootServer();
	}

	public static BootServer getInstance() {
		return Inner.BootServer;
	}

	
	public static void main(String[] args) {
		
	}
	public void init() throws Exception {
		System.out.println("execute init method !");
	}
	public void init(String[] args) throws Exception {
		System.out.println("execute init(args) method");
	}
	/**
	 * 启动服务
	 * @throws Exception
	 */
	public void start() throws Exception {
		
	}
}
